package com.nixc.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<ProductVO> list() throws Exception {
		return productDao.list();
	}
	
	public ProductVO detail(ProductVO productVO) throws Exception {
		return productDao.detail(productVO);
	}
	
	public int add(ProductVO productVO) throws Exception {
		return productDao.add(productVO);
	}
	
	public int update(ProductVO productVO) throws Exception {
		return productDao.update(productVO);
	}
	
}
