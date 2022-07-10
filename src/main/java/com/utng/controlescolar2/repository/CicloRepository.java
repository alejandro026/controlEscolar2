package com.utng.controlescolar2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar2.model.Ciclo;

public interface CicloRepository extends JpaRepository<Ciclo, Integer> {

	@Query("select a from Ciclo a where a.nombre = ?1 and a.clave = ?2")
	Optional<Ciclo> consultarPorNombre(@Param("nombre") String nombre, @Param("clave") String clave);

	
	@Query("select a from Ciclo a where a.nombre = ?1")
	Optional<Ciclo> consultarPorNombre2(@Param("nombre") String nombre);

	// Trae los elementos que coincidan con la busqueda
	@Query("select a from Ciclo a where a.nombre LIKE :nombre")
	List<Ciclo> consultarPorNombre3(@Param("nombre") String nombre);

	// Realiza una busaeuda por varios campos
	@Query("select a from Ciclo a where a.clave IN :listaClaves")
	List<Ciclo> consultarPorNombre4(@Param("listaClaves") List<String> listaClaves);

	// Busqueda dinamica
	@Query("select a from Ciclo a where a.nombre = ?1 or a.clave = ?1 or a.id=?1 "
			+ "or a.estatus=?1 or a.periodo=?1 or a.fechaInicio=?1 or a.fechaFin=?1")
	List<Ciclo> consultaDinamica(@Param("dato") String dato);

}
