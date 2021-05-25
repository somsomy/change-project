package com.somsomy.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.somsomy.dao.SupportDAO;
import com.somsomy.domain.SupporterBean;

@Service
public class SupportServiceImpl implements SupportService {
	
	@Inject
	private SupportDAO supportDAO;

	@Override
	public void insertSupporter(SupporterBean sb) {
		Integer num = supportDAO.getMaxNum();
		
		if(num == null) {
			sb.setNum(1);
		} else {
			sb.setNum(num + 1);
		}
		
		sb.setSupportStart(sb.getYear()+"-"+sb.getMonth()+"-"+sb.getDay());
		sb.setDate(new Timestamp(System.currentTimeMillis()));
		supportDAO.insertSupporter(sb);
	}

}
