package br.com.lummi.sge.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.lummi.sge.models.FormaCaptacao;

public class FormaCaptacaoDao extends GenericDao<FormaCaptacao> {

	@SuppressWarnings("unchecked")
	@Override
	public List<FormaCaptacao> findAll() {
		EntityManager entityManager = getEntityManager();
        return entityManager.createQuery(("FROM FormaCaptacao order by nome" )).getResultList();
	}

}
