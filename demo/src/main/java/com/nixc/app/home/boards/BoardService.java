package com.nixc.app.home.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public void list() {
		System.out.println("list");
	}
	
	public void detail() {
		System.out.println("detail");
	}
	
}
