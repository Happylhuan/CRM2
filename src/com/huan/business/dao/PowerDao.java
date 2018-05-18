package com.huan.business.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsPower;
import com.huan.business.po.TsRole;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class PowerDao  extends HibernateDaoSupport implements IPowerDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel getPowerList(TsPower power, final PageBean page) {
		/*if (power != null && (power.getClienName() != null && !"".equals(power.getClienName()))) {
			hql += "and power.clienName like '%" + power.getClienName() +"%'";
		}
		if (power != null && (power.getPhoneNum()!= null && !"".equals(power.getPhoneNum()))) {
			hql += "and power.phoneNum like '%" + power.getPhoneNum()+ "%'";
		}
		if (power != null && (power.getProductName() != null && !"".equals(power.getProductName()))) {
			hql += "and power.productName like '%" + power.getProductName() + "%' ";
		}
		if (power != null && (power.getSendTime() != null && !"".equals(power.getSendTime()))) {
			hql += "and power.sendTime='" + power.getSendTime() + "'";
		}
		if (power != null && (power.getUserId() != null && !"".equals(power.getUserId()))) {
			hql += "and power.userId='" + power.getUserId() + "'";
		}*/
		
		String hql = "from TsPower power where 1=1 ";
		HibernateTemplate Template =  this.getHibernateTemplate();
		List<TsPower> list2 = (List<TsPower>) Template.find(hql);
		PageModel pageModel = new PageModel(null, list2);
		return pageModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getPowerList() {
		// TODO Auto-generated method stub
		PageModel pageModel = this.getPowerList(null,null);
		List<TsPower> list = (List<TsPower>) pageModel.getObject();
		 List<Integer> name = new ArrayList<Integer>();
		 for (Object obj : list) {
			 TsPower ts = (TsPower) obj;
			 	int str = ts.getPower();
				name.add(str);
			}
		 return name;
	}

}
