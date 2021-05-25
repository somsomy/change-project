package com.somsomy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somsomy.domain.CatsBean;
import com.somsomy.domain.MemberBean;
import com.somsomy.domain.PageBean;
import com.somsomy.domain.SupporterBean;
import com.somsomy.service.CatsService;
import com.somsomy.service.MemberService;
import com.somsomy.service.SupportService;

@Controller
public class SupportController {
	
	@Inject
	private SupportService supportService;
	@Inject
	private CatsService catsService;
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "/support", method = RequestMethod.GET)
	public String support(HttpServletRequest request, Model model) {
		
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		
		if(request.getParameter("pageNum") == null) {
			pb.setPageNum("1");
		}else {
			pb.setPageNum(request.getParameter("pageNum"));
		}
		
		pb.setCount(catsService.getCatCount());
		
		List<CatsBean> cbList = catsService.getCatList(pb);
		
		model.addAttribute("pb", pb);
		model.addAttribute("cbList", cbList);
		
		return "support/supportList";
	}
	
	@RequestMapping(value = "/support/content", method = RequestMethod.GET)
	public String supportContent(HttpServletRequest request, HttpSession session, Model model) {
		
		int catId = Integer.parseInt(request.getParameter("catId"));
		
		CatsBean cb = catsService.findByCatId(catId);
		
		MemberBean mb = memberService.getMember((String) session.getAttribute("id"));
		
		model.addAttribute("cb", cb);
		model.addAttribute("mb", mb);
		
		return "support/support";
	}
	
	@RequestMapping(value = "/support/content", method = RequestMethod.POST)
	public String supportContent2(HttpServletRequest request, HttpSession session, SupporterBean sb, Model model) {
		
		int catId = Integer.parseInt(request.getParameter("catId"));
		
		CatsBean cb = catsService.findByCatId(catId);
		
		MemberBean mb = memberService.getMember((String) session.getAttribute("id"));
		
		model.addAttribute("cb", cb);
		model.addAttribute("mb", mb);
		model.addAttribute("sb", sb);
		
		return "support/support2";
	}
	
	@RequestMapping(value = "/support/complete", method = RequestMethod.POST)
	public String supportComplete(HttpSession session, SupporterBean sb) {
		sb.setUserid((String) session.getAttribute("id"));

		supportService.insertSupporter(sb);
		
		return "redirect:/support";
	}
	
}
