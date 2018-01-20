package pl.kupujswiadomie.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import pl.kupujswiadomie.entity.Review;
import pl.kupujswiadomie.repository.CategoryRepository;
import pl.kupujswiadomie.repository.ProductRepository;
import pl.kupujswiadomie.repository.ReviewRepository;

@Controller
@RequestMapping("review")
public class ReviewController {
	
	@Autowired
	private ReviewRepository reviewRepo;
		
}
