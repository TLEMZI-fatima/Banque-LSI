package org.lsi.services;

import java.util.List;

import org.lsi.entities.Client;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupeRestService {
	
	@Autowired
	private GroupeMetier groupeMetier;

	@RequestMapping(value="/groupes",method=RequestMethod.POST)
	public Groupe saveGroupe(@RequestBody Groupe g) {
		return groupeMetier.saveGroupe(g);
	}

	@RequestMapping(value="/groupes",method=RequestMethod.GET)
	public  String listGroupe(Model model) {
		List<Groupe> groupes = groupeMetier.listGroupe();
		model.addAttribute("listGroupes", groupes);
		return "groupes";
	}
	
	@RequestMapping(value="/ajouterGroupe")

	public String ajouterGroupe( String nomGroupe) {

		 groupeMetier.saveGroupe(new Groupe(nomGroupe));
		
		return "redirect:groupes";
	}
	

}


