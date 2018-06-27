package br.com.lummi.sge.autenticacao;

import br.com.lummi.sge.models.autenticacao.ZUsuario;

/**
 * 
 * @author davisousa
 *
 */
public interface AutenticacaoSOAP {

	public ZUsuario autenticacao(String nome, String senha) throws Exception;

	public ZUsuario getDadosFuncionario(String cpf) throws Exception;

	public String gerarToken(ZUsuario usuario) throws Exception;

	public String obterToken(ZUsuario usuario) throws Exception;

	public String redefinirSenha(ZUsuario usuario) throws Exception;

	public String alterarSenha(ZUsuario usuario) throws Exception;

	public String[][] getRecursos();
	
	public void sair();

	public String atualizarSenha(ZUsuario usuario) throws Exception;

}
