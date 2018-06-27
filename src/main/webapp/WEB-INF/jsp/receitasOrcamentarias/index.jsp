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
			  <div class="active section">Receitas Orçamentárias</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Receitas Orçamentárias</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<div class="ui icon buttons">
						<a class="ui cinza button" href="<c:url value='/painelReceitas'/>" data-content="Painel" data-position="top right"><i class="fa-pie-chart icon"></i></a>	
						<div class="pipe"></div>
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/receitasOrcamentarias/imprimir'/>', '<c:url value='/receitasOrcamentarias'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
						<div class="pipe"></div>
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/receitasOrcamentarias/gerarExcel'/>', '<c:url value='/receitasOrcamentarias'/>')" data-content="Exportar" data-position="top right"><i class="fa-file-excel-o icon"></i></a>	
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
			<form class="ui form" action="<c:url value='/receitasOrcamentarias' />" method="post" id="filterForm" onsubmit="return validarForm()">
				<div class="fields separador">
					<div class="ui dateANO three wide field required">
						<label>Ano Base</label>
						<input class="ui fluid campo-form-filtro" name="filtroFinanceiro.anoBase" value="${filtroFinanceiro.anoBase}">
					</div>
				</div>
				<div class="fields">
					<div class="six wide field required">
						<label>Período</label>
						<div class="field">
							<c:forEach items="${listaPeriodos}" var="periodo">
								<div class="ui radio checkbox">
	  								<input type="radio" ${filtroFinanceiro.periodo.ordinal() eq null or filtroFinanceiro.periodo.ordinal() eq periodo.ordinal()?'checked':''} name="filtroFinanceiro.periodo" value="${periodo.ordinal()}">
	  								<label>${periodo.name()}</label>
								</div>
							</c:forEach>
						 </div>
					</div>
					<c:set var="per" value="${filtroFinanceiro.periodo.ordinal()}" />	
					<div class="three wide field" style="display:none" id="valorPeriodo">
						<label></label>
						<div class="ui selection dropdown">
							<input name="filtroFinanceiro.valorPeriodo" type="hidden" value="${filtroFinanceiro.valorPeriodo}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
			  				</div>
			 			</div>
					</div>
				</div>
				<br/>
				<div class="fields">
					<button class="ui blue button">Filtrar</button>
					<button class="ui button gray" onclick="limpar();" type="button">Limpar</button>
				</div>
			</form>
		</div>
	</div>
	<c:if test="${relatorioEvolucaoReceitas != null}">
      	<div id="tabela" style="width:100%">
			<table class="ui black unstackable table" style="margin-top:0;margin-bottom:0;width:98.927%">
		        <thead class="teste">
	    	        <tr class="">
	        	        <th class="two wide column_blue">Mês</th>
	                    <th class="three wide right aligned column_blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Taxas</th>
	                    <th class="three wide right aligned column_blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Multas</th>
	                    <th class="three wide right aligned column_blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Outras Receitas</th>
	                    <th class="three wide right aligned column_blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total</th>
	                    <th class="two wide right aligned column_blue">% Evolução</th>
	                </tr>
	            </thead>
	        </table> 
	        <div  style="height:200px;overflow-y: scroll">
				<table class="ui black unstackable table" style="margin-top:0;margin-bottom:0;">
	               	<tbody>
						<c:forEach items="${relatorioEvolucaoReceitas.listaDetalhesReceita}" var="det">
	              			<tr>
		                       	<td class="two wide left aligned">${det.descricao}</td>
		                       	<td class="three wide right aligned">${det.getTaxaFormatada()}</td>
		                       	<td class="three wide right aligned">${det.getMultaFormatada()}</td>
		                       	<td class="three wide right aligned">${det.getOutraFormatada()}</td>
		                       	<td class="three wide right aligned">${det.getTotalFormatado()}</td>
		                   		<td class="two wide right aligned">${det.getEvolucaoFormatada()}</td>
	                    	</tr>
	                 	</c:forEach>
						<tr class="">
							<th class="left aligned column_blue">${relatorioEvolucaoReceitas.totalizadorReceita.descricao}</th>
							<th class="right aligned column_blue">${relatorioEvolucaoReceitas.totalizadorReceita.getTaxaFormatada()}</th>
							<th class="right aligned column_blue">${relatorioEvolucaoReceitas.totalizadorReceita.getMultaFormatada()}</th>
							<th class="right aligned column_blue">${relatorioEvolucaoReceitas.totalizadorReceita.getOutraFormatada()}</th>
							<th class="right aligned column_blue">${relatorioEvolucaoReceitas.totalizadorReceita.getTotalFormatado()}</th>
							<th class="right aligned column_blue">${relatorioEvolucaoReceitas.totalizadorReceita.getEvolucaoFormatada()}</th>
						</tr>
						<c:forEach items="${relatorioEvolucaoReceitas.listaMediasAnuais}" var="med">
							<tr class="">
								<th class="left aligned column_green">${med.descricao}</th>
								<th class="right aligned column_green">${med.getTaxaFormatada()}</th>
								<th class="right aligned column_green">${med.getMultaFormatada()}</th>
								<th class="right aligned column_green">${med.getOutraFormatada()}</th>
								<th class="right aligned column_green">${med.getTotalFormatado()}</th>
								<th class="right aligned column_green">${med.getEvolucaoFormatada()}</th>
							</tr>
		               	</c:forEach>
		            </tbody>
	        	</table> 
	        </div>
	    </div>
	</c:if>	
	
</jsp:body>
</template:admin>