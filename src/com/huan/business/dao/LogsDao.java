package com.huan.business.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.LljLogs;
import com.huan.business.po.LljMent;

public class LogsDao extends HibernateDaoSupport implements ILogsDao {

	@Override
	public  List<LljLogs> getLogs(String sql,int pageNo,int numNo) {
		// TODO Auto-generated method stub
	
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		PreparedStatement stmt2 = null;
		ResultSet rset2 = null;
		try {
			List<LljLogs> list = new ArrayList<LljLogs>();
			LljLogs bean = null;
			stmt = conn.prepareStatement(BaseDao.SQL_PAGE_STAR+sql+BaseDao.SQL_PAGE_END);
			stmt.setInt(1,(pageNo+1)*numNo);
			stmt.setInt(2,pageNo*numNo);
			rset= stmt.executeQuery();
			while(rset.next()){
				bean = new LljLogs();
				bean.setLogId(new BigDecimal(rset.getInt("log_id")));
				bean.setLogInfo(rset.getString("log_info"));
				bean.setUserId(new BigDecimal(rset.getInt("user_id")));
				bean.setLogTitle(rset.getString("log_title"));
				bean.setUserName(rset.getString("user_name"));
				bean.setLogAddtime(rset.getTimestamp("log_addtime"));
				list.add(bean);
			}
			 if ((list != null) && (list.size() > 0)){
				 List<LljMent> ments;
				 for(int i=0;i<list.size();i++){
						 ments = new ArrayList<LljMent>();
						String sql2 = "select m.ment_id,m.ment_log,m.ment_time,m.log_id,m.user_id,u.user_name from llj_ment m,ts_user u where  m.user_id = u.user_id and log_id =? order by ment_time desc";
		               stmt2 = conn.prepareStatement(sql2);
		               stmt2.setInt(1,list.get(i).getLogId().intValue());
		               rset2= stmt2.executeQuery();
		               while(rset2.next()){
	            	   LljMent  mentBean = new LljMent();
	            	   mentBean.setMentId(new BigDecimal(rset2.getInt("ment_id")));
	            	   mentBean.setMentLog(rset2.getString("MENT_LOG"));
	            	   mentBean.setLogId(new BigDecimal(rset2.getInt("log_id")));
	            	   mentBean.setMentTime(rset2.getTimestamp("ment_time"));
	            	   mentBean.setUserId(new BigDecimal(rset2.getInt("user_id")));
	            	   mentBean.setUserName(rset2.getString("user_name"));
	            	   ments.add(mentBean);
	   				}
		               list.get(i).setMents(ments);
	                    rset2.close();
	                    stmt2.close();
	                    
	                 
				 }
				 
			 }  
			 rset.close();
			 stmt.close();
             conn.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public  boolean addLog(LljLogs log) {
		// TODO Auto-generated method stub
		
		try {
			this.getHibernateTemplate().save(log);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	@Override
	public boolean updateLog(LljLogs log) {
	Connection conn = BaseDao.getConnection();
	PreparedStatement stmt = null;
	ResultSet rset = null;
	try {
	stmt = conn.prepareStatement("update llj_logs set log_info = ?, log_title = ? where log_id =?");
		stmt.setString(1, log.getLogInfo());
		stmt.setString(2, log.getLogTitle());
		stmt.setInt(3, log.getLogId().intValue());
		
		rset= stmt.executeQuery();
		if(rset.next()){
			rset.close();
			stmt.close();
			BaseDao.conn.close();
			return true;
		}
			return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return false;
	}

	@Override
	public boolean delectLog(LljLogs log) {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
		stmt = conn.prepareStatement("delete llj_logs where log_id = ?");
			stmt.setInt(1, log.getLogId().intValue());
			
			rset= stmt.executeQuery();
			if(rset.next()){
				rset.close();
				stmt.close();
				BaseDao.conn.close();
				return true;
			}
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public LljLogs getLogById(int logId) {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		LljLogs bean = null;
		try {
		stmt = conn.prepareStatement("select * from llj_logs where log_id = ?");
			stmt.setInt(1, logId);
			
			rset= stmt.executeQuery();
			while(rset.next()){
				bean = new LljLogs();
				bean.setLogId(new BigDecimal(rset.getInt("log_id")));
				bean.setLogInfo(rset.getString("log_info"));
				bean.setUserId(new BigDecimal(rset.getInt("user_id")));
				bean.setLogTitle(rset.getString("log_title"));
			}
			rset.close();
			stmt.close();
			BaseDao.conn.close();
			return bean;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Integer getLogsNumByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		String hql = " from LljLogs log where userId="+userId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<LljLogs> list = (List<LljLogs>) Template.find(hql);
		
		return list.size();
	}

	@Override
	public Integer getLogsNumByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		String hql = " from LljLogs log where manageId="+manageId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<LljLogs> list = (List<LljLogs>) Template.find(hql);
		
		return list.size();
	}

	

}
