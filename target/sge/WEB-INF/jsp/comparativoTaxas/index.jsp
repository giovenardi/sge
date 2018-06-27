<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<template:admin>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/financeiro.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
		<script type="text/javascript">
		
			function limpar(){
				$("form").form('clear');
				$(".radio.checkbox input").each(function() {$(this).prop('checked',true)});
				montarComboValor();
			}
				
		</script>
		<div class="ui small breadcrumb">
		      <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Gestão Financeira</div>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Comparativo de Taxas</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Comparativo de Taxas</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<div class="ui icon buttons">
						<a class="ui cinza button" href="<c:url value='/painelTaxas'/>" data-content="Painel" data-position="top right"><i class="fa-pie-chart icon"></i></a>	
						<div class="pipe"></div>
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/comparativoTaxas/imprimir'/>', '<c:url value='/comparativoTaxas'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
						<div class="pipe"></div>
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/comparativoTaxas/gerarExcel'/>', '<c:url value='/comparativoTaxas'/>')" data-content="Exportar" data-position="top right"><i class="fa-file-excel-o icon"></i></a>	
					</div>
				</div>
			</div>
		</div>
	<hr>
	<div class="ui styled fluid accordion">
		<div class="active title">
			<i class="dropdown icon"></i>
			Filtro de Pesquisa
		</div>
		<div class="content active">
			<form class="ui form" action="<c:url value='/comparativoTaxas' />" method="post" id="filterForm" onsubmit="return validarForm()">
				<div class="fields">
					<div class="ui dateANO three wide field required">
						<label>Ano Base</label>
						<input class="ui fluid campo-form-filtro" name="filtroComparativoTaxas.anoBase" value="${filtroComparativoTaxas.anoBase}">
					</div>
					<div class="seven wide field required check">
						<label>Tipos de Taxas</label>
						<div class="field">
							<c:forEach items="${listaTiposTaxas}" var="tipo">
								<div class="ui checkbox tipo">
		  							<input type="checkbox" name="filtroComparativoTaxas.tipos" value="${tipo.codigo}" ${filtroComparativoTaxas.tipos.contains(tipo.codigo)?'checked':''}>
		  							<label>${tipo.nome}</label>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="five wide field" style="/*display:none*/" id="taxa">
						<c:if test="${!empty(listaTaxas)}">
							<label>Taxa</label>
							<div class="ui selection dropdown">
								<input name="filtroComparativoTaxas.especificacao" type="hidden" value="${filtroComparativoTaxas.especificacao}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaTaxas}" var="taxa">
										<div class="item <c:if test="${taxa eq filtroComparativoTaxas.especificacao}">active selected</c:if>" data-value="${taxa}">${taxa}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</c:if>
					</div>
				</div>
				
				<div class="fields">
					<div class="six wide field required">
						<label>Período</label>
							<div class="field">
								<c:forEach items="${listaPeriodos}" var="periodo">
									<div class="ui radio checkbox">
		  								<input type="radio" ${filtroComparativoTaxas.periodo.ordinal() eq null or filtroComparativoTaxas.periodo.ordinal() eq periodo.ordinal()?'checked':''} name="filtroComparativoTaxas.periodo" value="${periodo.ordinal()}">
		  								<label>${periodo.name()}</label>
									</div>
								</c:forEach>
							 </div>
						</div>
					<c:set var="per" value="${filtroComparativoTaxas.periodo.ordinal()}" />	
					<div class="three wide field" style="display:none" id="valorPeriodo">
						<label></label>
						<div class="ui selection dropdown">
							<input name="filtroComparativoTaxas.valorPeriodo" type="hidden" value="${filtroComparativoTaxas.valorPeriodo}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
			  				</div>
			 			</div>
					</div>
					
				</div>
							
				<div class="fields">
					<button class="ui blue button">Filtrar</button>
					<button class="ui button gray" onclick="limpar();" type="button">Limpar</button>
				</div>
				<template:ordenacaoFormImpressao/>
			</form>
		</div>
	</div>
	<c:if test="${relatorioComparativoTaxas != null}">
      <div id="tabela" style="width:100%">
		<table class="ui black unstackable ordenacaoTabela table" style="margin-top:1em;margin-bottom:0;width:98.927%">
	        <thead class="teste">
    	        <tr>
        	        <th></th>
                    <th></th>
                    <th colspan="2" class="center aligned column_blue">${relatorioComparativoTaxas.periodoAnterior}</th>
                    <th colspan="2" class="center aligned column_green">${relatorioComparativoTaxas.periodoAtual}</th>
                    <th colspan="3" class="center aligned column_red">Diferença</th>
                </tr>
            	<tr>
                	<th class="one wide">Código</th>
                    <th class="four wide">Especificação</th>
                    <th class="right aligned one wide" data-sort="quantidadeAnterior">Qtd.</th>
                    <th class="right aligned two wide" data-sort="valorAnterior">Valor(R$)</th>
                    <th class="right aligned one wide" data-sort="quantidadeAtual">Qtd.</th>
                    <th class="right aligned two wide" data-sort="valorAtual">Valor(R$)</th>
                    <th class="right aligned one wide" data-sort="quantidadeDif">Qtd.</th>
                    <th class="right aligned two wide" data-sort="valorDif">Valor(R$)</th>
                    <th class="right aligned two wide">%</th>
                </tr>
            </thead>
        </table>
        <div style="width:100%;height: 300px; max-height: 300px; overflow-y:scroll">
			<table class="ui black unstackable table">
	            <tbody>
	    	        <c:forEach items="${relatorioComparativoTaxas.grupos}" var="grupo">
						<tr>
		                    <th colspan="9" class="sixteen wide center aligned column_white"><font size="4px"><b><c:out value="${grupo.descricao}"/></b></font></th>
						</tr>
	                	<c:forEach items='${grupo.taxas}' var='taxa'>                              	
	               			<tr>
	                        	<td class="one wide left aligned">${taxa.codigo}</td>
	                        	<td class="four wide left aligned">${taxa.especificacao}</td>
	                        	<td class="one wide right aligned column_blue">${taxa.getQuantidadeAnteriorFormatado()}</td>
	                        	<td class="two wide right aligned column_blue">${taxa.getValorAnteriorFormatado()}</td>
	                       		<td class="one wide right aligned column_green">${taxa.getQuantidadeAtualFormatado()}</td>
	                        	<td class="two wide right aligned column_green">${taxa.getValorAtualFormatado()}</td>
	                        	<td class="one wide right aligned column_red">${taxa.getDiferencaQuantidade()}</td>
	                        	<td class="two wide right aligned column_red">${taxa.getDiferencaValor()}</td>
	                        	<td class="two wide right aligned column_red">${taxa.getPercentual()}</td>
	                      	</tr>
	                  	</c:forEach>
						<tr>
	                       	<td class="left aligned" colspan="2">Total de ${grupo.descricao}</td>
	                       	<td class="right aligned column_blue">${grupo.getQuantidadeAnteriorFormatado()}</td>
	                       	<td class="right aligned column_blue">${grupo.getValorAnteriorFormatado()}</td>
	                      	<td class="right aligned column_green">${grupo.getQuantidadeAtualFormatado()}</td>
	                       	<td class="right aligned column_green">${grupo.getValorAtualFormatado()}</td>
	                       	<td class="right aligned column_red">${grupo.getDiferencaQuantidade()}</td>
	                       	<td class="right aligned column_red">${grupo.getDiferencaValor()}</td>
	                       	<td class="right aligned column_red">${grupo.getPercentual()}</td>
						</tr>
		        	</c:forEach>
				</tbody>
	        </table> 
		</div>
			<table class="ui black unstackable table" style="margin-top:0;margin-bottom:0;width:98.927%">
		            <thead>                     
						<tr>
	                       	<th style="padding: 10px 8px" class="five wide left aligned" colspan="2">Total Geral</th>
	                       	<th style="padding: 10px 8px" class="one wide right aligned column_blue">${relatorioComparativoTaxas.getQuantidadeAnteriorFormatado()}</th>
	                       	<th style="padding: 10px 8px" class="two wide right aligned column_blue">${relatorioComparativoTaxas.getValorAnteriorFormatado()}</th>
	                      	<th style="padding: 10px 8px" class="one wide right aligned column_green">${relatorioComparativoTaxas.getQuantidadeAtualFormatado()}</th>
	                       	<th style="padding: 10px 8px" class="two wide right aligned column_green">${relatorioComparativoTaxas.getValorAtualFormatado()}</th>
	                       	<th style="padding: 10px 8px" class="one wide right aligned column_red">${relatorioComparativoTaxas.getDiferencaQuantidade()}</th>
	                       	<th style="padding: 10px 8px" class="two wide right aligned column_red">${relatorioComparativoTaxas.getDiferencaValor()}</th>
	                       	<th style="padding: 10px 8px" class="two wide right aligned column_red">${relatorioComparativoTaxas.getPercentual()}</th>
						</tr>
		    		</thead>
	        </table> 
		  </div>
	</c:if>	
	</jsp:body>
</template:admin>