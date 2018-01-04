package pl.kupujswiadomie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("")
	public String home() {
		return "home";
	}
	
	@GetMapping("/products")
	public String products() {
		return "product/products";
	}
	
	@GetMapping("/producers")
	public String producers() {
		return "producer/producers";
	}
	
}
