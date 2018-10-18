package gestion.compte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.compte.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long>{

}
