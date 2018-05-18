package com.huan.business.service;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.LoginDao;
import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class LoginService implements ILoginService {
	private LoginDao loginDao; 
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public boolean CheckUser(String LoginName, String pass) {
		// TODO Auto-generated method stub
		return this.loginDao.CheckUser(LoginName, pass);
	}

	@Override
	public boolean CheckManage(String loginName, String passWord) {
		// TODO Auto-generated method stub
		return this.loginDao.CheckManage(loginName, passWord);
	}
	@Override
	public TsUser getUserByName(String userName){
		return this.loginDao.getUserByName(userName);
	}

	@Override
	public boolean saveManage(TsManage manage) {
		// TODO Auto-generated method stub
		return this.loginDao.saveManage(manage);
	}

	@Override
	public TsManage getManageByName(String manageName) {
		// TODO Auto-generated method stub
		TsManage manage = this.loginDao.getManageByName(manageName);
		if(null == manage){
			return null;
		}
		return manage;
	}
	@Override
	public TsManage getManageById(BigDecimal manageId) {
		// TODO Auto-generated method stub
		return this.loginDao.getManageById(manageId);
	}
}
