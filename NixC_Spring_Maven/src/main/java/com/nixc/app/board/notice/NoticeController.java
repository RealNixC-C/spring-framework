package com.nixc.app.board.notice;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nixc.app.board.BoardVO;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<BoardVO> list = noticeService.list();
		
		// request와 라이프사이클이 동일한 Spring의 모델 객체 사용, jsp단에서 동일하게 el을 사용하면됨
		model.addAttribute("list", list);
		
		return "notice/list";
	}

	@GetMapping("detail")
	public String detail(Model model, NoticeVO noticeVo) throws Exception {
		BoardVO boardVO = noticeService.detail(noticeVo);
		
		model.addAttribute("boardVO", boardVO);
		return "notice/detail";
	}
	
}
