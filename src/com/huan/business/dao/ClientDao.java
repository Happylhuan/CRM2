package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsOrder;
import com.huan.business.po.TsRole;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class ClientDao extends HibernateDaoSupport implements IClientDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel getClientList(TsClient client, final PageBean page, String hql) {

		if (client != null && (client.getClientIdcard() != null && !"".equals(client.getClientIdcard()))) {
			hql += "and client.clientIdcard  like '%" + client.getClientIdcard() + "%'";
		}
	
		if (client != null && (client.getClientName() != null && !"".equals(client.getClientName()))) {
			hql += "and client.clientName like '%" + client.getClientName() + "%'";
		}
		if (client != null && (client.getClientPhone() != null && !"".equals(client.getClientPhone()))) {
			hql += "and client.clientPhone like '%" + client.getClientPhone() + "%'";
		}
	
		final String hqla = hql;
		HibernateTemplate Template =  this.getHibernateTemplate();
		int allcows = Template.find(hqla).size();
		List<TsClient> list = Template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hqla);
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
				List  list = query.list();
				return list;
			}
		});
		int totalpage = page.getTotalPages(page.getPageSize(), allcows);
		if(list.size()==0){
			page.setPageNo(page.getPageNo()-1);
			allcows = Template.find(hqla).size();
			list = Template.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {
					Query query = session.createQuery(hqla);
					query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
					List  list = query.list();
					return list;
				}
			});
			totalpage = page.getTotalPages(page.getPageSize(), allcows);
		}
		page.setAllRows(allcows);
		page.setTotalPage(totalpage);
		PageModel pageModel = new PageModel(page, list);
		return pageModel;
	}

	@Override
	public boolean addClient(TsClient client) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(client);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean delClient(TsClient client) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(client);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean updateClient(TsClient client) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(client);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public TsClient getClientById(Integer clientId) {
		String hql = " from TsClient client where client.clientId="+clientId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		List<TsClient> list = (List<TsClient>) Template.find(hql);
		return (TsClient)list.get(0);
	}

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


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getClientsByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		String hql="from TsClient client where client.userId='"+userId+"' and client.clientIsuser=true";
		List<TsClient> list = (List<TsClient>) this.getHibernateTemplate().find(hql);
		List<String> name = new ArrayList<String>();
		 for (Object obj : list) {
				TsClient ts = (TsClient) obj;
				String str = ts.getClientName();
				name.add(str);
			}
		 return name;
		
	}

	@Override
	public Integer getClientNumByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsClient client where client.userId = "+userId+")";
			@SuppressWarnings("unchecked")
			List<TsClient> list = (List<TsClient>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.size();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
