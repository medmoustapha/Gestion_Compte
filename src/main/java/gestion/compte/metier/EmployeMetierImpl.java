package gestion.compte.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.compte.dao.EmployeRepository;
import gestion.compte.entities.Employe;
@Service
public class EmployeMetierImpl implements EmployeMetier {
	@Autowired
	private EmployeRepository EmployeRepository;
	
     
	@Override
	public Employe saveEmploye(Employe e) {
		
		return EmployeRepository.save(e);
	}

	@Override
	public List<Employe> listEmploye() {
	
		return EmployeRepository.findAll();
	}
	

}
