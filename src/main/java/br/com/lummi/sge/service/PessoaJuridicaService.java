package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.PessoaJuridicaDao;
import br.com.lummi.sge.models.PessoaJuridica;
import br.com.lummi.sge.models.transiente.ItemLog;

public class PessoaJuridicaService extends AbstractLogService<PessoaJuridica> {

	@Inject
	PessoaJuridicaDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, PessoaJuridica anterior, PessoaJuridica atual) {

	}

	public PessoaJuridica getByCnpj(String cnpj) {
		return dao.getByCnpj(cnpj);
	}

	@Override
	public GenericDao<PessoaJuridica> getDao() {
		return dao;
	}

	public PessoaJuridica save(PessoaJuridica pessoaJuridica) {
		if (pessoaJuridica.getDadosBancarios() != null && (pessoaJuridica.getDadosBancarios().getBanco() == null
				|| pessoaJuridica.getDadosBancarios().getBanco().getId() == null)) {
			pessoaJuridica.getDadosBancarios().setBanco(null);
		}
		if (pessoaJuridica.getId() == null) {
			return dao.save(pessoaJuridica);
		} else {
			return dao.update(pessoaJuridica);
		}
	}

}
