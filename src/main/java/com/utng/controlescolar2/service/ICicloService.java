package com.utng.controlescolar2.service;


import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.CicloFiltroRequest;
import com.utng.controlescolar2.model.Response;

public interface ICicloService {
	Response<Ciclo>  consultarTodos();
	
	Response<Ciclo> guardar(Ciclo ciclo);
	
	Response<Ciclo> buscarCicloId(Integer idCiclo);
	
	Response<Integer> eliminarCiclo(Integer idCiclo);
	
	Response<Ciclo> actualizarCiclo(Ciclo ciclo);
	
	Response<Ciclo> buscarPorNombreClave(String nombre,String idCiclo);
	
	Response<Ciclo> buscarCicloDinamica(CicloFiltroRequest ciclo);
}
