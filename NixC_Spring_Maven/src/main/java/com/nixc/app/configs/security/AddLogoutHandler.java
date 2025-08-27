package com.nixc.app.configs.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nixc.app.member.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AddLogoutHandler implements LogoutHandler {

	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String restKey;
	
	@Value("${http://localhost/member/logout}")
	private String uri;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// 소셜 로그인인지 확인
		if(authentication instanceof OAuth2AuthenticationToken) {
			MemberVO memberVO = (MemberVO)authentication.getPrincipal();
			if(memberVO.getSns().toUpperCase().equals("KAKAO")) {
				this.useKakao(memberVO);
			}
		}
	}
	
	private void useKakao(MemberVO memberVO) {
		WebClient webClient = WebClient.create();
		Map<String, Object> param = new HashMap<>();
		param.put("target_id_type", "user_id");
		param.put("target_id", memberVO.getName());
		log.info("logout:");
		Mono<String> result = webClient.post()
									.uri("https://kapi.kakao.com/v1/user/logout")
									.header("Authorization", "Bearer "+memberVO.getAccessToken())
									.bodyValue(param)
									.retrieve()
									.bodyToMono(String.class);
		
		log.info("logout : {}", result.block());
	}
	
	private void useWithKakao(MemberVO memberVO) {
		WebClient webClient = WebClient.create();
		
		Mono<String> result = webClient.get()
									.uri("http://kauth.kakao.com/logout?client_id="+restKey)
									.retrieve()
									.bodyToMono(String.class);
		
		log.info("Logout 2 {}", result.block());
	}
	
	
	
	
	
	
	
}
