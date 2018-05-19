package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;


public class LoginDao extends HibernateDaoSupport implements ILoginDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean CheckUser(String loginName,String passWord) {
		// TODO Auto-generated method stub
		String hql=" from TsUser user where user.loginName='"+loginName+"' and user.passWord = '"+passWord+"'";
		List<TsUser> list = (List<TsUser>) this.getHibernateTemplate().find(hql);
		if(list.size()!=0){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean CheckManage(String loginName,String passWord) {
		// TODO Auto-generated method stub
		String hql=" from TsManage manage where manage.manageLoginName='"+loginName+"' and manage.managePass = '"+passWord+"'";
		List<TsManage> list = (List<TsManage>) this.getHibernateTemplate().find(hql);
		if(list.size()!=0){
			return true;
		}
		return false;
	}
	@Override
	public TsUser getUserByName(String userName) {
		try {
			String name = userName.trim();
			String hql=" from TsUser user where user.loginName='"+name+"'";
			List<TsUser> list = (List<TsUser>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveManage(TsManage manage) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(manage);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public TsManage getManageByName(String manageName) {
		// TODO Auto-generated method stub
		try {
			String name = manageName.trim();
			if(null == name){
				return null;
			}
			String hql=" from TsManage manage where manage.manageLoginName='"+name+"'";
			List<TsManage> list = (List<TsManage>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public TsManage getManageById(BigDecimal manageId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsManage manage where manage.manageId='"+manageId+"'";
			List<TsManage> list = (List<TsManage>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateManage(TsManage manage) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(manage);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
}
