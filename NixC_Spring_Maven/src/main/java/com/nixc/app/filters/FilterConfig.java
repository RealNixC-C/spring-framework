package com.nixc.app.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfig implements WebMvcConfigurer {
	
	@Bean
	FilterRegistrationBean<Filter> filterResiRegistrationBean() {
		FilterRegistrationBean<Filter> fr = new FilterRegistrationBean<Filter>();
		// 필터 객체 생성
		fr.setFilter(new TestFilter());
		// 지정할 url 패턴
		fr.addUrlPatterns("");
		// 순서지정
		fr.setOrder(2);
		
		return fr;
		
	}
	
	@Bean
	FilterRegistrationBean<Filter> checkIfAdmin() {
		FilterRegistrationBean<Filter> fr = new FilterRegistrationBean<Filter>();
		// 필터 객체 생성
		fr.setFilter(new AdminCheckFilter());
		// 지정할 url 패턴
		fr.addUrlPatterns("/notice/add", "/notice/update", "/notice/delete");
		// 순서지정
		fr.setOrder(1);
		
		return fr;
		
	}
}
