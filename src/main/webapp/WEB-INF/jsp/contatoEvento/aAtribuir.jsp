<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
 	</jsp:attribute>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
 		<script src="<c:url value='/assets/js/contato.js'/>"></script>
 	</jsp:attribute>
 	<jsp:body>
 		<script type="text/javascript">
 			function limpar(){
 				$("form").form('clear');
 			}
 		</script>
 		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Projetos</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Contatos não Atribuídos</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Contatos não Atribuídos</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/contatoEvento/novo'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/contato/imprimirAAtribuir'/>', '<c:url value='/contato'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="ui styled fluid accordion">
			<div class="active title">
				<i class="dropdown icon"></i>
				Filtro de Pesquisa
			</div>
			<div class="content active">
				<form class="ui form" action="<c:url value='/contatoEvento/aatribuir' />" method="post" id="filterForm">
					<div class="fields">
						<div class="four wide field">
							<label>Tipo de Projeto</label>
							<div class="ui selection dropdown">
								<input name="contatoEvento.tipoProjeto" type="hidden" value="${contatoEvento.tipoProjeto.name()}">
								<div class="default text">Selecione</div>
								<i class="dropdown icon"></i>
								<div class="menu">
									<c:forEach items="${tipos}" var="tipo">
										<div class="item <c:if test="${tipo.name().equals(contatoEvento.tipoProjeto.name())}">active selected</c:if>" data-value="${tipo.name()}">${tipo.descricao}</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="fields">
						<button class="ui blue button">Filtrar</button>
						<button class="ui button gray" onclick="limpar();" type="button">Limpar</button>
					</div>
				</form>
			</div>
		</div>
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
						</div> 
					</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/fornecedor" formId="filterForm" />
	</jsp:body>
</template:admin>