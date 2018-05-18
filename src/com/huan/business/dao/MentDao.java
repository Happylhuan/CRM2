package com.huan.business.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		BaseDao.conn = BaseDao.getConnection();
		try {
		PreparedStatement stmt=BaseDao.conn.prepareStatement("insert into llj_ment(ment_id, ment_log, ment_time, user_id, log_id)values(LLJ_MENT_ID.nextval, ?, to_date('19950912','yyyy-mm-dd'),?, ?)");
		stmt.setString(1, ment.getMentLog());
		stmt.setInt(2, ment.getUserId().intValue());
		stmt.setInt(3, ment.getLogId().intValue());
		
		if(stmt.executeQuery()!=null){
			return true;
		}
		
		stmt.close();
		BaseDao.conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
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
