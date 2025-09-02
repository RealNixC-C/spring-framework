package com.nixc.app.configs.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter{

	private JwtTokenManager jwtTokenManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenManager jwtTokenManager) {
		super(authenticationManager);
		this.jwtTokenManager = jwtTokenManager;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		super.doFilterInternal(request, response, chain);
		
		// 1. 토큰을 꺼냄
		Cookie[] cookies = request.getCookies();
		String token = "";
		
		if(cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("accessToken")) {
					token = cookie.getValue();
					break;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
