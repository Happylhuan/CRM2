package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsProductBrand entity. @author MyEclipse Persistence Tools
 */

public class TsProductBrand implements java.io.Serializable {

	// Fields

	private BigDecimal productBrandId;
	private String productBrandName;
	private BigDecimal manageId;
	private String delEle;
	private String state;
	// Constructors

	/** default constructor */
	public TsProductBrand() {
	}

	/** full constructor */
	public TsProductBrand(String productBrandName, BigDecimal manageId) {
		this.productBrandName = productBrandName;
		this.manageId = manageId;
	}

	// Property accessors

	public BigDecimal getProductBrandId() {
		return this.productBrandId;
	}

	public void setProductBrandId(BigDecimal productBrandId) {
		this.productBrandId = productBrandId;
	}

	public String getProductBrandName() {
		return this.productBrandName;
	}

	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
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

}