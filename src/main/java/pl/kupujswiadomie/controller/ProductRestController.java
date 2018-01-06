package pl.kupujswiadomie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kupujswiadomie.entity.Category;
import pl.kupujswiadomie.entity.Subcategory;
import pl.kupujswiadomie.repository.CategoryRepository;
import pl.kupujswiadomie.repository.ProducerRepository;
import pl.kupujswiadomie.repository.ProductRepository;
import pl.kupujswiadomie.repository.StoreRepository;
import pl.kupujswiadomie.repository.SubcategoryRepository;

@RestController
@RequestMapping("/product")
public class ProductRestController {

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
	
	@GetMapping("/show/{id}")
	public List<Subcategory> showSubcategories(@PathVariable int id) {
		Category c = this.categoryRepo.findById(id);
		return this.subcategoryRepo.findByCategory(c);
	}
	
//	@GetMapping("/show/{id}")
//	public String showSubcategories2(Model m, @PathVariable int id) {
//		
//		return "ok2";
//	}
}
