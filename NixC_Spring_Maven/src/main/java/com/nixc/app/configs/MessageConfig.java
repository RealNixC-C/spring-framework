package com.nixc.app.configs;

import java.util.Locale;

import com.nixc.app.board.qna.QnaController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class MessageConfig implements WebMvcConfigurer {

    private final QnaController qnaController;

    MessageConfig(QnaController qnaController) {
        this.qnaController = qnaController;
    }

	@Bean
	LocaleResolver localeResolver() {
		// 현재 홈페이지에 사용되는 언어를 유지하기 위한 저장 방법
		// 한국어를 default값으로 셋팅 (setDefaultLocale)
		
		// 1. session
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		
		// 2. cookie
		CookieLocaleResolver resolver2 = new CookieLocaleResolver("lang");
		resolver2.setDefaultLocale(Locale.KOREAN);
		
		return resolver2;
	}

	// Message Intercepter
	LocaleChangeInterceptor changeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");
		// url?lang=ko
		
		return changeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(this.changeInterceptor())
				.addPathPatterns("/**");
	}
	
	
}
