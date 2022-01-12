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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "languages")
@DynamicUpdate
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="text_align")
	private int text_align;
	
	@Column(name="is_default")
	private int is_default;
	@Transient
	private String is_default1;
	
	public String getIs_default1() {
		return is_default1;
	}


	public void setIs_default1(String is_default1) {
		this.is_default1 = is_default1;
	}


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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public int getText_align() {
		return text_align;
	}


	public void setText_align(int text_align) {
		this.text_align = text_align;
	}


	public int getIs_default() {
		return is_default;
	}


	public void setIs_default(int is_default) {
		this.is_default = is_default;
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
