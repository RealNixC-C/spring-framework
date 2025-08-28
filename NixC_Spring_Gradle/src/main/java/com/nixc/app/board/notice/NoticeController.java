package com.nixc.app.board.notice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice/**")
public class NoticeController {

	@GetMapping("list")
	public String list() throws Exception {
		return "list";
	}
	
	@GetMapping("detail")
	public String detail() throws Exception {
		return "detail";
	}
	
}
