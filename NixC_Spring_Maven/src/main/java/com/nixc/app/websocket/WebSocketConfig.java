package com.nixc.app.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// WebSocket 설정 클래스
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	// 생성한 핸들러 가져옴
	@Autowired
	private AddWebSocketHandler addWebSocketHandler;
	
	// 구현메소드
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 2번째 인자값 경로에 해당하는곳에 요청 발생
		registry.addHandler(addWebSocketHandler, "/chat")
		.setAllowedOrigins("*")
		;
	}

}
