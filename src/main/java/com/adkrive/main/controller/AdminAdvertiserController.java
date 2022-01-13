package com.adkrive.main.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
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


@Controller
public class AdminAdvertiserController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/advertiser/all")
	public String viewAllAdvertiser(Model model, HttpServletRequest request) {
		List<Advertiser> listOfAllAdvertiser = adminService.getAllAdvertiser();
		model.addAttribute("advertise", new Advertiser());
		model.addAttribute("all", "all");
		model.addAttribute("listOfAllAdvertiser", listOfAllAdvertiser);
		return "advertiser";

	}

	@GetMapping("/advertiser/active/all")
	public String viewAllActiveAdvertiser(Model model, HttpSession session, HttpServletRequest req) {
		session = req.getSession();
		model.addAttribute("active", "active");
		List<Advertiser> listOfAllActiveAdvertiser = adminService.getAllActiveAdvertiser();
		model.addAttribute("listOfAllActiveAdvertiser", listOfAllActiveAdvertiser);
		return "activeAdvertiser";

	}

	@GetMapping("/advertiser/banned/all")
	public String viewAllBannedAdvertiser(Model model) {
		List<Advertiser> listOfAllBannedAdvertiser = adminService.getAllBannedAdvertiser();
		model.addAttribute("banned", "banned");
		model.addAttribute("listOfAllBannedAdvertiser", listOfAllBannedAdvertiser);
		return "bannedAdvertiser";

	}

	@GetMapping("/advertiser/email-unverified")
	public String viewAllEmailUnverifiedAdvertiser(Model model) {
		List<Advertiser> listOfAllEmailUnverifiedAdvertiser = adminService.getAllEmailUnverifiedAdvertiser();
		model.addAttribute("emailUnverified", "emailUnverified");
		model.addAttribute("listOfAllEmailUnverifiedAdvertiser", listOfAllEmailUnverifiedAdvertiser);
		return "emailUnVerifiedAdvertiser";

	}

	@GetMapping("/advertiser/sms-unverified")
	public String viewAllSmsUnverifiedAdvertiser(Model model) {
		List<Advertiser> listOfAllSmsUnverifiedAdvertiser = adminService.getAllSmslUnverifiedAdvertiser();
		model.addAttribute("smsUnverified", "smsUnverified");
		model.addAttribute("listOfAllSmsUnverifiedAdvertiser", listOfAllSmsUnverifiedAdvertiser);
		return "smsUnVerifiedAdvertiser";

	}

	@GetMapping("/advertiser/send-email")
	public String viewSendEmailToAllAdvertiser() {
		return "sendMailToAllAdvertiser";

	}

	@PostMapping("/advertiser/send-email")
	public String sendEmailToAllAdvertiser(@RequestParam("subject") String subject,
			@RequestParam("message") String message, Model model,RedirectAttributes redirectAttributes)
			throws MessagingException, UnknownHostException, IOException {
		List<Advertiser> allAdvList = adminService.getAllAdvertiser();

		List<String> names = allAdvList.stream().map(Advertiser::getEmail).collect(Collectors.toList());

		System.out.println(message);
		boolean status = Utility.sendMailToAll(names, subject, message, mailSender);
		if (status) {
			redirectAttributes.addFlashAttribute("message",GeneralConstant.advertserSendMsgToAll);
			return "redirect:/advertiser/send-email";
		} else {
			model.addAttribute("message", "Mail send Failed");
			return "redirect:/advertiser/send-email";
		}

	}

	@GetMapping("/advertiser/search")
	public String searchByNameOrEmail(@RequestParam("search") String value, Model model, HttpSession session) {

		List<Advertiser> advertiserList = adminService.searchAdvertiserByNameOrEmail(value);
		model.addAttribute("search", "search");
		model.addAttribute("searchList", advertiserList);
		return "advertiser";

	}
	
	
	@GetMapping("/advertiser/active/search")
	public String activeSearchByNameOrEmail(@RequestParam("search") String value, Model model, HttpSession session) {

		List<Advertiser> advertiserList = adminService.activeSearchAdvertiserByNameOrEmail(value);
		model.addAttribute("search", "search");
		model.addAttribute("searchList", advertiserList);
		return "advertiser";

	}


	public Map<String, String> getCountryList() {
		Map<String, String> countryMap = new LinkedHashMap<String, String>();
		List<Country> countryList = adminService.getListOfCountries();
		if (countryList != null) {
			for (int i = 0; i < countryList.size(); i++) {
				countryMap.put(countryList.get(i).getCountryCode().toString(),
						countryList.get(i).getCountryName().toString());
			}
		}

		return countryMap;

	}


	// Changing method

	@GetMapping("/advertiser/details/{id}")
	public String showUpdateAdvertiserPage(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("advertise", adminService.updateByAdvertiserId(id).orElse(null));
		model.addAttribute("advTxCount", adminService.getAllAdvTxLog().size());
		return "advertiserDetails";
	}

	@PostMapping("/advertiser/update/{id}")
	public String updateAdvertiserPage(@PathVariable Integer id, @ModelAttribute("advertise") Advertiser advertiser,
			Model model,RedirectAttributes redirectAttributes) {
		if(adminService.updateAdvertiserDetail(id, advertiser)!=null)
		{
			redirectAttributes.addFlashAttribute("message",GeneralConstant.advertserMsg);
		}
		model.addAttribute("advertise", adminService.updateByAdvertiserId(id).orElse(null));
		return "redirect:/advertiser/details/{id}";
	}

	@PostMapping("/advertiser/add-sub-balance/{id}")
	public String advertiserAddOrSubBalance(@PathVariable Integer id, @RequestParam(value = "amount") String amount,
			@ModelAttribute("advertise") Advertiser advertiser, Model model, HttpServletRequest req,RedirectAttributes redirectAttributes) {
		String status = req.getParameter("act");
	
		int statusTest=adminService.saveOrUpdateAdvAndTrans(amount, advertiser, new AdvTransactionLog(), status);
		if(statusTest!=0)
		{
			if(status!=null)
			{
				redirectAttributes.addFlashAttribute("message",GeneralConstant.advertserAddMsg);
			}
			else
			{
				
				redirectAttributes.addFlashAttribute("message",GeneralConstant.advertserSubMsg);
			}
		}
		return "redirect:/advertiser/details/{id}";
	}

	@GetMapping("/advertiser/login/history/{id}")
	public String advertiserLogHistoryPage(Model model, @PathVariable(value = "id") Integer aid) {
		model.addAttribute("advLogHistory", adminService.getAllAdvertiserLogin(aid));
		return "advertiserLogHistory";
	}

	@GetMapping("/user/email/{id}/advertiser")
	public String showSendMailToSpecificAdvertiser(Model model, @PathVariable(value = "id") Integer id) {
		Admin admin = adminService.getAdminDetails();
		model.addAttribute("adminid", admin.getId());
		model.addAttribute("advertise", adminService.getAdvertiserById(id).orElse(null));
		
		return "sendMailToSpecificAdvertiser";
	}

	@GetMapping("/advertiser/transactions/{id}")
	public String getAdvertiseTransaction(Model model, @PathVariable(value = "id") Integer id)
	{
		model.addAttribute("advertise", adminService.getAdvertiserById(id).orElse(null));
		model.addAttribute("advTxLog",adminService.getAllAdvTxLog());
		return "advertiserTransaction";
	}
	
	@GetMapping("/advertiser/deposits/{id}")
	public String getAdvertiserDeposit(Model model, @PathVariable(value = "id") Integer id)
	{
		model.addAttribute("advertise", adminService.getAdvertiserById(id).orElse(null));
		model.addAttribute("advDepositList",adminService.getAllDeposit());
		
		return "advertiserDeposit";
	}
	
	@GetMapping("/advertiser/ads/{id}")
	public String getAdvertiserAd(Model model, @PathVariable(value = "id") Integer id)
	{
		model.addAttribute("advertise", adminService.getAdvertiserById(id).orElse(null));
		model.addAttribute("advListAid",adminService.getAllAdvertise());
		
		return "advertiserAd";
	}
	
	

}
