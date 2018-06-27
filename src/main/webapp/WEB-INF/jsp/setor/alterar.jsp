<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="alterar" />
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">Cadastro</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/setor/'/>" class="section">Setor</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Alterar</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Alterar Setor</h2>
			</div>
		</div>
		<hr>
		<form class="ui form segment" id="formAlterar" action="<c:url value='/setor/alterar'/>" method="POST" onsubmit="return validarForm()">
			<jsp:include page="form.jsp" />
			<a class="ui cinza button" href="javascript:history.back();">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
		</form>
	</jsp:body>
</template:admin>