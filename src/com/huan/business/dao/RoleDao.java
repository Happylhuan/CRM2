package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsRole;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class RoleDao extends HibernateDaoSupport implements IRoleDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public PageModel getRoleList(TsRole role,final PageBean page) {
		String hql = " from TsRole role where manageId = "+role.getManageId()+" ";
		if (role.getRoleName() != null && !"".equals(role.getRoleName())) {
			hql += "and role.roleName like '%" + role.getRoleName() + "%'";
		}
		if (role.getRoleRemark() != null && !"".equals(role.getRoleRemark())) {
			hql += "and role.roleRemark  like '%" + role.getRoleRemark() + "%'";
		}
		
		 Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(hql);
		 	//得到滚动结果集
	        ScrollableResults scroll = query.scroll();
	        //滚动到最后一行
	        scroll.last();
	        int allcows = scroll.getRowNumber() + 1;
	        //设置分页位置
	        if(page.getPageNo()!=1 && allcows <= (page.getPageNo()-1)*page.getPageSize()){
		    	page.setPageNo(page.getPageNo()-1);
		    } 
	       query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
	       List<TsRole> list = query.list();
	    
		int totalpage = page.getTotalPages(page.getPageSize(), allcows);
		page.setAllRows(allcows);
		page.setTotalPage(totalpage);
		PageModel pageModel = new PageModel(page, list);
		return pageModel;
		}

	@Override
	public boolean addRole(TsRole role) {
		try {
			this.getHibernateTemplate().save(role);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean delRole(TsRole role) {
		try {
			this.getHibernateTemplate().delete(role);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateRole(TsRole role) {
		try {
			this.getHibernateTemplate().update(role);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public TsRole getRoleById(int roleId) {
		String hql = " from TsRole role where 1=1 and roleId="+roleId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		List<TsRole> list = (List<TsRole>) Template.find(hql);
		return (TsRole)list.get(0);
	}
	@Override
	public List<String> getRoleNameById(BigDecimal manageId) {
		String sql = "select role_name from  ts_role where manage_id = "+manageId+"";   
	    SQLQuery query = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql); 
	    @SuppressWarnings("unchecked")
		List<String> list = query.list();
	    this.getHibernateTemplate().clear();
		return list;
	}

	@Override
	public boolean delRoles(String[] roleName) {
		// TODO Auto-generated method stub
		try {
			for (int i=0;i<roleName.length;i++) {
				Integer id =Integer.valueOf(roleName[i]);
				String sql = "delete ts_role where role_id = ?";   
			    SQLQuery query = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);  
			    query.setInteger(0, id);  
			    query.executeUpdate();
			}
			this.getHibernateTemplate().clear();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Integer getRoleNumByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsRole role where role.manageId='"+manageId+"'";
			@SuppressWarnings("unchecked")
			List<TsRole> list = (List<TsRole>) this.getHibernateTemplate().find(hql);
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
