package com.huan.business.action;

import java.util.List;

import com.huan.business.po.TsUser;
import com.huan.business.service.IPowerService;
import com.huan.business.service.IRoleService;
import com.huan.business.service.IUserService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author acer
 *	user:用户对象
 *	users：用户集合
 *	pageModel：分页模板
 *	page:分页对象
 *	rolesName：角色集合
 */
public class UserAction extends ActionSupport implements ModelDriven<TsUser> {
	
	private TsUser user = new TsUser();
	private IUserService userService;
	private IRoleService roleService;
	private IPowerService powerService;
	private List<TsUser> users;
	private PageModel pageModel;
	private List<String> rolesName ;
	private List<Integer> powerList ;
	private PageBean page = new PageBean(1,20);
	
	/**
	 * 获取需要更新的对象
	 * @return
	 * 
	 */
	public String getupUser() {
		rolesName = this.roleService.getRoleNameById(user.getManageId());
		TsUser luser = this.userService.getUserById(user.getUserId());
		powerList =this.powerService.getPowerList();
		if (luser!= null) {
			user = luser;
			return "update";
		} else {
			this.addActionError("添加用户失败");
			return INPUT;
		}
	}
	

	/**
	 * 主页面的入口
	 * @return
	 */
	public String mainUser() {
		return "main";
	}
	/**
	 * 添加之前加载角色集合
	 * @return
	 */
	public String addBefUser() {
	List<String> list = this.roleService.getRoleNameById(user.getManageId());
	List<Integer> list2 = (List<Integer>) this.powerService.getPowerList();
	if (list!= null && list2 != null) {
		rolesName = list;
		powerList = list2;
		return "add";
	} else {
		this.addActionError("添加用户失败");
		return INPUT;
	}
	}
	/**
	 * 添加用户的方法
	 * @return
	 */
	public String addUser() {
		if (this.userService.addUser(user) != null) {
			return "success";
		} else {
			this.addActionError("添加用户失败");
			return INPUT;
		}
	}
	public String getInfoUser() {
		user = userService.getUserById(user.getUserId());
		user.setManageName(userService.getManageById(user.getManageId().intValue()).getManageName());
		return "userInfo";
	}
	/**
	 * 删除用户的方法
	 * @return
	 */
	public String delUser() {
		if (this.userService.delUser(user)) {
			return "success";
		} else {
			this.addActionError("删除用户失败");
			return INPUT;
		}
	}
	public String delsUser() {
		if (this.userService.delUsers(user.getDelEle())) {
			return "success";
		} else {
			this.addActionError("删除用户失败");
			return INPUT;
		}
	}
	/**
	 * 更新用户的方法
	 * @return
	 */
	public String updateUser() {
		
		if (this.userService.updateUser(user)){
			return "success";
		} else {
			this.addActionError("更新用户失败");
			return INPUT;
		}
	}

	/**
	 * 查询用户
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String listUser(){
		pageModel = this.userService.listUser(user, page);
		users = (List<TsUser>) pageModel.getObject();
		if (users != null) {
			return "list";
		} else {
			this.addActionError("查询用户失败");
			return INPUT;
		}

	}

	

	public List<String> getRolesName() {
		return rolesName;
	}

	public void setRolesName(List<String> rolesName) {
		this.rolesName = rolesName;
	}

	public IRoleService getiRoleService() {
		return roleService;
	}

	public void setiRoleService(IRoleService iRoleService) {
		this.roleService = iRoleService;
	}


	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}


	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public TsUser getUser() {
		return user;
	}

	public void setUser(TsUser user) {
		this.user = user;
	}

	public List<TsUser> getUsers() {
		return users;
	}

	public void setUsers(List<TsUser> users) {
		this.users = users;
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}

	public List<Integer> getPowerList() {
		return powerList;
	}
	public void setPowerList(List<Integer> powerList) {
		this.powerList = powerList;
	}
	
	
	public IPowerService getPowerService() {
		return powerService;
	}
	public void setPowerService(IPowerService powerService) {
		this.powerService = powerService;
	}
	@Override
	public TsUser getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
