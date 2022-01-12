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
@Table(name = "email_sms_templates")
@DynamicUpdate
public class EmailManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="act")
	private String act;
	
	@Column(name="name")
	private String name;
	
	@Column(name="subj")
	private String subj;
	
	@Column(name="email_body")
	private String email_body;
	
	@Column(name="sms_body")
	private String sms_body;
	
	@Column(name="shortcodes")
	private String shortcodes;
	
	@Column(name="email_status")
	private int email_status;
	
	@Column(name="sms_status")
	private int sms_status;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date created_at;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updated_at;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAct() {
		return act;
	}


	public void setAct(String act) {
		this.act = act;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSubj() {
		return subj;
	}


	public void setSubj(String subj) {
		this.subj = subj;
	}


	public String getEmail_body() {
		return email_body;
	}


	public void setEmail_body(String email_body) {
		this.email_body = email_body;
	}


	public String getSms_body() {
		return sms_body;
	}


	public void setSms_body(String sms_body) {
		this.sms_body = sms_body;
	}


	public String getShortcodes() {
		return shortcodes;
	}


	public void setShortcodes(String shortcodes) {
		this.shortcodes = shortcodes;
	}


	public int getEmail_status() {
		return email_status;
	}


	public void setEmail_status(int email_status) {
		this.email_status = email_status;
	}


	public int getSms_status() {
		return sms_status;
	}


	public void setSms_status(int sms_status) {
		this.sms_status = sms_status;
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
	
	
}
