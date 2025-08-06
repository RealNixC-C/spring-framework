package com.nixc.app.board;

import java.util.List;

import com.nixc.app.commons.Pager;

public interface BoardDao {

	public int add(BoardVO boardVO)throws Exception;
	public int update(BoardVO boardVO)throws Exception;
	public int delete(BoardVO boardVO)throws Exception;
	public BoardVO detail(BoardVO boardVO)throws Exception;
	public List<BoardVO> list(Pager pager)throws Exception;
	public Long totalCount() throws Exception;
}
