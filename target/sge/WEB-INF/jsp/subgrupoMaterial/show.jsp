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
		<script src="<c:url value='/assets/js/subgrupoMaterial.js'/>"></script>
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
			  <a href="<c:url value='/subgrupoMaterial'/>">Subgrupos de Materiais</a>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Visualizar Subgrupos de Materiais</div>
		</div>
		
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Detalhar Subgrupos de Materiais</h2>
			</div>
			<div class="eight wide column">
				<div  style="float: right">
					<div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/subgrupoMaterial/imprimir/${subgrupoMaterial.id}'/>" data-content="Imprimir"><i class="print icon"></i></a></div>
					<div class="ui icon buttons"><a class="ui cinza button" href="<c:url value='/subgrupoMaterial/historico/${subgrupoMaterial.id}'/>" data-content="Histórico" data-position="top right"><i class="wait icon"></i></a></div>
				</div>
			</div>
		</div>
	<hr>
    <jsp:include page="form.jsp"/>
	<table class="ui black unstackable table">
        <thead>
   	        <tr class="">
       	        <th colspan="3" class="wide center aligned">Materiais</th>
               </tr>
               <tr>
       	        <th class="three wide">Código</th>
       	        <th class="ten wide">Descrição do Material</th>
       	        <th class="three wide">Status</th>
               </tr>
           </thead>
           <tbody>
			<c:forEach items="${subgrupoMaterial.materiais}" var="material">
                <tr class="">
        	        <td>${material.codigoSeplag}</td>
        	        <td>${material.descricao}</td>
        	        <td>${material.status.descricao}</td>
                </tr>
			</c:forEach>
           </tbody>
      	</table>
	<br />
	<a class="ui cinza button" href="<c:url value='/subgrupoMaterial'/>">Voltar</a>
</jsp:body>
</template:admin>