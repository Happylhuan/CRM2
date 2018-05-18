package com.huan.business.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TsOrder entity. @author MyEclipse Persistence Tools
 */

public class TsOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private String clienName;
	private String productName;
	private Date sendTime;
	private String address;
	private String phoneNum;
	private Integer userId;
	private Boolean isSend;
	private Date orderTime;
	private String userName;
	private String sendState;
	private Integer productNum;
	private Integer productPrice;
	private Long totalPrice;
	private BigDecimal manageId;
	// Constructors

	/** default constructor */
	public TsOrder() {
	}

	/** full constructor */
	public TsOrder(String clienName, String productName, Date sendTime, String address, String phoneNum, Integer userId,
			Boolean isSend, Date orderTime,Integer productNum,Integer productPrice,Long totalPrice) {
		this.clienName = clienName;
		this.productName = productName;
		this.sendTime = sendTime;
		this.address = address;
		this.phoneNum = phoneNum;
		this.userId = userId;
		this.isSend = isSend;
		this.orderTime = orderTime;
		this.productNum = productNum;
		this.productPrice = productPrice;
		this.totalPrice = totalPrice;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public String getSendState() {
		return sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getClienName() {
		return this.clienName;
	}

	public void setClienName(String clienName) {
		this.clienName = clienName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIsSend() {
		return this.isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getManageId() {
		return manageId;
	}

	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}

}