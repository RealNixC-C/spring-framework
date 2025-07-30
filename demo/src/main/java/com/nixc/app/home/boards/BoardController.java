package com.nixc.app.home.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// class 선언부 상단에 @RequestMapping을 사용하고 /board/* 요청을 모두 받은 후
	// 아래 선언된 메소드 list를 더해서 요청을 받게된다
	
	// Service클래스에 어노테이션을 만들었으니 필요없음
//	public BoardController() {
//		this.boardService = new BoardService();
//	}
	
	// /board/list =>
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String boardList() {
		System.out.println("list");
		boardService.list();
		return "board/list";
	}
	
	// /board/detail =>
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void boardDetail(BoardVo boardVo) {
//		String num = request.getParameter("detail");
//		int n = Integer.parseInt(num);
//		BoardVo boardVo = new BoardVo();
//		boardVo.setName(kind);
//		boardVo.setNum(num);
		
		System.out.println("detail : " + boardVo);
	}
}
