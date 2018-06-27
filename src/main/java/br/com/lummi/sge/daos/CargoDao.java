package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Cargo;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;

public class CargoDao extends GenericDao<Cargo> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Cargo cargo, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(cargo);
        return queryPaginator.list(Funcionario.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(Cargo cargo) {
		Criteria criteria = getSession().createCriteria(cargo.getClass());
		if (cargo != null && cargo.getNome() != null && cargo.getNome().length() > 0) {
			criteria.add(Restrictions.ilike("nome", "%"+cargo.getNome()+"%"));
		}
		return criteria;
	}

}
