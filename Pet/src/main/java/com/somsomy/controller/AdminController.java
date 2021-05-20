package com.somsomy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somsomy.domain.NoticeBean;
import com.somsomy.domain.PageBean;
import com.somsomy.service.AdminService;

@Controller
public class AdminController {
	
	@Inject
	private AdminService adminService;

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(HttpServletRequest request, Model model) {
		
		PageBean pb = new PageBean();
		pb.setPageSize(5);
		
		if(request.getParameter("pageNum") == null) {
			pb.setPageNum("1");
		} else {
			pb.setPageNum(request.getParameter("pageNum"));
		}
		
		pb.setCount(adminService.getNoticeCount());
		
		List<NoticeBean> nbList = adminService.getNoticeList(pb);
		
		model.addAttribute("pb", pb);
		model.addAttribute("nbList", nbList);
		
		return "petcenter/notice";
	}
	
	@RequestMapping(value = "/notice/write", method = RequestMethod.GET)
	public String noticeWrite() {
		
		
		return "petcenter/noticeWrite";
	}
	
	@RequestMapping(value = "/notice/write", method = RequestMethod.POST)
	public String noticeWritePost(NoticeBean nb) {
		
		adminService.writeNotice(nb);
		
		return "redirect:/notice";
	}
	
	@RequestMapping(value = "/notice/content", method = RequestMethod.GET)
	public String noticeContent(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));

		adminService.updateReadcount(num);
		
		NoticeBean nb = adminService.getNotice(num);
		
		model.addAttribute("nb", nb);
		
		return "petcenter/noticeContent";
	}
	
	@RequestMapping(value = "/notice/delete", method = RequestMethod.GET)
	public String noticeDelete(HttpServletRequest request) {
		
		return "redirect:/notice";
	}
	
}
