package com.adkrive.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "extensions")
@DynamicUpdate
public class Extension {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="act")
	private String act;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Lob
	@Column(name="image")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] image;
	
	@Column(name="script")
	private String script;
	
	@Column(name="shortcode")
	private String shortcode;
	
	@Column(name="support")
	private String support;
	
	@Column(name="status")
	private int status;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_at")
	private Date deleted_at;
	
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getScript() {
		return script;
	}


	public void setScript(String script) {
		this.script = script;
	}


	public String getShortcode() {
		return shortcode;
	}


	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}


	public String getSupport() {
		return support;
	}


	public void setSupport(String support) {
		this.support = support;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getDeleted_at() {
		return deleted_at;
	}


	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
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
