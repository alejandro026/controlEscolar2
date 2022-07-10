package com.utng.controlescolar2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar2.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer>{

	@Query("select a from Materia a where a.nombre = ?1")
	Optional<Materia> consultarPorNombre(@Param("nombre") String nombre);
	
	// Busqueda dinamica
	@Query("select a from Materia a where a.nombre = ?1 or a.clave = ?1 or a.id=?1 "
			+ "or a.estatus=?1")
	List<Materia> consultaDinamica(@Param("dato") String dato);
}
