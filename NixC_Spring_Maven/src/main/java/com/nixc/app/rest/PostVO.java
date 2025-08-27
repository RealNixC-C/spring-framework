package com.nixc.app.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostVO {
	
	private Long id;
	private Long userId;
	private String title;
	private String body;

}
