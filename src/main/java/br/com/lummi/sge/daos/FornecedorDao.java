package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Fornecedor;
import br.com.lummi.sge.models.PaginatedList;

public class FornecedorDao extends GenericDao<Fornecedor> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Fornecedor fornecedor, int currentPage, int max) {
		Criteria criteria = obterCriteriaFiltro(fornecedor);
		return queryPaginator.list(Fornecedor.class, criteria, currentPage, max, Order.asc("pessoa.nome"));
	}

	private Criteria obterCriteriaFiltro(Fornecedor fornecedor) {
		Criteria criteria = getSession().createCriteria(fornecedor.getClass());
		criteria.createAlias("pessoa", "pessoa");
		if (fornecedor.getPessoa() != null && fornecedor.getPessoa().getNome() != null
				&& fornecedor.getPessoa().getNome().length() > 0) {
			criteria.add(Restrictions.ilike("pessoa.nome", "%" + fornecedor.getPessoa().getNome() + "%"));
		}
		return criteria;
	}

	/**
	 * @param id
	 * @return
	 */
	public Integer buscarPorIdPessoa(Integer id) {
		return ((Number) getSession().createCriteria(Fornecedor.class).createAlias("pessoa", "pessoa")
				.add(Restrictions.eq("pessoa.id", id)).setProjection(Projections.count("id")).uniqueResult())
						.intValue();
	}

}
