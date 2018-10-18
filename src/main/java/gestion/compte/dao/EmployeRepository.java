package gestion.compte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.compte.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long>{
    @Query("select e from Employe e where e.codeEmploye like :x")
	Employe findOne(@Param("x")Long codeEmp);

}
