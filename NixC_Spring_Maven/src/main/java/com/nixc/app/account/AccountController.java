package com.nixc.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nixc.app.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/account/*")
@Slf4j
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("add")
	public String add(Model model, Long[] productNo , HttpSession session) throws Exception {
	
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = accountService.add(memberVO, productNo);
		
		model.addAttribute("msg", "가입 완료");
		model.addAttribute("url", "/products/list");
		
		return "commons/result";
	}
}
