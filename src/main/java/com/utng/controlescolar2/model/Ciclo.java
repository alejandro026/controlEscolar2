/**
 * 
 */
package com.utng.controlescolar2.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;




/**
 * 
 * @author Alejandro Guerrero
 *
 */
@Getter
@Setter
@Entity
@Table (name="TBL_CICLO_ESCOLAR")
public class Ciclo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7050556843575522943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CICLO")
	private Integer id;
	
	@Column(name="CLAVE")
	private String clave;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	
	@Column(name="ESTATUS")
	private Integer estatus;
	
	
	@Column(name="PERIODO")
	private Integer periodo;
	
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name="FECHA_FIN")
	private Date fechaFin;

}
