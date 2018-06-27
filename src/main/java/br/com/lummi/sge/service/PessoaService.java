package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.PessoaDao;
import br.com.lummi.sge.models.Pessoa;
import br.com.lummi.sge.models.transiente.ItemLog;

public class PessoaService extends AbstractLogService<Pessoa> {

	@Inject
	PessoaDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Pessoa anterior, Pessoa atual) {

	}

	@Override
	public GenericDao<Pessoa> getDao() {
		return dao;
	}

}
