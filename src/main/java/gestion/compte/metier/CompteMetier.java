package gestion.compte.metier;

import gestion.compte.entities.Compte;

public interface CompteMetier {
       public Compte saveCompte(Compte cp);
       public Compte getCompte(String code);
}
