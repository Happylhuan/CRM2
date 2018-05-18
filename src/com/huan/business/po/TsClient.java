package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsClient entity. @author MyEclipse Persistence Tools
 */

public class TsClient implements java.io.Serializable {

	// Fields

	private BigDecimal clientId;
	private String clientName;
	private String clientIdcard;
	private String clientPhone;
	private Boolean clientIsuser;
	private Integer userId;
	private String userName;
	private String state;
	// Constructors

	/** default constructor */
	public TsClient() {
	}

	/** full constructor */
	public TsClient(String clientName, String clientIdcard, String clientPhone, Boolean clientIsuser, Integer userId) {
		this.clientName = clientName;
		this.clientIdcard = clientIdcard;
		this.clientPhone = clientPhone;
		this.clientIsuser = clientIsuser;
		this.userId = userId;
	}

	// Property accessors

	public BigDecimal getClientId() {
		return this.clientId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setClientId(BigDecimal clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientIdcard() {
		return this.clientIdcard;
	}

	public void setClientIdcard(String clientIdcard) {
		this.clientIdcard = clientIdcard;
	}

	public String getClientPhone() {
		return this.clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Boolean getClientIsuser() {
		return this.clientIsuser;
	}

	public void setClientIsuser(Boolean clientIsuser) {
		this.clientIsuser = clientIsuser;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}