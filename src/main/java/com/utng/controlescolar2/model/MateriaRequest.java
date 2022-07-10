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
public class MateriaRequest {
	
	private Integer id;
	
	private String clave;
	
	private String nombre;
	
	private Integer estatus;
	
	private Integer ciclo;
}
