package com.huan.tool;

import java.util.List;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsNotice;

public class ManageIndex {
	private Integer  logNum;
	private Integer  userNum;
	private Integer  roleNum;
	private Integer  orderNum;
	private Integer  productNum;
	private Integer  productTypeNum;
	private Integer  productBrandNum;
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
	
	public Integer getUserNum() {
		return userNum;
	}
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
	public Integer getRoleNum() {
		return roleNum;
	}
	public void setRoleNum(Integer roleNum) {
		this.roleNum = roleNum;
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
	
	public Integer getProductTypeNum() {
		return productTypeNum;
	}
	public void setProductTypeNum(Integer productTypeNum) {
		this.productTypeNum = productTypeNum;
	}
	public Integer getProductBrandNum() {
		return productBrandNum;
	}
	public void setProductBrandNum(Integer productBrandNum) {
		this.productBrandNum = productBrandNum;
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
