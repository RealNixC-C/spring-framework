package com.nixc.app.account;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class AccountDaoTest {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	@DisplayName("Account Add Test")
	void test() throws Exception {
		List<AccountVO> list = new ArrayList<>();
		AccountVO accountVO = new AccountVO();
		accountVO.setAccountNo("1");
		accountVO.setMemberId("test4");
		accountVO.setProductNo(1L);
		
		list.add(accountVO);
		accountVO = new AccountVO();
		accountVO.setAccountNo("2");
		accountVO.setMemberId("test2");
		accountVO.setProductNo(3L);
		
		list.add(accountVO);
		
		int result = accountDao.add(list);
		
		assertNotEquals("0", result);
	}

}
