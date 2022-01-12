package com.adkrive.main.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "feed")
public class Feeds {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feed_id")
	private long feedId;

	@Column(name = "native_id")
	private String native_id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	@JoinColumn(name = "network_id", referencedColumnName = "networkId")
	private FeedNetwork feedNetwork;

	@Column(name = "feed_name")
	private String feedName;

	@Column(name = "dailyMaxQuery")
	private long dailyMaxQuery;

	@Column(name = "platform")
	private String platform;

	@Column(name = "status", columnDefinition = "boolean default false")
	private boolean status;

	@Column(name = "revenueShare")
	private int revenueShare;
	
	@Column(name = "checker",columnDefinition = "integer default 0")
	private Integer  checker;
	
	@Transient
	private String network;
	
	
	
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", insertable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date updated_at;

	public long getFeedId() {
		return feedId;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public String getNative_id() {
		return native_id;
	}

	public void setNative_id(String native_id) {
		this.native_id = native_id;
	}

	@JsonIgnore
	public FeedNetwork getFeedNetwork() {
		return feedNetwork;
	}

	@JsonIgnore
	public void setFeedNetwork(FeedNetwork feedNetwork) {
		this.feedNetwork = feedNetwork;
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public long getDailyMaxQuery() {
		return dailyMaxQuery;
	}

	public void setDailyMaxQuery(long dailyMaxQuery) {
		this.dailyMaxQuery = dailyMaxQuery;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getRevenueShare() {
		return revenueShare;
	}

	public void setRevenueShare(int revenueShare) {
		this.revenueShare = revenueShare;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	
	public int getNetwork_Id() {
		return feedNetwork.getNetworkId();
	}
	
	
	public String getNetworkName()
	{
		return feedNetwork.getNewtworkName();
	}

	public Integer getChecker() {
		return checker;
	}

	public void setChecker(Integer checker) {
		this.checker = checker;
	}

	
	
	
	
}
