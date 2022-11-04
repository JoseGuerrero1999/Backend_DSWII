package com.Proyecto_DSWII_T6EB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Proyecto_DSWII_T6EB.entity.Medicos;
@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Integer> {

	@Query("select x from Medicos x where x.nombre like ?1")
	public List<Medicos>listamedicospornombre(String nombre);
}
