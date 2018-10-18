package gestion.compte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestion.compte.metier.OperationMetier;
import gestion.compte.metier.PageOperation;

@RestController
public class OperationRestService {
	@Autowired
      private OperationMetier operationMetier;
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
    public PageOperation getOperation(@RequestParam String codeCompte, 
							    		@RequestParam int page, 
							    		@RequestParam int size) {
		return operationMetier.getOperation(codeCompte, page, size);
	}
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(
			      @RequestParam String code, 
			      @RequestParam double montant, 
			      @RequestParam Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
    @RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(
			  @RequestParam String code, 
		      @RequestParam double montant, 
		      @RequestParam Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
    @RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String cpt1, @RequestParam String cpt2, 
			                @RequestParam double montant, @RequestParam Long codeEmp) {
		return operationMetier.virement(cpt1, cpt2, montant, codeEmp);
	}
}
