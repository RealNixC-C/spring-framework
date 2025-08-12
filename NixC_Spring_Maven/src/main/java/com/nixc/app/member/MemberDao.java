package com.nixc.app.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

	public int insert(MemberVO memberVO) throws Exception;
	public int insertProfile(ProfileVO profileVO) throws Exception;
	
}
