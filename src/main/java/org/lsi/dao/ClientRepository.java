package org.lsi.dao;


import org.lsi.entities.Client;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {
//	public Page<Client> findByDesignationContains(String mc, Pageable
//			pageable);
//			@Query("select p from client p where  p.code_client like :x")
//			public Page<Client> chercher(@Param("x")String mc, Pageable pageable);

}
