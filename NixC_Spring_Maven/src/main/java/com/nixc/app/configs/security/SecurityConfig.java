package com.nixc.app.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
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
	
	// 개발자가 만든것
	@Autowired
	private JwtTokenManager jwtTokenManager;
	
	// Spring의 기능
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
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
				form.disable()
				;
			})
//			.httpBasic(httpBasic -> {
//				httpBasic
//			})
			// Session 인증방식이 아닌
			// Token을 인증방식이기 때문에 Session을 사용하지 않음
			.sessionManagement(s -> {
				// 세션 생성방식을 사용하지 않음
				s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				;
			})
			//
			.addFilter(new JwtLoginFilter(authenticationConfiguration.getAuthenticationManager(), jwtTokenManager))
			// 소셜 로그인
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
