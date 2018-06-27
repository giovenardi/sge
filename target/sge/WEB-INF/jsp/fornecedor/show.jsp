<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" value="detalhar" scope="request" />
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
			<a href="<c:url value='/fornecedor'/>">Fornecedores</a>
			<i class="right arrow icon divider"></i>
			<div class="active section">Detalhar Fornecedor</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Detalhar Fornecedor</h2>
			</div>
			<div class="eight wide column">
				<div  style="float: right">
					<div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/fornecedor/imprimir/${fornecedor.id}'/>" data-content="Imprimir"><i class="print icon"></i></a></div>
					<div class="ui icon buttons"><a class="ui cinza button" href="<c:url value='/fornecedor/historico/${fornecedor.id}'/>" data-content="Histórico" data-position="top right"><i class="wait icon"></i></a></div>
				</div>
			</div>
		</div>
		<hr>
			<div class="ui segment">
				<div class="ui form">
					<div class="fields">
						<div class="three wide field required">
							<label>CRC</label> 
							<input type='text' id="crc" disabled name='fornecedor.crc' value='${fornecedor.crc}' class='campo-form-filtro crc'>
						</div>
						<div class="four wide field required" disabled>
							<label>Tipo</label>
							<div class="ui selection dropdown tipoPessoa disabled">
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
	</jsp:body>
</template:admin>