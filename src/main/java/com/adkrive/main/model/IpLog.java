package com.adkrive.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ip_logs")
@DynamicUpdate
public class IpLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ip_id")
	private Integer ip_id;

	@Column(name = "country")
	private String country;
	
	@Column(name = "ad_id")
	private String ad_id;
	
	@Column(name = "ad_type")
	private String ad_type;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date created_at;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updated_at;


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_type() {
		return ad_type;
	}

	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setIp_id(Integer ip_id) {
		this.ip_id = ip_id;
	}

	public void setAd_type(String ad_type) {
		this.ad_type = ad_type;
	}

	public java.util.Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(java.util.Date created_at) {
		this.created_at = created_at;
	}

	public java.util.Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(java.util.Date updated_at) {
		this.updated_at = updated_at;
	}
}
