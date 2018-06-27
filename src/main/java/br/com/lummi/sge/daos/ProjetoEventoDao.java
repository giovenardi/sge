package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.ProjetoEvento;
import br.com.lummi.sge.models.Turma;

public class ProjetoEventoDao extends GenericDao<ProjetoEvento> {

	@SuppressWarnings("unchecked")
	public List<ProjetoEvento> findByIdProjeto(Integer idProjeto) {
		return getSession().createCriteria(Turma.class)
				.createAlias("projeto", "projeto")
				.add(Restrictions.eq("projeto.id", idProjeto))
				.list();
	}

}
