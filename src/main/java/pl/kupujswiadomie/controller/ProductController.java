package pl.kupujswiadomie.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String addProductPost(Model m, @Valid @ModelAttribute Product product, BindingResult bindingResult,
			@RequestParam("fileUrl") MultipartFile file) {
		if (bindingResult.hasErrors()) {
			return "product/addproduct";
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		product.setCreatedBy(u);
		product.setCreated(new Date());
		product.setFileUrl(null);

		// zapis do bazy produktu
		this.productRepo.save(product);

		// pobranie id
		int imgId = product.getId();

		// budowanie nazwy
		String fileName = null;
		if (!file.isEmpty()) {
			try {

				if (file.getSize() > 131072l) {
					m.addAttribute("errorMessage", "Za duży rozmiar pliku");
					return "product/addproduct";
				}
				
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());

				if (extension.equals("jpg") || extension.equals("jpeg")) {

					fileName = "product_" + imgId + "." + extension;
					byte[] bytes = file.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
							"/home/ewa/eclipse-workspace/Aware_shopping/src/main/webapp/resources/uploads/products/"
									+ fileName)));
					buffStream.write(bytes);
					buffStream.close();

					// seter dla url
					product.setFileUrl(fileName);
					// zapis db
					this.productRepo.save(product);

					m.addAttribute("message", "Dodano produkt do bazy.");
					return "redirect:/products";
					
				} else {
					m.addAttribute("errorMessage", "Niepoprawny format pliku graficznego.");
					return "product/addproduct";
				}

			} catch (Exception e) {
				return "home";
			}
		}
		m.addAttribute("errorMessage", "Brak zdjęcia.");
		return "product/addproduct";

	}

	@GetMapping("/{id}")
	public String productDetails(Model m, @PathVariable int id, @RequestParam(required = false) String message) {
		Product product = this.productRepo.findById(id);
		m.addAttribute("product", product);
		List<Store> stores = this.storeRepo.findAllByProductId(product.getId());
		m.addAttribute("stores", stores);
		m.addAttribute("message", message);
		return "product/details";
	}

	@GetMapping("edit/{id}")
	@Transactional
	public String edit(Model m, @PathVariable int id) {
		HttpSession s = SessionManager.session();
		User activeUser = (User) s.getAttribute("user");
		Product product = this.productRepo.findById(id);
		if (activeUser.getUsername().equals(product.getCreatedBy().getUsername())) {
			m.addAttribute("product", product);
			return "product/addproduct";
		} else {
			m.addAttribute("message", "Nie możesz edytować tego produktu!");
			return "redirect:/product/" + id;
		}
	}

	@PostMapping("edit/{id}")
	public String editPost(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "product/addproduct";
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		product.setCreatedBy(u);
		this.productRepo.save(product);
		m.addAttribute("message", "Edytowano produkt");
		return "redirect:/products";
	}

	@GetMapping("delete/{id}")
	@Transactional
	public String delete(Model m, @PathVariable int id) {
		HttpSession s = SessionManager.session();
		User activeUser = (User) s.getAttribute("user");
		Product product = this.productRepo.findById(id);
		if (activeUser.getUsername().equals(product.getCreatedBy().getUsername())) {
			this.productRepo.delete(product);
			m.addAttribute("message", "Usunięto wybrany produkt.");
			return "redirect:/products";
		} else {
			m.addAttribute("message", "Nie możesz usunąć tego produktu!");
			return "redirect:/product/" + id;
		}
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

	@ModelAttribute("byFirstCategory")
	public List<Subcategory> getFirstSubcategories() {
		return this.subcategoryRepo.findByCategoryId();
	}

}
