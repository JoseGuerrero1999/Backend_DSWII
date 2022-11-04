package com.Proyecto_DSWII_T6EB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto_DSWII_T6EB.entity.Especialidad;
import com.Proyecto_DSWII_T6EB.entity.Proveedor;
import com.Proyecto_DSWII_T6EB.service.EspecialidadService;
import com.Proyecto_DSWII_T6EB.service.ProveedorService;
import com.Proyecto_DSWII_T6EB.util.AppSettings;



@RestController
@RequestMapping("/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private EspecialidadService espeservi;
	
	@Autowired
	private ProveedorService proveservi;
	
	@GetMapping("/listaespecialidad")
	@ResponseBody
	public List<Especialidad> listaespecialidad() {
		return espeservi.listaespecialidad();
	}

	@GetMapping("/listaproveedor")
	@ResponseBody
	public List<Proveedor> listaproveedor() {
		return proveservi.listaproveedor();
	}
	
}
