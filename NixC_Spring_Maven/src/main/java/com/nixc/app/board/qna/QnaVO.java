package com.nixc.app.board.qna;

import org.springframework.stereotype.Component;

import com.nixc.app.board.BoardVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class QnaVO extends BoardVO{

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	
}
