package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import com.Proyecto_DSWII_T6EB.entity.Medicos;

public interface MedicosService {

	public abstract List<Medicos> listamedicospornombre(String nombre);
	public abstract Medicos insertupdatemedicos(Medicos medicos);
}
