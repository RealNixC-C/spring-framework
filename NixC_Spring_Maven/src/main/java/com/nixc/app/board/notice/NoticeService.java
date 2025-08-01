package com.nixc.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixc.app.board.BoardService;
import com.nixc.app.board.BoardVO;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<BoardVO> list() throws Exception {
		return noticeDao.list();
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return noticeDao.detail(boardVO);
	}
	
	@Override
	public int add(BoardVO boardVO) throws Exception {
		return noticeDao.add(boardVO);
	}
	
	@Override
	public int update(BoardVO boardVO) throws Exception {
		return noticeDao.update(boardVO);
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		return noticeDao.delete(boardVO);
	}
}
