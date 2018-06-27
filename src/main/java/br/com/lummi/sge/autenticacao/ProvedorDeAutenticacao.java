package br.com.lummi.sge.autenticacao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.inject.Inject;

import br.com.lummi.sge.clients.IdentidadeSoapClient;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.autenticacao.ZUsuario;
import br.com.lummi.sge.utils.Mensagens;

public class ProvedorDeAutenticacao {
	
	private ZUsuario usuario;
	
	@Inject
	private IdentidadeSoapClient client;
	
	public ZUsuario obterDadosFuncionario(String cpf) throws Exception {
		ZUsuario usuario = new ZUsuario();
		HashMap<String, String> dadosFuncionario = client.getDadosFuncionario(cpf);
		try {
			usuario.setIdentidadedetran(Long.parseLong(dadosFuncionario.get("CODIGOUSUARIO")));
		} catch (NumberFormatException e) {
			throw new SgeException(Mensagens.MSG_CPF_NAO_ENCONTRADO);
		}
		usuario.setMatricula(dadosFuncionario.get("MATRICULA"));
		usuario.setLotacao(dadosFuncionario.get("LOTACAO"));
		usuario.setNomecompleto(dadosFuncionario.get("FUNCIONARIO"));
		usuario.setEmail(dadosFuncionario.get("EMAIL"));
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
			throw new SgeException(Mensagens.MSG_EMAIL_NAO_CADASTRADO);
		}
		return usuario;
	}
	
	public HashMap<String, String> enviaEmailToken(ZUsuario usuario) throws Exception {
		return client.enviaEmailToken(usuario);
	}
	
	public ZUsuario autenticacao(String usuario, String senha) throws Exception {
		
		this.usuario = null;
		
		HashMap<String, String> hashUsuario = this.client.getValidaUsuario(usuario, this.encSenha(senha));
		
		
		if(hashUsuario.get("USUCODIGO_PK") != null){
			
			this.usuario = new ZUsuario();
			
			HashMap<String, String> hash = this.client.getFuncionarioUsuario(hashUsuario.get("USUCODIGO_PK"));

			this.usuario.setNome(hash.get("LOGIN"));
			this.usuario.setSenha("");
			this.usuario.setCpf(hash.get("CPF"));
			this.usuario.setEmail(hash.get("EMAIL"));
			this.usuario.setNomecompleto(hash.get("NOME"));
			this.usuario.setLotacao(hash.get("DESCLOTACAO"));
			
			Long idDetran = Long.parseLong(hash.get("USUCODIGO_PK"),10);
			
		    this.usuario.setIdentidadedetran(idDetran);
		    
		    this.usuario.setUltimoAcesso(new Date());

		    ArrayList<HashMap<String, String>> recursos = client.getRetornaRecursosAll(hash.get("USUCODIGO_PK"));
		    
		    ArrayList<String> permissoes = new ArrayList<String>();
		    
		    for(HashMap<String, String> permissao:recursos){
		    	
		    	if(permissao.get("METODO") != null 
		        && permissao.get("METODO").toUpperCase().substring(0, 4).equals("SGD|")){
		    		permissoes.add(permissao.get("METODO"));
		    	}
		    	
		    }
		    
		    this.usuario.adicionarPermissoes(permissoes);
			
		}
		
		return this.usuario;
	}
	
	public static void main(String[] args) {
		ProvedorDeAutenticacao prov = new ProvedorDeAutenticacao();
		System.out.println(prov.encSenha("teste"));
	}
	
	private String encSenha(String senha){

        String valor = null;

		try {
			   String prefixo = "qp10zm29";
			   
			   
			   MessageDigest md = MessageDigest.getInstance("MD5") ;
			   byte[] digest = md.digest((prefixo + senha).toUpperCase().getBytes());
			   BigInteger big = new BigInteger(1,digest);
			   valor = big.toString(16).toUpperCase();
			   
		  } catch (NoSuchAlgorithmException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		
		return valor;
		
	}

	public HashMap<String, String> atualizarSenha(ZUsuario usuario) throws Exception {
		return client.atualizarSenha(usuario.getIdentidadedetran().toString(), encSenha(usuario.getSenha()));
	}
	
	
	
}
