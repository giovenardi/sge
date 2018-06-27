package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FormandoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Formando;
import br.com.lummi.sge.models.transiente.ItemLog;

public class FormandoService extends AbstractLogService<Formando> {

	@Inject
	private FormandoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Formando anterior, Formando atual) {
		// TODO Auto-generated method stub

	}

	@Override
	public GenericDao<Formando> getDao() {
		return dao;
	}

	/**
	 * @param id
	 * @return
	 */
	public List<Formando> listarPorProjetoId(Integer id) {
		return dao.listarPorProjetoId(id);
	}

}
