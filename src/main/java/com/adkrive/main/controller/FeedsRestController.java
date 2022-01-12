package com.adkrive.main.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adkrive.main.feedservice.FeedService;
import com.adkrive.main.model.FeedNetwork;
import com.adkrive.main.model.Feeds;
import com.adkrive.main.model.RestClientRegistration;
import com.adkrive.main.utility.BcryptHashedPassword;
import com.adkrive.main.utility.JwtUtil;
import com.feed.exception.FeedNotFoundException;


@RestController
@RequestMapping("/api/rest/client")
public class FeedsRestController {

	@Autowired
	private FeedService feedService;
	
	 @Autowired
	    private JwtUtil jwtUtil;
	 
	    
	
	
	@PostMapping("/signup")
    public void signUp(@RequestBody RestClientRegistration user)
    {
        user.setPassword(BcryptHashedPassword.hashedPassword(user.getPassword()));
        feedService.save(user);
    }
	
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody RestClientRegistration user) throws Exception {
        return jwtUtil.generateToken(user.getUsername());
    }
	
	@PostMapping(value="/saveNetwork",produces= {MimeTypeUtils.APPLICATION_XML_VALUE,MimeTypeUtils.APPLICATION_JSON_VALUE},consumes = {MimeTypeUtils.APPLICATION_XML_VALUE,MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<FeedNetwork> saveNetwork(@Validated @RequestBody FeedNetwork feedetwork)
	{
		FeedNetwork _feedetwork = feedService.saveNetwork(feedetwork);
		if(feedetwork!=null)
		{
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_feedetwork.getNetworkId()).toUri();  
			return ResponseEntity.created(location).build(); 
		}
		else
			throw new FeedNotFoundException("Error while creating FeedNetwork" + HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@GetMapping(value="get/{id}",produces = {MimeTypeUtils.APPLICATION_XML_VALUE,MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Feeds> getFeedById(@PathVariable("id") long id) throws Exception {

		
		Feeds feedData = feedService.getFeedsById(id);
		if(feedData!=null)
			return new ResponseEntity<>(feedData, HttpStatus.OK);
		else
			throw new FeedNotFoundException("No Feed Found With id = " +id);
		
		
	}
	
	
	
	@GetMapping(value = "/findall", produces= {MimeTypeUtils.APPLICATION_XML_VALUE,MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Feeds>> findAllFeed() {
		
		List<Feeds> feedsList=feedService.getAllFeeds();
		if(feedsList!=null)
			return new ResponseEntity<>(feedsList, HttpStatus.OK);
		else
			throw new FeedNotFoundException(""+HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value = "/create",produces= {MimeTypeUtils.APPLICATION_XML_VALUE,MimeTypeUtils.APPLICATION_JSON_VALUE},consumes = {MimeTypeUtils.APPLICATION_XML_VALUE,MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Feeds> createFeed(@Validated @RequestBody Feeds feed,
			HttpServletRequest request) {

		Feeds _feed = feedService.saveRestFeed(feed);
		if(_feed!=null)
		{
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_feed.getFeedId()).toUri();  
			return ResponseEntity.created(location).build();  
		}
		else
			throw new FeedNotFoundException("Error while creating Feeds" + HttpStatus.BAD_REQUEST);
			
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Feeds> updateFeed(@PathVariable("id") long id, @RequestBody Feeds feed) {
		Feeds _feed = feedService.getFeedsById(id);
		if(_feed!=null)
		{
			_feed.setDailyMaxQuery(feed.getDailyMaxQuery());
			
			_feed.setRevenueShare(feed.getRevenueShare());
			_feed.setFeedName(feed.getFeedName());
			_feed.setPlatform(feed.getPlatform());
			_feed.setNative_id(feed.getNative_id());
			return new ResponseEntity<>(feedService.saveRestFeed(_feed), HttpStatus.OK);
		}
		
		else
			throw new FeedNotFoundException("Error while Updation Feeds" + _feed);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFeed(@PathVariable("id") long id) {
		feedService.deleteFeeds(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
