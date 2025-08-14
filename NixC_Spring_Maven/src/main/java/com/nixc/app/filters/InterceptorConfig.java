package com.nixc.app.filters;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nixc.app.interceptors.UpdateWriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new UpdateWriterCheckInterceptor())
		.addPathPatterns("/notice/update", "/qna/update");
		
	}
	
}
