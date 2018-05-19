package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;

public interface ILoginService {
	public boolean CheckUser(String LoginName,String pass);
	public boolean CheckManage(String LoginName,String pass);
	public TsUser getUserByName(String userName);
	public TsManage getManageByName(String manageName);
	public boolean saveManage(TsManage manage);
	public TsManage getManageById(BigDecimal manageId);
	public boolean updateManage(TsManage manage);
	public  Map<String, Object> getManageIndexByManageId(BigDecimal manageId);
	public  Map<String, Object> getUserIndexByUserId(BigDecimal userId);
}
