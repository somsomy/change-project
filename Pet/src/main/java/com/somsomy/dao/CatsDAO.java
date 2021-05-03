package com.somsomy.dao;

import java.util.List;

import com.somsomy.domain.CatsBean;
import com.somsomy.domain.PageBean;

public interface CatsDAO {
	public List<CatsBean> getCatList(PageBean pb);
	public Integer getCatCount();
}
