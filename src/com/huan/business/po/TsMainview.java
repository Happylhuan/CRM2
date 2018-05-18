package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsMainview entity. @author MyEclipse Persistence Tools
 */

public class TsMainview implements java.io.Serializable {

	// Fields

	private BigDecimal mainId;
	private Integer orderNum;
	private Integer clientNum;
	private String userName;
	private String userRole;
	private BigDecimal userId;
	private double totalPrice;
	private BigDecimal manageId;
	// Constructors
	public BigDecimal getMainId() {
		return mainId;
	}
	public void setMainId(BigDecimal mainId) {
		this.mainId = mainId;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getClientNum() {
		return clientNum;
	}
	public void setClientNum(Integer clientNum) {
		this.clientNum = clientNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public BigDecimal getUserId() {
		return userId;
	}
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public BigDecimal getManageId() {
		return manageId;
	}
	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}
	public TsMainview(BigDecimal mainId, Integer orderNum, Integer clientNum, String userName, String userRole,
			BigDecimal userId, double totalPrice) {
		super();
		this.mainId = mainId;
		this.orderNum = orderNum;
		this.clientNum = clientNum;
		this.userName = userName;
		this.userRole = userRole;
		this.userId = userId;
		this.totalPrice = totalPrice;
	}
	public TsMainview() {
		super();
		// TODO Auto-generated constructor stub
	}

}