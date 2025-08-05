package com.nixc.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixc.app.board.BoardService;
import com.nixc.app.board.BoardVO;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDao qnaDao;

	@Override
	public List<BoardVO> list() throws Exception {
		return qnaDao.list();
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return qnaDao.detail(boardVO);
	}

	public int reply(QnaVO qnaVO) throws Exception {
		QnaVO parent = (QnaVO)qnaDao.detail(qnaVO);
		qnaVO.setBoardRef(parent.getBoardRef());
		qnaVO.setBoardStep(parent.getBoardStep()+1);
		qnaVO.setBoardDepth(parent.getBoardDepth()+1);
		qnaDao.replyUpdate(parent);
		int result = qnaDao.add(qnaVO);
		return result;
	}
	
	@Override
	public int add(BoardVO boardVO) throws Exception {
		
		int result = qnaDao.add(boardVO);
		//ref값을 update
		result = qnaDao.refUpdate(boardVO);
		return result;
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
