package com.somsomy.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.somsomy.dao.MemberDAO;
import com.somsomy.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO memberDAO;

	@Override
	public MemberBean userCheck(MemberBean mb) {
		
		return memberDAO.userCheck(mb);
	}

}
