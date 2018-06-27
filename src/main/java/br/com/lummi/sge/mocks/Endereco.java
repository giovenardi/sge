package br.com.lummi.sge.mocks;

import java.util.HashMap;

public class Endereco {
	private static final HashMap<String, HashMap<String, String>> mapa = new HashMap<String, HashMap<String, String>>();
	{
		HashMap<String, String> endereco = new HashMap<String, String>();
		endereco.put("uf", "CE");
		endereco.put("municipio", "FORTALEZA");
		endereco.put("bairro", "ALDEOTA");
		endereco.put("logradouro", "R VICENTE LEITE (TESTE)");
		mapa.put("11111111", endereco);
		endereco = new HashMap<String, String>();
		endereco.put("uf", "CE");
		endereco.put("municipio", "FORTALEZA");
		endereco.put("bairro", "VICENTE PINZON");
		endereco.put("logradouro", "R CORONEL JOSÉ AURÉLIO CÂMARA");
		mapa.put("22222222", endereco);
		endereco = new HashMap<String, String>();
		endereco.put("uf", "CE");
		endereco.put("municipio", "CASCAVEL");
		endereco.put("bairro", "CENTRO");
		endereco.put("logradouro", "R JARARACA");
		mapa.put("33333333", endereco);
	}

	public HashMap<String, String> get(String chave) {
		return mapa.get(chave);
	}
}