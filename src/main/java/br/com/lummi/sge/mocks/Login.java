package br.com.lummi.sge.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import br.com.lummi.sge.autenticacao.PermissoesEnum;
import br.com.lummi.sge.models.autenticacao.ZUsuario;

public class Login {
	
	public static void main(String[] args) {
		String[] split = "SGD|FINANCEIRO|TAXASELIC|IMPRIMIR_HISTORICO".split("\\|");
		System.out.println(split);
	}
	private static final HashMap<String, ZUsuario> mapa = new HashMap<String, ZUsuario>();
	{
		ZUsuario usuario = new ZUsuario();
		usuario.setNome("luiz");
		usuario.setSenha("");
		usuario.setCpf("533.388.559-15");
		usuario.setLotacao("DETRAN");
		usuario.setEmail("giovenardi@gmail.com");
		usuario.setNomecompleto("Luiz Fernando Giovenardi");
		Long idDetran = Long.parseLong("12344",10);
	    usuario.setIdentidadedetran(idDetran);
	    usuario.setUltimoAcesso(new Date());
	    PermissoesEnum[] values = PermissoesEnum.values();
	    ArrayList<String> permissoes = new ArrayList<>();
		for(PermissoesEnum valor : values){
			permissoes .add(valor.getNome());
	    }
	    usuario.adicionarPermissoes(permissoes);
	    mapa.put("luiz", usuario);

	    usuario = new ZUsuario();
		usuario.setNome("suporte");
		usuario.setSenha("");
		usuario.setCpf("533.388.559-15");
		usuario.setLotacao("DETRAN");
		usuario.setEmail("giovenardi@gmail.com");
		usuario.setNomecompleto("suporte");
		idDetran = Long.parseLong("12354",10);
	    usuario.setIdentidadedetran(idDetran);
	    usuario.setUltimoAcesso(new Date());
	    usuario.adicionarPermissoes(permissoes);
	    mapa.put("suporte", usuario);
		
	    usuario = new ZUsuario();
		usuario.setNome("davi");
		usuario.setSenha("");
		usuario.setCpf("533.388.559-15");
		usuario.setLotacao("DETRAN");
		usuario.setEmail("giovenardi@gmail.com");
		usuario.setNomecompleto("Davi Felipe");
		idDetran = Long.parseLong("12345",10);
	    usuario.setIdentidadedetran(idDetran);
	    usuario.setUltimoAcesso(new Date());
	    usuario.adicionarPermissoes(permissoes);
	    mapa.put("davi", usuario);
	}

	public ZUsuario get(String chave) {
		return mapa.get(chave);
	}
}
