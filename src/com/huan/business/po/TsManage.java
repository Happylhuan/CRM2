package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsManage entity. @author MyEclipse Persistence Tools
 */

public class TsManage implements java.io.Serializable {

	// Fields

	private BigDecimal manageId;
	private String manageName;
	private String manageLoginName;
	private String managePass;

	// Constructors

	/** default constructor */
	public TsManage() {
	}

	/** full constructor */
	public TsManage(String manageName, String manageLoginName, String managePass) {
		this.manageName = manageName;
		this.manageLoginName = manageLoginName;
		this.managePass = managePass;
	}

	// Property accessors

	public BigDecimal getManageId() {
		return this.manageId;
	}

	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}

	public String getManageName() {
		return this.manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getManageLoginName() {
		return this.manageLoginName;
	}

	public void setManageLoginName(String manageLoginName) {
		this.manageLoginName = manageLoginName;
	}

	public String getManagePass() {
		return this.managePass;
	}

	public void setManagePass(String managePass) {
		this.managePass = managePass;
	}

}