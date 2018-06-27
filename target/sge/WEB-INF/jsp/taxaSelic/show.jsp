<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
			  <div class="active section">Detalhar Taxa Selic</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Detalhar Taxa Selic</h2>
			</div>
			<div class="eight wide column">
				<div  style="float: right">
					<div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/taxaSelic/imprimir/${taxaSelic.id}'/>" data-content="Imprimir"><i class="print icon"></i></a></div>
					<div class="ui icon buttons"><a class="ui cinza button" href="<c:url value='/taxaSelic/historico/${taxaSelic.id}'/>" data-content="Histórico" data-position="top right"><i class="wait icon"></i></a></div>
				</div>
			</div>
		</div>
	<hr>
	<div class="ui segment">
		<div class="ui form">
			<div class="fields separador">
				<div class="ui date three wide field ">
					<label>Código</label>
					<input type="text" class="ui fluid campo-form-filtro" disabled name="taxaSelic.id" value="${taxaSelic.id}" >
				</div>
			</div>
			<div class="fields separador">
				<div class="ui three wide field ">
					<label>Mês/Ano de Referência</label>
					<input type="text" class="ui fluid campo-form-filtro" disabled name="taxaSelic.anoReferencia" value="<fmt:formatNumber value='${taxaSelic.mesReferencia}' minIntegerDigits='2'/> / ${taxaSelic.anoReferencia}">
				</div>
			</div>
			<div class="fields separador">
		 		<div class="ui three wide field ">
					<label>Valor</label>
					<input type="text" disabled name="taxaSelic.valorString" value='${taxaSelic.valorString}' class="ui fluid campo-form-filtro">
				</div>
			</div>
			<div class="fields separador">
		 		<div class="ui three wide field ">
					<label>Data de Cadastro</label>
					<input type="text" disabled value="<fmt:formatDate pattern='dd/MM/yyyy' value='${taxaSelic.createdAt}' />" class="ui fluid campo-form-filtro">
				</div>
			</div>
		</div>
	</div>
	<br />
	<a class="ui cinza button" href="<c:url value='/taxaSelic'/>">Voltar</a>
</jsp:body>
</template:admin>