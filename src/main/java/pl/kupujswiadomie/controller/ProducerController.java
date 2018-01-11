package pl.kupujswiadomie.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
	public String addProducerPost(Model m, @Valid @ModelAttribute Producer producer, BindingResult bindingResult,
			@RequestParam("fileUrl") MultipartFile file) {
		if (bindingResult.hasErrors()) {
			return "redirect:/addproducer";
		}

		producer.setFileUrl(null);

		// zapis do bazy produktu
		this.producerRepo.save(producer);

		// pobranie id
		int imgId = producer.getId();

		// budowanie nazwy
		String fileName = null;
		if (!file.isEmpty()) {
			try {

				if (file.getSize() > 131072l) {
					m.addAttribute("errorMessage", "Za duży rozmiar pliku");
					return "producer/addproducer";
				}

				String extension = FilenameUtils.getExtension(file.getOriginalFilename());

				if (extension.equals("jpg") || extension.equals("jpeg")) {

					fileName = "producer_" + imgId + "." + extension;
					byte[] bytes = file.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
							"/home/ewa/eclipse-workspace/Aware_shopping/src/main/webapp/resources/uploads/producers/"
									+ fileName)));
					buffStream.write(bytes);
					buffStream.close();

					// seter dla url
					producer.setFileUrl(fileName);
					// zapis db
					this.producerRepo.save(producer);

					m.addAttribute("message", "Dodano producenta do bazy.");

					this.producerRepo.save(producer);
					return "redirect:/producers";

				} else {
					m.addAttribute("errorMessage", "Niepoprawny format pliku graficznego.");
					return "producer/addproducer";
				}

			} catch (Exception e) {
				return "home";
			}
		}
		m.addAttribute("errorMessage", "Brak zdjęcia.");
		return "producer/addproducer";
	}

	@GetMapping("/{id}")
	public String producerDetails(@PathVariable int id, Model m) {
		Producer producer = this.producerRepo.findById(id);
		m.addAttribute("producer", producer);
		List<Product> products = this.productRepo.findByProducer(producer);
		m.addAttribute("products", products);
		return "producer/details";
	}

	@GetMapping("edit/{id}")
	@Transactional
	public String edit(Model m, @PathVariable int id) {
		Producer producer = this.producerRepo.findById(id);
		m.addAttribute("producer", producer);
		return "producer/addproducer";
	}

	@PostMapping("edit/{id}")
	public String editPost(@Valid @ModelAttribute Producer producer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "producer/addproducer";
		}
		this.producerRepo.save(producer);
		return "redirect:/producers";
	}
}
