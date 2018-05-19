package com.huan.business.dao;

import java.math.BigDecimal;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;

public interface ILoginDao {
	public boolean CheckUser(String loginName,String pass);
	public boolean CheckManage(String loginName,String pass);
	public TsUser getUserByName(String userName);
	public TsManage getManageByName(String manageName);
	public boolean saveManage(TsManage manage);
	public TsManage getManageById(BigDecimal manageId);
	public boolean updateManage(TsManage manage);
}
