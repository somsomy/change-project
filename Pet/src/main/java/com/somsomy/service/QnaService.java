package com.somsomy.service;

import java.util.List;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.QnaBean;

public interface QnaService {
	Integer getQnaCount();
	List<QnaBean> getQnaList(PageBean pb);
	void qnaWrite(QnaBean qb);
	void updateReadcount(int parseInt);
	QnaBean getQna(int num);
	void updateQna(QnaBean qb);
}
