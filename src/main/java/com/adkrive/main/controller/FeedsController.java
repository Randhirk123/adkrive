package com.adkrive.main.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.adkrive.main.feedservice.FeedService;
import com.adkrive.main.model.FeedNetwork;
import com.adkrive.main.model.Feeds;
import com.adkrive.main.repository.FeednetworkRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FeedsController {

	@Autowired
	private FeedService feedService;
	
	@Autowired
	private FeednetworkRepository feednetworkRepository;

	@GetMapping("feeds/all")
	public String showFeedPage(Model model) {
		Map<String, List<Feeds>> mapList = new HashMap<String, List<Feeds>>();
		boolean status=false;
		List<FeedNetwork> feedNetworks=null;
		List<Feeds> feedChecker=feedService.getAllChecker();
		 
		for(int i=0; i<feedChecker.size(); i++)
		{
			if(feedChecker.get(i).getChecker()==1)
			{
				status=true;
				break;
			}
		}
		if(status)
		{
			feedNetworks=feednetworkRepository.findAll();
			
		}
		else
		{
			feedNetworks=feednetworkRepository.getAllActiveNetwork();
		}
		
		for (FeedNetwork feedNetwork : feedNetworks) {
			
			mapList.put(feedNetwork.getNewtworkName(), feedNetwork.getFeeds());
		}
		model.addAttribute("status", status);
		model.addAttribute("networkList", mapList);
		model.addAttribute("limit", 1);
		return "feedtable";
	}

	@GetMapping("/add/new/feed")
	public String showNewFeedPage(Model model) {
		model.addAttribute("feeds", new Feeds());
		model.addAttribute("networkList", feedService.getNetworkList());

		return "addFeedPage";
	}

	@PostMapping("/saveFeed")
	public String saveFeed(@ModelAttribute("feeds") Feeds feed) {
		feedService.saveFeed(feed);

		return "redirect:/feeds/all";
	}

	@GetMapping("/feedEdit/{feedId}")
	public String showFeedEditPage(@PathVariable("feedId") Long Id, Model model) {
		model.addAttribute("feeds", feedService.getFeedsById(Id));
		model.addAttribute("networkList", feedService.getNetworkList());

		return "feedEditPage";
	}
	
	@PostMapping("/feedEdit")
	public String saveEditFeeds(@RequestParam("network")String feednetwork ,@ModelAttribute("feeds")Feeds feed)
	{
		feedService.updateEditedFeeds(feed);
		
		return "redirect:/feeds/all";
	}

	@GetMapping("/check")
	@ResponseBody
	public String updateFeedOnChecked(@RequestParam("id") String id, @RequestParam("status") boolean status,
			Model model) {
		String msg = null;
		Feeds feed = feedService.getFeedsById(Long.parseLong(id));
		if (feed != null) {
			feed.setStatus(true);
			feedService.saveFeed(feed);
			msg = "Feeds Updated SuccessFully.";
		}
		return msg;

	}

	@GetMapping("/select")
	@ResponseBody
	public String showAllFeed(@RequestParam("status") boolean status, Model model) {
		
		if(status)
		{
			Feeds feed=new Feeds();
			feed.setChecker(1);
			feedService.updatechecker(feed);
			return "success";
			
		}
		else
			return "failed";
		

	}
	
	
	@GetMapping("/unselect")
	@ResponseBody
	public String showAactiveFeed(@RequestParam("status") boolean status, Model model) {
		
		if(!status)
		{
			Feeds feed=new Feeds();
			feed.setChecker(0);
			feedService.updatechecker(feed);
			return "success";
			
		}
		else
			return "failed";
		

	}
	

	@GetMapping("/uncheck")
	@ResponseBody
	public String updateFeedOnUnChecked(@RequestParam("id") String id, @RequestParam("status") boolean status,
			Model model) {
		String msg = null;
		Feeds feed = feedService.getFeedsById(Long.parseLong(id));
		if (feed != null) {
			feed.setStatus(false);
			feedService.saveFeed(feed);
			msg = "Feeds Updated SuccessFully.";
		}
		return msg;
		
	}
	
	@GetMapping("/linkBuilder/{feedId}")
	public String clientRequestUriBulder(@PathVariable("feedId") Long feedId,Model model,HttpServletRequest request,@RequestHeader(value = "User-Agent") String userAgent)
	{
		
		String url="/showXml"+"/"+feedId;
		
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("ip", request.getRemoteAddr()).queryParam("ua",userAgent).encode();
		URI uri= builder.buildAndExpand(url).toUri();		 
		model.addAttribute("link", uri);
		return "generateLink";
		
	}
	
	@GetMapping(value="/showXml/{feedId}",produces = { "application/xml"}, consumes = MediaType.ALL_VALUE)
	 @ResponseBody
	public Feeds showXmlFeedsPage(@PathVariable("feedId") Long fid)
	{
		Feeds fetchedFeed=feedService.getFeedsById(fid);
		return fetchedFeed;
		
	}
	
	
}
