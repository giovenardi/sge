<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/cargo.js'/>"></script>
 	</jsp:attribute>
 	<jsp:body>
 		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Cadastro</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Cargo</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Cargos</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue inverted button" id="novoCargo">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/cargo/imprimirLista'/>', '<c:url value='/cargo'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<table class="ui black sortable unstackable table">
			<thead class="teste">
				<tr>
					<th class="two wide">Código</th>
					<th class="twelve wide">Nome</th>
                   	<th class="two wide"></th>
				</tr>
			</thead>
		<div class="scrolling content">
			<tbody>
				<c:forEach items="${cargoList}" var="det" varStatus="count">
					<tr class="cell-content-selectable">
						<td>${det.id}</td>
						<td>${det.nome}</td>
						<td>
							<div class="ui icon buttons">
								<a class="ui button" onclick="editarCargo(${det.id})" data-content="Alterar"> 
									<i class="write icon"></i>
								</a>
								<a class="ui button" onclick="visualizarCargo(${det.id})" data-content="Visualizar"> 
									<i class="eye icon"></i>
								</a>
							</div>
						</td> 
					</tr>
				</c:forEach>
			</tbody>
		</div>
		</table> 
		<jsp:include page="formCargo.jsp" />
	</jsp:body>
</template:admin>
