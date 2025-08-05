package com.nixc.app.board.notice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nixc.app.board.BoardVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class NoticeDaoTest {

	@Autowired
	private NoticeDao noticeDao;
	
	//@Test
	void insertTest()throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("title3");
		noticeVO.setBoardContent("content3");
		noticeVO.setBoardWriter("writer3");
		int result = noticeDao.insert(noticeVO);
		
		// 단정문
		assertEquals(0, result);
	}
	
	//@Test
	void updateTest()throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("타이틀");
		noticeVO.setBoardContent("콘텐트");
		int result = noticeDao.update(noticeVO);
		
		// 단정문
		assertEquals(1, result);
		
	}
	
	//@Test
	void delete()throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardNo(3);
		int result = noticeDao.delete(noticeVO);
		
		//단정문
		assertEquals(1, result);
	}
	
	@Test
	void detailTest()throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		// L을 명시하지 않았는데 왜 에러나지않음
		noticeVO.setBoardNo(1);
		BoardVO boardVO = noticeDao.detail(noticeVO);
		log.info("result : {}", boardVO);
		assertNotNull(boardVO);
	}
	

}
