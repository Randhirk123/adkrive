package com.adkrive.main.controller;

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
import com.adkrive.main.model.Admin;
import com.adkrive.main.model.Ticket;


@Controller
public class SupportTicketController {

	@Autowired
	private AdminService adminService;
	@GetMapping("/tickets")
	public String showAllTicket(Model model)
	{
		model.addAttribute("ticket",new Ticket());
		model.addAttribute("allTicketList",adminService.getAllTicket());
		return "ticket";
		
	}
	
	@GetMapping("/tickets/pending")
	public String showPendingTicket(Model model)
	{
		
		model.addAttribute("ticket",new Ticket());
		model.addAttribute("pendingTicketList",adminService.getAllPendingTicket());
		return "pendingTicket";
		
	}
	
	@GetMapping("/tickets/closed")
	public String showClosedTicket(Model model)
	{
		model.addAttribute("ticket",new Ticket());
		model.addAttribute("closedTicketList",adminService.getAllClosedTicket());
		return "closedTicket";
		
	}
	
	@GetMapping("/tickets/answered")
	public String showAnsweredTicket(Model model)
	{
		model.addAttribute("ticket",new Ticket());
		model.addAttribute("answeredTicketList",adminService.getAllAnsweredTicket());
		return "answeredTicket";
		
	}
	
	@GetMapping("/tickets/view/{id}")
	public String allTypeticketView(Model model,@PathVariable Integer id)
	{

		Admin admin=adminService.getAdminDetails();

		Ticket chkTicket=adminService.getTicketStatus(id);
		if(chkTicket.getStatus()==0)
		{
			model.addAttribute("openTktView", chkTicket);

			//model.addAttribute("admin", admin);

			model.addAttribute("admin", admin);

			model.addAttribute("publish", adminService.updateByPublisherId(id).orElse(null));
			return "openTicketView";
		}
		else if(chkTicket.getStatus()==3)
		{
			model.addAttribute("closeTktView", chkTicket);
			return "closeTicketView";
		}
		else if(chkTicket.getStatus()==1)
		{
			model.addAttribute("answerTktView", chkTicket);
			return "answerTicketView";
		}
		
		else
		{
			model.addAttribute("replyTktView", chkTicket);
			return "replyTicketView";
		}
		
		
		
	}
	
	
	
	
	@PostMapping("/ticket/reply/{id}")
	public String replyTicket(Model model, @PathVariable Integer id,
			@ModelAttribute(value = "ticket") Ticket ticket,@RequestParam("message") String message,@RequestParam("attachments[]") MultipartFile[] file)
	{

		Admin admin=adminService.getAdminDetails();
	  boolean status=	adminService.sendReplayTicketToUsers(ticket,id,message,file,admin.getId());
		if(status)
		{
			System.out.println("success");
		}

		System.out.println(message);
		System.out.println("length of file.."+file.length);
		return "";
	}
}
