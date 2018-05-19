package com.huan.business.dao;

import java.math.BigDecimal;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface  IUserDao {

	public PageModel getUserList(TsUser user,PageBean page,String hql);

	public boolean addUser(TsUser user);;

	public boolean delUser(TsUser user);

	public boolean updateUser(TsUser user);

	public TsUser getUserById(BigDecimal userid);
	
	public Integer getManageIdByName(String loginName);
	
	public TsUser getUserByName(String userName);
	public Boolean delUsers(String[] ids);
	public String getUserNameById(Integer userid);
	public TsManage getManageById(Integer manageId);
	public Integer getUserNumByManageId(BigDecimal manageId);
	
}
