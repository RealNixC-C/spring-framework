package com.nixc.app.board.notice;

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
@RequestMapping(value="/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

    @Value("${board.notice}")
    private String name;
    
    @ModelAttribute("board")
    public String getBoard() {
    	return name;
    }
	
	@GetMapping("list")
	public String list(Model model, Pager pager, MultipartFile attaches) throws Exception {
		
		List<BoardVO> list = noticeService.list(pager);
		
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}

	@GetMapping("detail")
	public String detail(Model model, NoticeVO noticeVo) throws Exception {
		BoardVO boardVO = noticeService.detail(noticeVo);
		
		model.addAttribute("boardVO", boardVO);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(NoticeVO noticeVO, MultipartFile attaches) throws Exception {
		int result = noticeService.add(noticeVO, attaches);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(Model model, BoardVO noticeVO) throws Exception {
		BoardVO boardVO = noticeService.detail(noticeVO);
		model.addAttribute("boardVO", boardVO);
		
		return "board/add";
	}
	
	@PostMapping("update")
	public String update(Model model, NoticeVO noticeVO) throws Exception{
		int result = noticeService.update(noticeVO);
		
		String msg = "수정 실패";
		String url="./detail?boardNo="+noticeVO.getBoardNo();
		if(result > 0) {
			msg = "수정 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";   // "redirect:./detail?boardNo="+noticeVO.getBoardNo();
	}
	
	@PostMapping
	public String delete(Model model, NoticeVO noticeVO) throws Exception {
		int result = noticeService.delete(noticeVO);
		
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
