package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import com.google.gson.Gson;
import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value = "/regist")
	public String regist(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		MemberDto memberDto = new MemberDto(
				map.get("userid"), 
				map.get("passwd"), 
				map.get("username"), 
				map.get("nickname"), 
				map.get("address"), 
				map.get("addressdetail"), 
				map.get("interdongcode"), 
				map.get("email"), 
				map.get("phone"));
		
		try {
			memberService.insertMember(memberDto);
			session.setAttribute("userinfo", memberDto);
		} catch (Exception e1) {
			e1.printStackTrace();
			model.addAttribute("msg", "회원 가입 중 문제가 발생했습니다.");
		}
		return "index";
	}
	
	@GetMapping(value = "/select")
	public void select(Model model, HttpSession session, HttpServletResponse resp) throws IOException{
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		try {
			memberDto = memberService.selectMember(memberDto.getUserid());
			System.out.println(memberDto.getUserid());
		} catch (Exception e1) {
			e1.printStackTrace();
			model.addAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
		}
//		return "index";
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(new Gson().toJson(memberDto));
		out.close();
		
//		String path = "/view/index.jsp";
//		RequestDispatcher disp = req.getRequestDispatcher(path);
//		disp.forward(req, resp);
	}
	
	@PostMapping(value = "/update")
	public String update(@RequestParam Map<String, String> map, Model model){
		MemberDto memberDto = new MemberDto(
				map.get("updateUserId"), 
				map.get("updatePwd"), 
				map.get("updateUsername"), 
				map.get("updateNickname"), 
				map.get("updateAddr"), 
				map.get("updateAddrDetail"), 
				map.get("updateInterArea"), 
				map.get("updateEmail"), 
				map.get("updatePhone"));
		try {
			memberService.updateMember(memberDto);
		} catch (Exception e1) {
			e1.printStackTrace();
			model.addAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
		}
		return "index";
	}
	
	@GetMapping(value = "/delete")
	public String delete(Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		try {
			memberService.deleteMember(memberDto);
			session.invalidate();
		} catch (Exception e1) {
			e1.printStackTrace();
			model.addAttribute("msg", "회원 정보 삭제 중 문제가 발생했습니다.");
		}
		return "index";
	}

	@PostMapping(value = "/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		try {
			MemberDto memberDto = memberService.login(map);
			if(memberDto != null) { // 성공
				session.setAttribute("userinfo", memberDto);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
		}
		return "index";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 다 지움
		return "index";
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String root = req.getContextPath();
//		String act = req.getParameter("act");
//		
//		if (act == null) {
//			//resp.sendRedirect(root + "/index.jsp");
//		} else if("registMember".equals(act)) { // 회원 가입
//			regist(req, resp);
//		} else if("selectMember".equals(act)) { // 회원 조회
//			select(req, resp);
//		} else if("updateMember".equals(act)) { // 회원 수정
//			update(req, resp);
//		} else if("deleteMember".equals(act)) { // 회원 탈퇴
//			delete(req, resp);
//		} else if("login".equals(act)) { // 로그인 
//			login(req, resp);
//		} else if ("logout".equals(act)) {
//			logout(req,resp);
//		}
//		
//	}
//	private void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		
//		try {
//			memberDto = memberService.selectMember(memberDto.getUserid());
//		} catch (Exception e1) {
//			req.setAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
//			e1.printStackTrace();
//		}
//		resp.setContentType("application/json; charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.println(new Gson().toJson(memberDto));
//		out.close();
//		
////		String path = "/view/index.jsp";
////		RequestDispatcher disp = req.getRequestDispatcher(path);
////		disp.forward(req, resp);
//	}
//	private void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		MemberDto memberDto = new MemberDto(
//				req.getParameter("userid"), 
//				req.getParameter("passwd"), 
//				req.getParameter("username"), 
//				req.getParameter("nickname"), 
//				req.getParameter("address"), 
//				req.getParameter("addressdetail"), 
//				req.getParameter("interarea"), 
//				req.getParameter("email"), 
//				req.getParameter("phone"));
//		
//		try {
//			memberService.insertMember(memberDto);
//			HttpSession session = req.getSession();
//			session.setAttribute("userinfo", memberDto);
//			
////			if(resultMemberDto != null) { // 성공
//////				session 설정
////			} else { // 실패
////				req.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
////			}
//		} catch (Exception e1) {
//			req.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
//			e1.printStackTrace();
//		}
//		
//		String path = "/view/index.jsp";
//		RequestDispatcher disp = req.getRequestDispatcher(path);
//		disp.forward(req, resp);
//	}
//	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		MemberDto memberDto = new MemberDto(
//				req.getParameter("updateUserId"), 
//				req.getParameter("updatePwd"), 
//				req.getParameter("updateUsername"), 
//				req.getParameter("updateNickname"), 
//				req.getParameter("updateAddr"), 
//				req.getParameter("updateAddrDetail"), 
//				req.getParameter("updateInterArea"), 
//				req.getParameter("updateEmail"), 
//				req.getParameter("updatePhone"));
//		try {
//			memberService.updateMember(memberDto);
//		} catch (Exception e1) {
//			req.setAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
//			e1.printStackTrace();
//		}
//		String path = "/view/index.jsp";
//		RequestDispatcher disp = req.getRequestDispatcher(path);
//		disp.forward(req, resp);
//		
//	}
//
//	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		try {
//			memberService.deleteMember(memberDto);
//			session.invalidate();
//		} catch (Exception e1) {
//			req.setAttribute("msg", "회원 정보 삭제 중 문제가 발생했습니다.");
//			e1.printStackTrace();
//		}
//		String path = "/view/index.jsp";
//		RequestDispatcher disp = req.getRequestDispatcher(path);
//		disp.forward(req, resp);
//	}
//
//	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String userid = req.getParameter("loginid");
//		String passwd = req.getParameter("loginpasswd");
//		MemberDto memberDto = new MemberDto();
//		memberDto.setUserid(userid);
//		memberDto.setPasswd(passwd);
//		MemberDto result = null;
//		try {
//			result = memberService.login(memberDto);
//			if(result != null) { // 성공
////				session 설정
//				HttpSession session = req.getSession();
//				session.setAttribute("userinfo", memberDto);
//			}
//		} catch (Exception e1) {
//			req.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
//			e1.printStackTrace();
//		}
//		String path = "/view/index.jsp";
//		RequestDispatcher disp = req.getRequestDispatcher(path);
//		disp.forward(req, resp);
//	}
//	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		HttpSession session = req.getSession();
//		session.invalidate(); // 세션 다 지움
//		resp.sendRedirect(req.getContextPath() + "/view/index.jsp");
//	}
}

