package com.somsomy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somsomy.domain.AdoptBean;
import com.somsomy.domain.CatsBean;
import com.somsomy.domain.PageBean;
import com.somsomy.service.AdoptService;

@Controller
public class BoardController {
	
	@Inject
	private AdoptService adoptService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		
		return "petcenter/welcome";
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map() {
		
		return "petcenter/map";
	}
	
	@RequestMapping(value = "/adopt/info", method = RequestMethod.GET)
	public String adoptInfo() {
		
		return "adopt/adoptInfo";
	}
	
	@RequestMapping(value = "/adopt", method = RequestMethod.GET)
	public String adopt(HttpServletRequest request, Model model) {
		
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		
		if(request.getParameter("pageNum") == null) {
			pb.setPageNum("1");
		}else {
			pb.setPageNum(request.getParameter("pageNum"));
		}
		
		pb.setCount(adoptService.getMaxNum());
		
		List<AdoptBean> abList = adoptService.getBoardList(pb);
		
		model.addAttribute("pb", pb);
		model.addAttribute("abList", abList);

		return "adopt/adopt";
	}
}
