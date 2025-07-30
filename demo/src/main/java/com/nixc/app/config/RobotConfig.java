package com.nixc.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nixc.app.factory.Arm;
import com.nixc.app.factory.GunArm;
import com.nixc.app.home.boards.BoardController;

@Configuration // 설정클래스
public class RobotConfig {
	
	private final BoardController boardController;
	
	RobotConfig(BoardController boardController) {
		this.boardController = boardController;
	}
	
	@Bean
	Arm getGunArm() {
		return new GunArm();
	}
		
}
