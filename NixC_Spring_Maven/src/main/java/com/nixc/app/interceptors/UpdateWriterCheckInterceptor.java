package com.nixc.app.interceptors;

import java.util.Map;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nixc.app.board.BoardVO;
import com.nixc.app.member.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateWriterCheckInterceptor implements HandlerInterceptor{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().toUpperCase().equals("POST")) {
			return;
		}
		
		MemberVO memberVO = (MemberVO)request.getSession(false).getAttribute("member");
		if(memberVO == null) {
			modelAndView.addObject("msg", "작성자만 가능");
			modelAndView.addObject("url", "./list");
			modelAndView.setViewName("commons/result");
		}
		
		// 비회원일 경우 여기서 NPE발생 수정해야됨
		String memberId = memberVO.getMemberId();
		
		Map<String, Object> map = modelAndView.getModel();
		BoardVO boardVO = (BoardVO)map.get("boardVO");
		if(!memberId.equals(boardVO.getBoardWriter())) {
			// 동일하지 않을 경우 보낼곳
			// 방법 1
			modelAndView.addObject("msg", "작성자만 가능");
			modelAndView.addObject("url", "./list");
			
			// 방법 2
			modelAndView.setViewName("commons/result");
			
			// 방법 3
//			request.setAttribute("msg", "작성자만 가능");
//			request.setAttribute("url", "/");
//			request.getRequestDispatcher("/WEB-INF/views/commons/result").forward(request, response);
		}
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
