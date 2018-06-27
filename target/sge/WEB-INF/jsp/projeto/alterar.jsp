<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="acao" value="add" scope="request" />
<template:admin>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/projeto.js'/>"></script>
		<script src="<c:url value='/assets/js/planos.js'/>"></script>
		<script src="<c:url value='/assets/js/cerimonial.js'/>"></script>
		<script src="<c:url value='/assets/js/turmas.js'/>"></script>
		<script src="<c:url value='/assets/js/formandos.js'/>"></script>
	</jsp:attribute>
    <jsp:body>
	     <div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Projetos</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Registro de Projeto</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Registro de Projeto</h2>
			</div>
		</div>
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
					<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
						<label>Número</label>
						<input type="hidden" id="projeto_id" name="projeto.id" value="${projeto.id}">
						<input type="text" readOnly maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form numero" name="projeto.numero" value="${projeto.numero}">
					</div>
					<div class="two wide field">
						<label>Data de Ativação</label>
						<input type="text" readOnly class="campo-form" name="projeto.dataAtivacao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.dataAtivacao}" />">
					</div>
			 		<div class="nine wide field <c:if test='${acao ne "show"}'>required</c:if>">
						<label>Nome</label>
						<input type="text" readOnly class="campo-form" id="nomeProjeto" name="projeto.nome" value="${projeto.nome}">
					</div>
			 		<div class="two wide field">
						<label>Status</label>
						<input name="projeto.status" type="hidden" value="${projeto.status.name()}" />
						<input type="text" disabled value="${projeto.status.descricao}" />
					</div>
				</div>
			</div>
		</div>
		<div class="ui top attached tabular menu">
		  <a class="item active" data-tab="painel_tab">Painel</a>
		  <!-- <a class="item" data-tab="historico_tab">Histórico de Atendimentos</a> -->
		  <a class="item" data-tab="turma_tab">Turmas</a>
		  <a class="item" data-tab="comissao_tab">Comissao</a>
		  <a class="item" data-tab="cerimonial_tab">Cerimonial</a>
		  <a class="item" data-tab="planos_tab">Planos</a>
		  <a class="item" data-tab="formandos_tab">Formandos</a>
		</div>
		<jsp:include page="painelTab.jsp" />
		<jsp:include page="historicoTab.jsp" />
		<jsp:include page="turmaTab.jsp" />
		<jsp:include page="comissaoFormaturaTab.jsp" />
		<jsp:include page="cerimonialTab.jsp" />
		<jsp:include page="planosTab.jsp" />
		<jsp:include page="formandosTab.jsp" />
		<jsp:include page="../pessoaFisica/tela.jsp" />
   	</jsp:body>
</template:admin>
