package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DSWII_T6EB.entity.Medicos;
import com.Proyecto_DSWII_T6EB.repository.MedicosRepository;
@Service
public class MedicosServiceImp implements MedicosService {

	@Autowired
	private MedicosRepository medirepo;

	@Override
	public List<Medicos> listamedicospornombre(String nombre) {
		return medirepo.listamedicospornombre(nombre);
	}

	@Override
	public Medicos insertupdatemedicos(Medicos medicos) {
		return medirepo.save(medicos);
	}
}
