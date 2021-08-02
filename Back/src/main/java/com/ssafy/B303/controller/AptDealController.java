package com.ssafy.B303.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.B303.model.dto.AptDealDto;
import com.ssafy.B303.model.dto.SearchDto;
import com.ssafy.B303.model.service.AptDealService;

@Controller
@RequestMapping("/aptDeal")
public class AptDealController {
	
	private static final Logger logger = LoggerFactory.getLogger(AptDealController.class);
	
	@Autowired
	private AptDealService aptDealService;
	
	@GetMapping(value = "/list")		//실거래 검색 보기로 들어온경우
	public String searchedList(Model model) {
		String dongcode = "1168010700";
		SearchDto searchDto = new SearchDto();
		searchDto.setDongcode(dongcode);
		String pageNo = "1";
		searchDto.setPageNo(Integer.parseInt(pageNo));
		try {
			List<AptDealDto> list =  aptDealService.searchAptDeal(searchDto);
			model.addAttribute("aptDealList", list);
			model.addAttribute("beginPage", 1);
			model.addAttribute("endPage", 10);
			model.addAttribute("dongcode", dongcode);
			model.addAttribute("pageNo", pageNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "boardResult";
	}
	
	@GetMapping(value = "searchbylist")
	private String searchedList(
			@RequestParam(value="dongcode", defaultValue = "1168010700") String dongcode,
			@RequestParam(value="pageNo", defaultValue = "1") String pageno,
			Model model
			) {
		
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageno);
		}catch (Exception e) {} 
		SearchDto searchDto = new SearchDto();
		searchDto.setDongcode(dongcode);
		searchDto.setPageNo(pageNo);
		
		try {
			List<AptDealDto> list = aptDealService.searchAptDeal(searchDto);
			model.addAttribute("aptDealList", list);
			model.addAttribute("beginPage", 1);
			model.addAttribute("endPage", 10);
			model.addAttribute("dongcode", dongcode);
			model.addAttribute("pageNo", pageNo);

//			req.getRequestDispatcher("/view/boardResult.jsp").forward(req, resp);;
		} catch (SQLException e) {
			// 에러 페이지 연결
			e.printStackTrace();
		}
		return "boardResult";
	}
	
	
	
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String act = req.getParameter("act");
//		if("list".equals(act) || "searchbylist".equals(act)) {
////			showList(req, resp);
//			searchedList(req,resp);
//		} 
//	}
//
//	private void searchedList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String dongcode = req.getParameter("dongcode");
//		int pageNo = 1;
//		try {
//			pageNo = Integer.parseInt(req.getParameter("pageNo"));
//		}catch (Exception e) {} 
//		SearchDto searchDto = new SearchDto();
//		searchDto.setDongcode(dongcode);
//		searchDto.setPageNo(pageNo);
//		
//		try {
//			List<AptDealDto> list = aptDealService.selectAptDeal(searchDto);
//			req.setAttribute("aptDealList", list);
//			req.setAttribute("beginPage", 1);
//			req.setAttribute("endPage", 10);
//			req.setAttribute("dongcode", dongcode);
//			req.setAttribute("pageNo", pageNo);
//
//			req.getRequestDispatcher("/view/boardResult.jsp").forward(req, resp);;
//		} catch (SQLException e) {
//			// 에러 페이지 연결
//			e.printStackTrace();
//		}
//	}
//	private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int pageNo = 1;
//		try {
//			pageNo = Integer.parseInt(req.getParameter("pageNo"));
//		}catch (Exception e) {} 
//		try {
//			List<AptDealDto> list = aptDealService.selectAptDeal();
//			String dongcode = req.getParameter("dongcode");
//			req.setAttribute("aptDealList", list);
//			req.setAttribute("beginPage", 1);
//			req.setAttribute("endPage", 10);
//			req.setAttribute("dongcode", dongcode);
//			req.setAttribute("pageNo", pageNo);
//			req.getRequestDispatcher("/view/boardResult.jsp").forward(req, resp);;
//		} catch (SQLException e) {
//			// 에러 페이지 연결
//			e.printStackTrace();
//		}
//		
//	}

	
}
