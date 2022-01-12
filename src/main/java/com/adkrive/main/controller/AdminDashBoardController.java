package com.adkrive.main.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.Admin;
import com.adkrive.main.model.CustomAdminDetails;


@Controller
public class AdminDashBoardController {
	@Autowired
	private AdminService adminService;


	@GetMapping("/dashboard")
	public String viewDashBoard(@AuthenticationPrincipal CustomAdminDetails userDetails, Model model,
			HttpSession session) {
		String username = userDetails.getUsername();
		Admin adminDetail = adminService.getAdminByUserName(username);
		model.addAttribute("admin", adminDetail);
		model.addAttribute("total_Advertises", adminService.getAllAdvertise().size());
		model.addAttribute("total_Advertiser", adminService.getAllAdvertiser().size());
		model.addAttribute("total_Publisher", adminService.getAllPublisher().size());
		model.addAttribute("total_AidType", adminService.getAllAidTpe().size());
		model.addAttribute("total_PricePlan", adminService.getAllPricePlan().size());
		model.addAttribute("total_ApprovedDomain", adminService.getAllApprovedDomain().size());
		model.addAttribute("total_PendingDomain", adminService.getAllPendingDomain().size());
		model.addAttribute("total_WithdrawMethod", adminService.getAllWithdrawMethod().size());
		model.addAttribute("total_Withdraw", adminService.getAllWithdrawls().size());
		model.addAttribute("total_WithdrawPending", adminService.getAllPendingWithdrawls().size());
		model.addAttribute("total_WithdrawApproved", adminService.getAllApprovedWithdrawls().size());
		model.addAttribute("total_PendingTicket", adminService.getAllPendingTicket().size());
		model.addAttribute("advTxLog", adminService.getAllAdvTxLog());
		model.addAttribute("globalSetting", adminService.getCpcAndCpm());
		session.setAttribute("adminUserName", adminDetail.getUserName());
		return "dashboard";

	}

	 
	
	

}
