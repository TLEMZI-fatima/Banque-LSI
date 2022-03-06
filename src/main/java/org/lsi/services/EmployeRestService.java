package org.lsi.services;

import java.util.Collection;
import java.util.List;

import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;

import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;

import org.lsi.metier.EmployeMetier;
import org.lsi.metier.EmployeMetierImpl;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeRestService {
	
	@Autowired
	private EmployeMetier employeMetier;
	@Autowired
	private GroupeMetier groupeMetier;
	
	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private EmployeRepository employeRepository;
	

//	@RequestMapping(value="/employes",method=RequestMethod.POST)
//	public Employe saveEmploye(@RequestBody Employe e) {
//		return employeMetier.saveEmploye(e);
//	}
//	
	

	@GetMapping("/employes")
	public String listEmployes(Model model) {
		List<Employe> employes= employeMetier.listEmployes();
		model.addAttribute("listEmployes",employes);
		return "employes";	
	}
	
	
	@GetMapping("/addEmpEmp")
	public String addEmployes(Model model) {
		Employe emp=new Employe();
		model.addAttribute("emp", emp);
		model.addAttribute("listEmployes",employeMetier.listEmployes());
		return "addEmp";	
	}
	
	@PostMapping("/addEmpEm")
	public String addEmp(@ModelAttribute("emp") Employe emp) {
		try{
			employeMetier.saveEmploye(emp);
		}
		catch(Exception e) { e.printStackTrace();
		}
		
		return "redirect:/employes";
	}
	
	
	
	// affectation 
	
	@RequestMapping(value="/empGroupe/{codeEmploye}",method=RequestMethod.GET)
	public String empGroupe(Model model,@PathVariable("codeEmploye") Long codeEmploye) {
//		Employe emp=new Employe();
		model.addAttribute("grp", groupeRepository.findAll());
//		Employe grp=new Employe();
		model.addAttribute("emp", employeRepository.findById(codeEmploye).get().getNomEmploye());
		return "empGroupe";	
	}


	@PostMapping(value="/affecterGroupeEmp")
	public String affecterGroupe(Long codeEmploye, Long codeGroupe) {
		Groupe g=groupeRepository.findById(codeGroupe).get();
		Employe e=employeRepository.findById(codeEmploye).get();
		 g.getEmploye().add(e);    //ajouter au tableau
		e.getGroupes().add(g);

	    groupeMetier.saveGroupe(g);    //ajouter dans la base de donnes 
		employeMetier.saveEmploye(e);
		
		return "redirect:/employes";   //refresh la page
	}
	
	
	


	
}
