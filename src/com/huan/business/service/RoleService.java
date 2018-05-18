package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.IRoleDao;
import com.huan.business.dao.RoleDao;
import com.huan.business.po.TsRole;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
/** 
 * @Transactional中的的属性 propagation :事务的传播行为
 * 						 isolation :事务的隔离级别 
 * 						readOnly :只读 
 *                     rollbackFor :发生哪些异常回滚
 *                     noRollbackFor :发生哪些异常不回滚 
 *                     rollbackForClassName 根据异常类名回滚 
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)  
public class RoleService implements IRoleService {
	private IRoleDao roledao;

	public IRoleDao getRoledao() {
		return roledao;
	}

	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}

	@Override
	public PageModel listRole(TsRole role,PageBean page) {
		// TODO Auto-generated method stub
		if("add".equals(role.getState())||"upd".equals(role.getState())){
			role.setRoleName("");
			role.setRoleRemark("");
		}
		return this.roledao.getRoleList(role,page);
	}

	@Override
	public Boolean addRole(TsRole role) {
		// TODO Auto-generated method stub
		role.setRoleName(role.getRoleName().trim());
		role.setRoleRemark(role.getRoleRemark().trim());
		return this.roledao.addRole(role);
	}

	@Override
	public Boolean updateRole(TsRole role) {
		// TODO Auto-generated method stub
		return this.roledao.updateRole(role);
	}

	@Override
	public Boolean delRole(TsRole role) {
		// TODO Auto-generated method stub
		return this.roledao.delRole(role);
	}

	@Override
	public List<String> getRoleNameById(BigDecimal manageId){
		return roledao.getRoleNameById(manageId);
	}

	@Override
	public TsRole getRoleById(int roleId) {
		return this.roledao.getRoleById(roleId);
	}

	@Override
	public Boolean delRoles(String roleName) {
		// TODO Auto-generated method stub
		String[] list = roleName.split(";");
		return this.roledao.delRoles(list);
	}



}
