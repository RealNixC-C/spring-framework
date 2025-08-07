package com.nixc.app.board.notice;

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
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${board.notice}")
	private String board;
	
	@Override
	public List<BoardVO> list(Pager pager) throws Exception {
		// pager 객체는 controller에서부터 주소값을 가져왔기때문에 return하지않고
		// controller의 pager 그대로 사용하면됨
		Long totalCount = noticeDao.totalCount(pager);
		pager.makeNum(totalCount);
		
		return noticeDao.list(pager);
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return noticeDao.detail(boardVO);
	}
	
	@Override
	public int add(BoardVO boardVO, MultipartFile attaches) throws Exception {
		// 1. boardNo정보를 얻기 위해 우선 notice테이블에 등록 후 useGeneratedKey값을 가져옴
		int result = noticeDao.add(boardVO);
		
		if(attaches == null && attaches.isEmpty()) {
			return result;
		}
		// 2. File을 HDD에 저장
			
		String fileName = fileManager.fileSave(upload + board, attaches);
		
		// 3. 저장된 파일의 정보를 DB에 저장
		BoardFileVO vo = new BoardFileVO();
		vo.setOriName(attaches.getOriginalFilename());
		vo.setSaveName(fileName);
		vo.setBoardNo(boardVO.getBoardNo());
		result = noticeDao.addFile(vo);
		
		return result;
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
