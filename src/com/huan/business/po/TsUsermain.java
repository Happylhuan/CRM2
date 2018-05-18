package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsUsermain entity. @author MyEclipse Persistence Tools
 */

public class TsUsermain implements java.io.Serializable {

	// Fields

	private BigDecimal usermainId;
	private String clientName;
	private String clientPhone;
	private Integer clientOrdernum;
	private double clientTotalPriceNum;
	private BigDecimal clientId;
	private String userName;
	private Integer userId;
	// Constructors

	/** default constructor */
	public TsUsermain() {
	}

	/** full constructor */
	public TsUsermain(String clientName, String clientPhone, Integer clientOrdernum, BigDecimal clientId,Double clientTotalPriceNum) {
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.clientOrdernum = clientOrdernum;
		this.clientId = clientId;
		this.clientTotalPriceNum = clientTotalPriceNum;
	}

	// Property accessors

	public BigDecimal getUsermainId() {
		return this.usermainId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUsermainId(BigDecimal usermainId) {
		this.usermainId = usermainId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return this.clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Integer getClientOrdernum() {
		return this.clientOrdernum;
	}

	public void setClientOrdernum(Integer clientOrdernum) {
		this.clientOrdernum = clientOrdernum;
	}

	public BigDecimal getClientId() {
		return this.clientId;
	}

	public void setClientId(BigDecimal clientId) {
		this.clientId = clientId;
	}

	public double getClientTotalPriceNum() {
		return clientTotalPriceNum;
	}

	public void setClientTotalPriceNum(double clientTotalPriceNum) {
		this.clientTotalPriceNum = clientTotalPriceNum;
	}

}