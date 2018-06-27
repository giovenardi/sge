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
import br.com.lummi.sge.models.PessoaFisica;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.PessoaFisicaService;

@Controller
@Path("/pessoaFisica")
public class PessoaFisicaController {

	@Inject
	private Result result;
	
	@Inject
	private PessoaFisicaService service;

	@Get
    @Path("/buscarPorCPF/{cpf}")
    public void buscarPorCPF(String cpf) throws SgeException {
		RetornoJson<PessoaFisica> retornoJson = new RetornoJson<PessoaFisica>();
		PessoaFisica pessoa = service.getByCpf(cpf);
		if (pessoa == null) {
			pessoa = new PessoaFisica();
			pessoa.setCpf(cpf);
		}
		retornoJson.setObj(pessoa);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.endereco", "?obj.endereco.uf", "?obj.dadosBancarios", "?obj.dadosBancarios.banco").serialize();;
		
    }

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(PessoaFisica pessoa) {
		RetornoJson<PessoaFisica> retornoJson = new RetornoJson<PessoaFisica>();
		pessoa = service.save(pessoa);
		retornoJson.setObj(pessoa);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.endereco", "?obj.endereco.uf", "?obj.dadosBancarios", "?obj.dadosBancarios.banco").serialize();;
	}

}