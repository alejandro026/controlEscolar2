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
 * @author Alejandro Guerrero
 *
 */
@Getter
@Setter
@Entity
@Table (name="TBL_MATERIAS")
public class Materia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 416774436511975260L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MATERIA")
	private Integer id;
	
	@Column(name="CLAVE")
	private String clave;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	
	@Column(name="ESTATUS")
	private Integer estatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo;

	
}
