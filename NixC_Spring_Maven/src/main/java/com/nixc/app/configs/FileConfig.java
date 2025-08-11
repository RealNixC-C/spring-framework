package com.nixc.app.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer{

	// files가 D:/upload/spring_study로 치환되고
	// 나머지 / 뒤의 경로는 치환된 값 뒤에 붙음
	// ex) "/files/${ board }/${boardVO.boardFileVO.saveName}" 요청이 들어오면
	// 최종경로는 D:/upload/spring_study/${ board }/${boardVO.boardFileVO.saveName}이 됨
	
	@Value("${app.upload}")
	private String path; // D:/upload/spring_study/
	
	@Value("${app.url}") 
	private String url;  // /files/**
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(url).addResourceLocations("file:" + path);
	}
	
}
