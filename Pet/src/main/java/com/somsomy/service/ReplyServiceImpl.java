package com.somsomy.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.somsomy.dao.ReplyDAO;
import com.somsomy.domain.FindPageBean;
import com.somsomy.domain.PageBean;
import com.somsomy.domain.ReplyBean;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO replyDAO;

	@Override
	public void updateReply(ReplyBean rb) {
		replyDAO.updateReply(rb);
	}

	@Override
	public List<ReplyBean> getReplyList(FindPageBean pb) {
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
		
		return replyDAO.getReplyList(pb);
	}

	@Override
	public void writeReply(ReplyBean rb) {
		rb.setDate(new Timestamp(System.currentTimeMillis()));
		rb.setRe_lev(0);
		rb.setRe_seq(0);
				
		if(replyDAO.getReplyMaxNum() == null) {
			rb.setNum(1);
		}else {
			rb.setNum(replyDAO.getReplyMaxNum() + 1);
		}
		
		if(replyDAO.getRerefMaxNum(rb.getBoardNum()) == null) {
			rb.setRe_ref(1);
		} else {
			rb.setRe_ref(replyDAO.getRerefMaxNum(rb.getBoardNum()) + 1);			
		}
		
		replyDAO.writeReply(rb);
	}

	@Override
	public void deleteReply(ReplyBean rb) {
		
		replyDAO.deleteReply(rb.getNum());
		
	}

	@Override
	public void rewriteReply(ReplyBean rb) {
		replyDAO.updateReseq(rb);
		
		rb.setDate(new Timestamp(System.currentTimeMillis()));
		rb.setRe_lev(rb.getRe_lev() + 1);
		rb.setRe_seq(rb.getRe_seq() + 1);
		rb.setNum(replyDAO.getReplyMaxNum() + 1);
		
		replyDAO.writeReply(rb);
	}

}
