package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.SetorDao;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Setor;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class SetorService extends AbstractLogService<Setor> {

	@Inject
	SetorDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Setor anterior, Setor atual) {
		
	}

	public PaginatedList findByFiltro(Setor cargo, int page, int tamanho) {
		return dao.findByFiltro(cargo, page, tamanho);
	}

	@Override
	public GenericDao<Setor> getDao() {
		return dao;
	}

	public void alterar(Setor setor) throws SgeValidationException {
		validarSetor(setor);
		update(setor);
	}

	private void validarSetor(Setor setor) throws SgeValidationException {
		if (setor.getNome() == null || setor.getNome().trim().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

	public void novo(Setor setor) throws SgeValidationException {
		validarSetor(setor);
		create(setor);
	}

}
