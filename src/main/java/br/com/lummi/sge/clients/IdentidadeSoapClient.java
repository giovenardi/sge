package br.com.lummi.sge.clients;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.naming.NamingException;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import br.com.lummi.sge.enums.ChaveParametroEnum;
import br.com.lummi.sge.models.autenticacao.ZUsuario;
import br.com.lummi.sge.service.ParametroSistemaService;

/**
 * Created by davisousa on 03/06/2016. Classe que faz chamada ao webservice SOAP
 * Identidade DETRAN.
 */
@Singleton
public class IdentidadeSoapClient {

	@Inject
	private ParametroSistemaService parametroService;
	
	public ArrayList<HashMap<String, String>> getRetornaRecursosAll(String codigo)
			throws RemoteException, ServiceException, NamingException {

		Object[] params = { codigo };

		ArrayList<HashMap<String, String>> lista = this.getDados(1, "getRetornaRecursosAll", params);

		return lista;

	}

	public HashMap<String, String> getFuncionarioUsuario(String codigo)
			throws ServiceException, RemoteException, NamingException {

		Object[] params = { codigo };

		ArrayList<HashMap<String, String>> lista = this.getDados(35, "getFuncionarioUsuario", params);

		return lista.get(0);

	}

	public HashMap<String, String> getDadosFuncionario(String cpf)
			throws ServiceException, RemoteException, NamingException {

		Object[] params = { cpf };

		ArrayList<HashMap<String, String>> lista = this.getDados(12, "getInformaFuncionario", params);

		return lista.get(0);
	}

	public HashMap<String, String> getValidaUsuario(String usuario, String senha)
			throws ServiceException, RemoteException, NamingException {

		Object[] params = { usuario, senha };

		ArrayList<HashMap<String, String>> lista = this.getDados(12, "getValidaUsuario", params);

		return lista.get(0);

	}

	@SuppressWarnings("unchecked")
	private ArrayList<HashMap<String, String>> getDados(int qtdCampos, String metodo, Object[] params)
			throws ServiceException, RemoteException {

		String endpoint = parametroService.obterPorChave(ChaveParametroEnum.IDENTIDADE_DETRAN).getValor();

		final String ENDPOINT = endpoint;

		Service service = new Service();
		Call call = (Call) service.createCall();

		call.setTargetEndpointAddress(ENDPOINT);
		call.setOperationName(metodo);

		ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> map = new HashMap<>();

		if (ENDPOINT.contains("identidade-mock")) {

			ArrayList<String> retorno = (ArrayList<String>) call.invoke(params);

			int numLinhas = (retorno.size() / qtdCampos);

			for (int l = 1; l <= numLinhas; l++) {
				map = new HashMap<>();

				for (int i = 0; i < qtdCampos; i++) {

					int indiceCampo = (numLinhas > 2 ? l : (i + qtdCampos));

					if (numLinhas > 2 && l < numLinhas && retorno.get(indiceCampo) != null) {

						map.put(retorno.get(i), retorno.get(indiceCampo));

					} else if (numLinhas == 2 && retorno.get(indiceCampo) != null) {
						map.put(retorno.get(i), retorno.get(indiceCampo));
					}

				}

				lista.add(map);

			}

		} else {

			String[][] retorno = (String[][]) call.invoke(params);

			int linhaAtual = 1;

			for (String[] linha : retorno) {
				if (linhaAtual < retorno.length) {
					map = new HashMap<>();
					for (int colunaAtual = 0; colunaAtual < linha.length; colunaAtual++) {
						map.put(retorno[0][colunaAtual], retorno[linhaAtual][colunaAtual]);
					}
				}

				if (linhaAtual <= retorno.length) {
					lista.add(map);
				}
				linhaAtual++;

			}

		}

		return lista;

	}

	public HashMap<String, String> enviaEmailToken(ZUsuario usuario) throws RemoteException, ServiceException {
		Object[] params = { usuario.getIdentidadedetran().toString(), usuario.getNomecompleto(), usuario.getEmail(), "xd1e2t3r4a5nx" };

		ArrayList<HashMap<String, String>> lista = this.getDados(35, "setEnviaEmailToken", params);

		return lista.get(0);
	}

	public HashMap<String, String> atualizarSenha(String codigo, String senha) throws RemoteException, ServiceException {
		Object[] params = { codigo, senha };

		ArrayList<HashMap<String, String>> lista = this.getDados(35, "setValidaAtualizacaoSenha", params);

		return lista.get(0);
	}

}
