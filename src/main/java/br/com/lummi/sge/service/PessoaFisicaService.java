package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.PessoaFisicaDao;
import br.com.lummi.sge.models.PessoaFisica;
import br.com.lummi.sge.models.transiente.ItemLog;

public class PessoaFisicaService extends AbstractLogService<PessoaFisica> {

	@Inject
	PessoaFisicaDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, PessoaFisica anterior, PessoaFisica atual) {
		
	}

	public PessoaFisica getByCpf(String cpf) {
		return dao.getByCpf(cpf);
	}

	@Override
	public GenericDao<PessoaFisica> getDao() {
		return dao;
	}

	public PessoaFisica save(PessoaFisica pessoaFisica) {
		if (pessoaFisica.getDadosBancarios() != null && (pessoaFisica.getDadosBancarios().getBanco() == null || pessoaFisica.getDadosBancarios().getBanco().getId() == null )) {
			pessoaFisica.getDadosBancarios().setBanco(null);
		}
		if (pessoaFisica.getId() == null) {
			return dao.save(pessoaFisica);
		} else {
			return dao.update(pessoaFisica);
		}
	}

}
