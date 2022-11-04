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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Entity
@Table(name ="tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_usu")
	private int idusuario;
	
	@Column(name ="nombre_susu")
	private String nombre;
	
	@Column(name ="apellido_usu")
	private String apellido;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name ="fechanaci_usu")
	private Date FechaNaci;
	
	@Column(name ="login_usu")
	private String login;
	
	@Column(name ="password_usu")
	private String password;
	
	
	
	@ManyToOne
	@JoinColumn(name="cod_tipousu")
	private Tipousuario tipousuario;
}
