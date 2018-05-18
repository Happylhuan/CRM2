package com.huan.business.service;

import java.util.List;

import com.huan.business.po.TsPower;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface  IPowerService {
	public PageModel getPowerList(TsPower power, final PageBean page);
	public  List<Integer> getPowerList();
}
