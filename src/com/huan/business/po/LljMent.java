package com.huan.business.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * LljMent entity. @author MyEclipse Persistence Tools
 */

public class LljMent implements java.io.Serializable {

	// Fields

	private BigDecimal mentId;
	private String mentLog;
	private Date mentTime;
	private BigDecimal userId;
	private BigDecimal logId;
	private String userName;
	private LljLogs log;
	// Constructors

	public LljLogs getLogs() {
		return log;
	}

	public void setLogs(LljLogs log) {
		this.log = log;
	}

	/** default constructor */
	public LljMent() {
	}

	/** full constructor */
	public LljMent(String mentLog, Date mentTime, BigDecimal userId, BigDecimal logId) {
		this.mentLog = mentLog;
		this.mentTime = mentTime;
		this.userId = userId;
		this.logId = logId;
	}

	// Property accessors

	public BigDecimal getMentId() {
		return this.mentId;
	}

	public void setMentId(BigDecimal mentId) {
		this.mentId = mentId;
	}

	public String getMentLog() {
		return this.mentLog;
	}

	public void setMentLog(String mentLog) {
		this.mentLog = mentLog;
	}

	public Date getMentTime() {
		return this.mentTime;
	}

	public void setMentTime(Date mentTime) {
		this.mentTime = mentTime;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public BigDecimal getLogId() {
		return this.logId;
	}

	public void setLogId(BigDecimal logId) {
		this.logId = logId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}