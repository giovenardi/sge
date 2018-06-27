package br.com.lummi.sge.daos;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;

public class FuncionarioDao extends GenericDao<Funcionario> {

	@Inject
	private QueryPaginator queryPaginator;

	public PaginatedList findByFiltro(Funcionario funcionario, int currentPage, int max) {
        Criteria criteria = obterCriteriaFiltro(funcionario);
        return queryPaginator.list(Funcionario.class, criteria, currentPage, max,
                Order.asc("pessoa.nome"));
	}

	private Criteria obterCriteriaFiltro(Funcionario funcionario) {
		Criteria criteria = getSession().createCriteria(funcionario.getClass());
		criteria.createAlias("pessoa", "pessoa");
		if (funcionario.getPessoa() != null && funcionario.getPessoa().getNome() != null && funcionario.getPessoa().getNome().length() > 0) {
			criteria.add(Restrictions.ilike("pessoa.nome", "%" + funcionario.getPessoa().getNome() + "%"));
		}
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getCaptadores() {
		return getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.createAlias("cargo", "cargo")
				.add(Restrictions.eq("cargo.captador", true))
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getVendedores() {
		return getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.createAlias("cargo", "cargo")
				.add(Restrictions.eq("cargo.vendedor", true))
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getGerentes() {
		return getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.createAlias("cargo", "cargo")
				.add(Restrictions.eq("cargo.gerente", true))
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}

}
