package com.utng.controlescolar2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar2.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	@Query("select a from Grupo a where a.grupo = ?1")
	Optional<Grupo> consultarPorNombre(@Param("grupo") String grupo);

	/*
	 * @Query("select a from Ciclo a where a.nombre = ?1 and a.clave = ?2")
	 * Optional<Ciclo> consultarPorNombre2(@Param("nombre") String nombre,
	 * 
	 * @Param("clave") String clave);
	 * 
	 * //Trae los elementos que coincidan con la busqueda
	 * 
	 * @Query("select a from Ciclo a where a.nombre LIKE :nombre") List<Ciclo>
	 * consultarPorNombre3(@Param("nombre") String nombre);
	 * 
	 * //Realiza una busaeuda por varios campos
	 * 
	 * @Query("select a from Ciclo a where a.clave IN :listaClaves") List<Ciclo>
	 * consultarPorNombre4(@Param("listaClaves") List<String> listaClaves);
	 */
	
	// Busqueda dinamica
	@Query("select a from Grupo a where a.grupo = ?1 or a.id=?1 or a.estatus=?1")
	List<Grupo> consultaDinamica(@Param("dato") String dato);
}
