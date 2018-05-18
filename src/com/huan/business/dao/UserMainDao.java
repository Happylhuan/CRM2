package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsOrder;
import com.huan.business.po.TsUser;
import com.huan.business.po.TsUsermain;

public class UserMainDao extends HibernateDaoSupport implements IUserMainDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TsUsermain> getTopClients(Integer userid) {

		
		SQLQuery query =  this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(" "
				+ "select  o.clien_name, (select client_phone from ts_client where client_name = o.clien_name and user_id = "+userid+") client_phone , count(*) order_Num,(select t.client_id from ts_client t where t.client_name = o.clien_name and user_id = "+userid+") client_id ,sum(o.total_price) total_price "
				+ "from ts_order o  where o.user_id="+userid+" group by o.clien_name order by total_price desc");//语句按降序排列
	        query.setFirstResult(0);//开始从第几条开始取数据
	        query.setMaxResults(5);//取多少条数据
	
	        List<Object[]> list =  query.list();//转换成表的集合。。。
	        List<TsUsermain> reList = new ArrayList<TsUsermain>();
			 for (Object[] objects : list) {
				  
				 TsUsermain event = new TsUsermain(); 
				  event.setClientName((String)objects[0]);
				  event.setClientPhone((String)objects[1]);
				  event.setClientOrdernum(((BigDecimal)objects[2]).intValue());
				  event.setClientId(((BigDecimal)objects[3]));
				  event.setClientTotalPriceNum(((BigDecimal)objects[4]).doubleValue());
				  reList.add(event);
			 }
			
			return reList;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getUserIdByName(String userName) {
		String Name = userName.trim();
		String hql="from TsUser user where user.loginName='"+Name+"'";
		List<TsUser> list = (List<TsUser>) this.getHibernateTemplate().find(hql);
		if(list.size()!=0){
			return list.get(0).getUserId().intValue();
		}
		return 0;
	}

	@Override
	public TsClient getClientById(Integer clientid) {
		// TODO Auto-generated method stub
		String hql="from TsClient client where client.clientId='"+clientid+"'";
		@SuppressWarnings("unchecked")
		List<TsClient> list = (List<TsClient>) this.getHibernateTemplate().find(hql);
		
		
		 return list.get(0);
		}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getTotalOrderNum(Integer userId) {
		// TODO Auto-generated method stub
		String hql="from TsOrder order where order.userId = "+userId+"";
		List<TsOrder> list = (List<TsOrder>) this.getHibernateTemplate().find(hql);
		
		 return list.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getTotalClientNum(Integer userId) {
		// TODO Auto-generated method stub
		String hql="from TsClient client where client.userId = "+userId+"";
		List<TsClient> list = (List<TsClient>) this.getHibernateTemplate().find(hql);
		
		 return list.size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Double getTotalPriceNum(Integer userId) {
		// TODO Auto-generated method stub
		Double totalPrice = 0.00;
		String sql = "select sum(t.total_price) from ts_order t where user_id = "+userId+"";
		SQLQuery query =  this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);
		List<Object[]> list =  query.list();
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
