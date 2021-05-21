package com.somsomy.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.somsomy.dao.VolunteerDAO;
import com.somsomy.domain.PageBean;
import com.somsomy.domain.VolunteerBean;
import com.somsomy.domain.VolunteerReplyBean;

@Service
public class VolunteerServiceImpl implements VolunteerService {
	
	@Inject
	private VolunteerDAO volunteerDAO;

	@Override
	public Integer getVolunteerCount() {
		return volunteerDAO.getVolunteerCount();
	}

	@Override
	public List<VolunteerBean> getVolunteerList(PageBean pb) {
		return volunteerDAO.getVolunteerList(pb);
	}

	@Override
	public void writeVolunteer(VolunteerBean vb) {
		vb.setDate(new Timestamp(System.currentTimeMillis()));
		vb.setReadcount(0);
		
		if(volunteerDAO.getMaxNum()==null) {
			vb.setNum(1);
		}else {
			vb.setNum(volunteerDAO.getMaxNum()+1);
		}
		
		volunteerDAO.writeVolunteer(vb);
	}

	@Override
	public void updateReadcount(int num) {
		volunteerDAO.updateReadcount(num);
	}

	@Override
	public List<VolunteerReplyBean> getVolunteerReplyList(PageBean pb) {
		return volunteerDAO.getVolunteerReplyList(pb);
	}

	@Override
	public int getVolunteerReplyCount(int num) {
		return volunteerDAO.getVolunteerReplyCount(num);
	}

	@Override
	public VolunteerBean getVolunteer(int num) {
		return volunteerDAO.getVolunteer(num);
	}

	@Override
	public void updateVolunteer(VolunteerBean vb) {
		volunteerDAO.updateVolunteer(vb);
	}

	@Override
	public void deleteVolunteer(int num) {
		volunteerDAO.deleteVolunteer(num);
		volunteerDAO.deleteReply(num);
	}

}
