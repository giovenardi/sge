<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<c:set var="acao" value="add" scope="request" />
<template:admin>
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
			  <a href="<c:url value='/subgrupoMaterial'/>">Subgrupos de Materiais</a>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Incluir Subgrupos de Materiais</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Incluir Subgrupos de Materiais</h2>
			</div>
			
		</div>
	<hr>
        <form role="form" action="<c:url value='/subgrupoMaterial/add'/>" method="POST" onsubmit="return validarForm()">
        	
           
            <jsp:include page="form.jsp"/>
            <a class="ui cinza button" href="<c:url value='/subgrupoMaterial'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
        </form>
    </jsp:body>
</template:admin>
<script type="text/javascript">
	$("document").ready(function(){
		$("#cep").change();
	});
</script>