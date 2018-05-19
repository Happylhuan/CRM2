package com.huan.business.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.ClientDao;
import com.huan.business.dao.IClientDao;
import com.huan.business.dao.ILogsDao;
import com.huan.business.dao.INoticeDao;
import com.huan.business.dao.IOrderDao;
import com.huan.business.dao.IProductDao;
import com.huan.business.dao.IRoleDao;
import com.huan.business.dao.IUserDao;
import com.huan.business.dao.LoginDao;
import com.huan.business.po.TsManage;
import com.huan.business.po.TsNotice;
import com.huan.business.po.TsUser;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class LoginService implements ILoginService {
	private LoginDao loginDao;
	private IUserDao userDao;
	private IRoleDao roleDao;
	private IOrderDao orderDao;
	private IProductDao productDao;
	private INoticeDao noticeDao;
	private ILogsDao logsDao;
	private IClientDao clientDao;

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

	@Override
	public boolean updateManage(TsManage manage) {
		// TODO Auto-generated method stub
		return this.loginDao.updateManage(manage);
	}

	@Override
	public Map<String, Object> getManageIndexByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		int userNum = userDao.getUserNumByManageId(manageId);
		int roleNum = roleDao.getRoleNumByManageId(manageId);
		int orderNum = orderDao.getOrderNumByManageId(manageId);
		int productNum = productDao.getProductNumByManageId(manageId);
		int productTypeNum = productDao.getProductTypeNumByManageId(manageId);
		int productBrandNum = productDao.getProductBraNumByManageId(manageId);
		List<TsNotice> notices = noticeDao.getNoticeByManageId(manageId);
		int logNum = logsDao.getLogsNumByManageId(manageId);
		Map<String, Object> indexMap = new HashMap<String, Object>();
		indexMap.put("userNum", userNum);
		indexMap.put("roleNum", roleNum);
		indexMap.put("orderNum", orderNum);
		indexMap.put("productNum", productNum);
		indexMap.put("productTypeNum", productTypeNum);
		indexMap.put("productBrandNum", productBrandNum);
		indexMap.put("logNum", logNum);
		indexMap.put("notices", notices);
		return indexMap;
	}
	@Override
	public Map<String, Object> getUserIndexByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		int orderNum = orderDao.getOrderNumByUserId(userId);
		int productNum = productDao.getProductNumByUserId(userId);
		int logNum = logsDao.getLogsNumByUserId(userId);
		int clientNum = clientDao.getClientNumByUserId(userId);
		List<TsNotice> notices = noticeDao.getNoticeByUserId(userId);
		Map<String, Object> indexMap = new HashMap<String, Object>();
		indexMap.put("orderNum", orderNum);
		indexMap.put("productNum", productNum);
		indexMap.put("logNum", logNum);
		indexMap.put("clientNum", clientNum);
		indexMap.put("notices", notices);
		
		return indexMap;
	}
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	public INoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public ILogsDao getLogsDao() {
		return logsDao;
	}

	public void setLogsDao(ILogsDao logsDao) {
		this.logsDao = logsDao;
	}

	public IClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}



	
	
}
