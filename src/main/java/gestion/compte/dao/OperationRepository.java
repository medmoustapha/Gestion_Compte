package gestion.compte.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.compte.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	@Query("select o from Operation o where o.compte.codeCompte like :x order By dateOperation desc")
	public Page<Operation> getOperations(@Param("x")String code,Pageable pageable);

}
