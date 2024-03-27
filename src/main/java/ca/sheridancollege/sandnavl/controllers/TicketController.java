package ca.sheridancollege.sandnavl.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.sandnavl.beans.Ticket;
import ca.sheridancollege.sandnavl.repositories.TicketRepository;
import ca.sheridancollege.sandnavl.repositories.UserRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Controller
public class TicketController {
	private TicketRepository ticketRepo;
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("users",userRepo.getUsers());
		return "addPage.html";
	}
	@PostMapping("/add")
	public String addTicket(@ModelAttribute Ticket ticket) {
		ticketRepo.addTicket(ticket);
		return "redirect:/view";
	}
	@GetMapping("/view")
	public String viewPage(Model model, Authentication authentication) {
		model.addAttribute("tickets", ticketRepo.getTickets());
		model.addAttribute("userId",userRepo.findUserByUserName(authentication.getName()).getUserId());
		ArrayList<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga: authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		model.addAttribute("role",roles.get(0));
		return "view.html";
	}
	@GetMapping("/edit/{id}")
	public String editPage(Model model, @PathVariable int id) {
		model.addAttribute("ticket", ticketRepo.getTicketById(id));
		model.addAttribute("users",userRepo.getUsers());
		return "editPage.html";
	}
	@PostMapping("/edit")
	public String editTicket(@ModelAttribute Ticket ticket) {
		ticketRepo.editTicket(ticket);
		return "redirect:/view";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ticketRepo.deleteTicketById(id);
		return "redirect:/view";
	}
}
