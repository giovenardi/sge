<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="funcPrincipal" value="taxaSelic"/>
<c:set var="descricao" value="log"/>
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
	</jsp:attribute>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Gestão Financeira</div>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Cadastros Corporativos</div>
			  <i class="right arrow icon divider"></i>
			  <a href="<c:url value='/taxaSelic'/>">Taxas Selic</a>
			  <i class="right arrow icon divider"></i>
			<a href="<c:url value='/taxaSelic/show/${filtroAuditoria.idObjeto}'/>" class="section">Detalhar Taxa Selic</a>
			<i class="right arrow icon divider"></i>
     		<div class="active section">Histórico</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column"><h2 class="ui header" style="padding-top: 10px">Histórico da Taxa Selic</h2></div>
			<div class="eight wide column"><div  style="float: right"><div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/taxaSelic/imprimirHistorico/${filtroAuditoria.idObjeto}'/>" data-content="Imprimir"><i class="print icon"></i></a></div></div>
			</div>	
		</div>
		<hr> 
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
			 		<div class="six wide field">
						<label>Mês/Ano de Referência - Valor</label>
						<input type="text" value='${descselic}' readonly class="campo-form">
					</div>
				</div>
			</div>
		</div>
		<hr> 
		<%@include file="../historico_include.jsp"%>
		<a class="ui cinza button" href="<c:url value='/taxaSelic/show/${filtroAuditoria.idObjeto}'/>">Voltar</a>
	</jsp:body>
</template:admin>