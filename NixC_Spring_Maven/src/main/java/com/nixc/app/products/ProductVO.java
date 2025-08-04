package com.nixc.app.products;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@ToString
public class ProductVO {

	private Long productNo;
	private Long kindNo;
	private String productName;
	private String productContent;
	private LocalDateTime productDate;
	private Double productRate;
	
	// 1:1
	// 단방향
	private ProductKindVO productKindVO;
	
}
