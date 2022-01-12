package com.adkrive.main.controller;

import java.io.IOException;

import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.Admin;
import com.adkrive.main.model.CustomAdminDetails;
import com.adkrive.main.utility.ImageUploadHandler;
import com.adkrive.main.utility.UtilityConstant;



@Controller
public class AdminprofileController {
@Autowired
	private AdminService adminService;

	@GetMapping("/profile")
	public String profileSetting(@AuthenticationPrincipal CustomAdminDetails userDetails, Model model) {
		String username = userDetails.getUsername();
		model.addAttribute("admin", adminService.getAdminByUserName(username));
		return "profile_setting";

	}

	@PostMapping("/profile")

	public String UpdateAdminProfile(@ModelAttribute("admin")Admin admin,@RequestParam("file") MultipartFile multipartFile,
			Model model, RedirectAttributes redirectAttributes,HttpServletRequest request,HttpSession session)
			throws IOException {
		String fileName =ImageUploadHandler.getFileName(multipartFile);
		admin.setImage(fileName);
		int id=Integer.parseInt(request.getParameter("aid"));
		Admin savedData=adminService.saveAdmin(admin,id);
		if(savedData!=null)
		{
			String uploadDir = UtilityConstant.adminFilePath +savedData.getId();
			if (fileName.isEmpty())
			{
				fileName =savedData.getImage();
			}
			Path ImagePath=ImageUploadHandler.saveFile(uploadDir,fileName, multipartFile);
			String sessionPath=ImagePath.toString().replaceAll("\\\\", "/");
			session.setAttribute("adminImg", sessionPath);
			redirectAttributes.addFlashAttribute("message","Profile Updated SuccessFully.");
			
		}
		else
		{
			redirectAttributes.addFlashAttribute("message","Error Occured While Updating Profile.");
		}
		return "redirect:/profile";

	}

}
