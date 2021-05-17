package com.somsomy.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somsomy.domain.MemberBean;
import com.somsomy.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPost(MemberBean mb, HttpSession session, Model model) {
		
		MemberBean loginMb = memberService.userCheck(mb);
		
		if(loginMb != null) {
			session.setAttribute("id", mb.getId());
			return "redirect: /main";
		}else {
			model.addAttribute("msg", "가입되지 않은 아이디거나 잘못된 비밀번호입니다.");
			return "member/msg";
		}
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect: /pet/main";
	}

	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join() {
		
		return "member/join";
	}
	
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String joinPost(MemberBean mb) {
		memberService.join(mb);
		return "redirect: /pet/member/login";
	}
}
