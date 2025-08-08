package com.nixc.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.board.BoardFileVO;
import com.nixc.app.board.BoardService;
import com.nixc.app.board.BoardVO;
import com.nixc.app.commons.FileManager;
import com.nixc.app.commons.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDao qnaDao;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	String upload;
	
	@Value("${board.qna}")
	String board;

	@Override
	public List<BoardVO> list(Pager pager) throws Exception {
		pager.makeNum(qnaDao.totalCount(pager));
		return qnaDao.list(pager);
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return qnaDao.detail(boardVO);
	}

	public int reply(MultipartFile[] attaches, QnaVO qnaVO) throws Exception {
		QnaVO parent = (QnaVO)qnaDao.detail(qnaVO);
		qnaVO.setBoardRef(parent.getBoardRef());
		qnaVO.setBoardStep(parent.getBoardStep()+1);
		qnaVO.setBoardDepth(parent.getBoardDepth()+1);
		qnaDao.replyUpdate(parent);
		int result = qnaDao.add(qnaVO);
		return result;
	}
	
	@Override
	public int add(BoardVO boardVO, MultipartFile[] attaches) throws Exception {
		int result = qnaDao.add(boardVO);
		
		result = qnaDao.refUpdate(boardVO);
		
		if(attaches != null && attaches.length != 0) {
			for (MultipartFile attach : attaches) {
				if(attach == null || attach.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(upload + board, attach);
				
				BoardFileVO vo = new BoardFileVO();
				vo.setBoardNo(boardVO.getBoardNo());
				vo.setOriName(attach.getOriginalFilename());
				vo.setSaveName(fileName);
				result = qnaDao.addFile(vo);
			}
		}
		return result;
	}

	@Override
	public int update(BoardVO boardVO, MultipartFile[] attaches) throws Exception {
		int result = qnaDao.update(boardVO);
		
		if(attaches == null || attaches.length == 0) return result;
		
		for(MultipartFile attach : attaches) {
			if(attach == null || attach.isEmpty()) {
				continue;
			}
		
			String fileName = fileManager.fileSave(upload + board, attach);
			BoardFileVO vo = new BoardFileVO();
			vo.setBoardNo(boardVO.getBoardNo());
			vo.setOriName(attach.getOriginalFilename());
			vo.setSaveName(fileName);
			result = qnaDao.addFile(vo);
		}
		
		return result;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		boardVO = qnaDao.detail(boardVO);
		
		int result = 0;
		if(boardVO.getBoardFileVOs() != null || boardVO.getBoardFileVOs().size() != 0) {
			for (BoardFileVO vo : boardVO.getBoardFileVOs()) {
				boolean fileResult = fileManager.fileDelete(upload + board, vo.getSaveName());
			}
			result = qnaDao.fileDelete(boardVO);
		}
		boardVO.setBoardTitle("deleted");
		
		return qnaDao.titleUpdate(boardVO);
		
	}

	@Override
	public int fileDelete(BoardFileVO boardFileVO) throws Exception {
		boardFileVO = qnaDao.fileDetail(boardFileVO);
		
		boolean result = fileManager.fileDelete(upload + board, boardFileVO.getSaveName());
		
		return qnaDao.fileDeleteOne(boardFileVO);
	}

}
