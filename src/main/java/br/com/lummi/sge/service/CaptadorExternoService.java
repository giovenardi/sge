package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.CaptadorExternoDao;
import br.com.lummi.sge.models.CaptadorExterno;
import br.com.lummi.sge.models.Endereco;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.PessoaFisica;
import br.com.lummi.sge.models.transiente.ItemLog;

public class CaptadorExternoService extends AbstractLogService<CaptadorExterno> {

	@Inject
	CaptadorExternoDao dao;
	
	@Override
	public CaptadorExterno create(CaptadorExterno entity) {
		PessoaFisica pessoa = entity.getPessoa();
		Endereco endereco = pessoa.getEndereco();
		if (endereco.getUf() != null && endereco.getUf().getId() == null) {
			endereco.setUf(null);
		}
		if (endereco.getId() == null) {
			dao.getEntityManager().persist(endereco);
		} else {
			dao.getEntityManager().merge(endereco);
		}
		if (pessoa.getId() == null) {
			dao.getEntityManager().persist(pessoa);
		} else {
			dao.getEntityManager().merge(pessoa);
		}
		return dao.save(entity);
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, CaptadorExterno anterior, CaptadorExterno atual) {
		
	}

	public PaginatedList findByFiltro(CaptadorExterno captadorExterno, int page, int tamanho) {
		return dao.findByFiltro(captadorExterno, page, tamanho);
	}

	public CaptadorExternoDao getDao() {
		return dao;
	}

}
