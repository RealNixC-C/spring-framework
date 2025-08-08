package com.nixc.app.board;

import com.nixc.app.commons.FileVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardFileVO extends FileVO{
	
	private Long boardNo;
	
}
