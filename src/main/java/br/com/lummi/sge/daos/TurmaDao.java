package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Turma;

public class TurmaDao extends GenericDao<Turma> {

	@SuppressWarnings("unchecked")
	public List<Turma> findByIdProjeto(Integer idProjeto) {
		return getSession().createCriteria(Turma.class)
				.createAlias("projeto", "projeto")
				.add(Restrictions.eq("projeto.id", idProjeto))
				.list();
	}

}
