package br.com.lummi.sge.autenticacao;

import java.util.HashMap;

import javax.inject.Inject;

import br.com.caelum.vraptor.environment.Environment;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.mocks.Login;
import br.com.lummi.sge.models.autenticacao.ZUsuario;

public class AutenticacaoSOAPImpl implements AutenticacaoSOAP {
	
	@Inject
	ProvedorDeAutenticacao provedorAutenticacao;
	
	@Inject
	Environment environment;
	
	
	@Override
	public ZUsuario autenticacao(String nome, String senha) throws Exception {
		ZUsuario usuario = null;
//		if (environment.getName().equals("VTI")) {
			usuario = new Login().get(nome);
		return usuario;
	}

	@Override
	public String[][] getRecursos(){
		
		return null;
	}	
	
	@Override
	public void sair() {
	}

	@Override
	public String obterToken(ZUsuario usuario) throws Exception {
		return null;
	}

	@Override
	public String redefinirSenha(ZUsuario usuario) throws Exception {
		return null;
	}

	@Override
	public String alterarSenha(ZUsuario usuario) throws Exception {
		return null;
	}

	@Override
	public ZUsuario getDadosFuncionario(String cpf) throws Exception {
		return provedorAutenticacao.obterDadosFuncionario(cpf);
	}

	@Override
	public String gerarToken(ZUsuario usuario) throws Exception {
		HashMap<String, String> resultado = provedorAutenticacao.enviaEmailToken(usuario);
		String codigo = resultado.get("CODIGO_RETORNO");
		String mensagem = resultado.get("DESCRICAO_RETORNO");
		if (!"0".equals(codigo)) {
			throw new SgeException(mensagem);
		}
		return mensagem;
	}

	@Override
	public String atualizarSenha(ZUsuario usuario) throws Exception {
		HashMap<String, String> resultado = provedorAutenticacao.atualizarSenha(usuario);
		String codigo = resultado.get("CODIGO_RETORNO");
		String mensagem = resultado.get("DESCRICAO_RETORNO");
		if (!"0".equals(codigo)) {
			throw new SgeException(mensagem);
		}
		return mensagem;
	}

}
