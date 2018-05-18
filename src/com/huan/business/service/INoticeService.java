package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsNotice;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface INoticeService {
	public PageModel getNotices(BigDecimal userManageId,PageBean page);
	public boolean  addNotices(TsNotice notice);
	public boolean  updateNotices(TsNotice notice);
	public boolean  delectNotices(TsNotice notice);
	public List<TsNotice> getNoticesByManageId(BigDecimal manageId);
	public List<TsNotice> getNoticesByUserId(BigDecimal userId);
}
