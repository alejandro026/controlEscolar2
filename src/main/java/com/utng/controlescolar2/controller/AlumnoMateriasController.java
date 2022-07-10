/**
 * 
 */
package com.utng.controlescolar2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar2.model.AlumnoMaterias;
import com.utng.controlescolar2.service.IAlumnoMateriasService;

/**
 * @author Alejandro
 *
 */
@RestController
@RequestMapping("/alumno-materias")
public class AlumnoMateriasController {

	@Autowired
	private IAlumnoMateriasService alumnoMateriasService;
	
	@GetMapping(path="/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlumnoMaterias>> consultarTodos(){
        List<AlumnoMaterias> datos=alumnoMateriasService.consultarTodos();
        return new ResponseEntity<List<AlumnoMaterias>>(datos, HttpStatus.OK);       
    }
}
