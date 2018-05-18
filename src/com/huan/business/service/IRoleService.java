package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsRole;
import com.huan.business.po.TsRole;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IRoleService {
	public PageModel listRole(TsRole role,PageBean page);
	public Boolean addRole(TsRole role);
	public Boolean updateRole(TsRole role);
	public Boolean delRole(TsRole role);
	public Boolean delRoles(String roleName);
	public TsRole getRoleById(int roleId);
	public List<String> getRoleNameById(BigDecimal manageId);
}
