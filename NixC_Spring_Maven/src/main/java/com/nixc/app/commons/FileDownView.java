package com.nixc.app.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.nixc.app.board.BoardFileVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileDownView extends AbstractView{

	@Value("${app.upload}")
	private String path;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("========== custum view ==========");
		log.info("{}",model);
		
		BoardFileVO boardFileVO = (BoardFileVO)model.get("VO");
		
		String filePath = path + model.get("board").toString();
		
		File file = new File(filePath, boardFileVO.getSaveName());
		
		// 총 파일의 크기 (윈도우는 다운속도, 받은량은알지만 전체 파일크기를 알지 못하기때문에 알려줘야함)
		response.setContentLengthLong(file.length());
		
		// 파일 다운시 파일의 이름을 인코딩
		String fileName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		
		// Header 설정
		// 1. 파일정보 : 이름설정
		response.setHeader("Content-Disposition", "attachement; fileName=\"" + fileName + "\"");
		// 2. 컨텐트를 전송할때 사용하는 Encoding 방식 설정
		response.setHeader("Content-Transfer-Encoding", "binary");
		// 3. File을 읽어서
		FileInputStream fi = new FileInputStream(file);
		// 4. Client로 내보내기 연결
		OutputStream os = response.getOutputStream();
		// 5. 전송
		FileCopyUtils.copy(fi, os);
		// 6. 해제
		os.close();
		fi.close();
	
		
	}
	
}
