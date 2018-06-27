package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.TurmaDao;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.Turma;
import br.com.lummi.sge.models.Turno;
import br.com.lummi.sge.models.UnidadeInstituicao;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class TurmaService extends AbstractLogService<Turma> {

	private static final String ESPACO = " ";
	
	@Inject
	TurmaDao dao; 
	
	@Override
	public Turma create(Turma turma) {
		turma.setCurso(dao.getEntityManager().find(Curso.class, turma.getCurso().getId()));
		turma.setTurno(dao.getEntityManager().find(Turno.class, turma.getTurno().getId()));
		turma.setUnidadeInstituicao(dao.getEntityManager().find(UnidadeInstituicao.class, turma.getUnidadeInstituicao().getId()));
		ProjetoFormaturaSuperior projeto = dao.getEntityManager().find(ProjetoFormaturaSuperior.class, turma.getProjeto().getId());
		turma.setProjeto(projeto);
		definirNomeTurma(turma);
		definirNomeProjeto(projeto, turma.getNome());
		return dao.save(turma);
	}

	private void definirNomeProjeto(ProjetoFormaturaSuperior projeto, String nomeTurma) {
		String nomeProjeto = "";
		for (Turma turma : projeto.getTurmas()) {
			nomeProjeto += turma.getNome() + " ";
		}
		nomeProjeto += nomeTurma;
		projeto.setNome(nomeProjeto);
		dao.getEntityManager().merge(projeto);
	}

	private void definirNomeTurma(Turma turma) {
		StringBuffer sb = new StringBuffer(turma.getCurso().getNome()).append(ESPACO);
		sb.append(turma.getUnidadeInstituicao().getInstituicao().getNome()).append(ESPACO);
		sb.append(turma.getUnidadeInstituicao().getNome()).append(ESPACO);
		if (!turma.getSemestre().equals(SemestreEnum.ANUAL)) {
			sb.append(turma.getSemestre().getDescricao()).append("/");
		}
		sb.append(turma.getAno()).append(ESPACO);
		sb.append(turma.getTurno().getNome()).append(ESPACO);
		if (turma.getNumero() != null) {
			sb.append(turma.getNumero());
		}
		turma.setNome(sb.toString());
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Turma anterior, Turma atual) {
		
	}

	public List<Turma> findByIdProjeto(Integer idProjeto) throws SgeException {
		List<Turma> turmas = dao.findByIdProjeto(idProjeto);
		if (turmas.size() == 0) {
			throw new SgeException(Mensagens.MSG_NENHUM_REGISTRO);
		}
		return turmas;
	}

	@Override
	public GenericDao<Turma> getDao() {
		return dao;
	}

}
