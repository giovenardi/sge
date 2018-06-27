package br.com.lummi.sge.daos;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.PessoaJuridica;

public class PessoaJuridicaDao extends GenericDao<PessoaJuridica> {

	public PessoaJuridica getByCnpj(String cnpj) {
		return (PessoaJuridica) getSession().createCriteria(PessoaJuridica.class).add(Restrictions.eq("cnpj", cnpj))
				.uniqueResult();
	}

}
