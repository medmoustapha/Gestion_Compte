package gestion.compte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.compte.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
