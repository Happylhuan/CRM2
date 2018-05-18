package com.huan.business.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsOrder;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class OrderDao extends HibernateDaoSupport implements IOrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel getOrderList(TsOrder order, final PageBean page,String hql) {
		if (order != null && (order.getClienName() != null && !"".equals(order.getClienName()))) {
			hql += "and order.clienName like '%" + order.getClienName() +"%'";
		}
		if (order != null && (order.getPhoneNum()!= null && !"".equals(order.getPhoneNum()))) {
			hql += "and order.phoneNum like '%" + order.getPhoneNum()+ "%'";
		}
		if (order != null && (order.getProductName() != null && !"".equals(order.getProductName()))) {
			hql += "and order.productName like '%" + order.getProductName() + "%' ";
		}
		if (order != null && (order.getSendTime() != null && !"".equals(order.getSendTime()))) {
			hql += "and order.sendTime='" + order.getSendTime() + "'";
		}
		final String hqla = hql;
		HibernateTemplate Template =  this.getHibernateTemplate();
		int allcows = Template.find(hqla).size();
		List<TsOrder> list = Template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hqla);
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
				List  list = query.list();
				return list;
			}
		});
		Template.clear();
		int totalpage = page.getTotalPages(page.getPageSize(), allcows);
		page.setAllRows(allcows);
		page.setTotalPage(totalpage);
		PageModel pageModel = new PageModel(page, list);
		return pageModel;
	}

	@Override
	public boolean addOrder(TsOrder order) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(order);
			return true;
		} catch (Exception e) {
			return false;
		} 
		
	}

	@Override
	public boolean delOrder(TsOrder order) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(order);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean updateOrder(TsOrder Order) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(Order);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public TsOrder getOrderById(int orderId) {
		String hql = " from TsOrder order where 1=1 and orderId="+orderId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		List<TsOrder> list = (List<TsOrder>) Template.find(hql);
		
		return (TsOrder)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getUserIdByName(String userName) {
		String Name = userName.trim();
		String hql="from TsUser user where user.loginName='"+Name+"'";
		List<TsUser> list = (List<TsUser>) this.getHibernateTemplate().find(hql);
		if(list.size()!=0){
			return list.get(0).getUserId().intValue();
		}
		return 0;
	}
	}

