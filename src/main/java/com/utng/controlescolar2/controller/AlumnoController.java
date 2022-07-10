/**
 * 
 */
package com.utng.controlescolar2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.AlumnoRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.service.IAlumnoService;

/**
 * @author Alejandro
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping(path="/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Alumno>> consultarTodos(){
		Response<Alumno> alumnos=alumnoService.consultarTodos();
        return new ResponseEntity<Response<Alumno>>(alumnos, HttpStatus.OK);       
    }
	
	@PostMapping(path = "/buscarAlumnoDinamica", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> buscarAlumnoDinamica(
			@RequestBody AlumnoFiltroRequest filtro) {
		Response<Alumno> response = alumnoService.buscarAlumnoDinamica(filtro);
		return new ResponseEntity<Response<Alumno>>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/guardarAlumno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> guardarAlumno(@RequestBody AlumnoRequest alumno) {
		Response<Alumno> response = alumnoService.guardar(alumno);
		return new ResponseEntity<Response<Alumno>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/consultarAlumnoPorID/{idAlumno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> consultarAlumnoPorID(@PathVariable("idAlumno") Integer idAlumno) {
		Response<Alumno> response = alumnoService.buscarAlumnoId(idAlumno);
		return new ResponseEntity<Response<Alumno>>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/borrarAlumnoPorID/{idAlumno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarAlumnoPorID(@PathVariable("idAlumno") Integer idAlumno) {
		Response<Integer> response = alumnoService.eliminarAlumno(idAlumno);
		return new ResponseEntity<Response<Integer>>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/actualizarAlumno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> actaulizarAlumno(@RequestBody AlumnoRequest alumno) {
		Response<Alumno> response = alumnoService.actualizarAlumno(alumno);
		return new ResponseEntity<Response<Alumno>>(response, HttpStatus.OK);
	}
	
}
