package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.CaptadorExterno;
import br.com.lummi.sge.models.PaginatedList;

public class CaptadorExternoDao extends GenericDao<CaptadorExterno> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(CaptadorExterno captadorExterno, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(captadorExterno);
        return queryPaginator.list(CaptadorExterno.class, criteria, currentPage, max, Order.asc("pessoa.nome"));
	}

	private Criteria obterCriteriaFiltro(CaptadorExterno captadorExterno) {
		Criteria criteria = getSession().createCriteria(captadorExterno.getClass());
		criteria.createAlias("pessoa", "pessoa");
		if (captadorExterno.getPessoa() != null && captadorExterno.getPessoa().getNome() != null && captadorExterno.getPessoa().getNome().length() > 0) {
			criteria.add(Restrictions.ilike("pessoa.nome", "%" + captadorExterno.getPessoa().getNome() + "%"));
		}
		return criteria;
	}

}
