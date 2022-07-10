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
@Table(name = "TBL_ALUMNO_MATERIAS")
public class AlumnoMaterias implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845950536883323333L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_AL_MT")
	private Integer id;
	
	@Column(name="EXPEDIENTE")
	private String expediente;
	
	@Column(name="PROMEDIO")
	private float promedio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="ID_MATERIA")
	//@Column(name="ID_MATERIA")
	private Materia materia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="ID_ALUMNO")
	private Alumno alumno;
}
