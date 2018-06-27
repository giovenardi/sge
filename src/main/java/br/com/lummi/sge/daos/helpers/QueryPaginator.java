package br.com.lummi.sge.daos.helpers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import br.com.lummi.sge.models.PaginatedList;
/*
 * creada por brunodias@vti.com.br para o projeto sit
 */
public class QueryPaginator {
	
	/*
	 * Pega uma query de uma classe e a pagina
	 * exemplo se fizer uma query por veiculos desativados ela a manda paginada
	 */
	public <T> PaginatedList list(TypedQuery<T> query,
	         TypedQuery<Number> countQuery, int currentPage, int max){
		  if (max == 0) {
			  max = PaginatedList.TAMANHO_PAGINA_DEFAULT;
		  }
	      List<T> currentList = query.setFirstResult(currentPage * max)
	            .setMaxResults(max).getResultList();
	      Number count = countQuery.getSingleResult();
	      return new PaginatedList(currentList, count, max);
	}
	
	/*
	 * Pega uma criteria e retorna a lista do indice iniciante ao final 
	 * exemplo se fizer uma query por veiculos desativados ela a manda paginada
	 */
	public <T> PaginatedList list(Class<T> clazz, Criteria criteria, int currentPage, int max, Order... orders){
		  if (max == 0) {
			  max = PaginatedList.TAMANHO_PAGINA_DEFAULT;
		  }
		if (!clazz.isAnnotationPresent(Entity.class)){
	         throw new IllegalArgumentException("A sua classe não está anotada @Entity");
	      }
		  criteria.setProjection(Projections.count("id"));
		  Number contador = (Number) criteria.uniqueResult();
		  criteria.setProjection(null);
		  criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		  if (orders != null) {
			  for (Order order : orders) {
				  criteria.addOrder(order);
			  }
		  }
	      criteria.setFirstResult(currentPage * max).setMaxResults(max);
//	      TypedQuery<Number> countQuery = getPageCount(clazz, manager);
//	      return new PaginatedList(criteria.list(), countQuery.getSingleResult());
	      return new PaginatedList(criteria.list(), contador, max);
	}
	
	/*
	 * Retorna o numero de páginas para a lista usar
	 */
	private <T> TypedQuery<Number> getPageCount(Class<T> clazz, EntityManager manager) {
		TypedQuery<Number> countQuery = manager.createQuery(
		            "select count(1) from " + clazz.getSimpleName() + " o",
		            Number.class);
		return countQuery;
	}
	
	
	/*
	 * Pega envia uma listagem de uma classe usando indices e paginação
	 */
	public <T> PaginatedList list(EntityManager manager, Class<T> clazz, int currentPage, int max){
		  if (max == 0) {
			  max = PaginatedList.TAMANHO_PAGINA_DEFAULT;
		  }
	      if (!clazz.isAnnotationPresent(Entity.class)){
	         throw new IllegalArgumentException("A sua classe não está anotada @Entity");
	      }
	      TypedQuery<T> listQuery = manager.createQuery(
	            "select o from " + clazz.getSimpleName() + " o", clazz);
	      TypedQuery<Number> countQuery = getPageCount(clazz, manager);

	      return list(listQuery, countQuery, currentPage, max);
	   }
}
