package com.nixc.app.configs.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 로그인 요청시 실행하는 필터
// 기존 Security Login 여기서 함
// username, password를 꺼내서 LoadUserByUsernmae 호출
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	
	private JwtTokenManager jwtTokenManager;
	
	// 멤버변수 2개를 필요로 하는 생성자 선언
	public JwtLoginFilter(AuthenticationManager authenticationManager, JwtTokenManager jwtTokenManager) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenManager = jwtTokenManager;
		
		// 해당 Url이 왔을때 실행 등록
		this.setFilterProcessesUrl("/member/loginProcess");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("memberId");
		String password = request.getParameter("password");
		System.out.println("Jwt login Filter ===============================");
		System.out.println("memberId : " + username);
		System.out.println("password : " + password);
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		// UsernamePasswordAuthenticationToken에서 UserDetailService에서 UserDetailService의 loadUserByUsername 호출
		// 패스워드가 일치하는지 판별하고 해당 Authentication객체를 SecurityContextHolder에 담아줌
		
		return authenticationManager.authenticate(authenticationToken);
	}
	
	// attemptAuthentication메서드가 성공했을때 사용자의 정보로 Token을 생성
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// 로그인 성공시 해당 사용자 정보(Authentication)을 활용하여 Token을 생성
		String token = jwtTokenManager.createToken(authResult);
		
		// 토큰을 쿠키에 담아 클라이언트로 보냄
		Cookie cookie = new Cookie("accessToken", token);
		cookie.setPath("/");
		cookie.setMaxAge(180);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		response.sendRedirect("/");
	}
	
}
