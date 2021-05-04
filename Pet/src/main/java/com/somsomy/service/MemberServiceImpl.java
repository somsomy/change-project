package com.somsomy.service;

import java.util.regex.Pattern;

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

	@Override
	public MemberBean getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public int idCheck(String id) {
		
		String lengthRegex="[a-z0-9_]{5,20}";
		String engLowerRegex="[a-z]";
		String numRegex="[0-9]";
		String specRegex="[_]";
		
		int check = 0;
		
		if(Pattern.matches(lengthRegex, id)) {
			check += Pattern.compile(engLowerRegex).matcher(id).find() ? 1 : 0;
			check += Pattern.compile(numRegex).matcher(id).find() ? 1 : 0;
			check += Pattern.compile(specRegex).matcher(id).find() ? 1 : 0;
			
		} else {
			check = 0;
		}
			
		return check;
	}

	@Override
	public MemberBean findByNick(String nick) {
		return memberDAO.findByNick(nick);
	}

	@Override
	public int nickCheck(String nick) {
		String lengthRegex="[A-za-z0-9가-힣]{1,10}";
		String engUpperRegex="[A-Z]";
		String engLowerRegex="[a-z]";
		String numRegex="[0-9]";
		String korean="[가-힣]";
		
		int check = 0;
		
		if(Pattern.matches(lengthRegex, nick)) {
			check += Pattern.compile(engUpperRegex).matcher(nick).find() ? 1 : 0;
			check += Pattern.compile(engLowerRegex).matcher(nick).find() ? 1 : 0;
			check += Pattern.compile(numRegex).matcher(nick).find() ? 1 : 0;
			check += Pattern.compile(korean).matcher(nick).find() ? 1 : 0;

		} else {
			check = 0;
		}
			
		return check;
	}

}
