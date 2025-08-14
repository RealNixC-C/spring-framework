package com.nixc.app.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {

//	public int add(Map<String, Object> map) throws Exception;
	//선생님 풀이
	public int add(List<AccountVO> list) throws Exception;
	
}
