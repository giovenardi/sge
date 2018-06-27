package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;

public class CursoDao extends GenericDao<Curso> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Curso curso, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(curso);
        return queryPaginator.list(Funcionario.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(Curso curso) {
		Criteria criteria = getSession().createCriteria(curso.getClass());
		if (curso != null && curso.getNome() != null && curso.getNome().length() > 0) {
			criteria.add(Restrictions.ilike("nome", "%"+curso.getNome()+"%"));
		}
		return criteria;
	}

}
