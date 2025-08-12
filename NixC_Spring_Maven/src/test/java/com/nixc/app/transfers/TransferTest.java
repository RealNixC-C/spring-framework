package com.nixc.app.transfers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nixc.app.member.MemberVO;
import com.nixc.app.transfer.Pay;
import com.nixc.app.transfer.Transfers;

@SpringBootTest
class TransferTest {

	@Autowired
	private Transfers transfers;
	
	@Autowired
	private Pay pay;
	
	@Test
	void test() {
		
		transfers.takeBus("111");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId("user");
		memberVO = transfers.takeSubway(memberVO);
		
		
	}

	
	
}
