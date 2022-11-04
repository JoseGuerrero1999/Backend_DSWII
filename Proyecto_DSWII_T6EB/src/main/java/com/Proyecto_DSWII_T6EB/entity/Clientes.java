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
@Table(name ="tb_clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_cliente")
	private int idcliente;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "El nombre es de 2 a 100 caracteres")
	@Column(name ="nombre_cliente")
	private String nombre;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "El apellido es de 2 a 100 caracteres")
	@Column(name ="apellid_cliente")
	private String apellido;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "La direccion es de 2 a 100 caracteres")
	@Column(name ="direccion_cliente")
	private String direccion;
	
	@Pattern(regexp = "[0-9]{8}" ,message = "El dni tiene 8 dígitos")
	@Column(name ="dni_cliente")
	private String dni;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name ="fechaNacimiento_cliente")
	private Date FechaNaci;
	
	@Column(name ="malestar_cliente")
	private String malestar;
	
	@ManyToOne
	@JoinColumn(name="cod_especialidad")
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name="cod_usu")
	private Usuario usuario;
	
}
