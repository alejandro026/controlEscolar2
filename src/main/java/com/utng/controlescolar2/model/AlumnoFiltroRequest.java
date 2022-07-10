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
public class AlumnoFiltroRequest {

	private String expediente;
	
	private String nombre;
	
	private String curp;
	
	private String correo;
	
	private String cicloNombre;
	
	private Ciclo ciclo;
	
}
