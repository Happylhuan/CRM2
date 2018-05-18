package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsRole entity. @author MyEclipse Persistence Tools
 */

public class TsRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleRemark;
	private String delEle;
	private BigDecimal manageId;
	private String state;
	// Constructors

	/** default constructor */
	public TsRole() {
	}

	/** full constructor */
	public TsRole(String roleName, String roleRemark, BigDecimal manageId) {
		this.roleName = roleName;
		this.roleRemark = roleRemark;
		this.manageId = manageId;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleRemark() {
		return this.roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
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