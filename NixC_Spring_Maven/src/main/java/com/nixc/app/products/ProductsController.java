package com.nixc.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value="/products/*")
public class ProductsController {
	
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
	
	@GetMapping
	public String update() throws Exception {
		
		return "products/product_form";
	}
}
