package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.ProjetoDao;
import br.com.lummi.sge.daos.TurmaDao;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoCorporativo;
import br.com.lummi.sge.models.ProjetoCursoFormacao;
import br.com.lummi.sge.models.ProjetoFormatura;
import br.com.lummi.sge.models.ProjetoFormaturaEducaoInfantil;
import br.com.lummi.sge.models.ProjetoFormaturaFundamental;
import br.com.lummi.sge.models.ProjetoFormaturaFundamentalMedio;
import br.com.lummi.sge.models.ProjetoFormaturaMedio;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.ProjetoMarketing;
import br.com.lummi.sge.models.ProjetoSocial;
import br.com.lummi.sge.models.Turma;
import br.com.lummi.sge.models.Turno;
import br.com.lummi.sge.models.UnidadeInstituicao;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class TurmaService extends AbstractLogService<Turma> {

	private static final String ESPACO = " ";

	@Inject
	TurmaDao dao;

	@Inject
	ProjetoDao projetoDao;

	@Override
	public Turma create(Turma turma) {
		if (turma.getCurso() != null && turma.getCurso().getId() != null) {
			turma.setCurso(dao.getEntityManager().find(Curso.class, turma.getCurso().getId()));
		} else {
			turma.setCurso(null);
		}
		turma.setTurno(dao.getEntityManager().find(Turno.class, turma.getTurno().getId()));
		turma.setUnidadeInstituicao(
				dao.getEntityManager().find(UnidadeInstituicao.class, turma.getUnidadeInstituicao().getId()));
		// ProjetoFormatura projeto = (ProjetoFormatura)
		// dao.getEntityManager().find(turma.getProjeto().getClass(),
		// turma.getProjeto().getId());
		// turma.setProjeto(projeto);
		definirNomeTurma(turma);
		if (turma.getProjeto().getId() != null) {
			turma.setProjeto(projetoDao.getById(turma.getProjeto().getId()));
		}
		definirNomeProjeto(turma.getProjeto(), turma);
		return dao.save(turma);
	}

	public void delete(Turma turma) {
		Integer idProjeto = turma.getProjeto().getId();
		dao.delete(turma);
		ProjetoFormatura projeto = (ProjetoFormatura) projetoDao.getById(idProjeto);
		projeto.getTurmas().remove(turma);
		definirNomeProjeto(projeto, null);
	}

	private void definirNomeProjeto(Projeto projeto, Turma turmaNova) {
		StringBuffer nomeProjeto = new StringBuffer();
		StringBuffer cursos = new StringBuffer();
		StringBuffer niveis = new StringBuffer();
		StringBuffer instituicoes = new StringBuffer();
		StringBuffer semestres = new StringBuffer();
		StringBuffer turnos = new StringBuffer();
		StringBuffer numeros = new StringBuffer();
		ProjetoFormatura proj = (ProjetoFormatura) projeto;
		if (proj.getTurmas() != null) {
			for (Turma turma : proj.getTurmas()) {
				extrairDadosNome(cursos, niveis, instituicoes, semestres, turnos, numeros, turma);
			}
		}
		if (turmaNova != null) {
			extrairDadosNome(cursos, niveis, instituicoes, semestres, turnos, numeros, turmaNova);
		}
		nomeProjeto.append(cursos).append(niveis).append(instituicoes).append(semestres);
		// projeto = (ProjetoFormatura) dao.getEntityManager()
		// .find(getClasseProjeto(projeto.getContatoEvento().getTipoProjeto()),
		// projeto.getId());
		projeto.setNome(nomeProjeto.toString());
		dao.getEntityManager().merge(projeto);
	}

	/**
	 * @param tipo
	 * @return
	 */
	private Class getClasseProjeto(TipoProjetoEnum tipo) {
		switch (tipo) {
		case FORMATURA_FUNDAMENTAL:
			return ProjetoFormaturaFundamental.class;
		case FORMATURA_MEDIO:
			return ProjetoFormaturaMedio.class;
		case FORMATURA_FUNDAMENTAL_MEDIO:
			return ProjetoFormaturaFundamentalMedio.class;
		case FORMATURA_INFANTIL:
			return ProjetoFormaturaEducaoInfantil.class;
		case FORMATURA_SUPERIOR:
			return ProjetoFormaturaSuperior.class;
		case CORPORATIVO:
			return ProjetoCorporativo.class;
		case CURSO_FORMACAO:
			return ProjetoCursoFormacao.class;
		case MARKETING:
			return ProjetoMarketing.class;
		case SOCIAL:
			return ProjetoSocial.class;
		}
		return null;
	}

	private void extrairDadosNome(StringBuffer cursos, StringBuffer niveis, StringBuffer instituicoes,
			StringBuffer semestres,
			StringBuffer turnos, StringBuffer numeros, Turma turma) {
		if (turma.getCurso() != null) {
			cursos.append(turma.getCurso().getNome()).append(ESPACO);
		}
		if (turma.getNivel() != null) {
			niveis.append(turma.getNivel().name()).append(ESPACO);
		}
		instituicoes.append(turma.getUnidadeInstituicao().getInstituicao().getNome()).append(ESPACO);
		if (turma.getSemestre() != null && !turma.getSemestre().equals(SemestreEnum.ANUAL)) {
			semestres.append(turma.getSemestre().getDescricao()).append(ESPACO);
		}
		semestres.append(turma.getAno()).append(ESPACO);
		turnos.append(turma.getTurno().getNome()).append(ESPACO);
		if (turma.getNumero() != null) {
			numeros.append(turma.getNumero());
		}
	}

	private void definirNomeTurma(Turma turma) {
		StringBuffer sb = new StringBuffer();
		if (turma.getCurso() != null) {
			sb.append(turma.getCurso().getNome()).append(ESPACO);
		}
		if (turma.getNivel() != null) {
			sb.append(turma.getNivel().getDescricao()).append(ESPACO);
		}
		sb.append(turma.getUnidadeInstituicao().getInstituicao().getNome()).append(ESPACO);
		sb.append(turma.getUnidadeInstituicao().getNome()).append(ESPACO);
		if (turma.getSemestre() != null && !turma.getSemestre().equals(SemestreEnum.ANUAL)) {
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
