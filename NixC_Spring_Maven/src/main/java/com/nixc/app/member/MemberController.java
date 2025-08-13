package com.nixc.app.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nixc.app.products.ProductVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Value("${board.cartList}")
	String name;
	
	@ModelAttribute("board")
	String getboard() {
		return name;
	}
	
	@GetMapping("login")
	public String login() throws Exception {
		
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = memberService.login(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			log.info("memberVO : {}",memberVO);
		}
		
		return "index";
	}
	
	@GetMapping("join")
	public String join() {
		
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(Model model, MemberVO memberVO, MultipartFile attaches) throws Exception{
		
		int result = memberService.insert(memberVO, attaches);
		
		String msg = "가입 실패";
		String url = "/";
		
		if(result > 0) msg = "가입 완료";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		
		// 로그인 세션 지우는법
		// 방법 1
//		session.removeAttribute("member");
		
		// 방법 2
		 session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("detail")
	public String detail(HttpSession session) throws Exception {
		
		
		return "member/detail";
	}
	
//	public String detail(MemberVO memberVO) {
//		
//	}
	
	@PostMapping("addCart")
	@ResponseBody
	public int addCart(ProductVO productVO, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		if(memberVO == null) {
			return 0;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("productNo", productVO.getProductNo());
		map.put("memberId", memberVO.getMemberId());
		
		int result = memberService.addCart(map);
		
		return result;
	}
	
	@GetMapping("cartList")
	public String cartList(Model model, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		List<ProductVO> list = memberService.cartList(memberVO);
		model.addAttribute("list", list);
		
		return "member/cartList";
	}
	
}
