package com.somsomy.service;

import com.somsomy.domain.MemberBean;

public interface MemberService {

	MemberBean userCheck(MemberBean mb);
	MemberBean getMember(String id);
	int idCheck(String id);
	MemberBean findByNick(String nick);
	int nickCheck(String nick);

}
