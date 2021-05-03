package com.somsomy.pet;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somsomy.domain.CatsBean;
import com.somsomy.domain.PageBean;
import com.somsomy.service.CatsService;

@Controller
public class MainController {
	
	@Inject
	private CatsService catsService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, Model model) {
		
		PageBean pb = new PageBean();
		pb.setPageSize(5);
		
		if(request.getParameter("pageNum") == null) {
			pb.setPageNum("1");
		}else {
			pb.setPageNum(request.getParameter("pageNum"));
		}
		
		pb.setCount(catsService.getCatCount());
		
		List<CatsBean> cbList = catsService.getCatList(pb);
		
		model.addAttribute("pb", pb);
		model.addAttribute("cbList", cbList);

		return "main/main";
	}


}
