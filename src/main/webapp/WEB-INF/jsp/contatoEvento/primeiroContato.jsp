<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/contato.js'/>"></script>
 	</jsp:attribute>
 	<jsp:body>
 		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Projetos</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Primeiro Contato</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Primeiro Contato</h2>
			</div>
		</div>
		<hr>
		<table class="ui black unstackable table">
			<thead class="teste">
				<tr>
					<th class="three wide">Tipo de Projeto</th>
					<th class="six wide">Nome do Projeto</th>
					<th class="five wide">Nome do Contato</th>
                   	<th class="two wide"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
					<tr class="cell-content-selectable">
						<td onclick="modalLoading();location.href='<c:url value='/contatoEvento/showaatribuir/${det.id}'/>';">${det.tipoProjeto.descricao}</td>
						<td onclick="modalLoading();location.href='<c:url value='/contatoEvento/showaatribuir/${det.id}'/>';">${det.nomeProjeto}</td>
						<td onclick="modalLoading();location.href='<c:url value='/contatoEvento/showaatribuir/${det.id}'/>';">${det.nome}</td>
						<td>
							<div class="ui icon buttons">
								<a class="ui button" onclick="modalLoading();location.href='<c:url value='/contatoEvento/alterar/${det.id}'/>';" data-content="Alterar"> 
									<i class="write icon"></i>
								</a>
								<a class="ui button" onclick="solicitarAprovacao(${det.id})" data-content="Solicitar Aprovação"> 
									<i class="glyphicon glyphicon-transfer"></i>
								</a>
							</div> 
						</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<jsp:include page="formSolicitarAprovacao.jsp" />
	</jsp:body>
</template:admin>