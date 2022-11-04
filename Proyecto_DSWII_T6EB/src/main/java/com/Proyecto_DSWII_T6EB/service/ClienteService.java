package com.Proyecto_DSWII_T6EB.service;

import java.util.List;

import com.Proyecto_DSWII_T6EB.entity.Clientes;

public interface ClienteService {

	public abstract List<Clientes> listapordni(String dni);
	public abstract Clientes inserteupdateclientes(Clientes clientes);
}
