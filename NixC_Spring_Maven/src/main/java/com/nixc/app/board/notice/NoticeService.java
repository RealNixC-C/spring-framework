package com.nixc.app.board.notice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.board.BoardFileVO;
import com.nixc.app.board.BoardService;
import com.nixc.app.board.BoardVO;
import com.nixc.app.commons.FileManager;
import com.nixc.app.commons.Pager;

@Service
@Transactional
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${board.notice}")
	private String board;
	
	@Value("${board.file}")
	private String file;
	
	@Override
	public List<BoardVO> list(Pager pager) throws Exception {
		// pager 객체는 controller에서부터 주소값을 가져왔기때문에 return하지않고
		// controller의 pager 그대로 사용하면됨
		Long totalCount = noticeDao.totalCount(pager);
		if(totalCount == 0) return Collections.emptyList();
		pager.makeNum(totalCount);
		
		return noticeDao.list(pager);
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return noticeDao.detail(boardVO);
	}
	
	@Override
	public int add(BoardVO boardVO, MultipartFile[] attaches) throws Exception {
		// 1. boardNo정보를 얻기 위해 우선 notice테이블에 등록 후 useGeneratedKey값을 가져옴
		int result = noticeDao.add(boardVO);
		
		if(attaches != null && attaches.length != 0) {
			for (MultipartFile attach : attaches) {
				if(attach == null || attach.isEmpty()) {
					continue;
				}
				// 2. File을 HDD에 저장
					
				String fileName = fileManager.fileSave(upload + board, attach);
				
				// 3. 저장된 파일의 정보를 DB에 저장
				BoardFileVO vo = new BoardFileVO();
				vo.setOriName(attach.getOriginalFilename());
				vo.setSaveName(fileName);
				vo.setBoardNo(boardVO.getBoardNo());
				result = noticeDao.addFile(vo);
			}
		}
		return result;
	}
	
	@Override
	public int update(BoardVO boardVO, MultipartFile[] attaches) throws Exception {

		int result = 0;
		// 1. DB의 해당 글을 수정
		result = noticeDao.update(boardVO);
		
		// 2. 파일을 HDD에 저장
		if(attaches != null && attaches.length != 0) {
			for (MultipartFile attach : attaches) {
				if(attach == null || attach.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(upload + board, attach);
				
				// 3. 파일정보를 FileBD에 저장
				BoardFileVO vo = new BoardFileVO();
				vo.setOriName(attach.getOriginalFilename());
				vo.setSaveName(fileName);
				vo.setBoardNo(boardVO.getBoardNo());
				result = noticeDao.addFile(vo);
			}
		}
		
		return result;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		boardVO = noticeDao.detail(boardVO);
		
		for (BoardFileVO vo : boardVO.getBoardFileVOs()) {
			boolean result = fileManager.fileDelete(upload + board, vo.getSaveName());
		}
		int result = noticeDao.fileDelete(boardVO);
		
		return noticeDao.delete(boardVO);
	}
	
	@Override
	public int fileDelete(BoardFileVO boardFileVO) throws Exception {
		// 1. File 조회 (파일 save_name 가져옴)
		boardFileVO = noticeDao.fileDetail(boardFileVO);
		
		// 2. File 삭제
		boolean result = fileManager.fileDelete(upload + board, boardFileVO.getSaveName());
		
		// 3. DB 삭제
		return noticeDao.fileDeleteOne(boardFileVO);
	}
	
	@Override
	public BoardFileVO fileDetail(BoardFileVO boardFileVO) throws Exception {
		return noticeDao.fileDetail(boardFileVO);
	}
	
	@Override
	public String boardFile(MultipartFile multipartFile) throws Exception {
		if(multipartFile == null || multipartFile.getSize() == 0) return null;
		String fileName = fileManager.fileSave(upload + board + file, multipartFile);
		
		return "/files/"+ board + file + "/" + fileName;
	}
	
	@Override
	public boolean boardFileDelete(String fileName) throws Exception {
		fileName = fileName.substring(fileName.lastIndexOf("/"));
		
		return fileManager.fileDelete(upload + board + file + "/", fileName);
	}
}
