package com.nixc.app.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.commons.FileManager;
import com.nixc.app.products.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberService extends DefaultOAuth2UserService implements UserDetailsService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.member}")
	private String board;
	
	@Value("${app.upload}")
	private String upload;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("{}", userRequest.getAccessToken());
		log.info("{}", userRequest.getAdditionalParameters());
		log.info("{}", userRequest.getClientRegistration());
		
		String sns = userRequest.getClientRegistration().getRegistrationId();
		OAuth2User user = null;
		if(sns.toUpperCase().equals("KAKAO")) {
			user = this.useKakao(userRequest);
		}
		return user; 
	}
	
	private OAuth2User useKakao(OAuth2UserRequest userRequest) {
		OAuth2User user = super.loadUser(userRequest);
		log.info("{}", user.getName());
		log.info("{}", user.getAttributes());
		log.info("{}", user.getAuthorities());
		Map<String, Object> map = user.getAttributes();
		log.info("{}", map.get("properties").getClass().getName());
		LinkedHashMap<String, Object> m = (LinkedHashMap<String, Object>) map.get("properties");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setAccessToken(userRequest.getAccessToken().getTokenValue());
		
		memberVO.setName(user.getName());
		
		memberVO.setMemberId(m.get("nickname").toString());
		
		ProfileVO profileVO = new ProfileVO();
		if(m.get("profile_image") != null) {
			profileVO.setSaveName(m.get("profile_image").toString());
		}
		memberVO.setProfileVO(profileVO);
		
		List<RoleVO> list = new ArrayList<>();
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleName("ROLE_member");
		roleVO.setRoleNo(3L);
		list.add(roleVO);
		memberVO.setRoleVOs(list);
		
		memberVO.setAttributes(map);
		
		memberVO.setSns("kakao");
		
		return memberVO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = new MemberVO();
		// 직접 비밀먼호를 비교하고 싶은경우
//		passwordEncoder.matches(memberVO.getPassword(), passwordEncoder.encode("test"));
		memberVO.setMemberId(username);
		System.out.println("로그인 서비스");
		try {
			memberVO = memberDao.login(memberVO);
			return memberVO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 검증 메서드
	public boolean hasMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		
		boolean hasError = false;
		// check: true => 검증실패
		// check: false => 검증통과
		
		// 1. Annotation 검증
		hasError = bindingResult.hasErrors();
		
		// 2. 사용자 정의로 패스워드가 일치하는지 검증
		if(!memberVO.getPassword().equals(memberVO.getPasswordConfirm())) {
			bindingResult.rejectValue("passwordConfirm", "join.password.notEqual");
			
			hasError = true;
		}
		
		// 3. ID 중복 검사
		MemberVO result = memberDao.login(memberVO);
		
		if(result != null) {
			hasError = true;
			bindingResult.rejectValue("memberId", "join.memberId.duplicate");
		}
		
		return hasError;
	}
	
	public int insert(MemberVO memberVO, MultipartFile attaches) throws Exception {
		// 비밀번호 암호화
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		
		int result = memberDao.insert(memberVO);
		
		ProfileVO profileVO = new ProfileVO();
		profileVO.setMemberId(memberVO.getMemberId());
		profileVO.setOriName("default.jpg");
		profileVO.setSaveName("default.jpg");
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
	
	public int update(MemberVO memberVO) throws Exception {
		return memberDao.update(memberVO);
	}
	
	// security에서 처리
//	public MemberVO login(MemberVO memberVO) throws Exception {
//		MemberVO checkVO = memberDao.login(memberVO);
//		
//		if(checkVO != null && memberVO.getPassword().equals(checkVO.getPassword())) {
//			
//			return checkVO;
//		}
//		
//		return null;
//	}
	
	
	public List<ProductVO> cartList (MemberVO memberVO) throws Exception {
		// 나중에 페이징 처리 해야 함 
		
		return memberDao.cartList(memberVO);
	}
	
	public int addCart(Map<String, Object> map) throws Exception {
		return memberDao.addCart(map);
	}
	
	public int deleteCart(MemberVO memberVO, Long[] productNo) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberVO.getMemberId());
		map.put("list", Arrays.asList(productNo));
		
		return memberDao.deleteCart(map);
	}
	
	public void disconnect(MemberVO memberVO) throws Exception {
		
	}
	
}
