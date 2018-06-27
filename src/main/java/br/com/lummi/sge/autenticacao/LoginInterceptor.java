package br.com.lummi.sge.autenticacao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.lummi.sge.controllers.AuthController;
import br.com.lummi.sge.models.autenticacao.UsuarioLogado;

@Intercepts(before=PermissaoInterceptor.class)
@RequestScoped
public class LoginInterceptor {

	@Inject
	private HttpServletRequest request;
	@Inject
	private UsuarioLogado usuarioLogado;
	@Inject
    private Result result;
	private ControllerMethod metodo;
	private Properties properties;
	
	@AroundCall
    public void intercept(SimpleInterceptorStack stack) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			
		}
		if (usuarioLogado.isLogado()) {
			Get getAnnotation = metodo.getMethod().getAnnotation(Get.class);
			if (getAnnotation != null) {
				usuarioLogado.setUltimaFuncionalidade(obterIdFuncionalidade());
			}
			stack.next();
		} else {
			if (!metodo.getMethod().getAnnotation(Permissao.class).value().equals(PermissoesEnum.NULO)) {
				result.include("mensagem", "Não foi possível fornecer acesso. <br>Você deve estar autenticado para ter acesso.");
			}
			result.forwardTo(AuthController.class).index();		
		}
    }
	
	private String obterIdFuncionalidade() {
		String id = "SGD0000";
		Path annotation = metodo.getController().getType().getAnnotation(Path.class);
		if (annotation != null) {
			String[] valor = annotation.value();
			try {
				Enumeration<Object> chaves = getProperties().keys();
				while (chaves.hasMoreElements()) {
					String chave = chaves.nextElement().toString();
					if (Arrays.asList(valor).contains(getProperties().getProperty(chave))) {
						id = chave;
					}
				}
			} catch (IOException e) {}
		}
		return id;
	}

    private Properties getProperties() throws IOException {
    	if (properties == null) {
    		properties = new Properties();
    		FileInputStream file = new FileInputStream(this.getClass().getResource("/funcionalidades.properties").getFile());
    		properties.load(file);
    	}
    	return properties;

    }

	@Accepts
	public boolean accepts(ControllerMethod metodo){
		this.metodo = metodo;
		return metodo.containsAnnotation(Permissao.class);
	}
}
