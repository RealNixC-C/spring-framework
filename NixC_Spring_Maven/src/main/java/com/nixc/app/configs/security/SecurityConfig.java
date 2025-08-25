package com.nixc.app.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// 정적자원들을 Security에서 제외
	
	@Bean
	WebSecurityCustomizer customizer() {
		
		// web => WebSecurity
		return web -> {
			web
				.ignoring()
				.requestMatchers("/css/**")
				.requestMatchers("/js/**", "/vendor/**")
				.requestMatchers("/img/*")
				.requestMatchers("/files/**")
				;
		};
	}
	
	// 인증과 권한의 설정
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.cors(cors -> cors.disable())
			.csrf(csrf -> csrf.disable())
			
			// 권한에 관련된 설정
			.authorizeHttpRequests(auth->{
				auth
					.requestMatchers("/notice/add", "/notice/update", "/notice/delete").hasRole("admin")
					.requestMatchers("/products/add", "/products/update", "/products/delete").hasAnyRole("admin", "manager")
//					.requestMatchers("/member/logout", "/member/update", "/member/delete").access("hasRole")
					.requestMatchers("/member/logout", "/member/update", "/member/delete", "/member/detail").hasAnyRole("admin", "manager", "member")
					.anyRequest().permitAll()
					;
					
			})
			// 사용자가 만든 form 관련 설정
			.formLogin( form -> {
				form
					// login get과 post모드 적용
					.loginPage("/member/login")
					// 파라미터이름이 username과 password라면 생략가능 
					.usernameParameter("memberId")
					.passwordParameter("password")
					// 로그인이 성공했을 경우 보낼 url
					.defaultSuccessUrl("/")
					.failureUrl("/member/login")
					;
			})
			// logout 설정
			.logout(logout -> {
				logout
					// logout할 url
					.logoutUrl("/member/logout")
					// session을 소멸
					.invalidateHttpSession(true)
					// 관련된 cookie를 삭제
					.deleteCookies("JSESSIONID")
					// 로그아웃 성공시 이동할 url
					.logoutSuccessUrl("/");
			})
			;
		
		// 위에 추가한 결과물을 빌드하면 최종적으로 SecurityFilterChain타입이됨 그 값을 반환
		return httpSecurity.build();
	}
	
}
