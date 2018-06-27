<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="funcPrincipal" value="grupoMaterial"/>
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
			  <div class="section">Gestão Logística</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Almoxarifado</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Cadastro Base</div>
			  <i class="right arrow icon divider"></i>
		  	<a href="<c:url value='/grupoMaterial'/>" class="section">Grupos de Materiais</a>
		  	<i class="right arrow icon divider"></i>
			<a href="<c:url value='/grupoMaterial/show/${filtroAuditoria.idObjeto}'/>" class="section">Detalhar Grupo de Material</a>
			<i class="right arrow icon divider"></i>
     		<div class="active section">Histórico</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column"><h2 class="ui header" style="padding-top: 10px">Histórico de Grupo de Material</h2></div>
			<div class="eight wide column"><div  style="float: right"><div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/grupoMaterial/imprimirHistorico/${filtroAuditoria.idObjeto}'/>" data-content="Imprimir"><i class="print icon"></i></a></div></div>
			</div>	
		</div>
		<hr> 
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
			 		<div class="six wide field">
						<label>Descrição do Grupo</label>
						<input type="text" value='${descricao}' readonly class="campo-form">
					</div>
				</div>
			</div>
		</div>
		<hr> 
		<%@include file="../historico_include.jsp"%>
		<a class="ui cinza button" href="<c:url value='/grupoMaterial/show/${filtroAuditoria.idObjeto}'/>">Voltar</a>
	</jsp:body>
</template:admin>