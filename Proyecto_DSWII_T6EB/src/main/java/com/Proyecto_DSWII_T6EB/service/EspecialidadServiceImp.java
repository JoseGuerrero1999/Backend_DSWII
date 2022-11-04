package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DSWII_T6EB.entity.Especialidad;
import com.Proyecto_DSWII_T6EB.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImp implements EspecialidadService{

	@Autowired
	private EspecialidadRepository repoespi;

	@Override
	public List<Especialidad> listaespecialidad() {
		return repoespi.findAll();
	}
	
}
