package com.huan.business.service;

import java.util.List;

import com.huan.business.dao.IPowerDao;
import com.huan.business.po.TsPower;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class PowerService implements IPowerService {
	private IPowerDao powerDao;
	
	public IPowerDao getPowerDao() {
		return powerDao;
	}

	public void setPowerDao(IPowerDao powerDao) {
		this.powerDao = powerDao;
	}

	@Override
	public PageModel getPowerList(TsPower power, PageBean page) {
		// TODO Auto-generated method stub
		return this.powerDao.getPowerList(power, page);
	}

	@Override
	public List<Integer> getPowerList() {
		// TODO Auto-generated method stub
		return this.powerDao.getPowerList();
	}

}
