package com.adkrive.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.GlobalSetting;
import com.adkrive.main.model.SmsManager;
import com.adkrive.main.utility.GeneralConstant;
import com.adkrive.main.utility.Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class SmsManagerController {

	private static int counter=0;
	@Autowired
	private AdminService adminService;
	@GetMapping("/sms-template/global")
	public String getSmsManagerPage(Model model)
	{
		GlobalSetting global=adminService.getGeneralSetting();
		model.addAttribute("global", global);
		return "apisetting";
	}
	
	@PostMapping("/sms-template/global")
	public String updateGlobalSettingSmsTem(Model model,@ModelAttribute("global") GlobalSetting setting,RedirectAttributes redirectAttributes)
	{
		GlobalSetting global=adminService.getGeneralSetting();
		counter=adminService.updateGlobalSmsApi(global.getId(),setting);
		redirectAttributes.addFlashAttribute("count",counter);
		redirectAttributes.addFlashAttribute("Msg",GeneralConstant.smsTemplateMsg);
		return "redirect:/sms-template/global";
	}
	
	
	@PostMapping("/email-template/send-test-sms")
	public String sendTestSms(@RequestParam("mobile") String mobile) throws IOException, InterruptedException
	{
		boolean test=Utility.testSms(mobile);
		System.out.println(test);
				
		return "redirect:/sms-template/global";
	}
	
	@GetMapping("/sms-template/index")
	public String getallSmsTemplatePage(Model model)
	{
		List<SmsManager> smsList =adminService.getAllSms();
		model.addAttribute("smsMgrList", smsList);
		return "smsmanagerList";
		     
	}
	
	@GetMapping("/sms-template/edit/{id}")
	public String smsEditPage(@PathVariable Integer id, Model model) throws JsonMappingException, JsonProcessingException
	{
		model.addAttribute("id", id);
		SmsManager mgr=adminService.updateSmsById(id).orElse(null);
		  model.addAttribute("sms",mgr);
		  model.addAttribute("map",Utility.convertJsonToJava(mgr.getShortcodes()));
		  return "smsEdit";
		
	}
	
	@PostMapping("/sms-template/update/{id}")
	public String updateSmsmanagerPage(@PathVariable Integer id,Model model,@ModelAttribute("sms") SmsManager smsMgr)
	{
		 model.addAttribute("sms",adminService.updateSmsById(id).orElse(null));
		 adminService.updateSmsManager(id,smsMgr);
		 return "redirect:/sms-template/edit/{id}";
	}
	
	
	
}
