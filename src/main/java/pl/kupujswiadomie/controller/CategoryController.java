package pl.kupujswiadomie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.repository.CategoryRepository;
import pl.kupujswiadomie.repository.ProductRepository;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/{id}")
	public String getCategoryProducts(@PathVariable int id, Model m) {
		Category category = this.categoryRepo.findById(id); 
		List<Product> products = this.productRepo.findByCategory(category);
		m.addAttribute("category", category);
		m.addAttribute("products", products);
		return "product/category";
	}
	
}
