package gestion.compte.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import gestion.compte.entities.Compte;
import gestion.compte.metier.CompteMetier;
import gestion.compte.metier.OperationMetier;
import gestion.compte.metier.PageOperation;

@WebService
public class CompteSoapService {
	@Autowired
      private CompteMetier compteMetier;
	@Autowired
    private OperationMetier operationMetier;
	
	@WebMethod
	public Compte saveCompte(Compte cp) {
		return compteMetier.saveCompte(cp);
	}
	@WebMethod
	public Compte getCompte(@WebParam(name="code")String code) {
		return compteMetier.getCompte(code);
	}
	@WebMethod
	public boolean verser(@WebParam(name="code")String code,
							@WebParam(name="montant")double montant,
							@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	@WebMethod
	public boolean retirer(@WebParam(name="code")String code,
								@WebParam(name="montant")double montant,
								@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
	@WebMethod
	public boolean virement(@WebParam(name="cpt1")String cpt1,@WebParam(name="cpt2")String cpt2,
			@WebParam(name="montant")double montant,
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.virement(cpt1, cpt2, montant, codeEmp);
	}
	@WebMethod
	public PageOperation getOperation(@WebParam(name="codeCompte")String codeCompte,
			                          @WebParam(name="page") int page,
					                  @WebParam(name="size") int size) {
		return operationMetier.getOperation(codeCompte, page, size);
	}
}
