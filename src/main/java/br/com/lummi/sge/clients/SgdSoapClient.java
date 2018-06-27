
package br.com.lummi.sge.clients;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import br.com.lummi.sge.enums.ChaveParametroEnum;
import br.com.lummi.sge.service.ParametroSistemaService;

@Singleton
public class SgdSoapClient {

	@Inject
	private ParametroSistemaService parametroSistemaService;

	public HashMap<String, String> getEnderecoAll(String cep) throws Exception {
		Object[] params = { cep };
		System.out.println("REALIZANDO CHAMADA DO WEBSERVICE....");
		HashMap<String, String> lista = this.getWsEndereco(1, "getEnderecoNacional", params);
		return lista;
	}

	private HashMap<String, String> chamaWebService(String metodo, Object[] params, String endpoint)
			throws ServiceException, RemoteException {
		final String ENDPOINT = endpoint;
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(ENDPOINT);
		call.setOperationName(metodo);
		HashMap<String, String> map = null;
		String[][] retorno = (String[][]) call.invoke(params);
		if (retorno != null && retorno.length > 0 && retorno[0].length > 0) {
			map = new HashMap<>();
			int linhaAtual = 1;
			for (String[] linha : retorno) {
				if (linhaAtual < retorno.length) {
					for (int colunaAtual = 0; colunaAtual < linha.length; colunaAtual++) {
						map.put(retorno[0][colunaAtual], retorno[linhaAtual][colunaAtual]);
					}
				}
				linhaAtual++;
			}
			System.out.println("DADOS DE RETORNO:  " + map);
		}
		return map;
	}

	private HashMap<String, String> getWsEndereco(int qtdCampos, String metodo, Object[] params)
			throws ServiceException, RemoteException {
		String endpoint = parametroSistemaService.obterPorChave(ChaveParametroEnum.WS_CONSULTA_ENDERECO).getValor();
		HashMap<String, String> map = chamaWebService(metodo, params, endpoint);
		return map;
	}

}
