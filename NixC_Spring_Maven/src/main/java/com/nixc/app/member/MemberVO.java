package com.nixc.app.member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.nixc.app.member.validation.AddGroup;
import com.nixc.app.member.validation.UpdateGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO implements UserDetails, OAuth2User {

	@NotBlank(message = "아이디를 입력하세요", groups = AddGroup.class)
	private String memberId;
	// 최소 최대 사이즈
	@Size(min = 4, max = 12, groups = AddGroup.class)
	private String password;
	private String passwordConfirm;
	@NotBlank(groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	@Email(groups = {AddGroup.class, UpdateGroup.class})
	@NotBlank(groups= {AddGroup.class, UpdateGroup.class})
	private String email;
	// 정규식, regexp안에 정규식 작성
	// @Pattern(regexp = "")
	@NotBlank(groups = {AddGroup.class, UpdateGroup.class})
	private String phone;
	// 가져온 시간이 과거인가
	@NotNull
	@Past(groups = {AddGroup.class, UpdateGroup.class})
	private LocalDate birth;
	private boolean accountNonExpired; 
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private ProfileVO profileVO;
	private List<RoleVO> roleVOs;
	
	// --------------------------- Social
	private Map<String, Object> attributes;
	private String accessToken;
	private String sns;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			list.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		return list;
	}
	@Override
	public String getUsername() {
		return this.memberId;
	}
	
}
