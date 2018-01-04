package pl.kupujswiadomie.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kupujswiadomie.bean.SessionManager;
import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.repository.ProducerRepository;
import pl.kupujswiadomie.repository.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/add")
	public String addProduct(Model m) {
		HttpSession s = SessionManager.session();
		if (s.getAttribute("user") != null) {
			m.addAttribute("product", new Product());
			return "product/addproduct";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/add")
	public String addProducerPost(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/addproduct";
		}
		this.productRepo.save(product);
		return "redirect:/";
	}
}
