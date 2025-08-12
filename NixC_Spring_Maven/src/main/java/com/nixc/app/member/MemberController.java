package com.nixc.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@GetMapping("join")
	public String join() {
		
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(Model model, MemberVO memberVO, MultipartFile attaches) throws Exception{
		log.info("{}" ,memberVO);
		log.info("{}" ,attaches);
		
		int result = memberService.insert(memberVO, attaches);
		
		String msg = "가입 실패";
		String url = "/";
		
		if(result > 0) msg = "가입 완료";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
//		return "";
	}
	
}
