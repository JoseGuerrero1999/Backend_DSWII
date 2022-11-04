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

import com.Proyecto_DSWII_T6EB.entity.Medicamentos;
import com.Proyecto_DSWII_T6EB.service.MedicamentosService;
import com.Proyecto_DSWII_T6EB.util.AppSettings;

@RestController
@RequestMapping("/cibermed/medicamentos")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class MedicamentosController {

	@Autowired
	private MedicamentosService medicaservi;
	
	@GetMapping("/listamedicamento/{nom}")
	@ResponseBody
	public ResponseEntity<List<Medicamentos>> listapormedicamentos(@PathVariable("nom") String nom) {
		List<Medicamentos> lista  = null;
		try {
			if (nom.equals("todos")) {
				lista = medicaservi.listapornombre("%");
			}else {
				lista = medicaservi.listapornombre(nom + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registromedicamento")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertamedicamento(@Valid @RequestBody Medicamentos medicamento, Errors errors){
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
		Medicamentos objSalida = medicaservi.insertaactualiza(medicamento);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se registro el medicamento con el ID => " + objSalida.getIdmedicamentos());
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@PutMapping("/actualizarmedicamento")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizamedicamento(@Valid @RequestBody Medicamentos medicamento, Errors errors){
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
		Medicamentos objSalida = medicaservi.insertaactualiza(medicamento);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se actualizo el medicamento con el ID => " + objSalida.getIdmedicamentos());
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
}
