package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.InstituicaoDao;
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.transiente.ItemLog;

public class InstituicaoService extends AbstractLogService<Instituicao> {
	
	@Inject
	InstituicaoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Instituicao anterior, Instituicao atual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericDao<Instituicao> getDao() {
		return dao;
	}

	public PaginatedList findByFiltro(Instituicao instituicao, int page, int tamanho) {
		return dao.findByFiltro(instituicao, page, tamanho);
	}

}
