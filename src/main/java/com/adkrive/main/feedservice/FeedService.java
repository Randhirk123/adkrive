package com.adkrive.main.feedservice;

import java.util.List;
import java.util.Set;

import com.adkrive.main.model.FeedNetwork;
import com.adkrive.main.model.Feeds;
import com.adkrive.main.model.RestClientRegistration;

public interface FeedService {

	public Feeds saveFeed(Feeds feeds);

	public Feeds updateFeeds(Feeds feeds);

	public void deleteFeeds(long id);

	public List<Feeds> getAllFeeds();

	public List<Feeds> getActiveFeeds();

	public Feeds getFeeds();

	public Feeds getFeedsById(long id);

	public void save(RestClientRegistration registration);

	public RestClientRegistration getClientByUsername(String username);

	public FeedNetwork saveNetwork(FeedNetwork feedetwork);

	public List<FeedNetwork> getNetworkList();
	
	public List<FeedNetwork> getActiveNetworkList();

	public Feeds saveRestFeed(Feeds feed);

	public void updatechecker(Feeds feed);

	public List<Feeds> getAllChecker();

	public void updateEditedFeeds(Feeds feed);
}
