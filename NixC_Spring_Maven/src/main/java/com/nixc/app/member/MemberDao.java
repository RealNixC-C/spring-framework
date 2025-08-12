package com.nixc.app.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

	public int insert(MemberVO memberVO) throws Exception;
	public int insertProfile(ProfileVO profileVO) throws Exception;
	public int addRole(Map<String, Object> map)throws Exception;
	public MemberVO login(MemberVO memberVO) throws Exception;
	
}
