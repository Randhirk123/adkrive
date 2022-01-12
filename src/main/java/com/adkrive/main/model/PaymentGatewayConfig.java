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
@Table(name = "paymentgatewayconfig")
@DynamicUpdate
public class PaymentGatewayConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code")
	private int code;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gatewayName")
	private String gatewayName;
	
	@Column(name="merchantId")
	private String merchantId;
	
	@Column(name="secretkey")
	private String secretKey;
	
	@Column(name="currency")
	private String currencies;
	
	@Column(name="currencySymbol")
	private String currSymbol;
	
	@Column(name="paymentMethod")
	private String pmntMethod;
	
	@Column(name="paymentdesc")
	private String pmntDesc;
	
	@Column(name="paymentIntent")
	private String intent;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", insertable = false)
	private Date updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getCurrencies() {
		return currencies;
	}

	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}

	public String getCurrSymbol() {
		return currSymbol;
	}

	public void setCurrSymbol(String currSymbol) {
		this.currSymbol = currSymbol;
	}

	public String getPmntMethod() {
		return pmntMethod;
	}

	public void setPmntMethod(String pmntMethod) {
		this.pmntMethod = pmntMethod;
	}

	public String getPmntDesc() {
		return pmntDesc;
	}

	public void setPmntDesc(String pmntDesc) {
		this.pmntDesc = pmntDesc;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
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
