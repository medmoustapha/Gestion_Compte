package gestion.compte.metier;

import java.util.List;

import gestion.compte.entities.Employe;

public interface EmployeMetier {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmploye();
}
