package com.nixc.app.member;

import java.time.LocalDate;
import java.util.List;

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
public class MemberVO {

	@NotBlank
	private String memberId;
	// 최소 최대 사이즈
	@Size(min = 4, max = 12)
	private String password;
	@Size(min = 4, max = 12)
	private String passwordConfirm;
	@NotBlank
	private String name;
	@Email
	private String email;
	// 정규식, regexp안에 정규식 작성
	// @Pattern(regexp = "")
	private String phone;
	// 가져온 시간이 과거인가
	@NotNull
	@Past
	private LocalDate birth;
	private boolean accountNonExpired; 
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private ProfileVO profileVO;
	private List<RoleVO> roleVOs;
	
}
