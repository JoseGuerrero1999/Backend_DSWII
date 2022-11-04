package com.Proyecto_DSWII_T6EB.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto_DSWII_T6EB.entity.Clientes;
import com.Proyecto_DSWII_T6EB.service.ClienteService;
import com.Proyecto_DSWII_T6EB.util.AppSettings;

@RestController
@RequestMapping("/cibermed/cliente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ClientesController {

	@Autowired
	private ClienteService clienservi;
	
	@GetMapping("/listacliente/{dni}")
	@ResponseBody
	public ResponseEntity<List<Clientes>> listacliente(@PathVariable("dni") String dni) {
		List<Clientes> lista  = null;
		try {
			if (dni.equals("todos")) {
				lista = clienservi.listapordni("%");
			}else {
				lista = clienservi.listapordni(dni + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrocliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> InsetaCliente(@Valid @RequestBody Clientes cliente, Errors errors){
		HashMap<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<String>();
		salida.put("errores", lstMensajes);
		List<ObjectError> lstError = errors.getAllErrors();
		for (ObjectError objectError : lstError) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}
		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);
		}
		Clientes objSalida = clienservi.inserteupdateclientes(cliente);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se registro el cliente con el ID => " + objSalida.getIdcliente());
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizacliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Actualizacliente(@Valid @RequestBody Clientes cliente, Errors errors){
		HashMap<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<String>();
		salida.put("errores", lstMensajes);
		List<ObjectError> lstError = errors.getAllErrors();
		for (ObjectError objectError : lstError) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}
		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);
		}
		Clientes objSalida = clienservi.inserteupdateclientes(cliente);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se actualizo el cliente con el ID => " + objSalida.getIdcliente());
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
}
