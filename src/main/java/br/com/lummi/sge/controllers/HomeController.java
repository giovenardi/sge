package br.com.lummi.sge.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.autenticacao.Permissao;
import br.com.lummi.sge.autenticacao.PermissoesEnum;

@Controller
public class HomeController {

	private Properties properties;
	
	@Inject
	private Result result;
	
//	@Inject
//	private HttpServletRequest request;
	
	@Get
    @Path("/teste")
    @Permissao(PermissoesEnum.NULO)
    public void teste() {
    }

	@Get
    @Path("/")
    @Permissao(PermissoesEnum.NULO)
    public void index() {
    }

    @Path("/buscarFuncionalidade")
    @Permissao(PermissoesEnum.NULO)
    public void buscarFuncionalidade(String func) {
    	try {
    		if (func == null) {
    			func = "";
    		}
    		Integer numero = getInteger(func);
			if (numero != null && numero < 10000) { 
    			func = formatarNome(numero);
    		}
			String url = getProperties().getProperty(func.toUpperCase());
			if (url == null) {
				result.include("error", "Funcionalidade não localizada.");
				result.redirectTo("/");
			} else {
				result.redirectTo(url);
			}
		} catch (IOException e) {
		}
    	result.use(Results.nothing());
    }
    
    private String formatarNome(Integer numero) {
    	String codigo = new Integer(10000 + numero).toString();
		return "SGD" + codigo.substring(1);
	}

	private Integer getInteger(String func) {
    	Integer numero = null;
    	try {
    		numero = new Integer(func);
    	} catch (NumberFormatException e) {
    		
    	}
		return numero;
	}

	private Properties getProperties() throws IOException {
    	if (properties == null) {
    		properties = new Properties();
    		FileInputStream file = new FileInputStream(this.getClass().getResource("/funcionalidades.properties").getFile());
    		properties.load(file);
    	}
    	return properties;

    }
}