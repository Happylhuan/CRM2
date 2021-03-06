package com.huan.tool;

import java.util.List;

import com.huan.business.po.TsNotice;
import com.huan.business.po.TsUser;

public class UserIndex {
	private Integer  logNum;
	private List<TsNotice> notices;
	private Integer clientNum;
	private Integer orderNum;
	private Integer productNum;
	
	private TsUser user;
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
	public TsUser getUser() {
		return user;
	}
	public void setUser(TsUser user) {
		this.user = user;
	}
	public UserIndex(Integer logNum, List<TsNotice> notices, TsUser user) {
		super();
		this.logNum = logNum;
		this.notices = notices;
		this.user = user;
	}
	
	public Integer getClientNum() {
		return clientNum;
	}
	public void setClientNum(Integer clientNum) {
		this.clientNum = clientNum;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public UserIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}