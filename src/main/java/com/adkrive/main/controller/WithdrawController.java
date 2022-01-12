package com.adkrive.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.ManageKeyWord;
import com.adkrive.main.model.WithDrawMethod;
import com.adkrive.main.model.WithDrawls;


@Controller
public class WithdrawController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/withdraw/pending")
	public String showPendingWithDraw(Model model) {
		model.addAttribute("withdraw", new WithDrawls());
		model.addAttribute("pendingWithdrawList", adminService.getAllPendingWithdrawls());
		return "withdrawPending";

	}

	@GetMapping("/withdraw/approved")
	public String showApprovedWithDraw(Model model) {
		model.addAttribute("withdraw", new WithDrawls());
		model.addAttribute("approvedWithdrawList", adminService.getAllApprovedWithdrawls());
		return "withdrawApproved";

	}

	@GetMapping("/withdraw/rejected")
	public String showRejectedWithDraw(Model model) {
		model.addAttribute("withdraw", new WithDrawls());
		model.addAttribute("rejectedWithdrawList", adminService.getAllRejectedWithdrawls());

		return "withdrawRejected";

	}

	@GetMapping("/withdraw/log")
	public String showWithDrawLog(Model model) {
		model.addAttribute("withdraw", new WithDrawls());
		model.addAttribute("allWithdrawList", adminService.getAllWithdrawls());
		return "allWithdrawLog";

	}

	@GetMapping("/withdraw/method")
	public String showWithDrawMethod(Model model) {
		model.addAttribute("withMethod", new WithDrawMethod());
		List<WithDrawMethod> listMethod=adminService.getAllWithdrawMethod();
		String[] images=new String[listMethod.size()];
		for(int i=0; i<listMethod.size(); i++)
		{
			byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(listMethod.get(i).getImage());
			
			images[i]=new String(encoded);
			
		}
		
		model.addAttribute("images", images);
		model.addAttribute("listWithdrawMethod",listMethod);
		return "withdrawMethod";

	}

	@GetMapping("/withdraw/method/create")
	public String showCreateWithdrawMethodPage(Model model) {
		model.addAttribute("withMethod", new WithDrawMethod());
		return "createWithdrawMethod";
	}

	@PostMapping("/withdraw/method/create")
	public String createWithdrawMethod(@ModelAttribute("withMethod") WithDrawMethod method, Model model,
			@RequestParam("file") MultipartFile file) {

		adminService.addWithdrawMethodType(method, file);
		model.addAttribute("listWithdrawMethod", adminService.getAllWithdrawMethod());
		return "redirect:/withdraw/method";
	}

	@GetMapping("/withdraw/method/edit/{id}")
	public String editWithdrawMethod(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		WithDrawMethod getWithdrawDetail= adminService.updateWithdrawMethodById(id).orElse(null);
		byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(getWithdrawDetail.getImage());
		
		String encodedString = new String(encoded);
		model.addAttribute("image1", encodedString);
		model.addAttribute("withMethod",getWithdrawDetail);
		
		return "editMethod";
	}

	@PostMapping("/withdraw/method/edit/{id}")
	public String updateWithdrawMethod(@PathVariable Integer id, @ModelAttribute("withMethod") WithDrawMethod method,@RequestParam("file") MultipartFile file,
			Model model) throws IOException {
		
		
		adminService.updateWithdrawMethod(id, method,file);
		WithDrawMethod getWithdrawDetail= adminService.updateWithdrawMethodById(id).orElse(null);
        byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(getWithdrawDetail.getImage());
		
		String encodedString = new String(encoded);
		model.addAttribute("image1", encodedString);
		model.addAttribute("withMethod",getWithdrawDetail);
		return "redirect:/withdraw/method/edit/{id}";

	}
	
	@PostMapping("/withdraw/method/deactivate")
	public String deActivateWithdrawMethod(HttpServletRequest req, Model model)
	{
	 WithDrawMethod method=	adminService.deActivateWithdrawMethod(Integer.parseInt(req.getParameter("id")));
		model.addAttribute("withMethod",method);
		return "redirect:/withdraw/method";
		
	}
	
	@PostMapping("/withdraw/method/activate")
	public String actiVateWithdrawMethod(HttpServletRequest req)
	{
		adminService.activateWithdrawMethod(Integer.parseInt(req.getParameter("id")));
		return "redirect:/withdraw/method";
		
	}

}
