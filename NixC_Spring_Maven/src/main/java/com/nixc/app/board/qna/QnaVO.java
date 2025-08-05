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
	
	//setter
	//public void set변수명(타입 변수명){}
	
	//getter
	//getter 해당데이터타입 get변수명(){}
	public Long getBoardRef() {
		if(this.boardRef == null) {
			this.boardRef=0L;
		}
		return this.boardRef;
	}
	public Long getBoardStep() {
		if(this.boardStep == null) {
			this.boardStep=0L;
		}
		return this.boardStep;
	}
	public Long getBoardDepth() {
		if(this.boardDepth == null) {
			this.boardDepth=0L;
		}
		return this.boardDepth;
	}
	
}
