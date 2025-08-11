package com.nixc.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.commons.Pager;

public interface BoardService {

	public List<BoardVO> list(Pager pager) throws Exception;
	public BoardVO detail(BoardVO boardVO) throws Exception;
	public int add(BoardVO boardVO, MultipartFile[] attaches) throws Exception;
	public int update(BoardVO boardVO, MultipartFile[] attaches) throws Exception;
	public int delete(BoardVO boardVO) throws Exception;
	public int fileDelete(BoardFileVO boardFileVO) throws Exception;
	public BoardFileVO fileDetail(BoardFileVO boardFileVO) throws Exception;
	
}
