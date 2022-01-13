package com.adkrive.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.adkrive.main.adminservice.AdminService;

import com.adkrive.main.general.GeneralConstant;

import com.adkrive.main.model.AdType;
import com.adkrive.main.model.Advertise;
import com.adkrive.main.model.BlockedIpLog;
import com.adkrive.main.model.GlobalSetting;
import com.adkrive.main.model.IpLog;
import com.adkrive.main.model.PricePlan;



@Controller
public class AdvertisesController {

	@Autowired
	private AdminService adminService;
	
	
	//All Advertiser started
	@GetMapping("/advertise/all")
	public String showAdvertisesAll(Model model) {
		model.addAttribute("advertise", new Advertise());
		model.addAttribute("listAdvertise", adminService.getAllAdvertise());
		return "advertise";
	}
	
	//all price plan started
	
	@GetMapping("/advertise/price-plan")
	public String showPricePlanAll(Model model) {
		model.addAttribute("priceplan", new PricePlan());
		model.addAttribute("pricePlanList", adminService.getAllPricePlan());
		return "priceplan";
	}
	
	@PostMapping("/advertise/add/price-plan")
	public String createPricePlan(@ModelAttribute("priceplan") PricePlan plan,RedirectAttributes redirectAttributes) {
	
	int status=adminService.addPricePlan(plan);
	
	
		if(status!=0)
		{
			redirectAttributes.addFlashAttribute("message","Price Plan Created SuccessFully");
		}
		
	
		
		
		
		return "redirect:/advertise/price-plan";
	}
	
	@GetMapping("/advertise/update/price-plan/{id}")
	public String showUpdatePricePlanPage(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
		model.addAttribute("id", id);
		model.addAttribute("priceplan", adminService.updatePricePlanById(id).orElse(null));
		
		return "priceplan";
	}

	@PostMapping("/advertise/update/price-plan/{id}")
	public String updatePricePlanPage(@PathVariable Integer id, @ModelAttribute("priceplan") PricePlan plan,Model model,RedirectAttributes redirectAttributes) {
		int status=adminService.updatePricePlan(id, plan);
		if(status!=0)
		{
			
			redirectAttributes.addFlashAttribute("message","Price Plan Updated SuccessFully");
		}
		model.addAttribute("priceplan", adminService.updatePricePlanById(id).orElse(null));
		return "redirect:/advertise/price-plan";
	}

	//all ip log started
	@GetMapping("/advertise/ip-log")
	public String showIpLogAll(Model model) {
		model.addAttribute("ipLog", new IpLog());
		model.addAttribute("ipList", adminService.getAllIpLog());
		return "iplog";
	}
	
	//blocked ip log started
	
	@GetMapping("/advertise/blocked/ip-log")
	public String showBlockedIpLogAll(Model model) {
		model.addAttribute("blockIpLog", new BlockedIpLog());
		model.addAttribute("blockList", adminService.getAllBlockIpLog());
		return "blockIplog";
	}
	//AdType functionality started
	@GetMapping("/advertise/type")
	public String showAdtypePage(Model model) {
		model.addAttribute("aidType", new AdType());
		model.addAttribute("listAid", adminService.getAllAidTpe());
		return "adType";
	}

	@PostMapping("/advertise/add/type")
	public String createAdTypePage(@ModelAttribute("aidType") AdType aidType,RedirectAttributes redirectAttributes) {
	 int status=adminService.addAidType(aidType);
		if(status!=0)
		{
			redirectAttributes.addFlashAttribute("message",GeneralConstant.adTypeMsg);
		}
		return "redirect:/advertise/type";
	}
	
	

	@GetMapping("/advertise/update/type/{id}")
	public String showUpdateAidTypePage(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("aidType", adminService.updateAidById(id).orElse(null));
		return "adType";
	}

	@PostMapping("/advertise/update/type/{id}")
	public String updateAidTypedPage(@PathVariable Integer id,RedirectAttributes redirectAttributes, @ModelAttribute("aidType") AdType aidType) {
	 int status= adminService.updateAidType(id, aidType);
		if(status!=0)
		{
			redirectAttributes.addFlashAttribute("message",GeneralConstant.adTypeEditMsg);
		}
		return "redirect:/advertise/type";
	}
	@GetMapping("/advertise/cpc&cpm")
	public String showCpcAndCpmPage(Model model)
	{
		model.addAttribute("globalSetting",adminService.getCpcAndCpm());
		return "cpcAndCpm";
	}
	
	
	@PostMapping("/advertise/cpc&cpm/update")
	public String updateCpcAndCpmPage(@ModelAttribute("globalSetting") GlobalSetting setting,HttpServletRequest req,RedirectAttributes redirectAttributes)
	{
		Integer id=Integer.parseInt(req.getParameter("id").toString());
       	int status=adminService.updateCpcAndCpm(id,setting.getCpc(),setting.getCpm());
       	if(status!=0)
		{
			redirectAttributes.addFlashAttribute("message",GeneralConstant.CpcAndCpm);
		}
		
		return "redirect:/advertise/cpc&cpm";
	}
	
	

}
