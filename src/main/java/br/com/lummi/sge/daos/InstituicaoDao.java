package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.PaginatedList;

public class InstituicaoDao extends GenericDao<Instituicao> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Instituicao instituicao, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(instituicao);
        return queryPaginator.list(Funcionario.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(Instituicao instituicao) {
		Criteria criteria = getSession().createCriteria(instituicao.getClass());
		if (instituicao != null && instituicao.getNome() != null && instituicao.getNome().length() > 0) {
			criteria.add(Restrictions.ilike("nome", "%"+instituicao.getNome()+"%"));
		}
		if (instituicao != null && instituicao.getNomeCompleto() != null && instituicao.getNomeCompleto().length() > 0) {
			criteria.add(Restrictions.ilike("nomeCompleto", "%"+instituicao.getNomeCompleto()+"%"));
		}
		return criteria;
	}

}
