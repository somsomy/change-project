package com.somsomy.dao;

import java.util.List;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.ReplyBean;
import com.somsomy.domain.VolunteerBean;
import com.somsomy.domain.VolunteerReplyBean;

public interface VolunteerDAO {

	Integer getVolunteerCount();

	List<VolunteerBean> getVolunteerList(PageBean pb);

	void writeVolunteer(VolunteerBean vb);

	Integer getMaxNum();

	void updateReadcount(int num);

	List<VolunteerReplyBean> getVolunteerReplyList(PageBean pb);

	int getVolunteerReplyCount(int num);

	VolunteerBean getVolunteer(int num);

	void updateVolunteer(VolunteerBean vb);
	
	void deleteVolunteer(int num);

	void deleteReply(int num);

}
