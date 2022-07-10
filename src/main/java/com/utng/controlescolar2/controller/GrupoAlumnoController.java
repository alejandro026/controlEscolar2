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

import com.utng.controlescolar2.model.GrupoAlumno;
import com.utng.controlescolar2.service.IGrupoAlumnoService;

/**
 * @author Alejandro
 *
 */

@RestController
@RequestMapping("/grupo-alumno")
public class GrupoAlumnoController {

	
	@Autowired
	private IGrupoAlumnoService iGrupoAlumnoService;
	
	@GetMapping(path="/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GrupoAlumno>> consultarTodos(){
        List<GrupoAlumno> datos=iGrupoAlumnoService.consultarTodos();
        return new ResponseEntity<List<GrupoAlumno>>(datos, HttpStatus.OK);       
    }
	
}
