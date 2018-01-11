package pl.kupujswiadomie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kupujswiadomie.entity.Product;
import pl.kupujswiadomie.entity.Subcategory;
import pl.kupujswiadomie.repository.ProductRepository;
import pl.kupujswiadomie.repository.SubcategoryRepository;

@Controller
@RequestMapping("subcategory")
public class SubcategoryController {
	
	@Autowired
	private SubcategoryRepository subcategoryRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/{id}")
	public String getCategoryProducts(@PathVariable int id, Model m) {
		Subcategory subcategory = this.subcategoryRepo.findById(id);
		List<Product> products = this.productRepo.findBySubcategory(id);
		m.addAttribute("subcategory", subcategory);
		m.addAttribute("products", products);
		return "product/subcategory";
	}
	
}
