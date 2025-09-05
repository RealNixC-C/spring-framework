package com.nixc.app.websocket;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AddWebSocketHandler implements WebSocketHandler{

	private List<WebSocketSession> users = new ArrayList<>();
	private Map<String, WebSocketSession> map = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 실행전에 등록해야함 -> Class WebSocketConfig 생성
		// WebSocket으로 연결 되었을 때 실행
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Principal principal = session.getPrincipal();
		
		map.put(principal.getName(), session);
		
		log.info("{}", session);
		users.add(session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 사용자가 메세지를 전송 했을 때 실행
		log.info("{}", message.getPayload());
		users.forEach(u -> {
			try {
				u.sendMessage(message);
			} catch (IOException e) {
				System.out.println("전송 실패");
			}
		});
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// 메세지를 전달시 에러가 발생했을때
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// WebSocket 연결이 종료됐을때
		users.remove(session);
	}

	@Override
	public boolean supportsPartialMessages() {
		// 대용량 문서
		return false;
	}
	
	

}
