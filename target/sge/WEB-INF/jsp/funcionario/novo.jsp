<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="novo" />
<template:admin>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/funcionario.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">RH</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/funcionario/'/>" class="section">Funcionários</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Novo</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Novo Funcionário</h2>
			</div>
		</div>
		<hr>
		<form class="ui form segment" id="formAdd" action="<c:url value='/funcionario/novo'/>" method="POST" onsubmit="return validarForm()">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>CPF</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> <c:if test='${funcionario.pessoa.cpf ne null}'>readonly</c:if> id="cpf" class="campo-form cpf" name='funcionario.pessoa.cpf' value="${funcionario.pessoa.cpf}">
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="form.jsp" />
			<br/>
			<a class="ui cinza button" href="<c:url value='/'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
		</form>
	</jsp:body>
</template:admin>