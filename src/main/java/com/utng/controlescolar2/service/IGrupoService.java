/**
 * 
 */
package com.utng.controlescolar2.service;

import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoRequest;
import com.utng.controlescolar2.model.Response;

/**
 * @author Alejandro
 *
 */
public interface IGrupoService {

	Response<Grupo> consultarTodos();

	Response<Grupo> guardar(GrupoRequest grupo);

	Response<Grupo> buscarGrupoId(Integer idGrupo);

	Response<Integer> eliminarGrupo(Integer idGrupo);

	Response<Grupo> actualizarGrupo(GrupoRequest grupo);

	Response<Grupo> buscarPorNombre(String grupo);

	Response<Grupo> busquedaDinamica(String dato);

}
