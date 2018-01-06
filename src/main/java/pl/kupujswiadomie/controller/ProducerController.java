package pl.kupujswiadomie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kupujswiadomie.bean.SessionManager;
import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.repository.ProducerRepository;
import pl.kupujswiadomie.repository.ProductRepository;

@Controller
@RequestMapping("/producer")
public class ProducerController {

	@Autowired
	private ProducerRepository producerRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/add")
	public String addProducer(Model m) {
		HttpSession s = SessionManager.session();
		if (s.getAttribute("user") != null) {
			m.addAttribute("producer", new Producer());
			return "producer/addproducer";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/add")
	public String addProducerPost(@Valid @ModelAttribute Producer producer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/addproducer";
		}
		this.producerRepo.save(producer);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String producerDetails(@PathVariable int id, Model m) {
		Producer producer = this.producerRepo.findById(id);
		m.addAttribute("producer", producer);
		List<Product> products = this.productRepo.findByProducer(producer);
		m.addAttribute("products", products);
		return "producer/details";
	}
}
