package com.somsomy.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.somsomy.service.MemberService;
import com.somsomy.domain.MemberBean;


@RestController
public class AjaxController {
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheck(HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		String result = "";
		String id = request.getParameter("id");
		int check = memberService.idCheck(id);
		MemberBean mb = memberService.getMember(id);
		
		try {
			if(mb != null) {
				result = "iddup";
			}else {
				result = check >= 2? "idok" : "wrong";
			}
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/member/nickcheck", method = RequestMethod.GET)
	public ResponseEntity<String> nickcheck(HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		String result = "";
		String nick = request.getParameter("nick");
		int check = memberService.nickCheck(nick);
		MemberBean mb = memberService.findByNick(nick);
		
		try {
			if(mb != null) {
				result = "nickdup";
			}else {
				result = check >= 1? "nickok" : "wrong";
			}
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
