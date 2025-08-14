package com.nixc.app.filters;

import java.io.IOException;
import java.util.List;

import com.nixc.app.member.MemberVO;
import com.nixc.app.member.RoleVO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AdminCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean flag = false;
		
		MemberVO memberVO =  (MemberVO)session.getAttribute("member");
		List<RoleVO> roleList = memberVO.getRoleVOs();
		if(roleList != null) {
			for (RoleVO role : roleList) {
				if(role.getRoleName().equals("role_admin")) {
					flag = !flag;
					break;
				}
			}
		}
		if(flag) {
			chain.doFilter(httpRequest, response);
		} else {
			request.setAttribute("msg", "권한이 없습니다");
			request.setAttribute("url", "/");
			request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp").forward(httpRequest, response);
		}
		
	}

}
