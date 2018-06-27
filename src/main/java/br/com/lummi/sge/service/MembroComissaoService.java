/**
 * 
 */
package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.MembroComissaoDao;
import br.com.lummi.sge.models.MembroComissao;
import br.com.lummi.sge.models.transiente.ItemLog;

/**
 * @author luizfernando
 */
public class MembroComissaoService extends AbstractLogService<MembroComissao> {

	@Inject
	private MembroComissaoDao dao;
	@Inject
	private ComissaoFormaturaService comissaoFormaturaService;
	@Inject
	private PessoaService pessoaService;
	@Inject
	private FuncaoComissaoService funcaoComissaoService;

	@Override
	public MembroComissao update(MembroComissao membroComissao) {
		membroComissao
				.setComissaoFormatura(comissaoFormaturaService.getById(membroComissao.getComissaoFormatura().getId()));
		membroComissao.setPessoa(pessoaService.getById(membroComissao.getPessoa().getId()));
		membroComissao.setFuncao(funcaoComissaoService.getById(membroComissao.getFuncao().getId()));
		return super.update(membroComissao);
	}

	@Override
	public MembroComissao create(MembroComissao membroComissao) {
		membroComissao
				.setComissaoFormatura(comissaoFormaturaService.getById(membroComissao.getComissaoFormatura().getId()));
		membroComissao.setPessoa(pessoaService.getById(membroComissao.getPessoa().getId()));
		membroComissao.setFuncao(funcaoComissaoService.getById(membroComissao.getFuncao().getId()));
		return super.create(membroComissao);
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, MembroComissao anterior, MembroComissao atual) {
		// TODO Auto-generated method stub

	}

	@Override
	public GenericDao<MembroComissao> getDao() {
		return dao;
	}

}
