<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="mostrar" />
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">Cadastro</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/instituicao/'/>" class="section">Instituição</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Visualizar</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Alterar Instituição</h2>
			</div>
		</div>
		<hr>
		<jsp:include page="form.jsp" />
		<a class="ui cinza button" href="javascript:history.back();">Voltar</a>
		<jsp:include page="unidades.jsp" />
	</jsp:body>
</template:admin>