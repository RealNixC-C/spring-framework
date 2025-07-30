package com.nixc.app.board;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Component
public class BoardVO {

	private long boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private LocalDateTime boardDate;
	private long boardHit;
	
}
