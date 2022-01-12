package com.adkrive.main.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.adkrive.main.adminservice.AdminService;

import com.adkrive.main.general.GeneralConstant;
import com.adkrive.main.general.Utility;

import com.adkrive.main.model.Admin;
import com.adkrive.main.model.AdvTransactionLog;
import com.adkrive.main.model.Advertiser;
import com.adkrive.main.model.Country;
import com.adkrive.main.model.Publisher;


@Controller
public class AdminPublisherController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private JavaMailSender mailSender;

	private static int counter=0;
	@GetMapping("/publisher/all")
	public String showReadAllPublisherPage(Model model) {
		model.addAttribute("publish", new Publisher());
		model.addAttribute("all", "all");
		model.addAttribute("listOfAllPublishers", adminService.getAllPublisher());
		return "publisher";
	}

	@GetMapping("/publisher/details/{id}")
	public String showUpdatePublisherPage(@PathVariable Integer id, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("publish", adminService.updateByPublisherId(id).orElse(null));
		return "activePublisherDetails";
	}

	@PostMapping("/publisher/update/{id}")
	public String updatePublisherPage(@PathVariable Integer id, @ModelAttribute("publish") Publisher publish,RedirectAttributes redirectAttributes,
			Model model, HttpServletRequest req) {
		
		if(adminService.updatePublisherDetail(id, publish)!=null)
		{
			counter=1;
			redirectAttributes.addFlashAttribute("count",counter);
			redirectAttributes.addFlashAttribute("Msg",GeneralConstant.publisherrMsg);
		}
		model.addAttribute("publish", adminService.updateByPublisherId(id).orElse(null));
		return "redirect:/publisher/details/{id}";
	}

	@GetMapping("/publisher/active/all")
	public String showReadAllActivePublisherPage(Model model) {
		model.addAttribute("publish", new Publisher());
		model.addAttribute("active", "active");
		model.addAttribute("listOfAllActivePublishers", adminService.getAllActivePublisher());
		return "activePublisher";
	}

	@GetMapping("/publisher/banned/all")
	public String showReadAllBannedPublisherPage(Model model) {
		model.addAttribute("publish", new Publisher());
		model.addAttribute("listOfAllBannedPublishers", adminService.getAllBannedPublisher());
		return "bannedPublisher";
	}

	@GetMapping("/publisher/email-unverified")
	public String showReadAllEmailUnverifiedPublisherPage(Model model) {
		model.addAttribute("publish", new Publisher());
		
		model.addAttribute("listOfAllEmailUnverifiedPublisher", adminService.getAllEmailUnverifiedPublisher());
		return "email-UnverifiedPublisher";
	}

	@GetMapping("/publisher/sms-unverified")
	public String showReadAllSmsUnverifiedPublisherPage(Model model) {
		model.addAttribute("publish", new Publisher());
		
		model.addAttribute("listOfAllSmsUnverifiedPublisher", adminService.getAllSmslUnverifiedPublisher());
		return "sms-UnverifiedPublisher";
	}

	@GetMapping("/publisher/search")
	public String searchByNameOrEmail(@RequestParam("search") String value, Model model, HttpSession session) {
		List<Publisher> publishersList = adminService.searchPublisherByNameOrEmail(value);
		model.addAttribute("search", "search");
		model.addAttribute("searchList", publishersList);
		return "publisher";
	}
	
	@GetMapping("/publisher/active/search")
	public String activeSearchByNameOrEmail(@RequestParam("search") String value, Model model, HttpSession session) {

		List<Publisher> publisherList = adminService.activeSearchPublisherByNameOrEmail(value);
		model.addAttribute("search", "search");
		model.addAttribute("searchList", publisherList);
		return "publisher";

	}

	public Map<String, String> getCountryList() {

		Map<String, String> countryMap = new HashMap<String, String>();
		List<Country> countryList = adminService.getListOfCountries();
		if (countryList != null) {
			for (int i = 0; i < countryList.size(); i++) {
				countryMap.put(countryList.get(i).getCountryCode().toString(),
						countryList.get(i).getCountryName().toString());
			}

		}

		return countryMap;
	}

	@GetMapping("/publisher/login/history/{id}")
	public String publisherAddOrSubBalancePage(Model model, @PathVariable(value = "id") Integer pid) {
		model.addAttribute("pubLogHistory", adminService.getAllPublisherLogin(pid));
		return "publisherLogHistory";
	}

	@GetMapping("/users/login/ipHistory/{ip}")
	public String redirectPageTouserHistoryBasedOnIp(Model model, @PathVariable(value = "ip") String ip) {
		model.addAttribute("pubLogIpHistory", adminService.getAllPublisherLoginIp(ip));
		return "publishUserLoginIpHistory";

	}

	@GetMapping("/user/email/{id}/publisher")
	public String showSendMailToSpecificPublisher(Model model, @PathVariable(value = "id") Integer id) {

	 Admin admin=	adminService.getAdminDetails();
	 model.addAttribute("adminid",admin.getId());

		model.addAttribute("publish",adminService.getPublisherById(id).orElse(null));
		return "sendMailToSpecificPublisher";
	}
	
	@PostMapping("/user/send-email/{id}/{uid}")
	public String sendEmailToPublisherByAdmin(@PathVariable(value = "id") Integer id,@PathVariable(value = "uid") Integer uid,@RequestParam("message") String message,@RequestParam("subject") String subject,Model model,RedirectAttributes redirectAttributes)throws MessagingException, UnknownHostException, IOException
	{
		boolean status=false;
		if(uid==1)
		{
			Publisher publisher=adminService.getPublisherById(id).orElse(null);
			status=Utility.sendMailToSpecific(publisher.getEmail(),message, subject,mailSender);
			if(status)
			{
				redirectAttributes.addFlashAttribute("count",counter+1);
				redirectAttributes.addFlashAttribute("Msg",GeneralConstant.publisherSendMsg);
			}
			model.addAttribute("publish",adminService.getPublisherById(id).orElse(null));
			return "redirect:/user/email/{id}/publisher";
		}
		else
		{
			Advertiser advertiser = adminService.getAdvertiserById(id).orElse(null);
			status=Utility.sendMailToSpecific(advertiser.getEmail(), message, subject, mailSender);
			if(status)
			{
				redirectAttributes.addFlashAttribute("count",counter+1);
				redirectAttributes.addFlashAttribute("Msg",GeneralConstant.advertserSendMsg);
			}
			model.addAttribute("advertise", adminService.getAdvertiserById(id).orElse(null));
			return "redirect:/user/email/{id}/advertiser";
		}
		
	}

	@PostMapping("/publisher/send-email")
	public String sendEmailToAllPublishers(@RequestParam("subject") String subject,

			@RequestParam("message") String message, Model model,RedirectAttributes redirectAttributes)
			throws MessagingException, UnknownHostException, IOException {
		List<Publisher> allPublishList = adminService.getAllPublisher();

		List<String> names = allPublishList.stream().map(Publisher::getEmail).collect(Collectors.toList());

		System.out.println(message);
		boolean status = Utility.sendMailToAll(names, subject, message, mailSender);
		if (status) {
			redirectAttributes.addFlashAttribute("count",counter+1);
			redirectAttributes.addFlashAttribute("Msg",GeneralConstant.publisherAllSendMsg);
			return "redirect:/publisher/send-email";
		} else {
			model.addAttribute("Msg", "Mail send Failed to all Publishers");
			return "redirect:/publisher/send-email";
		}

	}

	@GetMapping("/publisher/send-email")
	public String viewSendEmailToAllPublishers() {
		return "sendMailToAllPublisher";

	}
	
	@PostMapping("/publisher/add-sub-balance/{id}")
	public String publisherAddOrSubBalance(@PathVariable Integer id,@RequestParam(value ="amount") String amount, @ModelAttribute("publish") Publisher publish,Model model,HttpServletRequest req) {
		String status= req.getParameter("act");
		adminService.saveOrUpdatePublisherBalance(amount,publish,new AdvTransactionLog(),status);
		
		
		
		return "redirect:/publisher/details/{id}";
	}
	
	@GetMapping("/publisher/withdrawals/{id}")
	public String getPublisherWithdrawls(@PathVariable Integer id,Model model)
	{
		model.addAttribute("publish",adminService.getPublisherById(id).orElse(null));
		model.addAttribute("pubWithdrawList",adminService.getAllWithdrawls());
		return "publisherWithdrawls";
	}

}
