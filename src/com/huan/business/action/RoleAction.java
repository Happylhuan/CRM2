package com.huan.business.action;

import java.util.List;

import com.huan.business.po.TsRole;
import com.huan.business.service.IRoleService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends ActionSupport implements ModelDriven<TsRole>{
	private TsRole role = new TsRole();
	private List<TsRole > roles ;
	private IRoleService roleService;
	private PageModel pageModel;
	private PageBean page = new PageBean(1,10);
	
	public PageBean getPage() {
		return page;
	}
	public void setPage(PageBean page) {
		this.page = page;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	
	public String listRole() {
		
		pageModel = this.roleService.listRole(role,page);
		roles = (List<TsRole>) pageModel.getObject();
		if(roles!=null){
			return "list";
		}else{
			this.addActionError("查询角色失败");
			return INPUT;
		}
	}
	public String addRole() {
		if(this.roleService.addRole(role)){
			return "successRedirect";
		}else{
			this.addActionError("添加角色失败");
			return INPUT;
		}
	}
	
	public String getupRole() {
	TsRole lrole = this.roleService.getRoleById(role.getRoleId().intValue());
		if (lrole!= null) {
			role = lrole;
			return "update";
		} else {
			this.addActionError("添加用户失败");
			return INPUT;
		}
	}
	
	public String updateRole() {
		if(this.roleService.updateRole(role)){
			return "successRedirect";
		}else{
			this.addActionError("更改角色失败");
			return INPUT;
		}
	}
	public String delRole() {

		if(this.roleService.delRole(role)){
			return "successRedirect";
		}else{
			this.addActionError("删除角色失败");
			return INPUT;
		}
	}
	public String delsRole() {
		if (this.roleService.delRoles(role.getDelEle())) {
			return "success";
		} else {
			this.addActionError("删除用户失败");
			return INPUT;
		}
	}
	
	public TsRole getRole() {
		return role;
	}

	public void setRole(TsRole role) {
		this.role = role;
	}

	public List<TsRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TsRole> roles) {
		this.roles = roles;
	}

	public IRoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	@Override
	public TsRole getModel() {
		// TODO Auto-generated method stub
		return this.role;
	}
}
