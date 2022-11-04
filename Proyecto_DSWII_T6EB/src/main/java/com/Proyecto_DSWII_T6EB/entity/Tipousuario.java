package com.Proyecto_DSWII_T6EB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="tb_tipousuario")
public class Tipousuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_tipousu")
	private int idtipousu;
	@Column(name="des_tipousu")
	private String descriptipousu;
}
