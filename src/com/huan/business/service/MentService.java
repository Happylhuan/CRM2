package com.huan.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.IMentDao;
import com.huan.business.dao.MentDao;
import com.huan.business.po.LljMent;
import com.huan.business.po.TsUser;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class MentService implements IMentService {

	
	private IMentDao mentDao;
	
	

	public IMentDao getMentDao() {
		return mentDao;
	}

	public void setMentDao(IMentDao mentDao) {
		this.mentDao = mentDao;
	}


	@Override
	public List<LljMent> getMents() {
		// TODO Auto-generated method stub
		return new MentDao().getMents();
	}

	@Override
	public boolean addMent(LljMent ment) {
		// TODO Auto-generated method stub
		ment.setMentTime(new Date());
		return mentDao.addMent(ment);
	}

	@Override
	public boolean updateMent(LljMent ment) {
		// TODO Auto-generated method stub
		return mentDao.updateMent(ment);
	}

	@Override
	public boolean delectMent(LljMent ment) {
		// TODO Auto-generated method stub
		return mentDao.delectMent(ment);
	}

	@Override
	public boolean getMentById(int mentId) {
		// TODO Auto-generated method stub
		return mentDao.getMentById(mentId);
	}

}
