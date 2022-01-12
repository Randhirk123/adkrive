package com.adkrive.main.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adkrive.main.feedservice.FeedService;
import com.adkrive.main.model.FeedNetwork;
import com.adkrive.main.model.Feeds;
import com.adkrive.main.model.RestClientRegistration;
import com.adkrive.main.repository.FeednetworkRepository;
import com.adkrive.main.repository.FeedsRepository;
import com.adkrive.main.repository.RestClientRepository;
import com.adkrive.main.utility.Utility;

@Service
public class FeedsServiceImpl implements FeedService {

	@Autowired
	private FeedsRepository feedsRepository;
	@Autowired
	private RestClientRepository clientRepository;
	
	
	@Autowired
	private FeednetworkRepository feednetworkRepository;
	
	@Override
	public Feeds saveFeed(Feeds feed) {
		
		/*
		 * Set<Feeds> feeds = new HashSet<>(); FeedNetwork feedNetwork1 = new
		 * FeedNetwork();
		 */
		feed.setNative_id(Utility.getUUID());
		FeedNetwork feedNetwork=feed.getFeedNetwork();
		feed.setFeedNetwork(feedNetwork);
	    Feeds feeds1=	feedsRepository.save(feed);
	    
		/*
		 * feeds.add(feeds1); feedNetwork1.setFeedList(feeds);
		 */
		
	    return feeds1;
	}

	@Override
	public Feeds updateFeeds(Feeds feeds) {
		
		return feedsRepository.save(feeds);
	}

	@Override
	public void deleteFeeds(long id) {
		feedsRepository.deleteById(id);
		
	}

	@Override
	public List<Feeds> getAllFeeds() {
		
		return feedsRepository.findAll();
	}

	@Override
	public List<Feeds> getActiveFeeds() {
		
		return feedsRepository.getAllActiveFeeds();
	}

	@Override
	public Feeds getFeeds() {
		
		return feedsRepository.getFeeds();
	}

	@Override
	public Feeds getFeedsById(long id) {
		
		return feedsRepository.findById(id).orElse(null);
	}

	@Override
	public void save(RestClientRegistration registration) {
		if(registration!=null)
		{
			registration.setStatus(true);
		}
		
		clientRepository.save(registration);
	}

	@Override
	public RestClientRegistration getClientByUsername(String username) {
		
		return clientRepository.findByUsername(username);
	}

	@Override
	public FeedNetwork saveNetwork(FeedNetwork feednetwork) {
		
		return feednetworkRepository.save(feednetwork);
	}

	@Override
	public List<FeedNetwork> getNetworkList() {
		return feednetworkRepository.findAll();
	}

	@Override
	public Feeds saveRestFeed(Feeds feeds) {
		feeds.setNative_id(Utility.getUUID());
		FeedNetwork feedNetwork=new FeedNetwork();
		//feedNetwork.addFeed(feeds);
		feednetworkRepository.save(feedNetwork);
		return feeds;
		
	}

	@Override
	public List<FeedNetwork> getActiveNetworkList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatechecker(Feeds feed) {
		
		feedsRepository.updateCheckerStatus(feed.getChecker());
	}

	@Override
	public List<Feeds> getAllChecker() {
		
		return feedsRepository.getAllChecker();
	}

	@Override
	public void updateEditedFeeds(Feeds feed) {
		Feeds feeds=feedsRepository.findById(feed.getFeedId()).orElse(null);
		feeds.setFeedName(feed.getFeedName());
		feeds.setRevenueShare(feed.getRevenueShare());
		feeds.setDailyMaxQuery(feed.getDailyMaxQuery());
		feeds.setPlatform(feed.getPlatform());
		feeds.setStatus(feed.isStatus());
		feedsRepository.save(feeds);
		
	}

}
