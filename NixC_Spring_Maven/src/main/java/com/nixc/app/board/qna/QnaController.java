package com.nixc.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.board.BoardVO;
import com.nixc.app.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value="qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@Value("${board.qna}")
	private String name;
	
	@ModelAttribute("board")
	public String getBoard() {
		return name;
	}
	
	@GetMapping("list")
	public String list(Model model, Pager pager) throws Exception {
		
		List<BoardVO> list = qnaService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String add() {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(Model model, QnaVO qnaVo, MultipartFile attaches) throws Exception {
		log.info("{}", attaches);
//		int result = qnaService.add(qnaVo);
		
		String msg = "등록 실패";
		String url = "./list";
//		if(result > 0) {
//			msg = "등록 성공";
//		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@GetMapping("reply")
	public String reply(Model model, QnaVO qnaVO) throws Exception {
		model.addAttribute("qnaVO", qnaVO);
		
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaVO qnaVO) throws Exception {
		
		int result = qnaService.reply(qnaVO);
//		String msg = "등록 실패";
//		String url = "./detail?boardNo=" + qnaVO.getBoardNo();
//		if(result > 0) {
//			msg = "등록 성공";
//		}
		
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, BoardVO boardVO) throws Exception {
		
		BoardVO result = qnaService.detail(boardVO);
		
		model.addAttribute("boardVO", result);
		return "board/detail";
	}
	
	public String delete(Model model, BoardVO boardVO) throws Exception {
		
		int result = qnaService.delete(boardVO);
		
		String msg = "삭제 실패";
		String url = "./list";
		if(result > 0) {
			msg = "삭제 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	
	
	
	
	
	
	
	
}
