package br.com.lummi.sge.models.transiente;

import java.io.Serializable;

import br.com.lummi.sge.models.Entidade;

public class RetornoJson<T extends Entidade> implements Serializable {

	private static final long serialVersionUID = 1045762027384417375L;

	private String error;
	
	private String warning;
	
	private String success;
	
	private String[] campos;
	
	private T obj;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String[] getCampos() {
		return campos;
	}

	public void setCampos(String[] campos) {
		this.campos = campos;
	}
	
}
