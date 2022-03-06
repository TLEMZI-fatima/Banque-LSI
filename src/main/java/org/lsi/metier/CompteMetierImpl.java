package org.lsi.metier;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.OperationRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier {
	
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte saveCompte(Compte cp) {
		// TODO Auto-generated method stub
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.findById(code).orElse(null);
	}

	public List<Compte> listCompte(Client C) {
		// TODO Auto-generated method stub
				return (List<Compte>) C.getComptes();
	}

	@Override
	public Page<Operation> listOperation(String codeCompte, int nbrePage, int nbreCompte) {
		// TODO Auto-generated method stub
		return operationRepository.getOperations(codeCompte, PageRequest.of(nbrePage, nbreCompte));

	}

	


}
