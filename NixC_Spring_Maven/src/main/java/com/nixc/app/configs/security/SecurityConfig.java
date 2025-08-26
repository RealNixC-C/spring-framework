package com.nixc.app.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.nixc.app.member.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	LoginSuccessHandler loginSuccessHander;
	
	@Autowired
	LoginFailureHandler failureHandler;
	
	@Bean
	WebSecurityCustomizer customizer() {
		
		return web -> {
			web.ignoring().requestMatchers("/css/**","/js/**", "/vender/**", "/img/**", "/files/**");
		};
	}	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.cors(cors -> cors.disable())
			.csrf(csrf -> csrf.disable())
			
			.authorizeHttpRequests(auth -> {
				auth
					.requestMatchers("/notice/add", "/notice/update", "/notice/delete").hasRole("admin")
					.requestMatchers("/products/add", "/products/update", "/products/delete").hasAnyRole("admin", "manager")
					.requestMatchers("/member/logout", "/member/update", "/member/delete", "/member/detail").hasAnyRole("admin", "manager", "member")
					.anyRequest().permitAll()
					;
			})
			
			.formLogin(form -> {
				form
					.loginPage("/member/login")
					.usernameParameter("memberId")
					.passwordParameter("password")
					.successHandler(loginSuccessHander)
					.failureHandler(failureHandler)
					.defaultSuccessUrl("/")
					;
			})
			.logout(logout -> {
				logout
					.logoutUrl("/member/logout")
					.addLogoutHandler(null)
					.logoutSuccessHandler(null)
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					;
			})
			.rememberMe(remember -> {
				remember
					.rememberMeParameter("remember-me")
					.tokenValiditySeconds(60*60*7)
					.key("rememberKey")
					.userDetailsService(memberService)
					.authenticationSuccessHandler(loginSuccessHander)
					.useSecureCookie(false)
					;
			})
			;
		
		return httpSecurity.build();
	}
	
}
