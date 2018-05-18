package com.huan.business.po;

import java.math.BigDecimal;

/**
 * TsNotice entity. @author MyEclipse Persistence Tools
 */

public class TsNotice implements java.io.Serializable {

	// Fields

	private BigDecimal noticeId;
	private BigDecimal manageId;
	private String noticeTitle;
	private String noticeInfo;
	private String manageName;

	// Constructors

	/** default constructor */
	public TsNotice() {
	}

	/** full constructor */
	public TsNotice(BigDecimal manageId, String noticeTitle, String noticeInfo, String manageName) {
		this.manageId = manageId;
		this.noticeTitle = noticeTitle;
		this.noticeInfo = noticeInfo;
		this.manageName = manageName;
	}

	// Property accessors

	public BigDecimal getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(BigDecimal noticeId) {
		this.noticeId = noticeId;
	}

	public BigDecimal getManageId() {
		return this.manageId;
	}

	public void setManageId(BigDecimal manageId) {
		this.manageId = manageId;
	}

	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeInfo() {
		return this.noticeInfo;
	}

	public void setNoticeInfo(String noticeInfo) {
		this.noticeInfo = noticeInfo;
	}

	public String getManageName() {
		return this.manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

}