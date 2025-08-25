package com.nixc.app.controller;

import java.security.Principal;
import java.util.Enumeration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixc.app.configs.InterceptorConfig;
import com.nixc.app.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

    private final InterceptorConfig interceptorConfig;

    HomeController(InterceptorConfig interceptorConfig) {
        this.interceptorConfig = interceptorConfig;
    }

	@GetMapping("/")
	public String home(HttpSession session) {
//		Enumeration<String> keys = session.getAttributeNames();
//		
//		// 권한 꺼내오기
//		// 방법 1
//		while(keys.hasMoreElements()) {
//			log.info("key : {}", keys.nextElement());
//		}
//		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
//		SecurityContextImpl contextImpl = (SecurityContextImpl)obj;
//		Authentication authentication = contextImpl.getAuthentication();
//		log.info("Auth : {}", authentication);
		
//		 방법2
//		 위과정을 static 메서드로 한번에 가져오는 방법
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		MemberVO memberVO = (MemberVO) authentication.getPrincipal();
//		
		return "index";
	}
	
	// 방법 3 
	// 매개변수로 principal 자체를 꺼냄
	// 위의 과정을 전부 실행하여 principal을 반환해줌
	@GetMapping("/info")
	public void info(Principal principal) {
		UserDetails userDetails = (UserDetails) principal;
//		log.info("{}", principal.getName());
		log.info(userDetails.getUsername());
		log.info(userDetails.getPassword());
//		log.info("{}", userDetails.getAuthorities());
	}
	
}
