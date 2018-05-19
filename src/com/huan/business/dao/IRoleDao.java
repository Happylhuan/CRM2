package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsRole;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface  IRoleDao {
	public PageModel getRoleList(TsRole role,PageBean page);

	public boolean addRole(TsRole role);

	public boolean delRole(TsRole role);

	public boolean delRoles(String[] roleName);
	public boolean updateRole(TsRole role);

	public TsRole getRoleById(int roleId);
	
	public  List<String> getRoleNameById(BigDecimal manageId);
	public Integer getRoleNumByManageId(BigDecimal manageId);

}
