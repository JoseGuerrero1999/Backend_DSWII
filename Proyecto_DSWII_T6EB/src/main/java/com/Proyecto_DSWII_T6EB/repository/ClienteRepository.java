package com.Proyecto_DSWII_T6EB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Proyecto_DSWII_T6EB.entity.Clientes;
@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

	@Query("select x from Clientes x where x.dni like ?1 ")
	public List<Clientes>listapordni(String dni);
	
}
