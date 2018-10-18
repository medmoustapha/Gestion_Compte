package gestion.compte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestion.compte.entities.Compte;
import gestion.compte.metier.CompteMetier;

@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;
    @RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte cp) {
		return compteMetier.saveCompte(cp);
	}
    @RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}

}
