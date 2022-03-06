package org.lsi.metier;

import java.util.List;

import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GroupeMetierImpl implements GroupeMetier {
	
	
	@Autowired
	private GroupeRepository GroupeRepository;



	@Override
	public Groupe saveGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return GroupeRepository.save(g);
		
	}

	@Override
	public List<Groupe> listGroupe() {
		// TODO Auto-generated method stub
		return GroupeRepository.findAll();
	}

}
