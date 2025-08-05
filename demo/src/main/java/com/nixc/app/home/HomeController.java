package com.nixc.app.home;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixc.app.factory.Robot;

//annotation = 설명과 실행 기능 / 어노테이션도 하나의 클래스
@Controller
public class HomeController {
	
	@Autowired
	private Robot robot;

	@RequestMapping(value = "/", method = RequestMethod.GET) // 루트 url과 메서드 형태가 get인것만 받겠다
	public String home() {
		System.out.println("home");
		robot.getSwordArm().attack();
		robot.getGunArm().attack();
		return "index";
	}
	
}
