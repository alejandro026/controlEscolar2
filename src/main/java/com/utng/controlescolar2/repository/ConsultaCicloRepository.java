/**
 * 
 */
package com.utng.controlescolar2.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.CicloFiltroRequest;
import com.utng.controlescolar2.model.Response;

/**
 * @author Alejandro
 *
 */
@Repository
public class ConsultaCicloRepository implements IConsultaCicloRepository{
	
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	@Override
	public Response<Ciclo> busquedaCiclo(CicloFiltroRequest filtro) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Ciclo> cq = criteriaBuilder.createQuery(Ciclo.class);

		Root<Ciclo> root = cq.from(Ciclo.class);

		List<Predicate> predicados = new ArrayList<Predicate>();

		if (filtro.getClave() != null && !filtro.getClave().isEmpty()) {
			//Aqui se pueden optener las conidicones de =
			
			predicados.add(
					criteriaBuilder.like(
							root.get("clave"), 
							"%"+filtro.getClave()+"%"));			
		}
		
		if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {

			predicados.add(
					criteriaBuilder.like(
							root.get("nombre"), 
							"%"+filtro.getNombre()+"%"));
		}
		
		if (filtro.getYear() != null&& !filtro.getYear().isEmpty()) {
			//Se obtiene el año y se contruyen las fechas 
			String fecha1=filtro.getYear()+"-01-01";
			String fecha2=filtro.getYear()+"-12-31";
			Date date1=Date.valueOf(fecha1);
			Date date2=Date.valueOf(fecha2);
			
			//Se hace una comparacion entre las 2 fechas
			predicados.add(
					criteriaBuilder.between(
							root.get("fechaInicio"), 
							date1, date2));
		}
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		
		//cq.where(criteriaBuilder.like(root.get("nombre"), filtro.getNombre()));
		cq.orderBy(criteriaBuilder.asc(root.get("id")));
		
		
		CriteriaQuery<Ciclo> select= cq.select(root);
				
		
		TypedQuery<Ciclo> typedQuery= entityManager.createQuery(select);
		
		List<Ciclo> lista= typedQuery.getResultList();
		
		Response<Ciclo> response= new Response<Ciclo>();
		
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
