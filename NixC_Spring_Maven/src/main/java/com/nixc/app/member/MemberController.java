package com.nixc.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login() throws Exception {
		
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = memberService.login(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			log.info("memberVO : {}",memberVO);
		}
		
		return "index";
	}
	
	@GetMapping("join")
	public String join() {
		
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(Model model, MemberVO memberVO, MultipartFile attaches) throws Exception{
		
		int result = memberService.insert(memberVO, attaches);
		
		String msg = "가입 실패";
		String url = "/";
		
		if(result > 0) msg = "가입 완료";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		
		// 로그인 세션 지우는법
		// 방법 1
		session.removeAttribute("member");
		
		// 방법 2
		// session.invalidate();
		
		return "redirect:/";
	}
	
}
