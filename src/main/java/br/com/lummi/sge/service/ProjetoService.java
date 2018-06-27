package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.ProjetoDao;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.transiente.ItemLog;

public class ProjetoService extends AbstractLogService<Projeto> {

	@Inject
	ProjetoDao dao;
	
	public Projeto create(Projeto entity, Class<?> clazz) throws SgeException {
		return dao.create(entity, clazz);
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Projeto anterior, Projeto atual) {
		
	}

	public PaginatedList findByFiltro(Projeto projeto, int page, int tamanho) {
		return dao.findByFiltro(projeto, page, tamanho);
	}

	@Override
	public GenericDao<Projeto> getDao() {
		return dao;
	}

}
