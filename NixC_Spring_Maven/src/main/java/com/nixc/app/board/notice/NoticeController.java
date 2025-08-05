package com.nixc.app.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("add")
	public void insert() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("title");
		noticeVO.setBoardContent("content");
		noticeVO.setBoardWriter("wrtier");
		int result = noticeDao.insert(noticeVO);
	}
	
	@GetMapping("update")
	public void update() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("타이틀");
		noticeVO.setBoardContent("콘텐트");
		int result = noticeDao.update(noticeVO);
	}
	
	public void delete() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardNo(3);
		int result = noticeDao.delete(noticeVO);
	}
	
}
