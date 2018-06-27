package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.CargoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Cargo;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class CargoService extends AbstractLogService<Cargo> {

	@Inject
	CargoDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Cargo anterior, Cargo atual) {
		
	}

	public PaginatedList findByFiltro(Cargo cargo, int page, int tamanho) {
		return dao.findByFiltro(cargo, page, tamanho);
	}

	@Override
	public GenericDao<Cargo> getDao() {
		return dao;
	}

	public void alterar(Cargo cargo) throws SgeException {
		validarCargo(cargo);
		update(cargo);
	}

	private void validarCargo(Cargo cargo) throws SgeValidationException {
		if (cargo.getNome() == null || cargo.getNome().trim().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

}
