package com.huan.business.service;

import java.math.BigDecimal;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IUserService {
	public PageModel listUser(TsUser user,PageBean page);
	public Boolean addUser(TsUser user);
	public Boolean updateUser(TsUser user);
	public Boolean delUser(TsUser user);
	public TsUser getUserById(BigDecimal userId);
	public Boolean delUsers(String str);
	public TsUser getUserByName(String userName);
	public String getUserNameById(int userid);
	public TsManage getManageById(int manageId);
}
