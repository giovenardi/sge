package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Setor;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;

public class SetorDao extends GenericDao<Setor> {
	
	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Setor setor, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(setor);
        return queryPaginator.list(Funcionario.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(Setor setor) {
		Criteria criteria = getSession().createCriteria(setor.getClass());
		if (setor != null && setor.getNome() != null && setor.getNome().length() > 0) {
			criteria.add(Restrictions.ilike("nome", "%"+setor.getNome()+"%"));
		}
		return criteria;
	}

}
