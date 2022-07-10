/**
 * 
 */
package com.utng.controlescolar2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.AlumnoMaterias;
import com.utng.controlescolar2.repository.AlumnoMateriasRepository;

/**
 * @author Alejandro
 *
 */
@Service
public class AlumnoMateriasService implements IAlumnoMateriasService{

	@Autowired
	private AlumnoMateriasRepository alumnoMateriasRepository;
	
	@Override
	public List<AlumnoMaterias> consultarTodos() {
		// TODO Auto-generated method stub
		return alumnoMateriasRepository.findAll();
	}
	
}
