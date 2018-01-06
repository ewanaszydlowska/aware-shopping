package pl.kupujswiadomie.controller;

import java.util.Date;
import java.util.List;

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
import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Producer;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.entity.Store;
import pl.kupujswiadomie.entity.Subcategory;
import pl.kupujswiadomie.entity.User;
import pl.kupujswiadomie.repository.CategoryRepository;
import pl.kupujswiadomie.repository.ProducerRepository;
import pl.kupujswiadomie.repository.ProductRepository;
import pl.kupujswiadomie.repository.StoreRepository;
import pl.kupujswiadomie.repository.SubcategoryRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProducerRepository producerRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private SubcategoryRepository subcategoryRepo;

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
	public String addProducerPost(Model m, @Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "product/addproduct";
		}
		HttpSession s = SessionManager.session();
		User u = (User)s.getAttribute("user");
		product.setCreatedBy(u);
		product.setCreated(new Date());
		this.productRepo.save(product);
		m.addAttribute("message", "Dodano produkt do bazy.");
		return "redirect:/";
	}
	
	@ModelAttribute("availableProducers")
	public List<Producer> getAllProducers() {
		return this.producerRepo.findAll();
	}
	
	@ModelAttribute("availableStores")
	public List<Store> getAllStores() {
		return this.storeRepo.findAll();
	}
	
	@ModelAttribute("availableCategories")
	public List<Category> getAllCategories() {
		return this.categoryRepo.findAll();
	}
	
	@ModelAttribute("availableSubcategories")
	public List<Subcategory> getAllSubcategories() {
		return this.subcategoryRepo.findAll();
	}
}
