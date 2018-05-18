package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsMainview;
import com.huan.business.po.TsOrder;
import com.huan.tool.TotalNum;

public class MainDao extends HibernateDaoSupport implements IMainDao{


	@SuppressWarnings("unchecked")
	@Override
	public List<TsMainview> getTopUserByOrderNum(BigDecimal manageId) {
		
		SQLQuery query =  this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(" "
		 		+ "select a.order_num orderNum,b.client_num clientNum,(select u.user_name from ts_user u where u.user_id = b.user_id) userName ,(select u.role from ts_user u where u.user_id = b.user_id)  userRole ,b.user_id userId ,a.total_price totalPrice "
		 		+ "from (select count(*) order_num,sum(total_price) total_price, user_id from ts_order group by user_id ) A "
		 		+ "left JOIN (select count(*) client_num, user_id from ts_client group by user_id ) b"
		 		+ " on a.user_id=b.user_id where b.user_id in (select user_id from ts_user where manage_id = "+manageId+") order by total_price desc ");//语句按降序排列
	        query.setFirstResult(0);//开始从第几条开始取数据
	        query.setMaxResults(5);//取多少条数据
	        List<Object[]> list =  query.list();//转换成表的集合。。。
	        List<TsMainview> reList = new ArrayList<TsMainview>();
			 for (Object[] objects : list) {
				  TsMainview event = new TsMainview(); 
				  event.setOrderNum(((BigDecimal)objects[0]).intValue());
				  event.setClientNum(((BigDecimal)objects[1]).intValue());
				  event.setUserName((String)objects[2]);
				  event.setUserRole((String)objects[3]);
				  event.setUserId((BigDecimal)objects[4]);
				  event.setTotalPrice(((BigDecimal)objects[5]).doubleValue());
				  reList.add(event);
			 }
			
			return reList;
		
			}
		
			@SuppressWarnings({ "unchecked" })
			@Override
			public Integer getTotalOrderNum(BigDecimal manageId) {
				// TODO Auto-generated method stub
				String hql = "from TsOrder where userId in (select u.userId from TsUser u where u.manageId = "+manageId+") ";
				List<TsOrder> orders = (List<TsOrder>) this.getHibernateTemplate().find(hql);
				return orders.size();
			}

			@SuppressWarnings("unchecked")
			@Override
			public Integer getTotalClientNum(BigDecimal manageId) {
				// TODO Auto-generated method stub
				String hql = "from TsClient where userId in (select u.userId from TsUser u where u.manageId = "+manageId+") ";
				List<TsClient> clients = (List<TsClient>) this.getHibernateTemplate().find(hql);
				this.getHibernateTemplate().clear();
				return clients.size();
			}
			@SuppressWarnings("unchecked")
			@Override
			public Double getTotalPriceNum(BigDecimal manageId) {
				// TODO Auto-generated method stub
				Double totalPrice = 0.00;
				String sql = "select sum(t.total_price) from ts_order t where user_id in (select u.user_id from ts_user u where u.manage_id = "+manageId+") ";
				SQLQuery query =  this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);
				List<Object> list =  query.list();
				if(0 != list.size()){
					for (Object object : list) {
						if(null != object){
							totalPrice = Double.valueOf(object.toString());
							return totalPrice;
						}
						
					}
				}
				this.getHibernateTemplate().clear();
				return totalPrice;
			}

}
