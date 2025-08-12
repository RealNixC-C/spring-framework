package com.nixc.app.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.commons.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
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
		result = memberDao.insertProfile(profileVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberVO.getMemberId());
		map.put("roleNo", 3);
		result = memberDao.addRole(map);
		
		return result;
	}
	
	public MemberVO login(MemberVO memberVO) throws Exception {
		MemberVO checkVO = memberDao.login(memberVO);
		
		if(checkVO != null && memberVO.getPassword().equals(checkVO.getPassword())) {
			
			return checkVO;
		}
		
		return null;
	}
	
}
