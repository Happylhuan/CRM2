package com.huan.business.po;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LljLogs entity. @author MyEclipse Persistence Tools
 */

public class LljLogs implements java.io.Serializable {

	// Fields

	private BigDecimal logId;
	private String logInfo;
	private Date logAddtime;
	private BigDecimal userId;
	private String logTitle;
	private Boolean logState;
	private String logStateStr;
	private String userName;
	private BigDecimal manageId;
	private Set<LljMent> ments = new HashSet<LljMent>();
	// Constructors

	/** default constructor */
	public LljLogs() {
	}

	/** full constructor */
	public LljLogs(String logInfo, Date logAddtime, BigDecimal userId, String logTitle, Boolean logState,BigDecimal manageId) {
		this.logInfo = logInfo;
		this.logAddtime = logAddtime;
		this.userId = userId;
		this.logTitle = logTitle;
		this.logState = logState;
		this.manageId = manageId;
	}

	// Property accessors

	public BigDecimal getLogId() {
		return this.logId;
	}

	public void setLogId(BigDecimal logId) {
		this.logId = logId;
	}

	public String getLogInfo() {
		return this.logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public Date getLogAddtime() {
		return this.logAddtime;
	}

	public void setLogAddtime(Date logAddtime) {
		this.logAddtime = logAddtime;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getLogTitle() {
		return this.logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}

	public Boolean getLogState() {
		return this.logState;
	}

	public void setLogState(Boolean logState) {
		this.logState = logState;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<LljMent> getMents() {
		return ments;
	}

	public void setMents(Set<LljMent> ments) {
		this.ments = ments;
	}

	public BigDecimal getManageId() {
		return manageId;
	}

	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}

	public String getLogStateStr() {
		return logStateStr;
	}

	public void setLogStateStr(String logStateStr) {
		this.logStateStr = logStateStr;
	}

	
}