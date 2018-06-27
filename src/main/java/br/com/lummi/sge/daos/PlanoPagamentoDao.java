package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.PlanoPagamento;

public class PlanoPagamentoDao extends GenericDao<PlanoPagamento> {

	@SuppressWarnings("unchecked")
	public List<PlanoPagamento> findByIdProjeto(Integer idProjeto) {
		return getSession().createCriteria(PlanoPagamento.class)
				.createAlias("projeto", "projeto")
				.add(Restrictions.eq("projeto.id", idProjeto))
				.list();
	}

}
