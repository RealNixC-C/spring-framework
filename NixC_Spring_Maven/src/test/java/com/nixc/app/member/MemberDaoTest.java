package com.nixc.app.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MemberDaoTest {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void testPasswordUpdate() throws Exception {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId("test_manager");
		memberVO.setPassword(passwordEncoder.encode("test"));
		int result = memberDao.passwordUpdate(memberVO);
	}

}
