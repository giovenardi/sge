package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.PessoaJuridica;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.PessoaJuridicaService;

@Controller
@Path("/pessoaJuridica")
public class PessoaJuridicaController {

	@Inject
	private Result result;

	@Inject
	private PessoaJuridicaService service;

	@Get
	@Path("/buscarPorId/{id}")
	public void buscarPorId(Integer id) throws SgeException {
		RetornoJson<PessoaJuridica> retornoJson = new RetornoJson<PessoaJuridica>();
		PessoaJuridica pessoa = service.getById(id);
		retornoJson.setObj(pessoa);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.endereco", "?obj.endereco.uf",
				"?obj.dadosBancarios", "?obj.dadosBancarios.banco").serialize();
	}

	@Get
	@Path("/buscarPorCNPJ/{cnpj}/{filial}")
	public void buscarPorCPF(String cnpj, String filial) throws SgeException {
		RetornoJson<PessoaJuridica> retornoJson = new RetornoJson<PessoaJuridica>();
		PessoaJuridica pessoa = service.getByCnpj(cnpj + filial);
		if (pessoa == null) {
			pessoa = new PessoaJuridica();
			pessoa.setCnpj(cnpj);
		}
		retornoJson.setObj(pessoa);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.endereco", "?obj.endereco.uf",
				"?obj.dadosBancarios", "?obj.dadosBancarios.banco").serialize();
		;

	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(PessoaJuridica pessoa) {
		RetornoJson<PessoaJuridica> retornoJson = new RetornoJson<PessoaJuridica>();
		pessoa = service.save(pessoa);
		retornoJson.setObj(pessoa);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.endereco", "?obj.endereco.uf",
				"?obj.dadosBancarios", "?obj.dadosBancarios.banco").serialize();
		;
	}

}