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
public class MateriaFiltroRequest {

	private String clave;
	
	private String nombre;

	private String cicloNombre;
	
	private Ciclo ciclo;
}
