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

import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.service.IGrupoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/grupo")
public class GrupoController {

	@Autowired
	private IGrupoService grupoService;

	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> consultarTodos() {
		Response<Grupo> response = grupoService.consultarTodos();
		return new ResponseEntity<Response<Grupo>>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/guardarGrupo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> guardarGrupo(@RequestBody GrupoRequest grupo) {
		Response<Grupo> response = grupoService.guardar(grupo);
		return new ResponseEntity<Response<Grupo>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/consultarGrupoPorID/{idGrupo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> consultarGrupoPorID(@PathVariable("idGrupo") Integer idGrupo) {
		Response<Grupo> response = grupoService.buscarGrupoId(idGrupo);
		return new ResponseEntity<Response<Grupo>>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/borrarGrupoPorID/{idGrupo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarGrupoPorID(@PathVariable("idGrupo") Integer idGrupo) {
		Response<Integer> response = grupoService.eliminarGrupo(idGrupo);
		return new ResponseEntity<Response<Integer>>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/actualizarGrupo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> actaulizarGrupo(@RequestBody GrupoRequest grupo) {
		Response<Grupo> response = grupoService.actualizarGrupo(grupo);
		return new ResponseEntity<Response<Grupo>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/buscarPorNombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> consultarGrupoPorClave(@PathVariable("nombre") String nombre) {
		Response<Grupo> response = grupoService.buscarPorNombre(nombre);
		return new ResponseEntity<Response<Grupo>>(response, HttpStatus.OK);
	}

	// Realizar un nuevo que tenga un campo dinamico
	@GetMapping(path = "/busquedaDinamica", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> busquedaDinamica(String dato) {
		Response<Grupo> response = grupoService.busquedaDinamica(dato);
		return new ResponseEntity<Response<Grupo>>(response, HttpStatus.OK);
	}
}
