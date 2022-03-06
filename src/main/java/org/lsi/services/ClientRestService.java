package org.lsi.services;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;


import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.metier.ClientMetier;
import org.lsi.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}


	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public  String listClient(Model model) {
		List<Client> clients = clientMetier.listClient();
		model.addAttribute("listClients", clients);
		return "clients";
	}
	
	@RequestMapping(value="/ajouterClient")

	public String ajouterClient( String nomClient) {

		 clientMetier.saveClient(new Client(nomClient));
		
		return "redirect:clients";
	}
	
	@RequestMapping(value="/consulterComptes")

	public String consulterComptes(Model model, Client Cl) {
		
			List<Compte> comptes = CompteMetier.listCompte(Cl);
			model.addAttribute("listComptes", comptes);
			return "redirect:clients";
		
		
	}
	
	
	
	
	
}


