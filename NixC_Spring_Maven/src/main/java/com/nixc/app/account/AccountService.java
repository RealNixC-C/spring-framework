package com.nixc.app.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixc.app.member.MemberDao;
import com.nixc.app.member.MemberVO;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private MemberDao memberDao;
	
	public int add(MemberVO memberVO, Long[] productNo) throws Exception{
		
		// 내 풀이
//		long accountNo = System.currentTimeMillis();
//		Map<String, Object> map = new HashMap<>();
//		return accountDao.add(map);

		// 선생님 풀이
		List<AccountVO> list = new ArrayList<>();
		
		for(Long num : productNo) {
			AccountVO accountVO = new AccountVO();
			accountVO.setMemberId(memberVO.getMemberId());
			accountVO.setProductNo(num);
			accountVO.setAccountNo(String.valueOf(System.currentTimeMillis()));
			list.add(accountVO);
			Thread.sleep(10);
		}
		int result = accountDao.add(list);
		if(result > 0) {
			Map<String, Object> map = new HashMap<>();
			map.put("memberId", memberVO.getMemberId());
			map.put("list", Arrays.asList(productNo));
			result = memberDao.deleteCart(map);
		}
		
		return result;
		
	}
	
}
