package com.nixc.app.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value="/products/*")
public class ProductsController {
	
	@GetMapping("list")
	public String list() {
		
		return "products/list";
	}
	
	@GetMapping("detail")
	public String detail() {
		
		return "products/detail";
	}
	
	@GetMapping("add")
	public String add() {
		
		return "products/product_form";
	}
	
	
}
