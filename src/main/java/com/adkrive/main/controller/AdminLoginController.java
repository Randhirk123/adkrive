package com.adkrive.main.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

import com.adkrive.main.general.GeneralConstant;

import com.adkrive.main.model.Admin;


@Controller
public class AdminLoginController {


	private static final Logger LOGGER = LogManager.getLogger(AdminLoginController.class);
	 @GetMapping("/admin") 

	 public String adminLogin(Model model,String error, String logout) 
	 {
		 LOGGER.info("adminLogin Started");
		 model.addAttribute("admin", new Admin());
		  return "admin"; 
	  }	
	 

	 public String adminLogin(Map<String, Object> model) 
	 {
		 LOGGER.info("adminLogin Started");
		 model.put("admin", new Admin());
		  if(GeneralConstant.loginFailureCount==1)
		  {
			  ((Model) model).addAttribute("message", "No Record Found with The Given input");
			  ((Model) model).addAttribute("count",GeneralConstant.loginFailureCount);
			 
		  }
		  
		 
		  LOGGER.info("adminLogin completed");
		  return "adminLogin"; 
	  }	

}
