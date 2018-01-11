package pl.kupujswiadomie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.repository.ProducerRepository;
import pl.kupujswiadomie.repository.ProductRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProducerRepository producerRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("")
	public String home(Model m) {
		
		return "home";
	}
	
	@GetMapping("/products")
	public String products(Model m, @RequestParam(required = false) String message) {
		m.addAttribute("message", message);
		return "product/products";
	}
	
	@GetMapping("/producers")
	public String producers(Model m, @RequestParam(required = false) String message) {
		m.addAttribute("message", message);
		return "producer/producers";
	}
	
	@ModelAttribute("lastProducts")
	public List<Product> getLastProducts() {
		return this.productRepo.findAllByCreated();
	}
	
	@ModelAttribute("availableProductsAsc")
	public List<Product> getAllProductsByNameAsc() {
		return this.productRepo.findAllByNameAsc();
	}
	
	@ModelAttribute("availableProducersAsc")
	public List<Producer> getAllProducersByNameAsc() {
		return this.producerRepo.findAllByNameAsc();
	}
}
