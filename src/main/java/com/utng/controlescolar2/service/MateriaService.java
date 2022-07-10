/**
 * 
 */
package com.utng.controlescolar2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.MateriaFiltroRequest;
import com.utng.controlescolar2.model.MateriaRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.repository.CicloRepository;
import com.utng.controlescolar2.repository.ConsultaMateriaRepository;
import com.utng.controlescolar2.repository.MateriaRepository;

/**
 * 
 * @author Alejandro Guerreros
 *
 */
@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private CicloRepository cicloRepository;
	
	@Autowired
	private ConsultaMateriaRepository consultaMateriaRepository;

	@Override
	public Response<Materia> consultarTodos() {
		Response<Materia> response = new Response<Materia>();
		List<Materia> lista = materiaRepository.findAll();

		if (lista.isEmpty()) {
			response.setMessage("No hay resultados");
		} else {
			response.setMessage("Consulta correcta");
		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());

		return response;
	}

	@Override
	public Response<Materia> guardar(MateriaRequest materia) {
		Response<Materia> response = new Response<Materia>();

		Optional<Ciclo> optional = cicloRepository.findById(materia.getCiclo());
		Ciclo ciclo = null;
		Materia materia1 = null;
		Materia materia2 = null;

		// Si optional regresa registro se agrega a una variable
		if (optional.isPresent()) {
			ciclo = optional.get();
			materia1 = new Materia();
			materia1.setClave(materia.getClave());
			materia1.setCiclo(ciclo);
			materia1.setEstatus(materia.getEstatus());
			materia1.setNombre(materia.getNombre());
			materia2 = materiaRepository.save(materia1);
			response.setMessage("Guardado correcto");
			response.setStatus("OK");
			response.setData(materia2);
		} else {
			response.setStatus("ERROR");
			response.setMessage("Ciclo no existe");
			response.setData(null);
		}

		return response;
	}

	@Override
	public Response<Materia> buscarMateriaId(Integer idMateria) {

		Response<Materia> response = new Response<Materia>();

		Materia materia = null;
		Optional<Materia> optional = materiaRepository.findById(idMateria);

		if (optional.isPresent()) {
			materia = optional.get();
			response.setMessage("Búsqueda exitosa");
			response.setData(materia);
		} else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Integer> eliminarMateria(Integer idMateria) {

		Response<Integer> response = new Response<Integer>();

		try {
			materiaRepository.deleteById(idMateria);
			response.setData(idMateria);
			response.setMessage("Eliminación correcta");
			response.setStatus("OK");
		} catch (Exception e) {
			response.setMessage("No se puede eliminar");
			response.setStatus("error");
		}
		

		return response;
	}

	@Override
	public Response<Materia> actualizarMateria(MateriaRequest materia) {
		Response<Materia> response = new Response<Materia>();

		Optional<Ciclo> optional = cicloRepository.findById(materia.getCiclo());
		Optional<Materia> optionalM = materiaRepository.findById(materia.getId());
		
		Ciclo ciclo = null;
		Materia materia1 = null;
		Materia materia2 = null;

		// Si optional regresa registro se agrega a una variable
		if (optionalM.isPresent()) {
			if (optional.isPresent()) {
				ciclo = optional.get();
				materia1 = new Materia();
				materia1.setClave(materia.getClave());
				materia1.setId(materia.getId());
				materia1.setCiclo(ciclo);
				materia1.setEstatus(materia.getEstatus());
				materia1.setNombre(materia.getNombre());
				materia2 = materiaRepository.save(materia1);
				response.setMessage("Actualización correcta");
				response.setStatus("OK");
				response.setData(materia2);
			} else {
				response.setStatus("OK");
				response.setMessage("Ciclo no existe");
				response.setData(null);
			}
		}else {
			response.setStatus("ERROR");
			response.setMessage("Error al actualizar, la materia no existe");
		}
		
		return response;
	}

	@Override
	public Response<Materia> buscarPorNombre(String nombre) {

		Response<Materia> response = new Response<Materia>();

		Materia materia = null;
		Optional<Materia> optional = materiaRepository.consultarPorNombre(nombre);
		if (optional.isPresent()) {
			materia = optional.get();
			response.setData(materia);
			response.setMessage("Búsqueda correcta");
		} else {
			response.setData(null);
			response.setMessage("Sin resultados");
		}
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Materia> buscarMateriaDinamica(MateriaFiltroRequest materia) {
		
		Optional<Ciclo> optional = cicloRepository.consultarPorNombre2(materia.getCicloNombre());
		Ciclo ciclo = null;
		
		if (optional.isPresent()) {
			ciclo = optional.get();
			materia.setCiclo(ciclo);
		}
		
		Response<Materia> response= new Response<Materia>();
		
		response=consultaMateriaRepository.busquedaMateria(materia);
		
		return response;
	}
}
