<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/instituicao.js'/>"></script>
 	</jsp:attribute>
 	<jsp:body>
 		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Cadastro</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Instituição</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Instituições</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue inverted button" id="novoInstituicao">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/cargo/imprimirLista'/>', '<c:url value='/cargo'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<table class="ui black unstackable table">
			<thead class="teste">
				<tr>
					<th class="two wide">Código</th>
					<th class="five wide">Nome</th>
					<th class="seven wide">Nome Completo</th>
                   	<th class="two wide"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${instituicaoList}" var="det" varStatus="count">
					<tr id='instituicao${det.id}' class="cell-content-selectable">
						<td>${det.id}</td>
						<td>${det.nome}</td>
						<td>${det.nomeCompleto}</td>
						<td>
							<div class="ui icon buttons">
								<a class="ui button" onclick="editarInstituicao(${det.id})" data-content="Alterar"> 
									<i class="write icon"></i>
								</a>
								<a class="ui button" onclick="visualizarInstituicao(${det.id})" data-content="Visualizar"> 
									<i class="eye icon"></i>
								</a>
                      			<input id="urlContextInst${det.id}" value="<c:url value='/instituicao/excluir'/>" hidden="true" />
                      			<a id="buttonModal" onclick="modalConfirmAjax(${det.id}, removerInstituicao)" class="ui button icon" data-content="Excluir" data-position="top right">
                        			<i class="erase alternate red icon"></i>
                      			</a>
							</div>
						</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<jsp:include page="formInstituicao.jsp" />
		<jsp:include page="formUnidadeInstituicao.jsp" />
	</jsp:body>
</template:admin>
