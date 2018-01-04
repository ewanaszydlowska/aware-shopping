package pl.kupujswiadomie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.repository.ProducerRepository;

@Controller
public class ProducerController {

	@Autowired
	private ProducerRepository producerRepo;
	
	@GetMapping("/addproducer")
	public String register(Model m) {
		m.addAttribute("user", new Producer());
		return "producer/addproducer";
	}
	
	@PostMapping("/addproducer")
	public String registerPost(@Valid @ModelAttribute Producer producer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/addproducer";
		}
		this.producerRepo.save(producer);
		return "redirect:/";
	}
}
