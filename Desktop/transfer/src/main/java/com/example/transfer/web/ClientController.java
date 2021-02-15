package com.example.transfer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.transfer.dao.ClientRepository;
import com.example.transfer.entities.Client;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	@Autowired
private ClientRepository clientrepository;
	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Client> c=clientrepository.findAll();
		model.addAttribute("Clients", c);
		return "Client";
	}
	

}
