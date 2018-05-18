package com.huan.business.service;
import java.math.BigDecimal;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.ILoginDao;
import com.huan.business.dao.IUserDao;
import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;
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
public class UserService implements IUserService {
	private IUserDao userDao;
	private ILoginDao loginDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public PageModel listUser(TsUser user,PageBean page) {
		String hql = " from TsUser user where user.manageId ='"+user.getManageId()+"' ";
		PageModel pageModel = ( PageModel) this.userDao.getUserList(user, page,hql);
		return pageModel;
	}
	@Override
	public Boolean addUser(TsUser user) {
		// TODO Auto-generated method stub
		if(user.getManageId()!=null){
			TsManage manage = loginDao.getManageById(user.getManageId());
			user.setManageName(manage.getManageName());
		}
		user.setLoginName(user.getLoginName().trim());
		user.setPassWord(user.getPassWord().trim());
		user.setPhoneNumber(user.getPhoneNumber().trim());
		
		if(this.userDao.addUser(user)){
			return true;
		}
		return false;
	}
	@Override
	public Boolean updateUser(TsUser user) {
		if(userDao.updateUser(user)){
			return true;
		}
		return false;
			
	}

	@Override
	public Boolean delUser(TsUser user) {
		
		return this.userDao.delUser(user);
	}
	@Override
	public TsUser getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public Boolean delUsers(String str) {
		// TODO Auto-generated method stub
		String[] list = str.split(";");
		if(userDao.delUsers(list)){
			return true;
		}
		
		return false;
	}

	@Override
	public TsUser getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(userName);
	}

	@Override
	public String getUserNameById(int userid) {
		// TODO Auto-generated method stub
		return userDao.getUserNameById(userid);
	}

	@Override
	public TsManage getManageById(int manageId) {
		// TODO Auto-generated method stub
		return userDao.getManageById(manageId);
	}

}
