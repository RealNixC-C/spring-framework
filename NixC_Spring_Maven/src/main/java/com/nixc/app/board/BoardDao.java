package com.nixc.app.board;

public interface BoardDao {

	//insert
	public int insert(BoardVO boardVO)throws Exception;
	public int update(BoardVO boardVO)throws Exception;
	public int delete(BoardVO boardVO)throws Exception;
}
