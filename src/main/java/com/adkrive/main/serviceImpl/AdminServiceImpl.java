package com.adkrive.main.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.adkrive.main.general.Argon2HashedPassword;
import com.adkrive.main.general.GeneralConstant;
import com.adkrive.main.general.Utility;

import com.adkrive.main.model.Admin;
import com.adkrive.main.model.AdvTransactionLog;
import com.adkrive.main.model.Advertise;
import com.adkrive.main.model.Advertiser;
import com.adkrive.main.model.BlockedIpLog;

import com.adkrive.main.adminservice.AdminService;

import com.adkrive.main.model.AdType;
import com.adkrive.main.model.Country;
import com.adkrive.main.model.Deposit;
import com.adkrive.main.model.Domain;
import com.adkrive.main.model.Extension;
import com.adkrive.main.model.Frontend;
import com.adkrive.main.model.GlobalSetting;
import com.adkrive.main.model.IpLog;
import com.adkrive.main.model.Language;
import com.adkrive.main.model.LogoIconSetting;
import com.adkrive.main.model.ManageKeyWord;
import com.adkrive.main.model.Password;
import com.adkrive.main.model.PmntGtway;
import com.adkrive.main.model.PricePlan;

import com.adkrive.main.model.Profile;

import com.adkrive.main.model.Publisher;
import com.adkrive.main.model.PublisherEarningLog;
import com.adkrive.main.model.SmsManager;
import com.adkrive.main.model.SupportAttachment;
import com.adkrive.main.model.SupportMessage;
import com.adkrive.main.model.Ticket;
import com.adkrive.main.model.UserLoginHistory;
import com.adkrive.main.model.WithDrawMethod;
import com.adkrive.main.model.WithDrawls;
import com.adkrive.main.repository.AdminRepository;
import com.adkrive.main.repository.AdvTxLogrepository;
import com.adkrive.main.repository.AdvertiseRepository;
import com.adkrive.main.repository.AdvertiserRepository;
import com.adkrive.main.repository.AidTypeRepository;
import com.adkrive.main.repository.BlockedIpRepository;
import com.adkrive.main.repository.CountryRepositiory;
import com.adkrive.main.repository.DepositRepository;
import com.adkrive.main.repository.DomainRepository;
import com.adkrive.main.repository.ExtensionRepository;
import com.adkrive.main.repository.FrontendRepository;
import com.adkrive.main.repository.GeneralSettingRepository;
import com.adkrive.main.repository.GlobalSettingRepository;
import com.adkrive.main.repository.IplogRepository;
import com.adkrive.main.repository.LanguageRepository;
import com.adkrive.main.repository.LogoIconRepository;
import com.adkrive.main.repository.ManagekeywordRepositiory;
import com.adkrive.main.repository.PasswordRepository;
import com.adkrive.main.repository.PmntGatewayRepository;
import com.adkrive.main.repository.PricePlanRepository;

import com.adkrive.main.repository.ProfileRepository;

import com.adkrive.main.repository.PubEarnLogrepository;
import com.adkrive.main.repository.PublisherRepository;
import com.adkrive.main.repository.SmsmanagerRepository;
import com.adkrive.main.repository.SupportAttachementRepository;
import com.adkrive.main.repository.SupportMessageRepository;
import com.adkrive.main.repository.SupportTicketRepository;
import com.adkrive.main.repository.UserLoginHistoryRepository;
import com.adkrive.main.repository.UserLogrepository;
import com.adkrive.main.repository.WithdrawMethodRepository;
import com.adkrive.main.repository.WithdrawRepository;

import com.adkrive.main.utility.*;



@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private FrontendRepository frontendRepository;

	

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private PasswordRepository passwordRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private CountryRepositiory countryRepositiory;
	@Autowired
	private AdvertiserRepository advertiserRepository;
	@Autowired
	private ManagekeywordRepositiory managekeywordRepositiory;
	@Autowired
	private AdvertiseRepository advertiseRepository;
	@Autowired
	private PricePlanRepository planRepository;
	@Autowired
	private IplogRepository iplogRepository;
	@Autowired
	private BlockedIpRepository blockedIpRepository;
	@Autowired
	private AidTypeRepository aidTypeRepository;
	@Autowired
	private PmntGatewayRepository gatewayRepository;
	@Autowired
	private DomainRepository domainRepository;
	@Autowired
	private DepositRepository depositRepository;
	@Autowired
	private WithdrawMethodRepository methodRepository;
	@Autowired
	private WithdrawRepository withdrawRepository;
	@Autowired
	private SupportTicketRepository ticketRepository;

	@Autowired
	private GeneralSettingRepository generalSettingRepository;
	@Autowired
	private LogoIconRepository iconRepository;
	@Autowired
	private GlobalSettingRepository globalSettingRepository;
	
	@Autowired
	private PubEarnLogrepository earnLogrepository;

	@Autowired
	private ExtensionRepository extensionRepository;
	
	@Autowired
	private AdvTxLogrepository advTxLogrepository;

	@Autowired
	private UserLogrepository logrepository;

	@Autowired
	private SupportMessageRepository messageRepository;
	
	@Autowired
	private SupportAttachementRepository attachementRepository;
	@Autowired
	private UserLoginHistoryRepository historyRepository;

	

	@Autowired
	private SmsmanagerRepository smsmanagerRepository;
	@Autowired
	private LanguageRepository languageRepository;
	@Override

	
	public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
		Admin admin = adminRepository.findByEmail(email);
		if (admin != null) {
			admin.setResetPasswordToken(token);
			adminRepository.save(admin);
		} else {
			throw new CustomerNotFoundException("Could not find any user with the email " + email);
		}
	}

	public Admin getByResetPasswordToken(String token) {
		return adminRepository.findByResetPasswordToken(token);
	}


	public void updatePassword(Admin admin, String newPassword) {

		
		String encodedPassword = Argon2HashedPassword.hashedPassword(newPassword);
		admin.setPassword(encodedPassword);

		admin.setResetPasswordToken(null);
		adminRepository.save(admin);
	}



	

	
	

	



	
	@Override
	public boolean saveNewPassword(Password pass) {

		boolean status = false;
		Password passDetails = passwordRepository.getPassWordDetails();
		Admin admin = adminRepository.getAllDetails();
		long count = adminRepository.count();
		if (count == 1 && passDetails == null) {

			pass.setEmail(admin.getEmail());
			pass.setStatus(1);
			pass.setResetPasswordToken(admin.getResetPasswordToken());
			
			if(passwordRepository.save(pass)!=null)
			{
				status=true;
				return status;
			}
			
		}
		if(pass.getPassword().equals(pass.getNewPassword()))
		{
			status=false;
			return status;
		}
		else {
			List<Admin> list = adminRepository.findAll();
			for (int i = 0; i < list.size(); i++) {
				if (Argon2HashedPassword.matches(pass.getPassword(), list.get(i).getPassword().toString())) {
					status = true;
					break;
				} else {
					status = false;
				}
			}


			if (status) {
				updatePassword(admin, pass.getNewPassword());
				status = true;
			} else {
				status = false;
			}

		}
		return status;
	}

	@Override
	public List<Publisher> getAllPublisher() {
		return publisherRepository.findAll();
	}

	@Override
	public List<Publisher> getAllActivePublisher() {
		return publisherRepository.getAllActivePublisher();

	}

	@Override
	public List<Publisher> getAllBannedPublisher() {

		return publisherRepository.getAllBannedPublisher();

	}

	@Override
	public List<Publisher> getAllEmailUnverifiedPublisher() {
		return publisherRepository.getAllEmailUnverifiedPublisher();

	}

	@Override
	public List<Publisher> getAllSmslUnverifiedPublisher() {

		return publisherRepository.getAllSmslUnverifiedPublisher();
	}


	public long no_of_publishers() {
		long count = publisherRepository.count();
		return count;
	}

	public long no_of_unVerifiedEmailpublishers() {
		long count = publisherRepository.count();
		return count;
	}

	public long no_of_unVerifiedSmspublishers() {
		long count = publisherRepository.count();
		return count;
	}


	@Override
	public List<Publisher> searchPublisherByNameOrEmail(String value) {
		List<Publisher> publishersList = publisherRepository.searchPublisherByNameOrEmail(value);
		return publishersList;
	}

	


	



	

	@Override
	public List<Advertiser> getAllAdvertiser() {

		return advertiserRepository.findAll();
	}

	@Override
	public List<Advertiser> getAllActiveAdvertiser() {

		return advertiserRepository.getAllActiveAdvertiser();
	}

	@Override
	public List<Advertiser> getAllBannedAdvertiser() {
		return advertiserRepository.getAllBannedAdvertiser();
	}

	@Override
	public List<Advertiser> getAllEmailUnverifiedAdvertiser() {
		return advertiserRepository.getAllEmailUnverifiedAdvertiser();
	}

	@Override
	public List<Advertiser> getAllSmslUnverifiedAdvertiser() {
		return advertiserRepository.getAllSmslUnverifiedAdvertiser();
	}

	@Override
	public List<Advertiser> searchAdvertiserByNameOrEmail(String value) {
		return advertiserRepository.searchAdvertiserByNameOrEmail(value);
	}

	@Override
	public List<Advertiser> activeSearchAdvertiserByNameOrEmail(String value) {
		return advertiserRepository.activeSearchAdvertiserByNameOrEmail(value);
	}

	
	@Override
	public Integer addKeyWords(ManageKeyWord manageKeyWord) {
		String[] str = Utility.getSplitOfListString(manageKeyWord.getKeywords());
		List<String> list = Arrays.asList(str);
		List<ManageKeyWord> addList = new ArrayList<ManageKeyWord>();
		for (int i = 0; i < list.size(); i++) {
			ManageKeyWord mkbd = new ManageKeyWord();
			mkbd.setKeywords(list.get(i));
			addList.add(mkbd);
		}
		List<ManageKeyWord> mkwd = managekeywordRepositiory.saveAll(addList);
		if (mkwd != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<ManageKeyWord> getAllManageKeyword() {

		return managekeywordRepositiory.findAll();
	}

	@Override
	public Optional<ManageKeyWord> updateById(Integer id) {

		return managekeywordRepositiory.findById(id);
	}

	@Override
	public ManageKeyWord updatemanageKeyword(Integer id, ManageKeyWord maWord) {
		ManageKeyWord updatedManageKeyword = managekeywordRepositiory.findById(id).orElse(null);
		updatedManageKeyword.setKeywords(maWord.getKeywords());
		return managekeywordRepositiory.save(updatedManageKeyword);

	}

	@Override
	public int deleteManageKeyword(Integer id) {
	 	managekeywordRepositiory.deleteById(id);

		return 1;
	}

	@Override
	public Optional<Publisher> updateByPublisherId(Integer id) {

		return publisherRepository.findById(id);
	}

	@Override
	public Publisher updatePublisherDetail(Integer id, Publisher publish) {
		Publisher updatePublisher = publisherRepository.findById(id).orElse(null);

		updatePublisher.setName(publish.getName());
		updatePublisher.setEmail(publish.getEmail());
		updatePublisher.setPhone(publish.getPhone());
		updatePublisher.setCity(publish.getCity());
		updatePublisher.setCountry(publish.getCountry());
		if (publish.getStatus1() != null) {
			if (publish.getStatus1().equals("on")) {
				updatePublisher.setStatus(1);
			}
		}

		else {
			updatePublisher.setStatus(2);
		}

		if (publish.getEv1() != null) {
			if (publish.getEv1().equals("on")) {
				updatePublisher.setEv(1);
			}
		}

		else {
			updatePublisher.setEv(0);
		}

		if (publish.getSv1() != null) {
			if (publish.getSv1().equals("on")) {
				updatePublisher.setSv(1);
			}
		}

		else {
			updatePublisher.setSv(0);
		}

		if (publish.getTs1() != null) {
			if (publish.getTs1().equals("on")) {
				updatePublisher.setTs(1);
			}
		}

		else {
			updatePublisher.setTs(0);
		}

		if (publish.getTv1() != null) {
			if (publish.getTv1().equals("on")) {
				updatePublisher.setTv(1);
			}
		}

		else {
			updatePublisher.setTv(0);
		}

		return publisherRepository.save(updatePublisher);
	}

	@Override
	public Optional<Advertiser> updateByAdvertiserId(Integer id) {

		return advertiserRepository.findById(id);
	}

	@Override
	public Advertiser updateAdvertiserDetail(Integer id, Advertiser advertiser) {

		Advertiser updateAdvertiser = advertiserRepository.findById(id).orElse(null);

		updateAdvertiser.setName(advertiser.getName());
		updateAdvertiser.setEmail(advertiser.getEmail());
		updateAdvertiser.setPhone(advertiser.getPhone());
		updateAdvertiser.setCity(advertiser.getCity());
		updateAdvertiser.setCountry(advertiser.getCountry());
		if (advertiser.getStatus1() != null) {
			if (advertiser.getStatus1().equals("on")) {
				updateAdvertiser.setStatus(1);
			}
		}

		else {
			updateAdvertiser.setStatus(2);
		}

		if (advertiser.getEv1() != null) {
			if (advertiser.getEv1().equals("on")) {
				updateAdvertiser.setEv(1);
			}
		}

		else {
			updateAdvertiser.setEv(0);
		}

		if (advertiser.getSv1() != null) {
			if (advertiser.getSv1().equals("on")) {
				updateAdvertiser.setSv(1);
			}
		}

		else {
			updateAdvertiser.setSv(0);
		}

		if (advertiser.getTs1() != null) {
			if (advertiser.getTs1().equals("on")) {
				updateAdvertiser.setTs(1);
			}
		}

		else {
			updateAdvertiser.setTs(0);
		}

		if (advertiser.getTv1() != null) {
			if (advertiser.getTv1().equals("on")) {
				updateAdvertiser.setTv(1);
			}
		}

		else {
			updateAdvertiser.setTv(0);
		}

		return advertiserRepository.save(updateAdvertiser);
	}

	@Override
	public List<AdType> getAllAidTpe() {
		return aidTypeRepository.findAll();
	}

	@Override
	public Integer addAidType(AdType aidType) {

		if (aidType.getStatus() != null) {
			if (aidType.getStatus().equals("on")) {
				aidType.setStatus("1");
			}
		} else {
			aidType.setStatus("0");
		}
		if (aidTypeRepository.save(aidType) != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public Optional<AdType> updateAidById(Integer id) {

		return aidTypeRepository.findById(id);
	}

	@Override
	public int updateAidType(Integer id, AdType aidType) {
		AdType updatedAidtype = aidTypeRepository.findById(id).orElse(null);
		updatedAidtype.setAdName(aidType.getAdName());
		updatedAidtype.setWidth(aidType.getWidth());
		updatedAidtype.setHeight(aidType.getHeight());
		if (aidType.getStatus() != null) {
			if (aidType.getStatus().equals("on")) {
				updatedAidtype.setStatus("1");
			}
		} else {
			updatedAidtype.setStatus("0");
		}
		
	 if(aidTypeRepository.save(updatedAidtype)!=null)
	 {
		 return 1;
	 }else
	 {
		 return 0;
	 }
	}

	@Override
	public List<PmntGtway> getAllPaymentGateway() {
		return gatewayRepository.findAll();
	}

	@Override
	public Optional<PmntGtway> updategateWayByName(String name) {
		return Optional.ofNullable(gatewayRepository.findbyName(name));

	}

	

	@Override
	public List<PublisherEarningLog> getAllPubLog() {

		return earnLogrepository.findAll();
	}

	@Override
	@Transactional
	public List<AdvTransactionLog> getAllAdvTxLog() {

		return advTxLogrepository.findAll();
	}

	@Override
	public List<UserLoginHistory> getAllUserLogin() {

		return historyRepository.findAll();
	}

	@Override
	public List<Deposit> getAllPendingDeposit() {
		
		return depositRepository.getAllPendingDeposit();
	}

	@Override
	public List<Deposit> getAllApprovedDeposit() {
		
		return depositRepository.getAllApprovedDeposit();
	}

	@Override
	public List<Deposit> getAllSuccesDeposit() {
		return depositRepository.getAllSuccessDeposit();
	}

	@Override
	public List<Deposit> getAllRejectedDeposit() {
		return depositRepository.getAllRejectedDeposit();
	}

	@Override
	public List<Deposit> getAllDeposit() {
		return depositRepository.findAll();
	}

	@Override
	public List<WithDrawMethod> getAllWithdrawMethod() {

		return methodRepository.findAll();
	}

	@Override
	public Integer addWithdrawMethodType(WithDrawMethod method, MultipartFile file) {
		int status = 0;
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			method.setImage(file.getBytes());

			if (methodRepository.save(method) != null) {
				status = 1;
			} else {
				status = 0;
			}
		} catch (Exception e) {
			System.out.println("Exception while saving data in withdraw method");
		}
		return status;
	}

	@Override
	public List<Ticket> getAllTicket() {

		return ticketRepository.findAll();
	}

	/* All advertise started....... */
	@Override
	public List<Advertise> getAllAdvertise() {

		return advertiseRepository.findAll();
	}

	@Override
	public List<PricePlan> getAllPricePlan() {

		return planRepository.findAll();
	}

	@Override
	public List<IpLog> getAllIpLog() {

		return iplogRepository.findAll();
	}

	@Override
	public List<BlockedIpLog> getAllBlockIpLog() {
		return blockedIpRepository.findAll();
	}

	@Override
	public Integer addPricePlan(PricePlan plan) {
		if (plan.getStatus1() != null) {
			if (plan.getStatus1().equals("on")) {
				plan.setStatus(1);
			}
		} else {
			plan.setStatus(0);
		}
		plan.setType(plan.getType().substring(0, 1).toUpperCase() + plan.getType().substring(1));
		if (planRepository.save(plan) != null) {
			return 1;
		}
		else
		{
			return 0;
		}
		
	}

	@Override
	public Optional<PricePlan> updatePricePlanById(Integer id) {

		return planRepository.findById(id);
	}

	@Override
	public int updatePricePlan(Integer id, PricePlan plan) {
		PricePlan updatePlan = planRepository.findById(id).orElse(null);

		updatePlan.setName(plan.getName());
		updatePlan.setPrice(plan.getPrice());
		updatePlan.setType(plan.getType().substring(0, 1).toUpperCase() + plan.getType().substring(1));
		updatePlan.setCredit(plan.getCredit());
		if (plan.getStatus1() != null) {
			if (plan.getStatus1().equals("on")) {
				updatePlan.setStatus(1);
			}
		} else {
			updatePlan.setStatus(0);
		}

		if(planRepository.save(updatePlan)!=null)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public GlobalSetting getCpcAndCpm() {
		
		return globalSettingRepository.getGlobalSetting();
	}

	@Override
	public int updateCpcAndCpm(Integer id, double cpc, double cpm) {
	int res=globalSettingRepository.updateCpcAndCpmById(id, cpc, cpm);
	return res;
		
	}

	@Override
	public List<Domain> getAllApprovedDomain() {
		
		return domainRepository.findAll();
	}

	@Override
	public List<Domain> getAllPendingDomain() {
		
		return domainRepository.getAllPendingDomain();
	}
//For all Withdrawls
	@Override
	public List<WithDrawls> getAllWithdrawls() {
	
		return withdrawRepository.findAll();
	}

	@Override
	public List<WithDrawls> getAllPendingWithdrawls() {
		return withdrawRepository.getAllPendingWithdraw();
	}

	@Override
	public List<WithDrawls> getAllApprovedWithdrawls() {
		return withdrawRepository.getAllApprovedWithdraw();
	}

	@Override
	public List<WithDrawls> getAllRejectedWithdrawls() {
		return withdrawRepository.getAllRejectedWithdraw();
	}

	@Override
	public List<UserLoginHistory> getAllPublisherLogin(Integer pid) {
		
		return historyRepository.getAllPublisherLog(pid);
	}

	@Override
	public List<UserLoginHistory> getAllPublisherLoginIp(String ip) {
		
		return historyRepository.getAllPublisherHistoryIpLog(ip);
	}

	@Override
	@Transactional
	public int saveOrUpdateAdvAndTrans(String amount,Advertiser advertiser, AdvTransactionLog advTransactionLog,String status) {
		Advertiser updateAdv=advertiserRepository.findById(advertiser.getId()).orElse(null);
		Integer counter=0;
		if(status==null)
		{
			updateAdv.setBalance(updateAdv.getBalance()-Double.parseDouble(amount));
		}
		else
		{
			updateAdv.setBalance(updateAdv.getBalance()+Double.parseDouble(amount));
		}
		
		if(advertiserRepository.save(updateAdv)!=null)
		{
			counter=1;
			if(advTxLogrepository.count()==0)
			{
				if(status==null)
				{
					
					advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
					advTransactionLog.setAmount(Double.parseDouble(amount));
					advTransactionLog.setCharge(0);
					advTransactionLog.setPost_balance(Double.parseDouble(amount));
					advTransactionLog.setDetails(GeneralConstant.adminsubMsg);
					advTxLogrepository.save(advTransactionLog);
					counter=1;
				}
				else
				{
					
					advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
					advTransactionLog.setAmount(Double.parseDouble(amount));
					advTransactionLog.setCharge(0);
					advTransactionLog.setPost_balance(Double.parseDouble(amount));
					advTransactionLog.setDetails(GeneralConstant.adminMsg);
					if(advTxLogrepository.save(advTransactionLog)!=null)
					{
						counter=1;
					}
					
				}
				
			}
			else   
			{
				List<AdvTransactionLog> getalladvTxList=advTxLogrepository.findAll();
				for(int i=0; i<getalladvTxList.size(); i++)
				{
					if(status==null)
					{
						
						advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
						advTransactionLog.setAmount(Double.parseDouble(amount));
						advTransactionLog.setCharge(0);
						advTransactionLog.setPost_balance(getalladvTxList.get(i).getPost_balance()-Double.parseDouble(amount));
						advTransactionLog.setDetails(GeneralConstant.adminsubMsg);
						if(advTxLogrepository.save(advTransactionLog)!=null)
						{
							counter=1;
						}
					}
					else
					{
					
					advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
					advTransactionLog.setAmount(Double.parseDouble(amount));
					advTransactionLog.setCharge(0);
					advTransactionLog.setPost_balance(getalladvTxList.get(i).getPost_balance()+Double.parseDouble(amount));
					advTransactionLog.setDetails(GeneralConstant.adminMsg);
					if(advTxLogrepository.save(advTransactionLog)!=null)
					{
						counter=1;
					}
					}
					
				}
				
			}
			
		
			
			
		}
		return counter;
		
		
		
		
	}

	@Override
	public List<Ticket> getAllPendingTicket() {
	
		return ticketRepository.getAllPendingTicket();
	}

	@Override
	public List<Ticket> getAllClosedTicket() {
		return ticketRepository.getAllclosedTicket();
	}

	@Override
	public List<Ticket> getAllAnsweredTicket() {
		return ticketRepository.getAllAnsweredTicket();
	}

	@Override
	public Ticket getTicketStatus(Integer id) {
		return ticketRepository.findById(id).orElse(null);
	}

	@Override
	public List<UserLoginHistory> getAllAdvertiserLogin(Integer aid) {
		return historyRepository.getAllAdvertiserLog(aid);
	}

	@Override
	public List<UserLoginHistory> getAllAdvertiserLoginIp(String ip) {
		return historyRepository.getAllAdvertiserIpLog(ip);
	}

	@Override
	public Optional<WithDrawMethod> updateWithdrawMethodById(Integer id) {
		
		return methodRepository.findById(id);
	}

	@Override
	public WithDrawMethod updateWithdrawMethod(Integer id, WithDrawMethod method,MultipartFile file) throws IOException {
		
		WithDrawMethod updatedMethod=methodRepository.findById(id).orElse(null);
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		
		updatedMethod.setName(method.getName());
		updatedMethod.setStatus(method.getStatus());
		updatedMethod.setCurrency(method.getCurrency());
		updatedMethod.setDescription(method.getDescription());
		updatedMethod.setUser_data(method.getUser_data());
		updatedMethod.setDelay(method.getDelay());
		updatedMethod.setFixed_charge(method.getFixed_charge());
		updatedMethod.setPercent_charge(method.getPercent_charge());
		updatedMethod.setMax_limit(method.getMax_limit());
		updatedMethod.setMin_limit(method.getMin_limit());
		updatedMethod.setRate(method.getRate());
		updatedMethod.setUpdated_at(new Date());
		updatedMethod.setImage(file.getBytes());
		methodRepository.save(updatedMethod);
		return updatedMethod;
		
	}

	@Override
	public WithDrawMethod deActivateWithdrawMethod(Integer id) {
		
		WithDrawMethod method= methodRepository.findById(id).orElse(null);
		method.setStatus(0);
		methodRepository.save(method);
		return null;
	}

	@Override
	public  Optional<WithDrawMethod> activateWithdrawMethod(Integer id) {
		WithDrawMethod method= methodRepository.findById(id).orElse(null);
		method.setStatus(1);
		methodRepository.save(method);
		return null;
	}

	@Override
	public GlobalSetting getGeneralSetting() {
		
		return generalSettingRepository.getGeneralSetting();
	}

	@Override
	public GlobalSetting updateGeneralSetting(GlobalSetting setting, Integer id) {
		GlobalSetting updateSetting=generalSettingRepository.findById(id).orElse(null);
		updateSetting.setSitename(setting.getSitename());
		updateSetting.setCur_sym(setting.getCur_sym());
		updateSetting.setCur_text(setting.getCur_text());
		updateSetting.setIntervals(setting.getIntervals());
		updateSetting.setAddress(setting.getAddress());
		updateSetting.setEmail(setting.getEmail());
		updateSetting.setPhone(setting.getPhone());
		updateSetting.setApikey(setting.getApikey());
		updateSetting.setBase_color(setting.getBase_color());
		updateSetting.setSecondary_color(setting.getSecondary_color());
		updateSetting.setLocation_api(setting.getLocation_api());
		
		if(setting.getRegistration1()!= null) {
			if (setting.getRegistration1().equals("on")) {
				updateSetting.setRegistration(1);
			}
		} else {
			updateSetting.setRegistration(0);
		}
		
		if(setting.getDomain_approval1()!= null) {
			if (setting.getDomain_approval1().equals("on")) {
				updateSetting.setDomain_approval(1);
			}
		} else {
			updateSetting.setDomain_approval(0);
		}
		
		if(setting.getEv1()!= null) {
			if (setting.getEv1().equals("on")) {
				updateSetting.setEv(1);
			}
		} else {
			updateSetting.setEv(0);
		}
		
		if(setting.getEn1()!= null) {
			if (setting.getEn1().equals("on")) {
				updateSetting.setEn(1);
			}
		} else {
			updateSetting.setEn(0);
		}
		
		if(setting.getSv1()!= null) {
			if (setting.getSv1().equals("on")) {
				updateSetting.setSv(1);
			}
		} else {
			updateSetting.setSv(0);
		}
		
		if(setting.getSn1()!= null) {
			if (setting.getSn1().equals("on")) {
				updateSetting.setSn(1);
			}
		} else {
			updateSetting.setSn(0);
		}
		
		return generalSettingRepository.save(updateSetting);
	}

	@Override
	public List<Extension> getAllExtension() {
		
		return extensionRepository.findAll();
	}

	@Override
	public List<Language> getAllLangList() {
		
		return languageRepository.findAll();
	}

	@Override
	public void addLanguage(Language lang) {
		
		if(lang.getIs_default1()!=null)
		{
			if(lang.getIs_default1().equals("on"))
			{
				lang.setIs_default(1);
			}
		}
		else {
			lang.setIs_default(0);
		}
		languageRepository.save(lang);
		
	}

	@Override
	public Optional<Language> updateLangById(Integer id) {
		
		return languageRepository.findById(id);
	}

	@Override
	public Language updateLangByIdVal(Integer id, Language lang) {
		Language updateLang=languageRepository.findById(id).orElse(null);
		updateLang.setName(lang.getName());
		updateLang.setText_align(lang.getText_align());
		updateLang.setIcon(lang.getIcon());
		if(lang.getIs_default1()!=null)
		{
			if(lang.getIs_default1().equals("on"))
			{
				updateLang.setIs_default(1);
			}
		}
		
		else {
			updateLang.setIs_default(0);
		}
		 return languageRepository.save(updateLang);
		
	}

	@Override
	@Transactional
	public void saveOrUpdatePublisherBalance(String amount, Publisher publish, AdvTransactionLog advTransactionLog,
			String status) {
		
		
		
		Publisher updatePublish=publisherRepository.findById(publish.getId()).orElse(null);
			if(status==null)
			{
				updatePublish.setBalance(updatePublish.getBalance()-Double.parseDouble(amount));
			}
			else
			{
				updatePublish.setBalance(updatePublish.getBalance()+Double.parseDouble(amount));
			}
			
			if(publisherRepository.save(updatePublish)!=null)
			{
				if(publisherRepository.count()==0)
				{
					if(status==null)
					{
						
						advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
						advTransactionLog.setAmount(Double.parseDouble(amount));
						advTransactionLog.setCharge(0);
						advTransactionLog.setPost_balance(Double.parseDouble(amount));
						advTransactionLog.setDetails(GeneralConstant.adminsubMsg);
						advTxLogrepository.save(advTransactionLog);
					}
					else
					{
						
						advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
						advTransactionLog.setAmount(Double.parseDouble(amount));
						advTransactionLog.setCharge(0);
						advTransactionLog.setPost_balance(Double.parseDouble(amount));
						advTransactionLog.setDetails(GeneralConstant.adminMsg);
						advTxLogrepository.save(advTransactionLog);
					}
					
				}
				else   
				{
					List<AdvTransactionLog> getalladvTxList=advTxLogrepository.findAll();
					for(int i=0; i<getalladvTxList.size(); i++)
					{
						if(status==null)
						{
							
							advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
							advTransactionLog.setAmount(Double.parseDouble(amount));
							advTransactionLog.setCharge(0);
							advTransactionLog.setPost_balance(getalladvTxList.get(i).getPost_balance()-Double.parseDouble(amount));
							advTransactionLog.setDetails(GeneralConstant.adminsubMsg);
							advTxLogrepository.save(advTransactionLog);
						}
						else
						{
						
						advTransactionLog.setTrx(Utility.generateUniqueTranx(12));
						advTransactionLog.setAmount(Double.parseDouble(amount));
						advTransactionLog.setCharge(0);
						advTransactionLog.setPost_balance(getalladvTxList.get(i).getPost_balance()+Double.parseDouble(amount));
						advTransactionLog.setDetails(GeneralConstant.adminMsg);
						advTxLogrepository.save(advTransactionLog);
						}
						
					}
					
				}
				
			
				
				
			}
			
			
			
			
		
	}

	@Override
	public Optional<Publisher> getPublisherById(Integer id) {
		
		return publisherRepository.findById(id);
	}

	@Override
	public Optional<Advertiser> getAdvertiserById(Integer id) {
		
		return advertiserRepository.findById(id);
	}

	@Transactional
	@Override
	public boolean sendReplayTicketToUsers(Ticket ticket, Integer id, String message, MultipartFile[] file,Integer adminId) {
		SupportMessage sMsg=null;
		SupportAttachment sAttach=null;
		if(messageRepository.count()==0)
		{
			sMsg=new SupportMessage();
			sMsg.setSupportticket_id(ticket.getId());
			sMsg.setAdmin_id(adminId);
			sMsg.setMessage(message);
			SupportMessage updateMsg= messageRepository.save(sMsg);
			if(attachementRepository.count()==0)
			{
				sAttach=new SupportAttachment();
				sAttach.setSupport_message_id(updateMsg.getId());
				for(int i=0; i<file.length; i++)
				{
					String fileName = StringUtils.cleanPath(file[i].getOriginalFilename());
					
					if (fileName.contains("..")) {
						System.out.println("not a a valid file");
					}
					try {
						sAttach.setAttachment(file[i].getBytes());
						attachementRepository.save(sAttach);
					} catch (Exception e) {

					}

				}
					
			}
			
			
		 	
	
		}
		
		if(sMsg!=null && sAttach!=null && ticketRepository.save(ticket)!=null)
		{
			return true;
		}
		
		
		
		return false;
	}

	@Override
	public Frontend getSeoManagerdata() {
		
		return frontendRepository.getSeoManagerData();
	}

	@Override
	public Frontend updateSeoManager(Frontend frontend) {
	Frontend updateSeo=frontendRepository.getSeoManagerData();
	updateSeo.setData_keys(frontend.getData_keys());
	updateSeo.setData_values(frontend.getData_values());
		return frontendRepository.save(updateSeo);
	}

	@Override
	public void EnableOrdisableExtension(int parseInt) {
		
		Extension update=extensionRepository.findById(parseInt).orElse(null);
		update.setStatus(0);
		extensionRepository.save(update);
	}

	@Override
	public void activateExtension(int parseInt) {
		Extension update=extensionRepository.findById(parseInt).orElse(null);
		update.setStatus(1);
		extensionRepository.save(update);
	}

	@Override
	public int saveLogoIcon(MultipartFile file1, MultipartFile file2) {
		int counter=0;
		LogoIconSetting logoicon = new LogoIconSetting();
		if (iconRepository.count() == 0) {
			
			String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
			String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
			if (fileName1.contains("..") || fileName2.contains("..")) {
				System.out.println("not a a valid file");
			}
			
			
			
			try {
				logoicon.setLogo(file1.getBytes());
				logoicon.setFavicon(file2.getBytes());
				if(iconRepository.save(logoicon)!=null)
				{
					counter=1;
				}

			} catch (Exception e) {

			}
		}
		LogoIconSetting updateSetting=iconRepository.getLogoIconDetails();
		String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
		String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
		if (fileName1.contains("..") || fileName2.contains("..")) {
			System.out.println("not a a valid file");
		}
		
		if(fileName1.isEmpty())
		{
			
			logoicon.setLogo(updateSetting.getLogo());
			
		}
		if(fileName2.isEmpty())
		{
			logoicon.setFavicon(updateSetting.getFavicon());
		}
		
		else
		{
			try {
				logoicon.setLogo(file1.getBytes());
				logoicon.setFavicon(file2.getBytes());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
			
			
			try {
				
				updateSetting.setLogo(logoicon.getLogo());
				updateSetting.setFavicon(logoicon.getFavicon());
				if(iconRepository.save(updateSetting)!=null)
				{
					counter=1;
				}

			} catch (Exception e) {

			}
			return counter;
		}
	

	@Override
	public LogoIconSetting getLogoIconDetails() {
		
		return iconRepository.getLogoIconDetails();
	}

	@Override
	public List<SmsManager> getAllSms() {
		
		return smsmanagerRepository.findAll();
	}

	@Override
	public Optional<SmsManager> updateSmsById(Integer id) {
		
		return smsmanagerRepository.findById(id);
	}

	@Override
	public void updateSmsManager(Integer id, SmsManager smsMgr) {
		
		SmsManager updateSms= smsmanagerRepository.findById(id).orElse(null);
		updateSms.setSms_body(smsMgr.getSms_body());
		if(smsMgr.getSms_status1()!=null)
		{
			if(smsMgr.getSms_status1().equals("on"))
			{
				updateSms.setSms_status(1);
			}
		}
		else
		{
			updateSms.setSms_status(0);
		}
		
		smsmanagerRepository.save(updateSms);
	}

	@Override
	public List<SmsManager> getAllEmail() {
		return smsmanagerRepository.findAll();
	}

	@Override
	public Optional<SmsManager> updateEmailById(Integer id) {
		return smsmanagerRepository.findById(id);
	}

	@Override
	public void updateEmailManager(Integer id, SmsManager smsMgr) {
		SmsManager updateEmail= smsmanagerRepository.findById(id).orElse(null);
		updateEmail.setEmail_body(smsMgr.getEmail_body());
		updateEmail.setSubj(smsMgr.getSubj());
		if(smsMgr.getEmail_status1()!=null)
		{
			if(smsMgr.getEmail_status1().equals("on"))
			{
				updateEmail.setEmail_status(1);     
			}
		}
		else
		{
			updateEmail.setEmail_status(0);
		}
		smsmanagerRepository.save(updateEmail);
	}

	@Override
	public int updateGlobalSmsApi(Integer id,GlobalSetting setting) {
	   GlobalSetting updateSetting=globalSettingRepository.findById(id).orElse(null);
	   updateSetting.setSms_api(setting.getSms_api());
	  if(globalSettingRepository.save(updateSetting)!=null)
	  {
		  return 1;
	  }
	  else
	  {
		  return 0;
	  }
	}

	@Override
	public void updateGlobalEmailTemplate(Integer id, GlobalSetting setting) {
		 GlobalSetting updateSetting=globalSettingRepository.findById(id).orElse(null);
		 updateSetting.setEmail_from(setting.getEmail_from());
		 updateSetting.setEmail_template(setting.getEmail_template());
		 globalSettingRepository.save(updateSetting);
	}

	@Override
	public List<Publisher> activeSearchPublisherByNameOrEmail(String value) {
		
		return publisherRepository.activeSearchPublisherByNameOrEmail(value);
	}


	@Override
	public Admin getAdminByUserName(String userName) {
		return adminRepository.findByUsername(userName);
	}
	
	 @Override
		public void increaseFailedAttempts(Admin admin) {
	        int newFailAttempts = admin.getFailedAttempt() + 1;
	        adminRepository.updateFailedAttempts(newFailAttempts, admin.getUserName());
	    }
		 @Override
	    public void resetFailedAttempts(String username) {
			 adminRepository.updateFailedAttempts(0, username);
	    }
	     
	    @Override
	    public void lock(Admin admin) {
	    	admin.setAccountNonLocked(false);
	    	admin.setLockTime(new Date());
	         
	    	adminRepository.save(admin);
	    }
	     
	    @Override
	    public boolean unlockWhenTimeExpired(Admin admin) {
	        long lockTimeInMillis = admin.getLockTime().getTime();
	        long currentTimeInMillis = System.currentTimeMillis();
	         
	        if (lockTimeInMillis + UtilityConstant.LOCK_TIME_DURATION < currentTimeInMillis) {
	        	admin.setAccountNonLocked(true);
	        	admin.setLockTime(null);
	        	admin.setFailedAttempt(0);
	             
	        	adminRepository.save(admin);
	             
	            return true;
	        }
	         
	        return false;
	    }

		

		
		@Override
		public Admin saveAdmin(Admin admin,int id) {
			Admin updated=adminRepository.findById(id).orElse(null);
			updated.setName(admin.getName());
			updated.setEmail(admin.getEmail());
			if(admin.getImage().isEmpty())
			{
				admin.setImage(updated.getImage());
			}
			updated.setImage(admin.getImage());
			return adminRepository.save(updated);
		}

		@Override
		public List<Country> getListOfCountries() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Admin getAdminDetails() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Admin changeAdminPassword(String userName, String newPassword) {
			Admin updatedPass=adminRepository.findByUsername(userName);
			updatedPass.setPassword(BcryptHashedPassword.hashedPassword(newPassword));
			return adminRepository.save(updatedPass);
		}

		


}
