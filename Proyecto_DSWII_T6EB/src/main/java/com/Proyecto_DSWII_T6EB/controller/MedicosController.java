package com.Proyecto_DSWII_T6EB.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.Proyecto_DSWII_T6EB.entity.Medicos;
import com.Proyecto_DSWII_T6EB.service.MedicosService;
import com.Proyecto_DSWII_T6EB.util.AppSettings;

@RestController
@RequestMapping("/cibermed/medicos")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class MedicosController {

	@Autowired
	private MedicosService mediservi;

	

	@GetMapping("/listamedico/{nom}")
	@ResponseBody
	public ResponseEntity<List<Medicos>> listapormedico(@PathVariable("nom") String nom) {
		List<Medicos> lista  = null;
		try {
			if (nom.equals("todos")) {
				lista = mediservi.listamedicospornombre("%");
			}else {
				lista = mediservi.listamedicospornombre(nom + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registramedico")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertamedico(@Valid @RequestBody Medicos medico, Errors errors){
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
		Medicos objSalida = mediservi.insertupdatemedicos(medico);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se registro el medico con el ID => " + objSalida.getIdmedico());
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizamedico")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizamedico(@Valid @RequestBody Medicos medico, Errors errors){
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
		Medicos objSalida = mediservi.insertupdatemedicos(medico);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se actualizo el medico con el ID => " + objSalida.getIdmedico());
		}
		return ResponseEntity.ok(salida);
	}
	
}
