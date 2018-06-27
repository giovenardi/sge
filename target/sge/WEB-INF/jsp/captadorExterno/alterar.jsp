<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="alterar" />
<template:admin>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/captador.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">Cadastro</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/captadorExterno/'/>" class="section">Captadores Externos</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Alterar</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Alterar Captador Externo</h2>
			</div>
		</div>
		<hr>
		<form class="ui form segment" id="formAlterar" action="<c:url value='/captadorExterno/alterar'/>" method="POST" onsubmit="return validarForm()">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>CPF</label>
							<input type="hidden" name="captadorExterno.pessoa.id" value="${captadorExterno.pessoa.id}">
							<input type="text" readonly class="campo-form cpf" name='captadorExterno.pessoa.cpf' value="${captadorExterno.pessoa.cpf}">
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="form.jsp" />
			<br/>
			<a class="ui cinza button" href="javascript:history.back();">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
		</form>
	</jsp:body>
</template:admin>