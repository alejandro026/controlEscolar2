package com.utng.controlescolar2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.CicloFiltroRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.repository.CicloRepository;
import com.utng.controlescolar2.repository.ConsultaCicloRepository;

@Service
public class CicloService implements ICicloService {

	@Autowired
	private CicloRepository cicloRepository;
	@Autowired
	private ConsultaCicloRepository consultaCicloRepository;

	@Override
	public Response<Ciclo> consultarTodos() {

		Response<Ciclo> response = new Response<Ciclo>();
		List<Ciclo> lista = cicloRepository.findAll();

		if (lista.isEmpty()) {
			response.setMessage("No hay resultados");
		}else {
			response.setMessage("Consulta correcta");

		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}

	@Override
	public Response<Ciclo> guardar(Ciclo ciclo) {

		Response<Ciclo> response = new Response<Ciclo>();

		Ciclo cicloNuevo = cicloRepository.save(ciclo);

		response.setMessage("Se guardo correctamente");
		response.setStatus("OK");
		response.setData(cicloNuevo);

		return response;
	}

	@Override
	public Response<Ciclo> buscarCicloId(Integer idCiclo) {

		Response<Ciclo> response = new Response<Ciclo>();

		Ciclo ciclo = null;
		Optional<Ciclo> optional = cicloRepository.findById(idCiclo);

		// Si optional regresa registro se agrega a una variable
		if (optional.isPresent()) {
			ciclo = optional.get();
			response.setMessage("Búsqueda exitosa");
			response.setData(ciclo);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		return response;
	}

	@Override
	public Response<Integer> eliminarCiclo(Integer idCiclo) {

		Response<Integer> response = new Response<Integer>();

		try {
			cicloRepository.deleteById(idCiclo);
			response.setData(idCiclo);
			response.setMessage("Eliminación Correcta");
			response.setStatus("OK");
		} catch (Exception e) {
			response.setMessage("No se puede eliminar");
			response.setStatus("Error");
		}
		
		

		return response;
	}

	@Override
	public Response<Ciclo> actualizarCiclo(Ciclo ciclo) {

		Response<Ciclo> response = new Response<>();
		
		Ciclo cicloNuevo = cicloRepository.save(ciclo);
		response.setData(cicloNuevo);
		response.setMessage("Actualización Correcta");
		response.setStatus("OK");
		
		return response;
	}

	@Override
	public Response<Ciclo> buscarPorNombreClave(String nombre, String clave) {

		Response<Ciclo> response = new Response<Ciclo>();

		Ciclo ciclo = null;
		Optional<Ciclo> optional = cicloRepository.consultarPorNombre(nombre, clave);

		// Si optional regresa registro se agrega a una variable
		if (optional.isPresent()) {
			ciclo = optional.get();
			response.setData(ciclo);
			response.setMessage("Busqueda correcta");
		}else {
			response.setData(null);
			response.setMessage("Sin resultados");
		}
		
		response.setStatus("OK");

		return response;
	}


	@Override
	public Response<Ciclo> buscarCicloDinamica(CicloFiltroRequest ciclo) {
		Response<Ciclo> response= new Response<Ciclo>();
		response=consultaCicloRepository.busquedaCiclo(ciclo);
		return response;
	}

}
