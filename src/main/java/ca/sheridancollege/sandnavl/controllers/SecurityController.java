package ca.sheridancollege.sandnavl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.sandnavl.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SecurityController {
	private UserRepository userRepo;

	@GetMapping("/login")
	public String login() {
		return "login.html";
	}

	@GetMapping("/accessDenied")
	public String denied() {
		return "accessDenied.html";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register.html";
	}

	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String password) {
		userRepo.addUser(username, password);
		return "redirect:/login";
	}
}