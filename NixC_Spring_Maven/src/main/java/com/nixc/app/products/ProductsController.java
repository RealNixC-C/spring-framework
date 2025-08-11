package com.nixc.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value="/products/*")
public class ProductsController {
	
	@Value("${board.product}")
	private String name;
	
	@ModelAttribute("board")
	private String getBoard() {
		return name;
	};
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public void list(Model model) throws Exception {
		
		List<ProductVO> productList = productService.list();
		model.addAttribute("productList", productList);
	}
	
	@GetMapping("detail")
	public void detail(Model model, ProductVO productVO) throws Exception {
		
		model.addAttribute("productVO", productService.detail(productVO));
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		
		return "products/product_form";
	}
	
	@PostMapping("add")
	public String add(Model model, ProductVO productVO) throws Exception {
		
		int result = productService.add(productVO);
		
		String msg = "등록 실패";
		String url = "./list";
		if(result > 0) {
			msg = "등록 성공";
		}
		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg", msg);
//		mv.addObject("url", url);
//		
//		mv.setViewName("commons/result");
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "commons/result";
		
//		return mv;
	}
	
	@GetMapping("update")
	public String update(ProductVO productVO, Model model) throws Exception {
		
		model.addAttribute("productVO", productService.detail(productVO));
//		mv.addObject("productVO", productVO);
//		mv.setViewName("products/product_form");
		return "products/product_form";
//		return mv;
	}
	
	@PostMapping("update")
	public String updatePost(ProductVO productVO, Model model) throws Exception {
	
		int result = productService.update(productVO);
		
		String msg = "등록 실패";
		String url = "./detail?productNo=" + productVO.getProductNo();
		if(result > 0) {
			msg = "등록 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "commons/result";
	}
	
	@PostMapping
	public String delete(Model model, ProductVO productVO) throws Exception {
		
		int result = productService.delete(productVO);
		
		String msg = "삭제 실패";
		String url = "./list";
		if(result > 0) {
			msg = "삭제 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "commons/result";
	}
	
	
}
