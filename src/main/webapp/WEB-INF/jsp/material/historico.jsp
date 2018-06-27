<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="funcPrincipal" value="material"/>
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
	</jsp:attribute>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
		<div class="ui small breadcrumb">
		  	<a href="<c:url value='/'/>" class="section">In�cio</a>
		  	<i class="right chevron icon divider"></i>
			  <div class="section">Gest�o Log�stica</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Almoxarifado</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Cadastro Base</div>
			  <i class="right arrow icon divider"></i>
		  	<a href="<c:url value='/material'/>" class="section">Materiais</a>
		  	<i class="right arrow icon divider"></i>
			<a href="<c:url value='/material/show/${filtroAuditoria.idObjeto}'/>" class="section">Detalhar Material</a>
			<i class="right arrow icon divider"></i>
     		<div class="active section">Hist�rico</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column"><h2 class="ui header" style="padding-top: 10px">Hist�rico de Material</h2></div>
			<div class="eight wide column"><div  style="float: right"><div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/material/imprimirHistorico/${filtroAuditoria.idObjeto}'/>" data-content="Imprimir"><i class="print icon"></i></a></div></div>
			</div>	
		</div>
		<hr> 
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
			 		<div class="six wide field">
						<label>Nome do Material</label>
						<input type="text" value='${descricao}' readonly class="campo-form">
					</div>
				</div>
			</div>
		</div>
		<hr> 
		<%@include file="../historico_include.jsp"%>
		<a class="ui cinza button" href="javascript:history.back();">Voltar</a>
	</jsp:body>
</template:admin>