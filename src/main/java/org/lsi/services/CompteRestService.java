package org.lsi.services;

import java.util.Date;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.entities.CompteCourant;
import org.lsi.entities.CompteEpargne;
import org.lsi.entities.Operation;
import org.lsi.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.collections.List;

@Controller
public class CompteRestService {
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private ClientRepository clientRepository;

	@PostMapping("/comptes")
	public Compte saveCompte(@RequestBody Compte cp ) {
		return compteMetier.saveCompte(cp);
	}
	
	@GetMapping("/comptes")
	public String get() {
		return "comptes";
	}
	
	@GetMapping("/comptes/{code}")
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
	
	
//	@PostMapping("/consulterCompte")
//	public String consulterCompte(Model model, String codeCompte) {
//		Compte c = compteMetier.getCompte(codeCompte);
//		model.addAttribute("getComptes", c);
//		return "comptes";
//	}
	
		@PostMapping("/consulterCompte")
		public String getCompte(Model m, String codeCompte) {
			
			m.addAttribute("codeCompte", codeCompte);
			try {
				Compte c=compteMetier.getCompte(codeCompte);
				try {
					Page <Operation> pageOps = compteMetier.listOperation(codeCompte, 0,5);
				
					m.addAttribute("PagesOperations", pageOps.getContent());
				}
				catch(Exception e) {
					System.out.println("FAIL");
					e.printStackTrace();
				}
				m.addAttribute("getComptes", c);	
			}
			catch(Exception e) {
				m.addAttribute("exception", e);
				e.printStackTrace();
			}
			return "comptes";
		}
		
		@GetMapping("/ajouterCompteC")
		public String ajouterPageC(Model model) {
			model.addAttribute("compteC", new CompteCourant());
			return "ajouterCompte";
		}


		@GetMapping("/ajouterCompteE")
		public String ajouterPageE(Model model) {
			model.addAttribute("compteE", new CompteEpargne());
			return "ajouterCompte";
		}
		
		
		
		
		
		
	@GetMapping(value="/consulterAllComptes/codeClient")
	public String consulterAllComptes(Model model, Long codeClient) {
		Client cl=clientRepository.findById(codeClient).get();
		java.util.List<Compte> c = CompteMetier.listCompte(cl);
		model.addAttribute("sesComptes", c);
		return "comptes";
	}
//	@RequestMapping(value="/addCourant")
//	public Compte addCourant(@RequestBody String codeCompte, Date dateCreation, double solde, double decouvert) {
//		CompteCourant cc=new CompteCourant(codeCompte,dateCreation,solde,decouvert);
//		
//	return	 saveCompte(cc);
//	 
//	}
	
//	@RequestMapping(value="/comptes")
//	public String consulterAllComptes(Model model, String code) {
//		List<Compte> c = compteMetier.listCompte();
//		model.addAttribute("listCompte", c);
//		
//		for (int i = 0; i < c.size(); i++) {
//			System.out.println(c.get(i).getCodeCompte());
//			System.out.println(c.get(i).getDateCreation());
//			System.out.println(c.get(i).getSolde());
//			System.out.println(c.get(i).getClient().getNomClient());
//			System.out.println(c.get(i).getEmploye().getNomEmploye());
//			System.out.println(c.get(i).getOperations());
//			
//		}
//		return "comptes";
//	}
	
}
