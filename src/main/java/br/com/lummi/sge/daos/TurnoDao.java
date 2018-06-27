package br.com.lummi.sge.daos;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Turno;

public class TurnoDao extends GenericDao<Turno> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Turno turno, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(turno);
        return queryPaginator.list(Funcionario.class, criteria, currentPage, max,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(Turno turno) {
		Criteria criteria = getSession().createCriteria(turno.getClass());
		if (turno != null && turno.getNome() != null && turno.getNome().length() > 0) {
			criteria.add(Restrictions.ilike("nome", "%"+turno.getNome()+"%"));
		}
		if (turno != null && turno.getSigla() != null && turno.getSigla().length() > 0) {
			criteria.add(Restrictions.ilike("sigla", "%"+turno.getSigla()+"%"));
		}
		return criteria;
	}

}
