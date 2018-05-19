package com.huan.business.action;

import java.text.DecimalFormat;
import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsUser;
import com.huan.business.po.TsUsermain;
import com.huan.business.service.IRoleService;
import com.huan.business.service.IUserMainService;
import com.huan.business.service.IUserService;
import com.huan.tool.TotalNum;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserMainAction extends ActionSupport {

	private TsUsermain userMain = new TsUsermain();
	private List<TsUsermain> userMains;
	private IUserMainService userMainService;
	private TsClient client;
	private TotalNum totalNum;
	private TsUser user= new TsUser();
	private IUserService userService;
	private IRoleService roleService;
	private List<String> rolesName ;
	
	public String listUsermain() {
		userMains = userMainService.getTopClients(userMain.getUserId());
		totalNum = userMainService.getTotalNum(userMain.getUserId());
		return "list";
	}
	public String getinfoUsermain(){
		client = userMainService.getClientById(userMain.getClientId().intValue());
		return "info";
	}
	//格式化数字显示
	  public String formatDouble(double s){
	      DecimalFormat fmt = new DecimalFormat("#0.00");
	      return fmt.format(s);
	  }
	  public String formatOrder(double s){
	      DecimalFormat fmt = new DecimalFormat("#0");
	      return fmt.format(s);
	  }
	/**
	 * 用户更新资料的方法
	 * @return
	 */
	public String editUsermain() {
		
		if (this.userService.updateUser(user)){
			userMains = userMainService.getTopClients(userMain.getUserId());
			totalNum = userMainService.getTotalNum(userMain.getUserId());
			return "relist";
		} else {
			this.addActionError("更新用户失败");
			return INPUT;
		}
	}
	public String getupeditUsermain() {
		rolesName = this.roleService.getRoleNameById(user.getManageId());
		TsUser luser = this.userService.getUserById(user.getUserId());
		if (luser!= null) {
			user = luser;
			return "edit";
		} else {
			this.addActionError("添加用户失败");
			return INPUT;
		}
	}
	
	
	public IUserMainService getUserMainService() {
		return userMainService;
	}



	public void setUserMainService(IUserMainService userMainService) {
		this.userMainService = userMainService;
	}



	public TotalNum getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(TotalNum totalNum) {
		this.totalNum = totalNum;
	}
	public TsClient getClient() {
		return client;
	}
	public void setClient(TsClient client) {
		this.client = client;
	}
	public TsUsermain getUserMain() {
		return userMain;
	}


	public void setUserMain(TsUsermain userMain) {
		this.userMain = userMain;
	}


	public List<TsUsermain> getUserMains() {
		return userMains;
	}


	public void setUserMains(List<TsUsermain> userMains) {
		this.userMains = userMains;
	}


	public TsUser getUser() {
		return user;
	}
	public void setUser(TsUser user) {
		this.user = user;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IRoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public List<String> getRolesName() {
		return rolesName;
	}
	public void setRolesName(List<String> rolesName) {
		this.rolesName = rolesName;
	}


	
}
