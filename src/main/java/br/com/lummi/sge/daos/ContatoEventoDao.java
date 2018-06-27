package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.ContatoEvento;
import br.com.lummi.sge.models.PaginatedList;

public class ContatoEventoDao extends GenericDao<ContatoEvento> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(ContatoEvento contatoEvento, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(contatoEvento);

        return queryPaginator.list(ContatoEvento.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(ContatoEvento contatoEvento) {
		Criteria criteria = getSession().createCriteria(contatoEvento.getClass());
		if (contatoEvento != null) {
			if (contatoEvento.getTipoProjeto() != null) {
				criteria.add(Restrictions.eq("tipoProjeto", contatoEvento.getTipoProjeto()));
			}
			if (contatoEvento.getStatus() != null) {
				criteria.add(Restrictions.eq("status", contatoEvento.getStatus()));
			}
		}
		return criteria;
	}

}
