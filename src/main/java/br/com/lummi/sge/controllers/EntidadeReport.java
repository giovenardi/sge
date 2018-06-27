package br.com.lummi.sge.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.jasperreports.Report;
import br.com.lummi.sge.models.Entidade;

public class EntidadeReport<T extends Entidade> implements Report{

    private final List<T> data;
    private Map<String, Object> parameters;
	private String template;

    /**
     * Constrói um novo relatório com o dados recebidos.
     * 
     * @param data
     *            Dados para composição do relatório.
     */
    public EntidadeReport(List<T> data, String template, String diretorioBase) {
        this.data = data;
        this.template = template;
        this.parameters = new HashMap<String, Object>();
        addParameter("diretorio_base", diretorioBase );
    }
    
    @Override
	public String getTemplate() {
		return template;
	}

	@Override
	public Map<String, Object> getParameters() {
		return parameters;
	}

	@Override
	public Collection<T> getData() {
		return data;
	}

	@Override
	public String getFileName() {
		return "report" + System.currentTimeMillis();
	}

	@Override
	public Report addParameter(String parameter, Object value) {
		parameters.put(parameter, value);
		return this;
	}

	@Override
	public boolean isCacheable() {
		return false;
	}

}
