package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Projeto;

public class ProjetoDao extends GenericDao<Projeto> {


	@Inject
	private QueryPaginator queryPaginator;

	public Projeto create(Projeto entity, Class<?> clazz) {
		getEntityManager().persist(clazz.cast(entity));
		getEntityManager().flush();
		return entity;
	}

	public PaginatedList findByFiltro(Projeto projeto, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(projeto);
        return queryPaginator.list(Projeto.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(Projeto projeto) {
		Criteria criteria = getSession().createCriteria(Projeto.class);
		return criteria;
	}

}
