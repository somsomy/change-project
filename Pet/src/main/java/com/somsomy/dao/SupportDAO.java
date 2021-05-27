package com.somsomy.dao;

import java.util.List;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.SupporterBean;
import com.somsomy.domain.SupporterCatsBean;

public interface SupportDAO {

	Integer getMaxNum();

	void insertSupporter(SupporterBean sb);

	Integer getMyCatsCount(String id);

	List<SupporterCatsBean> getMyCatsList(PageBean pb);

	SupporterCatsBean getSupporter(int num);

	void updateSupporter(SupporterBean sb);

	void deleteSupporter(int num);

}
