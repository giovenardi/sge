<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<c:set var="acao" value="edit" scope="request" />
<template:admin>
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
			  <div class="active section">Editar Taxa Selic</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Editar Taxa Selic</h2>
			</div>
			
		</div>
	<hr>
        <form role="form" action="<c:url value='/taxaSelic/edit'/>" method="POST" onsubmit="return validarForm()">
            <jsp:include page="form.jsp"/>
            <a class="ui cinza button" href="<c:url value='/taxaSelic'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
        </form>
    </jsp:body>
</template:admin>