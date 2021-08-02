package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String root = req.getContextPath();
//		
//		String act = req.getParameter("act");
//		if("list".equals(act)) {
//			showList(req,resp);
//		} else if("write".equals(act)) {
//			register(req, resp);
//		} else if("modify".equals(act)) {
//			modify(req, resp);
//		} else if("delete".equals(act)) {
//			delete(req, resp);
//		} else if("mvnoticewrite".equals(act)) {
//			resp.sendRedirect(root+"/view/noticeWrite.jsp");
//		} else if("mvnoticewatch".equals(act)) {
//			moveWatchNotice(req, resp);
//		} else if("mvnoticemodify".equals(act)) {
//			moveModifyNotice(req, resp);
//		} else if("mvnoticelist".equals(act)) {
//			showList(req, resp);
//		} 
//	}
	@GetMapping("/mvnoticewrite")
	public String moveWriteNotice() {
		return "noticeWrite";
	}
	
	@GetMapping("/mvnoticemodify")
	public String moveModifyNotice(@RequestParam String articleno, Model model) {
		String path = "index";
		try {
			NoticeDto noticeDto = noticeService.searchNotice(Integer.parseInt(articleno));
			model.addAttribute("notice", noticeDto);
			path = "noticeModify";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	@GetMapping("/mvnoticewatch")
	public String moveWatchNotice(@RequestParam String articleno, Model model) {
		String path = "index";
		try {
			NoticeDto noticeDto = noticeService.searchNotice(Integer.parseInt(articleno));
			model.addAttribute("notice", noticeDto);
			path = "noticeWatch";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String articleno, Model model){
		noticeService.deleteNotice(Integer.parseInt(articleno));
		
		 try {
				List<NoticeDto> list = noticeService.selectNotice();
				model.addAttribute("noticeList", list);
			} catch (SQLException e) {
				// 에러 페이지 연결
				e.printStackTrace();
			}
			return "noticeList";
	}
	
	@PostMapping("/modify")
	public String modify(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		NoticeDto noticeDto = new NoticeDto();
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
        noticeDto.setArticleno(Integer.parseInt(map.get("articleno")));
        noticeDto.setContent(map.get("content"));
        noticeDto.setSubject(map.get("subject"));
        noticeDto.setUserid(memberDto.getUserid());
        noticeDto.setViewcnt(Integer.parseInt(map.get("viewcnt")));
        noticeService.updateNotice(noticeDto);
        
        try {
			List<NoticeDto> list = noticeService.selectNotice();
			model.addAttribute("noticeList", list);
		} catch (SQLException e) {
			// 에러 페이지 연결
			e.printStackTrace();
		}
		return "noticeList";
//        resp.sendRedirect(req.getContextPath() + "/view/index.jsp");
	}
	
	@PostMapping("/regist")
	public String register(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		NoticeDto noticeDto = new NoticeDto();
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
        noticeDto.setContent(map.get("content"));
        noticeDto.setSubject(map.get("subject"));
        noticeDto.setUserid(memberDto.getUserid());
        noticeDto.setViewcnt(0);
        noticeService.insertNotice(noticeDto);
        
        try {
			List<NoticeDto> list = noticeService.selectNotice();
			model.addAttribute("noticeList", list);
		} catch (SQLException e) {
			// 에러 페이지 연결
			e.printStackTrace();
		}
		return "noticeList";
//        resp.sendRedirect(req.getContextPath() + "/notice?act=mvnoticelist");
	}
	
	@GetMapping("/list")
	public String showList(Model model) throws ServletException, IOException {
		try {
			List<NoticeDto> list = noticeService.selectNotice();
			model.addAttribute("noticeList", list);
		} catch (SQLException e) {
			// 에러 페이지 연결
			e.printStackTrace();
		}
		return "noticeList";
	}
	
}


