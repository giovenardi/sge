package br.com.lummi.sge.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.FormaCaptacao;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;

public class FormaCaptacaoDao extends GenericDao<FormaCaptacao> {

	@Inject
	private QueryPaginator queryPaginator;

	@SuppressWarnings("unchecked")
	@Override
	public List<FormaCaptacao> findAll() {
		EntityManager entityManager = getEntityManager();
        return entityManager.createQuery(("FROM FormaCaptacao order by nome" )).getResultList();
	}

	public PaginatedList findByFiltro(FormaCaptacao formaCaptacao, int page, int tamanho) {
        Criteria criteria = obterCriteriaFiltro(formaCaptacao);
        return queryPaginator.list(Funcionario.class, criteria, page, tamanho,
                Order.asc("nome"));
	}

	private Criteria obterCriteriaFiltro(FormaCaptacao formaCaptacao) {
		Criteria criteria = getSession().createCriteria(formaCaptacao.getClass());
		if (formaCaptacao != null && formaCaptacao.getNome() != null && formaCaptacao.getNome().length() > 0) {
			criteria.add(Restrictions.ilike("nome", "%"+formaCaptacao.getNome()+"%"));
		}
		return criteria;
	}
	
}
