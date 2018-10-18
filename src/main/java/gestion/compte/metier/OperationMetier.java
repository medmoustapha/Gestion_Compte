package gestion.compte.metier;

public interface OperationMetier {
	public boolean verser(String code,double montant,Long codeEmp);
	public boolean retirer(String code,double montant,Long codeEmp);
	public boolean virement(String cpt1,String cpt2,double montant,Long codeEmp);
	public PageOperation getOperation(String codeCompte,int page,int size);

}
