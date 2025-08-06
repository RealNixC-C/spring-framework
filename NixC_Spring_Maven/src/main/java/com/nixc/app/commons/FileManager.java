package com.nixc.app.commons;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	// 저장된 파일명을 리턴. dir은 파일의 경로
	public String fileSave(String dir, MultipartFile attaches) throws Exception {
		// 1. 디렉토리 생성
		File file = new File(dir);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 2. 저장할 파일명을 생성 (중복되지 않는 값을 사용하는게 중요 주로 시간기반)
		String fileName = UUID.randomUUID().toString().replaceAll("-", "");
		fileName = fileName + "_" + attaches.getOriginalFilename();
		
		// 3. HDD에 저장
		file = new File(file, fileName);
		// a. MultipartFile transferTo 메서드 사용
		// attaches.transferTo(file);
		
		// b. Spring에서 제공되는 FileCopyUtils의 copy 메서드 사용
		FileCopyUtils.copy(attaches.getBytes(), file);
		
		return fileName;
	}
	
}
