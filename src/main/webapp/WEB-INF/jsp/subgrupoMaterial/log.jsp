<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
		  	<a href="<c:url value='/'/>" class="section">In�cio</a>
		  	<i class="right chevron icon divider"></i>
			  <div class="section">Gest�o Log�stica</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Almoxarifado</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Cadastro Base</div>
			  
			  <i class="right arrow icon divider"></i>
		  	<a href="<c:url value='/subgrupoMaterial'/>" class="section">Subgrupos de Materiais</a>
		  	<i class="right arrow icon divider"></i>
			<a href="<c:url value='/subgrupoMaterial/show/${auditoria.objectId}'/>" class="section">Detalhar Subgrupo de Material</a>
			<i class="right arrow icon divider"></i>
			<a class="section" href="<c:url value='/subgrupoMaterial/historico/${auditoria.objectId}'/>">Hist�rico</a>
			<i class="right arrow icon divider"></i>
			<div class="active section">Log</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<div class="twelve wide column"><h2 class="ui header" style="padding-top: 10px">Log do Subgrupo de Material</h2></div>
			</div>
			<div class="eight wide column">
				<div  style="float: right">
				<div class="ui icon buttons"><a target="_blank" class="ui cinza button" href="<c:url value='/subgrupoMaterial/imprimirLog/${auditoria.id}/${descricao}'/>" data-content="Imprimir"><i class="print icon"></i></a></div>
				</div>
			</div>	
		</div>
		<hr> 
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
			 		<div class="six wide field">
						<label>Descri��o do Subgrupo</label>
						<input type="text" value='${descricao}' readonly class="campo-form">
					</div>
				</div>
			</div>
		</div>
		<hr> 
		<div class="ui segment">
		  <div class="ui form">
		  <div class="fields">
		    <div class="five wide field">
		        <label>Usu�rio</label>
				<input type="text"  name="auditoria.usuario.nomecompleto" value="${auditoria.usuario.getNomeParaRelatorio()}" readonly>
		    </div>
		    <div class="five wide field">
		        <label>A��o</label>
				<input type="text" name="auditoria.acao.descricao" value="${auditoria.acao.descricao}" readonly>
		    </div>
		    <div class="five wide field">
		        <label>Data / Hora</label>
				<input type="text" name="auditoria.createdAt" value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${auditoria.createdAt}" />" readonly>
		    </div>
		  </div>
		  </div>
		</div>
		<table class="ui black unstackable table">
		    <thead>
				<tr>
					<th><b>Campo</b></th>
					<th><b>Valor Anterior</b></th>
					<th><b>Valor Atual</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${auditoria.itensLog}" var="item">
					<tr class="${item.classe}">
						<td><b>${item.coluna}</b></td>
						<td>${item.anterior}</td>
						<td>${item.atual}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="ui cinza button" href="<c:url value='/subgrupoMaterial/historico/${auditoria.objectId}'/>">Voltar</a>
	</jsp:body>
</template:admin>
