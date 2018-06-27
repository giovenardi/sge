package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FornecedorDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Fornecedor;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.transiente.ItemLog;

public class FornecedorService extends AbstractLogService<Fornecedor> {

	@Inject
	private FornecedorDao dao;

	@Override
	public Fornecedor create(Fornecedor fornecedor) {
		return dao.save(fornecedor);
	}

	@Override
	public Fornecedor update(Fornecedor fornecedor) {
		return dao.update(fornecedor);
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Fornecedor anterior, Fornecedor atual) {

	}

	public PaginatedList findByFiltro(Fornecedor fornecedor, int page, int tamanho) {
		return dao.findByFiltro(fornecedor, page, tamanho);
	}

	@Override
	public GenericDao<Fornecedor> getDao() {
		return dao;
	}

	/**
	 * @param id
	 * @return
	 */
	public Integer buscarPorIdPessoa(Integer id) {
		return dao.buscarPorIdPessoa(id);
	}

}
