package com.nixc.app.account;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountVO {

	private String accountNo;
	private String memberId;
	private Long productNo;
	private LocalDate accountDate;
	private Long accountBalance;
	
}
