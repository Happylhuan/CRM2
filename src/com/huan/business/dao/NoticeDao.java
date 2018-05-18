package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsNotice;

public class NoticeDao extends HibernateDaoSupport implements INoticeDao {
	
	@Override
	public List<TsNotice> getNotices(String sql, int pageNo, int numNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNotice(TsNotice notice) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(notice);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean updateNotice(TsNotice notice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delectNotice(TsNotice notice) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(notice);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public List<TsNotice> getNoticeByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		String hql = " from TsNotice notice where manageId="+manageId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<TsNotice> list = (List<TsNotice>) Template.find(hql);
		
		return list;
	}
	@Override
	public List<TsNotice> getNoticeByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		String hql = " from TsNotice notice where manageId = (select manageId from TsUser where userId = "+userId+")";
		HibernateTemplate Template =  this.getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<TsNotice> list = (List<TsNotice>) Template.find(hql);
		return list;
	}
}
