package com.somsomy.service;

import java.util.List;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.ReplyBean;

public interface ReplyService {

	void updateReply(ReplyBean rb);

	List<ReplyBean> getReplyList(PageBean pb);

	void writeReply(ReplyBean rb);

	void deleteReply(ReplyBean rb);

	void rewriteReply(ReplyBean rb);

}
