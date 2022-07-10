/**
 * 
 */
package com.utng.controlescolar2.model;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Alejandro
 *
 */
@Getter
@Setter

public class AlumnoRequest {

	private Integer idAlumno;
	
	private String expediente;
	
	private String nombre;
	
	private String curp;
	
	private String genero;
	
	private String correo;
	
	private String estatus;
	
	private Integer idCiclo;
	
}
