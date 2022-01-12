package com.adkrive.main.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "feedNetwork")
@DynamicUpdate
public class FeedNetwork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int networkId;

	@Column(name = "network_name")
	private String newtworkName;

	@OneToMany(mappedBy = "feedNetwork", cascade =CascadeType.ALL,orphanRemoval = true)
	

	// private Set<Feeds> feedList = new HashSet<>();
	 private List<Feeds> feeds = new ArrayList<Feeds>();
	 public List<Feeds> getFeeds() {
		  return feeds;
		 }
		/*
		 * public void addFeed(Feeds feeds) { feedList.add(feeds);
		 * feeds.setFeedNetwork(this); }
		 */
	


	public int getNetworkId() {
		return networkId;
	}

	public void setNetWorkId(int networkId) {
		this.networkId = networkId;
	}

	public String getNewtworkName() {
		return newtworkName;
	}

	public void setNewtworkName(String newtworkName) {
		this.newtworkName = newtworkName;
	}
	
	
	

}
