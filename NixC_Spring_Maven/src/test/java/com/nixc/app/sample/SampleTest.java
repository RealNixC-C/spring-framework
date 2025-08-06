package com.nixc.app.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleTest {

	//@Test
	public void test() {
		// 1    =>    1
		// 2    =>    2
//		// 3	=>    3
		// 4    =>    10
		// 5    =>    11
		// 6    =>    12
		// 7    =>    13
//		// 8    =>    20
		// 9    =>    21
		int n = 1;
		
		int result = n / 4 * 10 + n % 4;
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		// 편의점
		int price = 32200;
		int money = 50000;
		
		int man = 0;
		int cheon = 0;
		int baek = 0;
		
		// 1. 잔돈 차감 방식
//		int c10000 = 10000;
//		int c1000 = 1000;
//		int c100 = 100;
//		
//		int totalChange = money - price;
//		man = totalChange / c10000;
//		totalChange = totalChange % c10000;
//		cheon = totalChange / c1000;
//		totalChange = totalChange % c1000;
//		baek = totalChange / c100;
//		totalChange = totalChange % c100;
//		
//		System.out.println("만원 " + man + "장");
//		System.out.println("천원 " + cheon + "장");
//		System.out.println("백원 " + baek + "장");
//		System.out.println("남은거스름 돈 : " + totalChange);
		
		// 2. 문자열 변환 후 값 구하기
		int totalChange = money - price;
		String totalChangeStr = totalChange + "";
		String[] strArr = totalChangeStr.split("");
		man = Integer.parseInt(strArr[0]);
		cheon = Integer.parseInt(strArr[1]);
		baek = Integer.parseInt(strArr[2]);
		System.out.println("만원 " + man + "장");
		System.out.println("천원 " + cheon + "장");
		System.out.println("백원 " + baek + "장");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
