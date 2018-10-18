package gestion.compte.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestion.compte.entities.Employe;
import gestion.compte.metier.EmployeMetier;

@RestController
public class EmployeService {

	@Autowired
	private EmployeMetier employeMetier;
    @RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeMetier.saveEmploye(e);
	}
    @RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employe> listEmploye() {
		return employeMetier.listEmploye();
	}
	
}
