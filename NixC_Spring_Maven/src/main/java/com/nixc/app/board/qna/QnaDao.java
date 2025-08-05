package com.nixc.app.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.nixc.app.board.BoardDao;
import com.nixc.app.board.BoardVO;

@Mapper
public interface QnaDao extends BoardDao{

	public int refUpdate(BoardVO BoardVO) throws Exception;
	
}
