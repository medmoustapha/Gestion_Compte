package gestion.compte.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.compte.dao.CompteRepository;
import gestion.compte.entities.Compte;
@Service
public class CompteMetierImpl implements CompteMetier{
    @Autowired 
	private CompteRepository compteRepository;
	@Override
	public Compte saveCompte(Compte cp) {
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		
		return compteRepository.findOne(code);
	}

}
