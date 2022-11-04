package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DSWII_T6EB.entity.Clientes;
import com.Proyecto_DSWII_T6EB.repository.ClienteRepository;

@Service
public class ClienteServiceImp  implements ClienteService{

	@Autowired
	private ClienteRepository clienrepo;

	@Override
	public List<Clientes> listapordni(String dni) {
		return clienrepo.listapordni(dni);
	}

	@Override
	public Clientes inserteupdateclientes(Clientes clientes) {
		return clienrepo.save(clientes);
	}
}
