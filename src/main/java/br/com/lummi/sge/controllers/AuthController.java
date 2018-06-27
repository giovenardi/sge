package br.com.lummi.sge.controllers;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.autenticacao.AutenticacaoSOAP;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Usuario;
import br.com.lummi.sge.models.autenticacao.UsuarioLogado;
import br.com.lummi.sge.service.UsuarioService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/auth")
@Controller
public class AuthController {

	// @Inject
	// private AutenticacaoSOAP autenticacaoSoap;

	@Inject
	private UsuarioLogado usuarioLogado;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private Result result;

	// @Inject
	// private HttpServletRequest request;

	public AuthController(final AutenticacaoSOAP autenticacao, final UsuarioLogado usuarioLogado, final Result result) {
		// this.autenticacaoSoap = autenticacao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}

	public AuthController() {

	}

	@Get
	@Path("")
	public void index() {
		// result.redirectTo(AlgumController.class).list();

	}

	@Get
	@Path({ "redefinir/", "redefinir" })
	public void redefinir() {

	}

	// @Post
	// @Path({"redefinir/", "redefinir"})
	// public void redefinir(Usuario usuario) {
	// result.include("usuario", usuario);
	// PessoaFisica pessoaFisica =
	// (PessoaFisica)usuario.getFuncionario().getPessoa();
	// if (pessoaFisica == null || pessoaFisica.getCpf() == null ||
	// pessoaFisica.getCpf().length() < 14) {
	// result.include("warning", Mensagens.MSG_CAMPOS_OBRIGATORIOS);
	// } else {
	// try {
	// String cpf = Util.retiraMascaraCPF(pessoaFisica.getCpf());
	// Util.validarCPF(cpf);
	//// usuario = autenticacaoSoap.getDadosFuncionario(cpf);
	//// String mensagem = autenticacaoSoap.gerarToken(usuario);
	// result.include("usuario", usuario);
	//// result.include("warning", mensagem);
	// result.redirectTo(AuthController.class).trocaSenha();
	// } catch (SgeValidationException e) {
	// result.include("warning", e.getMessage());
	//// } catch (SgeException e) {
	//// result.include("error", e.getMessage());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }

	@Get
	@Path({ "trocaSenha/", "trocaSenha" })
	public void trocaSenha() {

	}

	@Post
	@Path({ "trocaSenha/", "trocaSenha" })
	public void trocaSenha(Usuario usuario) {
		try {
			result.include("usuario", usuario);

			validaUsuarioTrocaSenha(usuario);

			// String mensagem = autenticacaoSoap.atualizarSenha(usuario);
			// result.include("success", mensagem);
			result.redirectTo(AuthController.class).index();
		} catch (SgeValidationException e) {
			result.include("warning", e.getMessage());
			// } catch (SgeException e) {
			// result.include("error", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void validaUsuarioTrocaSenha(Usuario usuario) throws SgeValidationException {
		if (usuario == null || usuario.getToken() == null
				|| usuario.getToken().isEmpty() && usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}

		if (!usuario.getSenha().equals(usuario.getConfSenha())) {
			throw new SgeValidationException(Mensagens.MSG_SENHAS_DIFERENTESS);
		}

		validaPadraoSenha(usuario.getSenha());

	}

	private void validaPadraoSenha(String senha) throws SgeValidationException {
		Pattern numero = Pattern.compile("\\d");
		Pattern letra = Pattern.compile("[a-zA-Z]");
		Pattern simbolo = Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]");
		int peso = 0;
		if (numero.matcher(senha).find()) {
			peso++;
		}
		if (letra.matcher(senha).find()) {
			peso++;
		}
		if (simbolo.matcher(senha).find()) {
			peso++;
		}

		if (senha.length() < 8 || peso < 3) {
			throw new SgeValidationException(Mensagens.MSG_FORMATO_SENHA);
		}

	}

	@Get
	@Path({ "alterarSenha/", "alterarSenha" })
	public void alterarSenha() {

	}

	@Post
	@Path({ "alterarSenha/", "alterarSenha" })
	public void alterarSenha(Usuario usuario) {
		result.include("usuario", usuario);
	}

	@Post
	@Path("/logar")
	@Transactional
	public void autenticar(Usuario usuario) {
		// String query = String.format("secret=%s&response=%s",
		// "6LcvKRoUAAAAAGnRr3qK6-LKhUfoRDKeWmvxD0-B",
		// g_recaptcha);
		// InputStream response = null;
		// StringBuffer resposta = new StringBuffer();
		// try {
		// Proxy proxy = new Proxy(Proxy.Type.HTTP, new
		// InetSocketAddress("172.25.136.131", 8080));
		// URLConnection connection = new URL(url).openConnection(proxy);
		// connection.setDoOutput(true);
		// OutputStream output = connection.getOutputStream();
		// output.write(query.getBytes(charset));
		// response = new BufferedInputStream(connection.getInputStream());
		// byte[] bytes = new byte[4096];
		// while (response.read(bytes) != -1) {
		// resposta.append(new String(bytes));
		// }
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		//
		// if (!resposta.toString().contains("\"success\": true")) {
		// result.include("warning",
		// "Não foi possível fornecer acesso. Você deve estar autenticado para ter
		// acesso.");
		// result.forwardTo(AuthController.class).index();
		// } else {

		if (validaUsuario(usuario)) {
			try {
				usuario = usuarioService.entrar(usuario.getLogin(), usuario.getSenha());

				usuarioLogado.logar(usuario);
				result.include("usuarioLogado", usuarioLogado);

				result.redirectTo(HomeController.class).index();
			} catch (SgeValidationException e) {
				result.include("warning", "Não foi possível fornecer acesso. <br>Nome e/ou senha inválido(s).");
				result.redirectTo(AuthController.class).index();
			} catch (Exception e) {
				e.printStackTrace();
				result.include("warning", e.getMessage());
				result.redirectTo(AuthController.class).index();
			}
		} else {
			result.include("warning", "Não foi possível fornecer acesso. Você deve estar autenticado para ter acesso.");
			result.forwardTo(AuthController.class).index();
		}
		// }
	}

	@Get
	@Path("/sair")
	public void sair() {
		usuarioLogado.finalizarSessao();
		result.redirectTo(AuthController.class).index();

	}

	private boolean validaUsuario(final Usuario usuario) {
		return (usuario != null && usuario.getLogin() != null && !usuario.getLogin().isEmpty()
				&& usuario.getSenha() != null && !usuario.getSenha().isEmpty());
	}
}