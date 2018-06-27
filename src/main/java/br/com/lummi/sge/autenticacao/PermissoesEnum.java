package br.com.lummi.sge.autenticacao;

public enum PermissoesEnum {

	SGD_HOME_INDEX("SGD|HOME|INDEX"), 
	SGD_COMPARATIVOTAXAS_INDEX("SGD|FINANCEIRO|COMPARATIVO_TAXAS|INDEX"), 
	SGD_EVOLUCAORECEITAS_INDEX("SGD|FINANCEIRO|EVOLUCAO_RECEITAS|INDEX"), 
	SGD_FORNECEDOR_INDEX("SGD|ALMOXARIFADO|FORNECEDOR|INDEX"), 
	SGD_FORNECEDOR_ADD("SGD|ALMOXARIFADO|FORNECEDOR|ADD"), 
	SGD_FORNECEDOR_EDIT("SGD|ALMOXARIFADO|FORNECEDOR|EDIT"), 
	SGD_FORNECEDOR_SHOW("SGD|ALMOXARIFADO|FORNECEDOR|SHOW"), 
	SGD_FORNECEDOR_REMOVE("SGD|ALMOXARIFADO|FORNECEDOR|REMOVE"), 
	SGD_FORNECEDOR_HISTORICO("SGD|ALMOXARIFADO|FORNECEDOR|HISTORICO"), 
	SGD_FORNECEDOR_LOG("SGD|ALMOXARIFADO|FORNECEDOR|LOG"), 
	SGD_FORNECEDOR_IMPRIMIR("SGD|ALMOXARIFADO|FORNECEDOR|IMPRIMIR"), 
	SGD_FORNECEDOR_IMPRIMIR_LISTA("SGD|ALMOXARIFADO|FORNECEDOR|IMPRIMIR_LISTA"), 
	SGD_FORNECEDOR_IMPRIMIR_HISTORICO("SGD|ALMOXARIFADO|FORNECEDOR|IMPRIMIR_HISTORICO"), 
	SGD_FORNECEDOR_IMPRIMIR_LOG("SGD|ALMOXARIFADO|FORNECEDOR|IMPRIMIR_LOG"), 
	SGD_GRUPOMATERIAL_INDEX("SGD|ALMOXARIFADO|GRUPO_MATERIAL|INDEX"), 
	SGD_GRUPOMATERIAL_ADD("SGD|ALMOXARIFADO|GRUPO_MATERIAL|ADD"), 
	SGD_GRUPOMATERIAL_EDIT("SGD|ALMOXARIFADO|GRUPO_MATERIAL|EDIT"), 
	SGD_GRUPOMATERIAL_SHOW("SGD|ALMOXARIFADO|GRUPO_MATERIAL|SHOW"), 
	SGD_GRUPOMATERIAL_REMOVE("SGD|ALMOXARIFADO|GRUPO_MATERIAL|REMOVE"), 
	SGD_GRUPOMATERIAL_HISTORICO("SGD|ALMOXARIFADO|GRUPO_MATERIAL|HISTORICO"), 
	SGD_GRUPOMATERIAL_LOG("SGD|ALMOXARIFADO|GRUPO_MATERIAL|LOG"), 
	SGD_GRUPOMATERIAL_IMPRIMIR("SGD|ALMOXARIFADO|GRUPO_MATERIAL|IMPRIMIR"), 
	SGD_GRUPOMATERIAL_IMPRIMIR_LISTA("SGD|ALMOXARIFADO|GRUPO_MATERIAL|IMPRIMIR_LISTA"), 
	SGD_GRUPOMATERIAL_IMPRIMIR_HISTORICO("SGD|ALMOXARIFADO|GRUPO_MATERIAL|IMPRIMIR_HISTORICO"), 
	SGD_GRUPOMATERIAL_IMPRIMIR_LOG("SGD|ALMOXARIFADO|GRUPO_MATERIAL|IMPRIMIR_LOG"), 
	SGD_MATERIAL_INDEX("SGD|ALMOXARIFADO|MATERIAL|INDEX"), 
	SGD_MATERIAL_ADD("SGD|ALMOXARIFADO|MATERIAL|ADD"), 
	SGD_MATERIAL_EDIT("SGD|ALMOXARIFADO|MATERIAL|EDIT"), 
	SGD_MATERIAL_SHOW("SGD|ALMOXARIFADO|MATERIAL|SHOW"), 
	SGD_MATERIAL_REMOVE("SGD|ALMOXARIFADO|MATERIAL|REMOVE"), 
	SGD_MATERIAL_HISTORICO("SGD|ALMOXARIFADO|MATERIAL|HISTORICO"), 
	SGD_MATERIAL_LOG("SGD|ALMOXARIFADO|MATERIAL|LOG"), 
	SGD_MATERIAL_IMPRIMIR("SGD|ALMOXARIFADO|MATERIAL|IMPRIMIR"), 
	SGD_MATERIAL_IMPRIMIR_LISTA("SGD|ALMOXARIFADO|MATERIAL|IMPRIMIR_LISTA"), 
	SGD_MATERIAL_IMPRIMIR_HISTORICO("SGD|ALMOXARIFADO|MATERIAL|IMPRIMIR_HISTORICO"), 
	SGD_MATERIAL_IMPRIMIR_LOG("SGD|ALMOXARIFADO|MATERIAL|IMPRIMIR_LOG"), 
	SGD_MATERIAL_ACTIVE("SGD|ALMOXARIFADO|MATERIAL|ACTIVE"), 
	SGD_MATERIAL_INACTIVE("SGD|ALMOXARIFADO|MATERIAL|INACTIVE"), 
	SGD_SUBGRUPOMATERIAL_INDEX("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|INDEX"), 
	SGD_SUBGRUPOMATERIAL_ADD("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|ADD"), 
	SGD_SUBGRUPOMATERIAL_EDIT("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|EDIT"), 
	SGD_SUBGRUPOMATERIAL_SHOW("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|SHOW"), 
	SGD_SUBGRUPOMATERIAL_REMOVE("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|REMOVE"), 
	SGD_SUBGRUPOMATERIAL_HISTORICO("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|HISTORICO"), 
	SGD_SUBGRUPOMATERIAL_LOG("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|LOG"), 
	SGD_SUBGRUPOMATERIAL_IMPRIMIR("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|IMPRIMIR"), 
	SGD_SUBGRUPOMATERIAL_IMPRIMIR_LISTA("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|IMPRIMIR_LISTA"), 
	SGD_SUBGRUPOMATERIAL_IMPRIMIR_HISTORICO("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|IMPRIMIR_HISTORICO"), 
	SGD_SUBGRUPOMATERIAL_IMPRIMIR_LOG("SGD|ALMOXARIFADO|SUBGRUPO_MATERIAL|IMPRIMIR_LOG"), 
	SGD_UFIRCE_INDEX("SGD|FINANCEIRO|UFIRCE|INDEX"), 
	SGD_UFIRCE_ADD("SGD|FINANCEIRO|UFIRCE|ADD"), 
	SGD_UFIRCE_EDIT("SGD|FINANCEIRO|UFIRCE|EDIT"), 
	SGD_UFIRCE_SHOW("SGD|FINANCEIRO|UFIRCE|SHOW"), 
	SGD_UFIRCE_REMOVE("SGD|FINANCEIRO|UFIRCE|REMOVE"), 
	SGD_UFIRCE_HISTORICO("SGD|FINANCEIRO|UFIRCE|HISTORICO"), 
	SGD_UFIRCE_LOG("SGD|FINANCEIRO|UFIRCE|LOG"), 
	SGD_UFIRCE_IMPRIMIR("SGD|FINANCEIRO|UFIRCE|IMPRIMIR"), 
	SGD_UFIRCE_IMPRIMIR_LISTA("SGD|FINANCEIRO|UFIRCE|IMPRIMIR_LISTA"), 
	SGD_UFIRCE_IMPRIMIR_HISTORICO("SGD|FINANCEIRO|UFIRCE|IMPRIMIR_HISTORICO"), 
	SGD_UFIRCE_IMPRIMIR_LOG("SGD|FINANCEIRO|UFIRCE|IMPRIMIR_LOG"), 
	SGD_TAXASELIC_INDEX("SGD|FINANCEIRO|TAXASELIC|INDEX"), 
	SGD_TAXASELIC_ADD("SGD|FINANCEIRO|TAXASELIC|ADD"), 
	SGD_TAXASELIC_EDIT("SGD|FINANCEIRO|TAXASELIC|EDIT"), 
	SGD_TAXASELIC_SHOW("SGD|FINANCEIRO|TAXASELIC|SHOW"), 
	SGD_TAXASELIC_REMOVE("SGD|FINANCEIRO|TAXASELIC|REMOVE"), 
	SGD_TAXASELIC_HISTORICO("SGD|FINANCEIRO|TAXASELIC|HISTORICO"), 
	SGD_TAXASELIC_LOG("SGD|FINANCEIRO|TAXASELIC|LOG"), 
	SGD_TAXASELIC_IMPRIMIR("SGD|FINANCEIRO|TAXASELIC|IMPRIMIR"), 
	SGD_TAXASELIC_IMPRIMIR_LISTA("SGD|FINANCEIRO|TAXASELIC|IMPRIMIR_LISTA"), 
	SGD_TAXASELIC_IMPRIMIR_HISTORICO("SGD|FINANCEIRO|TAXASELIC|IMPRIMIR_HISTORICO"), 
	SGD_TAXASELIC_IMPRIMIR_LOG("SGD|FINANCEIRO|TAXASELIC|IMPRIMIR_LOG"),
	SGD_BI_DASHBOARDS_RECEITAS("SGD|BI|DASHBOARDS|RECEITAS"),
	SGD_BI_DASHBOARDS_TAXAS("SGD|BI|DASHBOARDS|TAXAS"),
	NULO("");

	private String nome;

	PermissoesEnum(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
