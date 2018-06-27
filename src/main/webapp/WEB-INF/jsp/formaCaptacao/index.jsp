<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/formaCaptacao.js'/>"></script>
 	</jsp:attribute>
 	<jsp:body>
 		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Cadastro</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Forma de Captação</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Formas de Captação</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui green inverted button" id="novoFormaCaptacao">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/formaCaptacao/imprimirLista'/>', '<c:url value='/formaCaptacao'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<table class="ui black unstackable table">
			<thead class="teste">
				<tr>
					<th class="two wide">Código</th>
					<th class="twelve wide">Nome</th>
                   	<th class="two wide"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${formaCaptacaoList}" var="det" varStatus="count">
					<tr class="cell-content-selectable">
						<td>${det.id}</td>
						<td>${det.nome}</td>
						<td>
							<div class="ui icon buttons">
								<a class="ui button" onclick="editarFormaCaptacao(${det.id})" data-content="Alterar"> 
									<i class="write icon"></i>
								</a>
								<a class="ui button" onclick="visualizarFormaCaptacao(${det.id})" data-content="Visualizar"> 
									<i class="eye icon"></i>
								</a>
							</div>
						</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<jsp:include page="formFormaCaptacao.jsp" />
	</jsp:body>
</template:admin>
