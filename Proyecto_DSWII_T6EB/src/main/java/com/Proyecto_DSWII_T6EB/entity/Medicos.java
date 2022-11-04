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
@Table(name = "tb_medicos")
public class Medicos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_medic")
	private int  idmedico;
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "El nombre es de 2 a 100 caracteres")
	@Column(name ="nombre_medic")
	private String nombre;
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "El apellido es de 2 a 100 caracteres")
	@Column(name ="apellido_medic")
	private String apellido;
	@Pattern(regexp = "[0-9]{9}" ,message = "El telefono tiene 9 dígitos")
	@Column(name ="telefono_medic")
	private String telefono;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\\\s]{2,100}(@cibermed.com.edu.pe)" ,message = "Ingrese un correo de Cibermed")
	@Column(name ="correo_medic")
	private String correo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name ="fechacontrini_medic")
	private Date FechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name ="fechacontrfin_medic")
	private Date FechaFin;


	@ManyToOne
	@JoinColumn(name="cod_especialidad")
	private Especialidad especialidad;
	

	
}
