package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.ContatoEventoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.enums.StatusEventoEnum;
import br.com.lummi.sge.models.ContatoEvento;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.transiente.ItemLog;

public class ContatoEventoService extends AbstractLogService<ContatoEvento> {

	@Inject
	ContatoEventoDao dao;

	@Override
	public ContatoEvento create(ContatoEvento contatoEvento) {
		limparCampos(contatoEvento);
		contatoEvento.setStatus(StatusEventoEnum.PRIMEIRO_CONTATO);
		return dao.save(contatoEvento);
	}

	@Override
	public ContatoEvento update(ContatoEvento contatoEvento) {
		limparCampos(contatoEvento);
		return dao.update(contatoEvento);
	}

	private void limparCampos(ContatoEvento contatoEvento) {
		if (contatoEvento.getFuncionarioBonificacao() != null
				&& contatoEvento.getFuncionarioBonificacao().getId() == null) {
			contatoEvento.setFuncionarioBonificacao(null);
		}
		if (contatoEvento.getFuncionarioComissao() != null && contatoEvento.getFuncionarioComissao().getId() == null) {
			contatoEvento.setFuncionarioComissao(null);
		}
		if (contatoEvento.getCaptadorBonificacao() != null && contatoEvento.getCaptadorBonificacao().getId() == null) {
			contatoEvento.setCaptadorBonificacao(null);
		}
		if (contatoEvento.getProjetoBonificacao() != null && contatoEvento.getProjetoBonificacao().getId() == null) {
			contatoEvento.setProjetoBonificacao(null);
		}
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, ContatoEvento anterior, ContatoEvento atual) {

	}

	public PaginatedList findByFiltro(ContatoEvento contatoEvento, int page, int tamanho) {
		return dao.findByFiltro(contatoEvento, page, tamanho);
	}

	@Override
	public GenericDao<ContatoEvento> getDao() {
		return dao;
	}

	/**
	 * @param contatoEvento
	 */
	public void solicitarAprovacao(ContatoEvento contatoEvento) {
		contatoEvento = dao.getById(contatoEvento.getId());
		contatoEvento.setStatus(StatusEventoEnum.CONFIRMAR_ATENDIMENTO);
		dao.update(contatoEvento);
	}

	/**
	 * @param contatoEvento
	 */
	public void aprovar(ContatoEvento contatoEvento) {
		Funcionario vendedor = dao.getEntityManager().find(
				Funcionario.class, contatoEvento.getVendedor().getId());
		contatoEvento = dao.getById(contatoEvento.getId());
		contatoEvento.setStatus(StatusEventoEnum.EM_ATENDIMENTO);
		contatoEvento.setVendedor(vendedor);
		dao.update(contatoEvento);
	}

	/**
	 * @param contatoEvento
	 */
	public void solicitarAtivacao(ContatoEvento contatoEvento) {
		contatoEvento = dao.getById(contatoEvento.getId());
		contatoEvento.setStatus(StatusEventoEnum.CONFIRMAR_ATIVACAO);
		dao.update(contatoEvento);
	}

	/**
	 * @param contatoEvento
	 * @return
	 */
	public Funcionario ativar(ContatoEvento contatoEvento) {
		Funcionario gerente = dao.getEntityManager().find(
				Funcionario.class, contatoEvento.getGerente().getId());
		contatoEvento = dao.getById(contatoEvento.getId());
		contatoEvento.setStatus(StatusEventoEnum.ATIVO);
		dao.update(contatoEvento);
		return gerente;
	}

}
