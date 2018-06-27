<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="novo" />
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">Cadastro</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/cargo/'/>" class="section">Cargo</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Novo</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Novo Cargo</h2>
			</div>
		</div>
		<hr>
		<form class="ui form segment" id="formAdd" action="<c:url value='/cargo/novo'/>" method="POST" onsubmit="return validarForm()">
			<jsp:include page="form.jsp" />
			<a class="ui cinza button" href="<c:url value='/cargo/'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
		</form>
	</jsp:body>
</template:admin>