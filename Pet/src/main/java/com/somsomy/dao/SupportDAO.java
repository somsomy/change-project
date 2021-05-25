package com.somsomy.dao;

import com.somsomy.domain.SupporterBean;

public interface SupportDAO {

	Integer getMaxNum();

	void insertSupporter(SupporterBean sb);

}
