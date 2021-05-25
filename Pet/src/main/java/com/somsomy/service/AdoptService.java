package com.somsomy.service;

import java.util.List;

import com.somsomy.domain.AdoptBean;
import com.somsomy.domain.PageBean;

public interface AdoptService {
	
	Integer getMaxNum();

	List<AdoptBean> getBoardList(PageBean pb);

}
