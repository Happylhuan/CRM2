package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.ILoginDao;
import com.huan.business.dao.INoticeDao;
import com.huan.business.po.TsManage;
import com.huan.business.po.TsNotice;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false) 
public class NoticeService implements INoticeService {
	private INoticeDao noticeDao;
	private ILoginDao loginDao;
	@Override
	public PageModel getNotices(BigDecimal userManageId, PageBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNotices(TsNotice notice) {
		// TODO Auto-generated method stub
		TsManage manage = loginDao.getManageById(notice.getManageId());
		notice.setManageName(manage.getManageName());
		return noticeDao.addNotice(notice);
	}

	@Override
	public boolean updateNotices(TsNotice notice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delectNotices(TsNotice notice) {
		// TODO Auto-generated method stub
		return noticeDao.delectNotice(notice);
	}

	@Override
	public List<TsNotice> getNoticesByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeByManageId(manageId);
	}
	@Override
	public List<TsNotice> getNoticesByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeByUserId(userId);
	}

	public INoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}


}
