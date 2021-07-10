package syskathelpproject.syskathelpproject.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.dao.TicketRepository;

import syskathelpproject.syskathelpproject.entities.Ticket;

import syskathelpproject.syskathelpproject.services.TicketService;



@Controller

public class MainController {

	
	@Autowired
	private TicketService ticketservice;
	@Autowired
	private TicketRepository ticketrepository;
	
	@Autowired
 private ClientRepository  clientrepository;
	
	@Autowired
 private LogicielRepository logicielrepository;
	
	@Autowired
	 private IngenieurRepository ingenieurrepository;
	
	@RequestMapping("/login")
	public String loginpage() {
		
		return "login";
	}
	

	  
	  @RequestMapping(value="/dashboard")
		public String dashboardpage(Model model) {
			
			List<Ticket> tickets = ticketservice.findAll();
			
			model.addAttribute("tickets",tickets);
			long resolu = ticketrepository.count("resolu");
			long nonresolu = ticketrepository.count("non resolu");
			long encours = ticketrepository.count("en cours");
			long numberclient = clientrepository.count();
			long numberlogiciel = logicielrepository.count();
			long numberingenieur = ingenieurrepository.count();
			model.addAttribute("numberlogiciel",numberlogiciel);
			model.addAttribute( "resolu",resolu);
			model.addAttribute("numberclient",numberclient);
			model.addAttribute( "nonresolu",nonresolu);
			model.addAttribute("numberingenieur",numberingenieur);
			model.addAttribute("encours",encours);
			return "index";
		}

	}

