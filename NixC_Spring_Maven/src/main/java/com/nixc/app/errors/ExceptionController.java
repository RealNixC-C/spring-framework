package com.nixc.app.errors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(exception = NumberFormatException.class)
	public String error(Model model, NumberFormatException ex) {
		ex.getMessage();
		return "errors/error";
	}
	
	@ExceptionHandler(exception = Exception.class)
	public String error2() {
		return "errors/error";
	}
	
	@ExceptionHandler(exception = Throwable.class)
	public String error3() {
		return "errors/error";
	}
}
