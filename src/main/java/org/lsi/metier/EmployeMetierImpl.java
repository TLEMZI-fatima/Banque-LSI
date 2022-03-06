package org.lsi.metier;

import java.util.List;
import java.util.Optional;

import org.lsi.dao.EmployeRepository;
import org.lsi.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeMetierImpl implements EmployeMetier {
	
	@Autowired
	private  EmployeRepository  employeRepository;

	@Override
	public Employe saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}
	
	public  Employe getEmploye(Long code) {
		// TODO Auto-generated method stub
		return employeRepository.findById(code).orElse(null);
	}
//	public EmpGroupe() {
//		@Query("select o from Employe o where o.groupe.=:x")
//	}

}
