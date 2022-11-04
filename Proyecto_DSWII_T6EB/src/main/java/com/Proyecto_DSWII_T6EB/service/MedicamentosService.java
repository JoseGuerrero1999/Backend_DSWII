package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import com.Proyecto_DSWII_T6EB.entity.Medicamentos;

public interface MedicamentosService {

	public abstract List<Medicamentos>listapornombre(String nombre);
	public abstract Medicamentos insertaactualiza(Medicamentos medicamentos);
	
}
