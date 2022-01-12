package com.adkrive.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.Admin;
import com.adkrive.main.model.CustomAdminDetails;
import com.adkrive.main.utility.BcryptHashedPassword;



@Controller
public class AdminPasswordController {


	@Autowired
	private AdminService adminService;

	@GetMapping("/password")
	public String showAdminPasswordPage(@AuthenticationPrincipal CustomAdminDetails userDetails,Model model) {
		String username = userDetails.getUsername();
		model.addAttribute("admin", adminService.getAdminByUserName(username));
		return "password_setting";
	}

	@PostMapping("/password")
	public String savePasswordSetting(@AuthenticationPrincipal CustomAdminDetails userDetails,
			@ModelAttribute("admin") Admin admin, Model model, RedirectAttributes redirectAttributes) {

		if (userDetails != null) {
			Admin adminDetail = adminService.getAdminByUserName(userDetails.getUsername());
			if (adminDetail != null) {
				if (!BcryptHashedPassword.matches(admin.getNewPassword(), adminDetail.getPassword())) {
					if (BcryptHashedPassword.matches(admin.getPassword().trim(), adminDetail.getPassword())) {
						Admin savePass = adminService.changeAdminPassword(adminDetail.getUserName(),
								admin.getNewPassword().trim());
						if (savePass != null) {
							redirectAttributes.addFlashAttribute("message", "Password Updated SuccessFully.");
						} else {
							redirectAttributes.addFlashAttribute("message", "Password Not Updated.");

						}
					}
					else
					{
						redirectAttributes.addFlashAttribute("message","Entered Password Doesn't Exists.");
					}
				}

				else {
					redirectAttributes.addFlashAttribute("message","Password And New Password should be different.");
				}
			} else {
				redirectAttributes.addFlashAttribute("message","Some Critical Error occured.");	
			}
		}

		return "redirect:/password";

	}


	
  

}
