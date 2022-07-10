/**
 * 
 */
package com.utng.controlescolar2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.GrupoAlumno;
import com.utng.controlescolar2.repository.GrupoAlumnoRepository;

/**
 * @author Alejandro
 *
 */
@Service
public class GrupoAlumnoService implements IGrupoAlumnoService{

	@Autowired
	private GrupoAlumnoRepository grupoAlumnoRepository;
	
	@Override
	public List<GrupoAlumno> consultarTodos() {
		// TODO Auto-generated method stub
		return grupoAlumnoRepository.findAll();
	}

}
