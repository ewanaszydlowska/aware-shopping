package pl.kupujswiadomie.controller;

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

import pl.kupujswiadomie.bean.LoginData;
import pl.kupujswiadomie.bean.SessionManager;
import pl.kupujswiadomie.entity.User;
import pl.kupujswiadomie.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private SessionManager sessionManager;

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "user/register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/register";
		}
		this.userRepo.save(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("loginData", new LoginData());
		return "user/login";
	}

	@PostMapping("/login")
	public String loginPost(@ModelAttribute LoginData loginData, Model m) {
		User u = this.userRepo.findOneByUsername(loginData.getUsername());
		if (u != null && u.checkPassword(loginData.getPassword())) {
			HttpSession s = SessionManager.session();
			s.setAttribute("user", u);
			return "redirect:/";
		}
		m.addAttribute("message", "Wprowadz poprawne dane");
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logout(Model m) {
		HttpSession s = SessionManager.session();
		s.invalidate();
		
		m.addAttribute("loginData", new LoginData());
		return "redirect:/";
	}
	
	@GetMapping("/{username}")
	public String showProfile(@PathVariable String username, Model m) {
		m.addAttribute("user", this.userRepo.findOneByUsername(username));
		
		return "user/profile";
	}

}
