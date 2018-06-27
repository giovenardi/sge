package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FormaCaptacaoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.FormaCaptacao;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.transiente.ItemLog;

public class FormaCaptacaoService extends AbstractLogService<FormaCaptacao> {

	@Inject
	FormaCaptacaoDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, FormaCaptacao anterior, FormaCaptacao atual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericDao<FormaCaptacao> getDao() {
		return dao;
	}

	public PaginatedList findByFiltro(FormaCaptacao formaCaptacao, int page, int tamanho) {
		return dao.findByFiltro(formaCaptacao, page, tamanho);
	}

}
