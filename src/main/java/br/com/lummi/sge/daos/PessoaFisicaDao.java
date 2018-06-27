package br.com.lummi.sge.daos;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.PessoaFisica;

public class PessoaFisicaDao extends GenericDao<PessoaFisica> {

	public PessoaFisica getByCpf(String cpf) {
		return (PessoaFisica) getSession().createCriteria(PessoaFisica.class)
				.add(Restrictions.eq("cpf", cpf)).uniqueResult();
	}

}
