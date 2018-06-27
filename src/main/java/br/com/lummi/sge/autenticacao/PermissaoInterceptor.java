package br.com.lummi.sge.autenticacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.lummi.sge.controllers.HomeController;
import br.com.lummi.sge.models.autenticacao.UsuarioLogado;

@Intercepts
@RequestScoped
public class PermissaoInterceptor {

	@Inject
	private UsuarioLogado usuarioLogado;
	@Inject
	private ControllerMethod metodo;
	@Inject
    private Result result;
	
	@AroundCall
    public void intercept(SimpleInterceptorStack stack) {
		Permissao annotation = metodo.getMethod().getAnnotation(Permissao.class);
		if (annotation.value().equals(PermissoesEnum.NULO) || usuarioLogado.getUsuario().temPermissao(((PermissoesEnum)annotation.value()).getNome())) {
			stack.next();
		} else {
			result.include("warning", "Não foi possível fornecer acesso. Sem permissão para acessar esse recurso.");
			result.forwardTo(HomeController.class).index();		
		}
    }
	
	@Accepts
	public boolean accepts(ControllerMethod metodo){
		return metodo.containsAnnotation(Permissao.class);
	}
	
}
