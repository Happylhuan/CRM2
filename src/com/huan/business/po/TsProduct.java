package com.huan.business.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TsProduct entity. @author MyEclipse Persistence Tools
 */

public class TsProduct implements java.io.Serializable {

	// Fields

	private BigDecimal productId;
	private String productName;
	private String productType;
	private String venderAddress;
	private Date addTime;
	private BigDecimal manageId;
	private String delEle;
	private String state;
	private BigDecimal userId;
	// Constructors

	/** default constructor */
	public TsProduct() {
	}

	/** full constructor */
	public TsProduct(String productName, String productType, String venderAddress, Date addTime, BigDecimal manageId) {
		this.productName = productName;
		this.productType = productType;
		this.venderAddress = venderAddress;
		this.addTime = addTime;
		this.manageId = manageId;
	}

	// Property accessors

	public BigDecimal getProductId() {
		return this.productId;
	}

	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getVenderAddress() {
		return this.venderAddress;
	}

	public void setVenderAddress(String venderAddress) {
		this.venderAddress = venderAddress;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getManageId() {
		return this.manageId;
	}

	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}

	public String getDelEle() {
		return delEle;
	}

	public void setDelEle(String delEle) {
		this.delEle = delEle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

}