package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FuncionarioDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.transiente.ItemLog;

public class FuncionarioService extends AbstractLogService<Funcionario> {

	@Inject
	private FuncionarioDao dao;

	@Override
	public Funcionario create(Funcionario funcionario) {
		return dao.save(funcionario);
	}

	@Override
	public Funcionario update(Funcionario funcionario) {
		return dao.update(funcionario);
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Funcionario anterior, Funcionario atual) {

	}

	// public PaginatedList findByFiltro(Funcionario funcionario, int page, int
	// tamanho) {
	// return dao.findByFiltro(funcionario, page, tamanho);
	// }

	public List<Funcionario> getCaptadores() {
		return dao.getCaptadores();
	}

	public List<Funcionario> getVendedores() {
		return dao.getVendedores();
	}

	public List<Funcionario> getGerentes() {
		return dao.getGerentes();
	}

	@Override
	public GenericDao<Funcionario> getDao() {
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
