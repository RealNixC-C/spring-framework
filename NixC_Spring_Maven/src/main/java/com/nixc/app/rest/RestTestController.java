package com.nixc.app.rest;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/api/*")
@Slf4j
public class RestTestController {

	@GetMapping("list")
	public void m1() throws Exception {
//		log.info("api list");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null);
//		
//		// 응답을 어떻게 받을지
//		List<PhotoVO> result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", List.class, request);
//		
//		log.info("{}", result);
// ----------------------------------------
		
		// 객체 생성
		WebClient webClient = WebClient.builder()
										.baseUrl("https://jsonplaceholder.typicode.com/photos/1")
										.build();
		Mono<ResponseEntity<PhotoVO>> res = webClient.get()
													.retrieve()
													.toEntity(PhotoVO.class);
		PhotoVO photoVO = res.block().getBody();
		
		log.info("{}", photoVO);
		
		this.m2();
		this.m3();
	}
	
	private void m2() throws Exception {
		WebClient webClient = WebClient.builder()
											.baseUrl("https://jsonplaceholder.typicode.com")
											.build();
		Flux<UserVO> res = webClient.get()
							.uri("/users")
							.retrieve()
							.bodyToFlux(UserVO.class);
		
		res.subscribe(u -> {
			UserVO userVO = u;
			log.info("{}", userVO);
		});
		
		// 첫 번째 하나만 출력
//		log.info("{}", res.blockFirst());
	}
	
	private void m3() throws Exception {
		PostVO postVO = new PostVO();
		postVO.setTitle("test-title");
		postVO.setBody("test-content");
		postVO.setUserId(1L);
		
		WebClient webClient = WebClient.builder()
											.baseUrl("https://jsonplaceholder.typicode.com/posts")
											.build();
		
		// 방법 1
//		Mono<ResponseEntity<PostVO>> res = webClient.post()
//					.bodyValue(postVO)
//					.retrieve()
//					.toEntity(PostVO.class);
//		postVO = res.block().getBody();
		
		// 방법 2
		Mono<PostVO> res = webClient.post()
									.bodyValue(postVO)
									.accept(MediaType.APPLICATION_JSON)
									.retrieve()
									.bodyToMono(PostVO.class)
									;
		
		log.info("{}", postVO);
	}
	
	
	
	
	
	
	
	
	
}
