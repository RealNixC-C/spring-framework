package com.nixc.app.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nixc.app.products.ProductVO;

@Mapper
public interface MemberDao {

	public int insert(MemberVO memberVO) throws Exception;
	public int insertProfile(ProfileVO profileVO) throws Exception;
	public int addRole(Map<String, Object> map)throws Exception;
	public MemberVO login(MemberVO memberVO) throws Exception;
	public int addCart(Map<String, Object> map) throws Exception;
	public List<ProductVO> cartList(MemberVO memberVO) throws Exception;
	public int deleteCart(Map<String, Object> map) throws Exception;
	public List<MemberVO> memberList() throws Exception;
	
}
