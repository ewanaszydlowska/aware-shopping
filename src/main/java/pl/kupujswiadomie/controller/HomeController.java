package pl.kupujswiadomie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.repository.ProducerRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProducerRepository producerRepo;

	@GetMapping("")
	public String home(Model m) {
		
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
	
	@ModelAttribute("availableProducers")
	public List<Producer> getAllProducers() {
		return this.producerRepo.findAll();
	}
	
}
