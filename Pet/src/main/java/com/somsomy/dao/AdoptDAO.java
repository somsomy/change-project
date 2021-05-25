package com.somsomy.dao;

import java.util.List;

import com.somsomy.domain.AdoptBean;
import com.somsomy.domain.PageBean;

public interface AdoptDAO {

	Integer getMaxNum();

	List<AdoptBean> getBoardList(PageBean pb);

}
