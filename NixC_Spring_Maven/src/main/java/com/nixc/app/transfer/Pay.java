package com.nixc.app.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nixc.app.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Pay {

	@Around("execution (* com.nixc.app.transfer.Transfers.takeSubway(..))")
	// joinPoint는 point-cut 메소드를 객체화 시킨것
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("탑승전 카드 체크");
		// point-cut으로 받은 매개변수 출력하는 메소드 getArgs
		log.info("Args {}", joinPoint.getArgs());
		// 어떤 클래스인지 알아보는 메소드 getTarget()
		log.info("target {}", joinPoint.getTarget());
		log.info("kind {}", joinPoint.getKind());
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId("123");
		MemberVO[] members = new MemberVO[1];
		members[0] = memberVO;
		Object obj = joinPoint.proceed(members);
		log.info("return: {}",obj);
		System.out.println("하차시 카드 체크");
		return obj;
	}
	
}
