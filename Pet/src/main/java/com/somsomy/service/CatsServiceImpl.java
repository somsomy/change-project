package com.somsomy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.somsomy.dao.CatsDAO;
import com.somsomy.domain.CatsBean;
import com.somsomy.domain.PageBean;

@Service
public class CatsServiceImpl implements CatsService{
	
	@Inject
	private CatsDAO catsDAO;

	@Override
	public List<CatsBean> getCatList(PageBean pb) {
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow((pb.getCurrentPage() - 1) * pb.getPageSize());		
		
		return catsDAO.getCatList(pb);
	}

	@Override
	public Integer getCatCount() {
		return catsDAO.getCatCount();
	}

}
