<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" value="add" scope="request" />
<template:admin>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/fornecedor.js'/>"></script>
 	</jsp:attribute>
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
			<a href="<c:url value='/fornecedor'/>">Fornecedores</a>
			<i class="right arrow icon divider"></i>
			<div class="active section">Incluir Fornecedor</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Incluir Fornecedor</h2>
			</div>
		</div>
		<hr>
		<form class="ui form segment fornecedor" id="formAdd" action="<c:url value='/fornecedor/add'/>" method="POST" onsubmit="return validarForm()">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields">
						<div class="three wide field required">
							<label>CRC</label> 
							<input type='text' id="crc" name='fornecedor.crc' value='${fornecedor.crc}' class='campo-form-filtro crc'>
						</div>
						<div class="four wide field required">
							<label>Tipo</label>
							<div class="ui selection dropdown tipoPessoa">
								<input name="fornecedor.tipoPessoa" id="tipo" value="${fornecedor.tipoPessoa}" type="hidden">
								<div class="default text">Selecione</div>
								<i class="dropdown icon"></i>
								<div class="menu">
									<c:forEach items="${listaTiposPessoa}" var="tipo">
										<div class="item <c:if test="${tipo.name().equals(fornecedor.tipoPessoa.name())}">active selected</c:if>" data-value="${tipo.name()}">${tipo.descricao}</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${fornecedor.tipoPessoa ne null and fornecedor.tipoPessoa.name().equals('F')}">
				<jsp:include page="formPF.jsp" />
			</c:if>
			<c:if test="${fornecedor.tipoPessoa ne null and fornecedor.tipoPessoa.name().equals('J')}">
				<jsp:include page="formPJ.jsp" />
			</c:if>
			<a class="ui cinza button" href="<c:url value='/fornecedor'/>">Voltar</a>
			<button class="ui green button" <c:if test="${fornecedor.tipoPessoa eq null}">disabled</c:if> type="submit">Salvar</button>
		</form>
	</jsp:body>
</template:admin>
<script type="text/javascript">
	$("document").ready(function() {
		$("#cep").change();
	});
</script>