package com.huan.business.po;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TsUser entity. @author MyEclipse Persistence Tools
 */

public class TsUser implements java.io.Serializable {

	// Fields

	private BigDecimal userId;
	private String loginName;
	private String userName;
	private String passWord;
	private String phoneNumber;
	private String role;
	private BigDecimal manageId;
	private BigDecimal orderNum;
	private BigDecimal clientNum;
	private String mailbox;
	private Integer power;
	private String manageName;
	private String delEle;
	private String state;
	
	// Constructors

	/** default constructor */
	public TsUser() {
	}

	/** full constructor */
	public TsUser(String loginName, String userName, String passWord, String phoneNumber, String role,
			BigDecimal manageId, BigDecimal orderNum, BigDecimal clientNum, String mailbox, Integer power) {
		this.loginName = loginName;
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.manageId = manageId;
		this.orderNum = orderNum;
		this.clientNum = clientNum;
		this.mailbox = mailbox;
		this.power = power;
	}

	// Property accessors

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BigDecimal getManageId() {
		return this.manageId;
	}

	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}

	public BigDecimal getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(BigDecimal orderNum) {
		this.orderNum = orderNum;
	}

	public BigDecimal getClientNum() {
		return this.clientNum;
	}

	public void setClientNum(BigDecimal clientNum) {
		this.clientNum = clientNum;
	}

	public String getMailbox() {
		return this.mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public Integer getPower() {
		return this.power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
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