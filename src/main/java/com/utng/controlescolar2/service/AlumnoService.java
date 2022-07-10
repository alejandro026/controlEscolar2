/**
 * 
 */
package com.utng.controlescolar2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.AlumnoRequest;
import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.repository.AlumnoRepository;
import com.utng.controlescolar2.repository.CicloRepository;
import com.utng.controlescolar2.repository.ConsultaAlumnoRepository;

/**
 * @author Alejandro
 *
 */
@Service
public class AlumnoService implements IAlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private ConsultaAlumnoRepository consultaAlumnoRepository;
	@Autowired
	private CicloRepository cicloRepository;
	
	@Override
	public Response<Alumno> consultarTodos() {
		
		Response<Alumno> response= new Response<Alumno>();
		List<Alumno> lista = alumnoRepository.findAll();
		
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
	public Response<Alumno> buscarAlumnoDinamica(AlumnoFiltroRequest alumno) {
		
		Optional<Ciclo> optional = cicloRepository.consultarPorNombre2(alumno.getCicloNombre());
		Ciclo ciclo = null;
		
		if (optional.isPresent()) {
			ciclo = optional.get();
			alumno.setCiclo(ciclo);
		}
		
		
		Response<Alumno> response= new Response<Alumno>();
		response=consultaAlumnoRepository.busquedaAlumno(alumno);
		return response;
	}

	@Override
	public Response<Alumno> guardar(AlumnoRequest alumno) {
		Response<Alumno> response = new Response<Alumno>();

		Optional<Ciclo> optional = cicloRepository.findById(alumno.getIdCiclo());
		Ciclo ciclo = null;
		Alumno alumno1 = null;
		Alumno alumno2 = null;

		if (optional.isPresent()) {
			ciclo = optional.get();
			alumno1 = new Alumno();
			alumno1.setEstatus(alumno.getEstatus());
			alumno1.setCiclo(ciclo);
			alumno1.setCorreo(alumno.getCorreo());
			alumno1.setGenero(alumno.getGenero());
			alumno1.setCurp(alumno.getCurp());
			alumno1.setNombre(alumno.getNombre());
			alumno1.setExpediente(alumno.getExpediente());
			alumno2 = alumnoRepository.save(alumno1);
			response.setMessage("Guardado correcto");
			response.setData(alumno2);

		} else {
			response.setStatus("OK");
			response.setMessage("Ciclo no existe");
			response.setData(null);
		}

		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Alumno> buscarAlumnoId(Integer idAlumno) {
		Response<Alumno> response = new Response<Alumno>();

		Alumno alumno = null;
		Optional<Alumno> optional = alumnoRepository.findById(idAlumno);

		if (optional.isPresent()) {
			alumno = optional.get();
			response.setMessage("Búsqueda exitosa");
			response.setData(alumno);
		} else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Integer> eliminarAlumno(Integer idAlumno) {

		Response<Integer> response = new Response<Integer>();

		alumnoRepository.deleteById(idAlumno);
		response.setData(idAlumno);
		response.setMessage("Eliminación correcta");
		response.setStatus("OK");

		return response;
		
	}

	@Override
	public Response<Alumno> actualizarAlumno(AlumnoRequest alumno) {
		Response<Alumno> response = new Response<Alumno>();

		Optional<Ciclo> optional = cicloRepository.findById(alumno.getIdCiclo());
		Optional<Alumno> optionalA = alumnoRepository.findById(alumno.getIdAlumno());
		
		Ciclo ciclo = null;
		Alumno alumno1 = null;
		Alumno alumno2 = null;

		if(optionalA.isPresent()) {
			if (optional.isPresent()) {
				
				ciclo = optional.get();
				alumno1 = new Alumno();
				alumno1.setIdAlumno(alumno.getIdAlumno());
				alumno1.setEstatus(alumno.getEstatus());
				alumno1.setCiclo(ciclo);
				alumno1.setCorreo(alumno.getCorreo());
				alumno1.setGenero(alumno.getGenero());
				alumno1.setCurp(alumno.getCurp());
				alumno1.setNombre(alumno.getNombre());
				alumno1.setExpediente(alumno.getExpediente());
				alumno2 = alumnoRepository.save(alumno1);
				response.setMessage("Actualización correcta");
				response.setData(alumno2);
				response.setStatus("OK");

			} else {
				response.setStatus("OK");
				response.setMessage("Ciclo no existe");
				response.setData(null);
			}
		}else {
			response.setStatus("ERROR");
			response.setMessage("Error al actualizar, el alumno no existe");
		}

		return response;
	}

}
