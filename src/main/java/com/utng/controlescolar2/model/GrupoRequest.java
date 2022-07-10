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
@Setter
@Getter
public class GrupoRequest {

	private Integer id;

	private String grupo;

	private Integer estatus;

	private Integer idCiclo;
}
