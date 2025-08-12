package com.nixc.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.commons.FileManager;
import com.nixc.app.transaction.Transaction;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private Transaction transaction;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.member}")
	private String board;
	
	@Value("${app.upload}")
	private String upload;
	
	public int insert(MemberVO memberVO, MultipartFile attaches) throws Exception {
		int result = memberDao.insert(memberVO);
		
		ProfileVO profileVO = new ProfileVO();
		profileVO.setMemberId(memberVO.getMemberId());
		profileVO.setOriName("default.jsp");
		profileVO.setSaveName("default.jsp");
		if(attaches != null && !attaches.isEmpty()) {
			profileVO.setSaveName(fileManager.fileSave(upload + board, attaches));
			profileVO.setOriName(attaches.getOriginalFilename());
		}
		
		
		transaction.t2();
		
		return result;
	}
	
}
