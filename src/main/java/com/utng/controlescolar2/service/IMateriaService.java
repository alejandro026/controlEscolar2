package com.utng.controlescolar2.service;


import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.MateriaFiltroRequest;
import com.utng.controlescolar2.model.MateriaRequest;
import com.utng.controlescolar2.model.Response;

public interface IMateriaService {

	Response<Materia> consultarTodos();

	Response<Materia> guardar(MateriaRequest materia);

	Response<Materia> buscarMateriaId(Integer idMateria);

	Response<Integer> eliminarMateria(Integer idMateria);

	Response<Materia> actualizarMateria(MateriaRequest materia);

	Response<Materia> buscarPorNombre(String nombre);
	
	Response<Materia> buscarMateriaDinamica(MateriaFiltroRequest materia);

}
