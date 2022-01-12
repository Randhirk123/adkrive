package com.adkrive.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.GlobalSetting;
import com.adkrive.main.model.SmsManager;
import com.adkrive.main.utility.Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class EmailManagerController {

	@Autowired
	private AdminService adminService;
	@GetMapping("/email-template/index")
	public String getallEmailTemplatePage(Model model)
	{
		List<SmsManager> emailList =adminService.getAllEmail();
		model.addAttribute("emailList", emailList);
		return "emailManagerList";        
		     
	}
	
	@GetMapping("/email-template/{id}/edit")
	public String emailEditPage(@PathVariable Integer id, Model model) throws JsonMappingException, JsonProcessingException
	{
		model.addAttribute("id", id);
		SmsManager mgr=adminService.updateEmailById(id).orElse(null);
		  model.addAttribute("email",mgr);
		  model.addAttribute("map",Utility.convertJsonToJava(mgr.getShortcodes()));
		  return "emailEdit";
		
	}
	
	
	@PostMapping("/email-template/{id}/update")
	public String updateEmailManagerPage(@PathVariable Integer id,Model model,@ModelAttribute("email") SmsManager smsMgr)
	{
		 model.addAttribute("email",adminService.updateEmailById(id).orElse(null));
		 adminService.updateEmailManager(id,smsMgr);
		 return "redirect:/email-template/{id}/edit";
	}
	
	@GetMapping("/email-template/global")
	public String getEmailTemplatePage(Model model)
	{
		GlobalSetting global=adminService.getGeneralSetting();
		model.addAttribute("global", global);
		return "emailGlobalTemp";
	}
	
	@PostMapping("/email-template/global")
	public String updateGlobalSettingSmsTem(Model model,@ModelAttribute("global") GlobalSetting setting)
	{
		GlobalSetting global=adminService.getGeneralSetting();
		adminService.updateGlobalEmailTemplate(global.getId(),setting);
		return "redirect:/email-template/global";
	}
	
}
