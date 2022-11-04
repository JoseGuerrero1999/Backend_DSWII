package com.Proyecto_DSWII_T6EB.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name ="tb_medicamentos")
public class Medicamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_medicamentos")
	private int idmedicamentos;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "El nombre del medicamento es de 2 a 100 caracteres")
	@Column(name ="nombre_medicamento")
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name ="fechavencimiento_medicamento")
	private Date FechaVencimiento;
	
	@Column(name ="precio_medicamento")
	private String precio;
	
	@ManyToOne
	@JoinColumn(name="cod_proveedor")
	private Proveedor proveedor;
	
	
	@ManyToOne
	@JoinColumn(name="cod_medic")
	private Medicos medicos;
	
}
