<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<c:set var="acao" value="show" scope="request" />
<template:admin>
    <jsp:body>
     <div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Gestão Logística</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Almoxarifado</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Cadastro Base</div>
			  <i class="right arrow icon divider"></i>
			  <a href="<c:url value='/material'/>">Materiais</a>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Detalhar Material</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Detalhar Material</h2>
			</div>
			<div class="eight wide column">
				<div  style="float: right">
					<div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/material/imprimir/${material.id}'/>" data-content="Imprimir"><i class="print icon"></i></a></div>
					<div class="ui icon buttons"><a class="ui cinza button" href="<c:url value='/material/historico/${material.id}'/>" data-content="Histórico" data-position="top right"><i class="wait icon"></i></a></div>
				</div>
			</div>
		</div>
	<hr>
            <jsp:include page="form.jsp"/>
            <a class="ui cinza button" href="javascript:history.back();">Voltar</a>
    </jsp:body>
</template:admin>
<script type="text/javascript">
	$("document").ready(function(){
		$("#cep").change();
	});
</script>