package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DSWII_T6EB.entity.Medicamentos;
import com.Proyecto_DSWII_T6EB.repository.MedicamentoRepository;

@Service
public class MedicamentosServiceImp implements MedicamentosService {

	@Autowired
	private MedicamentoRepository medicirepo;

	@Override
	public List<Medicamentos> listapornombre(String nombre) {
		return medicirepo.listapornombremedicamento(nombre);
	}

	@Override
	public Medicamentos insertaactualiza(Medicamentos medicamentos) {
		return medicirepo.save(medicamentos);
	}
	
	
}
