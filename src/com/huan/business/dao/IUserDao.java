package com.huan.business.dao;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface  IUserDao {

	public PageModel getUserList(TsUser user,PageBean page,String hql);

	public boolean addUser(TsUser user);;

	public boolean delUser(TsUser user);

	public boolean updateUser(TsUser user);

	public TsUser getUserById(int userid);
	
	public Integer getManageIdByName(String loginName);
	
	public TsUser getUserByName(String userName);
	public Boolean delUsers(String[] ids);
	public String getUserNameById(int userid);
	public TsManage getManageById(int manageId);
}
