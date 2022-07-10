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

import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.MateriaFiltroRequest;
import com.utng.controlescolar2.model.MateriaRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.service.IMateriaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;

	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarTodos() {
		Response<Materia> response = materiaService.consultarTodos();
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/guardarMateria", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> guardarMateria(@RequestBody MateriaRequest materia) {
		Response<Materia> response = materiaService.guardar(materia);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/consultarMateriaPorID/{idMateria}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarMateriaPorID(@PathVariable("idMateria") Integer idMateria) {
		Response<Materia> response = materiaService.buscarMateriaId(idMateria);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/borrarMateriaPorID/{idMateria}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarMateriaPorID(@PathVariable("idMateria") Integer idMateria) {
		Response<Integer> response = materiaService.eliminarMateria(idMateria);
		return new ResponseEntity<Response<Integer>>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/actualizarMateria", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> actaulizarMateria(@RequestBody MateriaRequest materia) {
		Response<Materia> response = materiaService.actualizarMateria(materia);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/buscarPorNombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarMateriaPorClave(@PathVariable("nombre") String nombre) {
		Response<Materia> response = materiaService.buscarPorNombre(nombre);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/buscarMateriaDinamica", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> guardarMateria(
			@RequestBody MateriaFiltroRequest filtro) {
		Response<Materia> response = materiaService.buscarMateriaDinamica(filtro);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

}
