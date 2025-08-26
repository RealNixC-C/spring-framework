package com.nixc.app.configs.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("LoginSuccessHander : ");
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String memberId = userDetails.getUsername();
		
		// 아이디 기억 checkBox
		String rememberId = request.getParameter("rememberId");
		
		if(rememberId != null && "1".equals(rememberId)) {
			Cookie cookieRememberId = new Cookie("rememberId", memberId);
			cookieRememberId.setMaxAge(60*60*24*7);
			cookieRememberId.setPath("/");
			response.addCookie(cookieRememberId);
		} else {
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length != 0) {
				for (Cookie cookie : cookies) {
					if("rememberId".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
						break;
					}
				}
			}
		}
		
		response.sendRedirect("/");
	}
	
}
