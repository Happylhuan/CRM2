package com.huan.business.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.LljMent;

public class MentDao extends HibernateDaoSupport implements IMentDao {

	@Override
	public List<LljMent> getMents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMent(LljMent ment) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(ment);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean updateMent(LljMent ment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delectMent(LljMent ment) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(ment);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean getMentById(int mentId) {
		// TODO Auto-generated method stub
		return false;
	}

}
