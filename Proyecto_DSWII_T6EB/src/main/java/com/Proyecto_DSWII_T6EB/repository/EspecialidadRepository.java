package com.Proyecto_DSWII_T6EB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto_DSWII_T6EB.entity.Especialidad;
@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{

}
