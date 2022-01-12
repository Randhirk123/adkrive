package com.adkrive.main.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.adkrive.main.adminservice.AdminService;

import com.adkrive.main.general.GeneralConstant;

import com.adkrive.main.model.Extension;
import com.adkrive.main.model.Frontend;
import com.adkrive.main.model.GlobalSetting;
import com.adkrive.main.model.Language;
import com.adkrive.main.model.LogoIconSetting;


@Controller
public class SettingController {

	private static int counter = 0;
	@Autowired
	private AdminService adminService;

	@GetMapping("/general-setting")
	public String getGeneralSettingPage(Model model) {
		model.addAttribute("generalSetting", new GlobalSetting());
		GlobalSetting genSetting = adminService.getGeneralSetting();
		model.addAttribute("genSetting", genSetting);
		return "generalSetting";

	}

	@PostMapping("/general-setting")
	public String updateGeneralSettingPage(Model model, @ModelAttribute(value = "generalSetting") GlobalSetting setting,
			RedirectAttributes redirectAttributes) {
		GlobalSetting genSetting = adminService.getGeneralSetting();
		GlobalSetting updateSetting = adminService.updateGeneralSetting(setting, genSetting.getId());
		model.addAttribute("genSetting", updateSetting);
		if (updateSetting != null) {
			redirectAttributes.addFlashAttribute("count", counter + 1);
			redirectAttributes.addFlashAttribute("Msg", GeneralConstant.generalSettingMsg);
		}
		return "redirect:/general-setting";

	}

	@GetMapping("/language")
	public String getAllLanguage(Model model) {
		model.addAttribute("lang", new Language());
		model.addAttribute("langList", adminService.getAllLangList());
		return "language";
	}

	@PostMapping("/language")
	public String addLanguage(Model model, @ModelAttribute("lang") Language lang) {
		adminService.addLanguage(lang);
		model.addAttribute("langList", adminService.getAllLangList());

		return "redirect:/language";
	}

	@GetMapping("/language/edit/{id}")
	public String viewEditLanguage(@PathVariable Integer id, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("lang", adminService.updateLangById(id).orElse(null));
		return "language";
	}

	@GetMapping("/language/update/{id}")
	public String viewUpdateLanguage(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("lang", adminService.updateLangById(id).orElse(null));
		return "language";
	}

	@PostMapping("/language/update/{id}")
	public String UpdateLanguage(@PathVariable Integer id, Model model, @ModelAttribute("lang") Language lang) {

		adminService.updateLangByIdVal(id, lang);
		model.addAttribute("lang", adminService.updateLangById(id).orElse(null));

		return "redirect:/language";
	}

	@GetMapping("/setting/logo-icon")
	public String getLogoSetting(Model model) {

		LogoIconSetting logodetails = adminService.getLogoIconDetails();
		byte[] encoded1 = org.apache.commons.codec.binary.Base64.encodeBase64(logodetails.getLogo());
		byte[] encoded2 = org.apache.commons.codec.binary.Base64.encodeBase64(logodetails.getFavicon());
		String encodedString1 = new String(encoded1);
		String encodedString2 = new String(encoded2);

		model.addAttribute("logo", encodedString1);
		model.addAttribute("favicon", encodedString2);

		return "logoSetting";
	}

	@PostMapping("/setting/logoicon")
	public String saveLogoIconSetting(@RequestParam("logo") MultipartFile file1,
			@RequestParam("favicon") MultipartFile file2,RedirectAttributes redirectAttributes) {
		counter=adminService.saveLogoIcon(file1, file2);
		redirectAttributes.addFlashAttribute("count",counter);
		redirectAttributes.addFlashAttribute("Msg",GeneralConstant.logoIconMsg);
		return "redirect:/setting/logo-icon";

	}

	@GetMapping("/extensions")
	public String viewExtension(Model model) {
		model.addAttribute("extension", new Extension());
		model.addAttribute("extensionList", adminService.getAllExtension());
		return "extension";

	}

	@PostMapping("/extensions/deactivate")
	public String disableExtension(Model model, HttpServletRequest req) {

		adminService.EnableOrdisableExtension(Integer.parseInt(req.getParameter("id")));
		return "redirect:/extensions";

	}

	@PostMapping("/extensions/activate")
	public String activateExtension(Model model, HttpServletRequest req) {

		adminService.activateExtension(Integer.parseInt(req.getParameter("id")));
		return "redirect:/extensions";

	}

	@GetMapping("/seo")
	public String getSeoManagerPage(Model model) {
		Frontend seoMgr = adminService.getSeoManagerdata();
		model.addAttribute("seoMgr", seoMgr);

		return "seoManager";

	}

	@PostMapping("/frontend/frontend-content/seo")
	public String updateSeoManagerPage(@ModelAttribute("seoMgr") Frontend frontend, Model model) {
		Frontend seoManager = adminService.updateSeoManager(frontend);

		model.addAttribute("seoMgr", seoManager);

		return "redirect:/seo";
	}
}
