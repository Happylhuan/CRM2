package com.huan.business.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class UserDao implements IUserDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel getUserList(TsUser user, final PageBean page,String hql) {
		
		if(null==user.getState()){
		if (user != null && (user.getUserName() != null && !"".equals(user.getUserName()))) {
			hql += "and user.userName like '%" + user.getUserName() + "%'";
		}
		if (user != null && (user.getLoginName() != null && !"".equals(user.getLoginName()))) {
			hql += "and user.loginName like '%" + user.getLoginName() + "%'";
		}
		if (user != null && (user.getPhoneNumber() != null && !"".equals(user.getPhoneNumber()))) {
			hql += "and user.phoneNumber  like '%" + user.getPhoneNumber() + "%'";
		}
		if (user != null && (user.getRole() != null && !"".equals(user.getRole()))) {
			hql += "and user.role like '%" + user.getRole() + "%'";
		}
		}
		final String hqla = hql;
		HibernateTemplate Template = this.getHibernateTemplate();
		int allcows = Template.find(hqla).size();
		List<TsUser> list = Template.execute(new HibernateCallback() {
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
	public boolean addUser(TsUser user) {
		try {
			this.getHibernateTemplate().save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delUser(TsUser user) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(TsUser user) {
		try {
			this.getHibernateTemplate().update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public TsUser getUserById(int userid) {
		
		try {
			String hql = " from TsUser user where 1=1 and userId="+userid+"";
			HibernateTemplate Template =  this.getHibernateTemplate();
			List<TsUser> list = (List<TsUser>) Template.find(hql);
			return (TsUser)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getUserNameById(int userid) {
		
		try {
			String hql = " from TsUser user where 1=1 and userId="+userid+"";
			HibernateTemplate Template =  this.getHibernateTemplate();
			List<TsUser> list = (List<TsUser>) Template.find(hql);
			if(list.size()!=0){
				return list.get(0).getUserName();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Integer getManageIdByName(String loginName) {
		
		try {
			String Name = loginName.trim();
			String hql=" from TsManage manage where manage.manageLoginName='"+Name+"'";
			List<TsManage> list = (List<TsManage>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.get(0).getManageId().intValue();
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Boolean delUsers(String[] ids) {
		// TODO Auto-generated method stub
		try {
			for (int i=0;i<ids.length;i++) {
				Integer id =Integer.valueOf(ids[i]);
				String sql = "delete ts_user where user_id = ?";
			    SQLQuery query = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);  
			    query.setInteger(0, id);
			    query.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
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
	public TsManage getManageById(int manageId) {
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


	
}
