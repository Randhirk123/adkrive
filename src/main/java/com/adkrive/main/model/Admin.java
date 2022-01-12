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

import org.hibernate.annotations.DynamicUpdate;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "admins")
@DynamicUpdate
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	

	@Column(name="username")
	public String userName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="email_verified_at", insertable=true, updatable=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date email_verified_at;
	
	@Column(name = "image", nullable = true, length = 64)
	private String image;
	
	//for mysql
	//private boolean enabled;

	private Boolean enabled;
	
	@Column(name = "account_non_locked",columnDefinition = "boolean default true")
	private boolean accountNonLocked;

	@Column(name = "failed_attempt",columnDefinition = "int default 0")
	private int failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;

	@Column(name="password")
	private String password;


	@Transient
	private String confrmPass;

	@Transient
	private String newPassword;


	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public int getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	
     
	

	
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updated_at;
	
	@Column(name = "reset_password_token")
    private String resetPasswordToken;
     


	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	

	

	

	public Date getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(Date email_verified_at) {
		this.email_verified_at = email_verified_at;
	}

	



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	
	

	public String getConfrmPass() {
		return confrmPass;
	}

	public void setConfrmPass(String confrmPass) {
		this.confrmPass = confrmPass;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Transient
	public String getPhotosImagePath() {
		if (image == null || id == null)
			return null;

		return "/photo/admin/" + id + "/" + image;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	

}
