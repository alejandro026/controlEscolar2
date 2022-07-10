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

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.CicloFiltroRequest;
import com.utng.controlescolar2.model.CicloRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.service.ICicloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ciclo")
public class CicloController {

	@Autowired
	private ICicloService cicloService;

	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarTodos() {
		Response<Ciclo> response = cicloService.consultarTodos();
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}

	/*
	 * Cuando se manda un objeto se Pone la notacion @RequestBody tambien si se pone
	 * un consumes para inidcar que estoy mandando un objeto
	 */
	@PostMapping(path = "/guardarCiclo", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> guardarCiclo(@RequestBody Ciclo ciclo) {
		Response<Ciclo> response = cicloService.guardar(ciclo);
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/consultarCicloPorID/{idCiclo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarCicloPorID(@PathVariable("idCiclo") Integer idCiclo) {
		Response<Ciclo> response = cicloService.buscarCicloId(idCiclo);
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/borrarCicloPorID/{idCiclo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarCicloPorID(@PathVariable("idCiclo") Integer idCiclo) {
		Response<Integer> response = cicloService.eliminarCiclo(idCiclo);
		return new ResponseEntity<Response<Integer>>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/actualizarCiclo", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> actaulizarCiclo(@RequestBody Ciclo ciclo) {
		Response<Ciclo> response = cicloService.actualizarCiclo(ciclo);
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/buscarPorNombreClave/{nombre}/{clave}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarCicloPorClave(@PathVariable("nombre") String nombre,
			@PathVariable("clave") String clave) {
		Response<Ciclo> response = cicloService.buscarPorNombreClave(nombre, clave);
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/buscarPorNombreClave", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarCicloPorClave2(@RequestBody CicloRequest ciclo) {
		Response<Ciclo> response = cicloService.buscarPorNombreClave(ciclo.getNombre(), ciclo.getClave());
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}

	
	@PostMapping(path = "/buscarCicloDinamica", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> buscarCicloDinamica(
			@RequestBody CicloFiltroRequest filtro) {
		Response<Ciclo> response = cicloService.buscarCicloDinamica(filtro);
		return new ResponseEntity<Response<Ciclo>>(response, HttpStatus.OK);
	}
	
	
}
