package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.FormaPagamento;
import br.com.lummi.sge.models.PlanoPagamento;

public class FormaPagamentoDao extends GenericDao<FormaPagamento> {

	@SuppressWarnings("unchecked")
	public List<FormaPagamento> findByIdPlano(Integer idPlano) {
		return getSession().createCriteria(PlanoPagamento.class)
				.createAlias("planoPagamento", "planoPagamento")
				.add(Restrictions.eq("planoPagamento.id", idPlano))
				.list();
	}

}
