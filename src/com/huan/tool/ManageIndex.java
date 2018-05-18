package com.huan.tool;

import java.util.List;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsNotice;

public class ManageIndex {
	private Integer  logNum;
	private List<TsNotice> notices;
	private TsManage manage;
	public Integer getLogNum() {
		return logNum;
	}
	public void setLogNum(Integer logNum) {
		this.logNum = logNum;
	}
	public List<TsNotice> getNotices() {
		return notices;
	}
	public void setNotices(List<TsNotice> notices) {
		this.notices = notices;
	}
	public TsManage getManage() {
		return manage;
	}
	public void setManage(TsManage manage) {
		this.manage = manage;
	}
	public ManageIndex(Integer logNum, List<TsNotice> notices, TsManage manage) {
		super();
		this.logNum = logNum;
		this.notices = notices;
		this.manage = manage;
	}
	public ManageIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
