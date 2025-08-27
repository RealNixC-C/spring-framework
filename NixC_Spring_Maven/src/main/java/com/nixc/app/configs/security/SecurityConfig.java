package com.nixc.app.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.nixc.app.member.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// 정적자원들을 Security에서 제외
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private LoginFailureHandler failureHandler;
	
	@Autowired
	private AddLogoutHandler addLogoutHandler;
	
	@Autowired
	private AddLogoutSuccessHandler addLogoutSuccessHandler;
	
	@Autowired
	private MemberService memberService;
	
	@Bean
    ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }
	
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
			// 개발자가 로그인 검증을 하지 않는다,  Security Filter에서 검증
			.formLogin(form -> {
				form
					// login get과 post모드 적용
					.loginPage("/member/login")
					// 필드명이 username과 password라면 생략가능 
					.usernameParameter("memberId")
					.passwordParameter("password")
					// 로그인이 성공했을 경우 보낼 url
//					.defaultSuccessUrl("/")		// redirect
//					.successForwardUrl(null)		// forward
					.successHandler(loginSuccessHandler)		// defaultSuccessUrl과 동시에 사용불가
//					.failureUrl("/member/login")
					.failureHandler(failureHandler)
					;
			})
			// logout 설정
			// 개발자가 아닌 Security Filter에서 처리
			.logout(logout -> {
				logout
					// logout할 url
					.logoutUrl("/member/logout")
					.addLogoutHandler(addLogoutHandler)
					.logoutSuccessHandler(addLogoutSuccessHandler)
					// session을 소멸
					.invalidateHttpSession(true)
					// 관련된 cookie를 삭제
					.deleteCookies("JSESSIONID")
					// 로그아웃 성공시 이동할 url
//					.logoutSuccessUrl("/")
					;
			})
			.rememberMe(remember -> {
				remember
					// remember-me가 기본값 만약 다르다면 명시적으로 설정해야함
					.rememberMeParameter("remember-me")
					.tokenValiditySeconds(60)
					.key("rememberKey")
					.userDetailsService(memberService)
					.authenticationSuccessHandler(loginSuccessHandler)
					.useSecureCookie(false)
					;
			})
			.sessionManagement(s -> {
				s
					.invalidSessionUrl("/member/login")
					.maximumSessions(1)
					.maxSessionsPreventsLogin(false) // false : 이전 사용자 X, true: 현재 접속사용자X
					.expiredUrl("/member/login")
					;
			})
			.oauth2Login((o) -> {
				o.userInfoEndpoint((user)->{
					user.userService(memberService);
				});
			})
			;
		
		// 위에 추가한 결과물을 빌드하면 최종적으로 SecurityFilterChain타입이됨 그 값을 반환
		return httpSecurity.build();
	}
	
}
