package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsProductType entity. @author MyEclipse Persistence Tools
 */

public class TsProductType implements java.io.Serializable {

	// Fields

	private BigDecimal productTypeId;
	private String productTypeName;
	private BigDecimal manageId;
	private String delEle;
	private String state;

	// Constructors

	/** default constructor */
	public TsProductType() {
	}

	/** full constructor */
	public TsProductType(String productTypeName, BigDecimal manageId) {
		this.productTypeName = productTypeName;
		this.manageId = manageId;
	}

	// Property accessors

	public BigDecimal getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(BigDecimal productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return this.productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
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