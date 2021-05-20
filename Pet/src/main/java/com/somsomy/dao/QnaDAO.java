package com.somsomy.dao;

import java.util.List;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.QnaBean;

public interface QnaDAO {
	
	Integer getQnaCount();
	List<QnaBean> getQnaList(PageBean pb);
	Integer getMaxNum();
	void qnaWrtie(QnaBean qb);
	void updateReadcount(int num);
	QnaBean getQna(int num);
	void updateQna(QnaBean qb);

}
