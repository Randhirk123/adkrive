package com.adkrive.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackController {

	@GetMapping("/feeds")
	public String showFeedPage()
	{
		return "feedback";
	}
}
