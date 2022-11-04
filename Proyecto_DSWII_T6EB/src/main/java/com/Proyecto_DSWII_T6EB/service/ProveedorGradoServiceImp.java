package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DSWII_T6EB.entity.Proveedor;
import com.Proyecto_DSWII_T6EB.repository.ProveedorRepository;

@Service
public class ProveedorGradoServiceImp implements ProveedorService{

	@Autowired
	private ProveedorRepository repoprove;

	@Override
	public List<Proveedor> listaproveedor() {
		return repoprove.findAll();
	}
}
