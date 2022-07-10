/**
 * 
 */
package com.utng.controlescolar2.repository;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.Response;

/**
 * @author Alejandro
 *
 */
public interface IConsultaAlumnoRepository {
	Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro);
}
