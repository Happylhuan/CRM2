package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsNotice;

public interface INoticeDao {
	public List<TsNotice> getNotices(String sql,int pageNo,int numNo);
	public boolean  addNotice(TsNotice notice);
	public boolean  updateNotice(TsNotice notice);
	public boolean  delectNotice(TsNotice notice);
	public List<TsNotice>  getNoticeByManageId(BigDecimal manageId);
	public List<TsNotice>  getNoticeByUserId(BigDecimal userId);
}
