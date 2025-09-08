package com.nixc.app.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// WebSocket 설정 클래스
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {//WebSocketConfigurer {
	
	// 생성한 핸들러 가져옴
//	@Autowired
//	private AddWebSocketHandler addWebSocketHandler;
	
	// 구현메소드
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		// 2번째 인자값 경로에 해당하는곳에 요청 발생
//		registry.addHandler(addWebSocketHandler, "/chat")
//		.setAllowedOrigins("*")
//		;
//	}

	// 클라이언트가 메시지를 보낼 prefix 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");  // 구독 prefix
        config.setApplicationDestinationPrefixes("/app"); // 메시지 송신 prefix
    }

    // 클라이언트가 연결할 endpoint 등록
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // ws://localhost:8080/chat
                .setAllowedOriginPatterns("*")
                .withSockJS(); // SockJS fallback 지원
    }

}
