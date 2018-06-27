package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.BancoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Banco;
import br.com.lummi.sge.models.transiente.ItemLog;

public class BancoService extends AbstractLogService<Banco> {

	@Inject
	private BancoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Banco anterior, Banco atual) {
		
	}

	@Override
	public GenericDao<Banco> getDao() {
		return dao;
	}

}
