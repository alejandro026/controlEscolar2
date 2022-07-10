/**
 * 
 */
package com.utng.controlescolar2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alejandro
 *
 */
@Getter
@Setter
@Entity
@Table (name="TBL_ALUMNO")
public class Alumno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1255454613950752977L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ALUMNO")
	private Integer idAlumno;
	
	@Column(name="EXPEDIENTE")
	private String expediente;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CURP")
	private String curp;
	
	@Column(name="GENERO")
	private String genero;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="ESTATUS")
	private String estatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo;
}
