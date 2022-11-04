package com.Proyecto_DSWII_T6EB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Proyecto_DSWII_T6EB.entity.Medicamentos;
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamentos, Integer> {

	@Query("select x from Medicamentos x where x.nombre like ?1")
	public List<Medicamentos> listapornombremedicamento(String nombre);
}
