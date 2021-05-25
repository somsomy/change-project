package com.somsomy.service;

import java.util.List;

import com.somsomy.domain.CatsBean;
import com.somsomy.domain.PageBean;

public interface CatsService {
	public List<CatsBean> getCatList(PageBean pb);
	public Integer getCatCount();
	public CatsBean findByCatId(int catId);
}
