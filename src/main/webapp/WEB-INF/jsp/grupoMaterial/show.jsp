<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="acao" value="show" scope="request" />
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
	</jsp:attribute>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
		<script src="<c:url value='/assets/js/grupoMaterial.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
		<script type="text/javascript">
			function limpar(){
				$("form").form('clear');
			}
		</script>
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
			  <div class="active section">Detalhar Grupo de Material</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Detalhar Grupo de Material</h2>
			</div>
			<div class="eight wide column">
				<div  style="float: right">
					<div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/grupoMaterial/imprimir/${grupoMaterial.id}'/>" data-content="Imprimir"><i class="print icon"></i></a></div>
					<div class="ui icon buttons"><a class="ui cinza button" href="<c:url value='/grupoMaterial/historico/${grupoMaterial.id}'/>" data-content="Histórico" data-position="top right"><i class="wait icon"></i></a></div>
				</div>
			</div>
		</div>
		<hr>
        <jsp:include page="form.jsp"/>
		<table class="ui black unstackable table">
	        <thead class="teste">
    	        <tr class="">
        	        <th class="wide center aligned">Subgrupos</th>
                </tr>
                <tr class="">
        	        <th class="six wide">Descrição</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${grupoMaterial.subgrupos}" var="subgrupo">
	                <tr class="">
	        	        <td>${subgrupo.descricao}</td>
	                </tr>
				</c:forEach>
            </tbody>
       	</table>
		<br />
		<a class="ui cinza button" href="<c:url value='/grupoMaterial'/>">Voltar</a>
	</jsp:body>
</template:admin>