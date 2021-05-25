package com.somsomy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.somsomy.dao.AdoptDAO;
import com.somsomy.domain.AdoptBean;
import com.somsomy.domain.PageBean;

@Service
public class AdoptServiceimpl implements AdoptService {
	@Inject
	private AdoptDAO adoptDAO;

	@Override
	public Integer getMaxNum() {
		return adoptDAO.getMaxNum();
	}

	@Override
	public List<AdoptBean> getBoardList(PageBean pb) {
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow((pb.getCurrentPage() - 1) * pb.getPageSize());		
		
		return adoptDAO.getBoardList(pb);
	}

}
