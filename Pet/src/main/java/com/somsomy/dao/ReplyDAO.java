package com.somsomy.dao;

import java.util.List;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.ReplyBean;

public interface ReplyDAO {
	Integer getReplyMaxNum();

	void writeReply(ReplyBean rb);

	void updateReply(ReplyBean rb);

	List<ReplyBean> getReplyList(PageBean pb);

	void deleteReply(int num);

	Integer getRerefMaxNum(int boardNum);

	void updateReseq(ReplyBean rb);

	List<ReplyBean> getReplyChildList(ReplyBean rb);
	
	void deleteDate(ReplyBean rb);
}
