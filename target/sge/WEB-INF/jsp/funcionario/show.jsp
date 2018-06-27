<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="show" />
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">RH</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/funcionario/'/>" class="section">Funcionários</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Visualizar</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Visualizar Funcionário</h2>
			</div>
		</div>
		<hr>
		<div class="ui segment">
			<div class="ui form">
				<div class="fields separador">
					<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
						<label>CPF</label>
						<input type="hidden" name="funcionario.pessoa.id" value="${funcionario.pessoa.id}">
						<input type="text" readonly class="campo-form cpf" name='funcionario.pessoa.cpf' value="${funcionario.pessoa.cpf}">
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="form.jsp" />
			<br/>
		<a class="ui cinza button" href="javascript:history.back();">Voltar</a>
	</jsp:body>
</template:admin>