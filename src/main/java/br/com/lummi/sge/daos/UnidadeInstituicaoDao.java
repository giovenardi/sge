package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.UnidadeInstituicao;

public class UnidadeInstituicaoDao extends GenericDao<UnidadeInstituicao> {

	@SuppressWarnings("unchecked")
	public List<UnidadeInstituicao> findByInstituicao(Instituicao instituicao) {
		return getSession().createCriteria(UnidadeInstituicao.class)
				.createAlias("instituicao", "instituicao")
				.add(Restrictions.eq("instituicao.id", instituicao.getId()))
				.list();
	}
}
