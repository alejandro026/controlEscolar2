/**
 * 
 */
package com.utng.controlescolar2.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.MateriaFiltroRequest;
import com.utng.controlescolar2.model.Response;
import javax.persistence.criteria.Predicate;

/**
 * @author Alejandro
 *
 */
@Repository
public class ConsultaMateriaRepository implements IConsultaMateriaRepository {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	@Override
	public Response<Materia> busquedaMateria(MateriaFiltroRequest filtro) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Materia> cq = criteriaBuilder.createQuery(Materia.class);

		Root<Materia> root = cq.from(Materia.class);

		List<Predicate> predicados = new ArrayList<Predicate>();

		if (filtro.getClave() != null && !filtro.getClave().isEmpty()) {

			//Aqui se pueden optener las conidicones de =
			
			predicados.add(criteriaBuilder.like(root.get("clave"), "%"+filtro.getClave()+"%" ));
			
			
		}
		if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {

			
			predicados.add(
					criteriaBuilder.like(
							root.get("nombre"), 
							"%"+filtro.getNombre()+"%"));
		}
		
		if (filtro.getCiclo() != null&&!filtro.getCiclo().getNombre().isEmpty()) {
		
					
					predicados.add(
							criteriaBuilder.equal(
									root.get("ciclo"), 
								filtro.getCiclo()));
			}
		
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		
		cq.orderBy(criteriaBuilder.asc(root.get("id")));
		
		CriteriaQuery<Materia> select= cq.select(root);
		
		TypedQuery<Materia> typedQuery= entityManager.createQuery(select);
		
		List<Materia> lista= typedQuery.getResultList();
		
		Response<Materia> response= new Response<Materia>();
		
		if (!lista.isEmpty()) {
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa");
			response.setCount(lista.size());
		}else {
			response.setMessage("Sin resultados");
			response.setStatus("OK");
		}
		

		return response;
	}

}
