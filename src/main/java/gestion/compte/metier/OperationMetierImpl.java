package gestion.compte.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestion.compte.dao.CompteRepository;
import gestion.compte.dao.EmployeRepository;
import gestion.compte.dao.OperationRepository;
import gestion.compte.entities.Compte;
import gestion.compte.entities.Operation;
import gestion.compte.entities.Retrait;
import gestion.compte.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findOne(code);
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(employeRepository.findOne(codeEmp));
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("Solde Insuffisant");
		Operation o=new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(employeRepository.findOne(codeEmp));
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpt1, String cpt2, double montant, Long codeEmp) {
		retirer(cpt1, montant, codeEmp);
		verser(cpt2, montant, codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperation(String codeCompte, int page, int size) {
		Page<Operation> ops=operationRepository.getOperations(codeCompte,new PageRequest(page, size));
		PageOperation pop=new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperation(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalPage(ops.getTotalPages());
		pop.setTotalOperation((int)ops.getTotalElements());
		return pop;
	}

}
