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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.Response;

/**
 * @author Alejandro
 *
 */
@Repository
public class ConsultaAlumnoRepository implements IConsultaAlumnoRepository{

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Alumno> cq = criteriaBuilder.createQuery(Alumno.class);

		Root<Alumno> root = cq.from(Alumno.class);

		List<Predicate> predicados = new ArrayList<Predicate>();

		if (filtro.getCorreo() != null && !filtro.getCorreo().isEmpty()) {
			//Aqui se pueden optener las conidicones de =
			
			predicados.add(
					criteriaBuilder.like(
							root.get("correo"), 
							"%"+filtro.getCorreo()+"%"));			
		}
		
		if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {

			predicados.add(
					criteriaBuilder.like(
							root.get("nombre"), 
							"%"+filtro.getNombre()+"%"));
		}
		
		if (filtro.getCurp() != null && !filtro.getCurp().isEmpty()) {

			predicados.add(
					criteriaBuilder.like(
							root.get("curp"), 
							"%"+filtro.getCurp()+"%"));
		}
		//
		if (filtro.getExpediente() != null && !filtro.getExpediente().isEmpty()) {

			predicados.add(
					criteriaBuilder.like(
							root.get("expediente"), 
							"%"+filtro.getExpediente()+"%"));
		}
		
		if (filtro.getCiclo() != null && !filtro.getCiclo().getNombre().isEmpty()) {

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
		
		//cq.where(criteriaBuilder.like(root.get("nombre"), filtro.getNombre()));
		cq.orderBy(criteriaBuilder.desc(root.get("idAlumno")));
		
		
		CriteriaQuery<Alumno> select= cq.select(root);
				
		
		TypedQuery<Alumno> typedQuery= entityManager.createQuery(select);
		
		List<Alumno> lista= typedQuery.getResultList();
		
		Response<Alumno> response= new Response<Alumno>();
		
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
