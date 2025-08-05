package com.nixc.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nixc.app.board.BoardVO;

@Controller
@RequestMapping(value="qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public String list(Model model) throws Exception {
		
		List<BoardVO> list = qnaService.list();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String add() {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(Model model, QnaVO qnaVo) throws Exception {
		
		int result = qnaService.add(qnaVo);
		
		String msg = "등록 실패";
		String url = "./list";
		if(result > 0) {
			msg = "등록 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	
	
	
	
	
	
	
	
	
	
}
