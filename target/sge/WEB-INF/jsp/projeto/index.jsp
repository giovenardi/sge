<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
 	</jsp:attribute>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
 		<script src="<c:url value='/assets/js/funcionario.js'/>"></script>
 	</jsp:attribute>
 	<jsp:body>
 		<script type="text/javascript">
 			function limpar(){
 				$('form').form('clear');
 			}
 		</script>
 		<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Projetos</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Painel</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Painel de Projetos</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/projeto/imprimirLista'/>', '<c:url value='/projeto'/>')" data-content="Imprimir" data-position="top right">
							<i class="print icon"></i>
						</a>
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
				<form class="ui form" action="<c:url value='/funcionario/' />" method="post" id="filterForm">
					<div class="fields separador">
				 		<div class="five wide field required">
							<label>Nome</label>
							<input type="text" maxlength="100" class="campo-form" name="projeto.nome" value="${projeto.nome}">
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
		<table class="ui selectable stackable table blue">
			<thead class="teste">
				<tr>
					<th class="two wide">Número</th>
					<th class="four wide">Nome</th>
					<th class="two wide">Tipo</th>
					<th class="three wide">Gerente</th>
					<th class="three wide">Vendedor</th>
					<th class="two wide">Status</th>
					<th class="one wide"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
					<tr class="cell-content-selectable">
						<td onclick="modalLoading();location.href='<c:url value='/projeto/show/${det.id}'/>';">${det.numero}</td>
						<td onclick="modalLoading();location.href='<c:url value='/projeto/show/${det.id}'/>';" title="${det.nome}" nowrap><div style="overflow:hidden; text-overflow: ellipsis">${det.nome}</div></td>
						<td onclick="modalLoading();location.href='<c:url value='/projeto/show/${det.id}'/>';" title="${det.tipo.descricao}">${det.tipo.descricao}</td>
						<td onclick="modalLoading();location.href='<c:url value='/projeto/show/${det.id}'/>';">${det.gerente.pessoa.nome}</td>
						<td onclick="modalLoading();location.href='<c:url value='/projeto/show/${det.id}'/>';">${det.vendedor.pessoa.nome}</td>
						<td onclick="modalLoading();location.href='<c:url value='/projeto/show/${det.id}'/>';">${det.status.descricao}</td>
						<td>
							<div class="ui icon buttons">
								<a class="ui button" onclick="modalLoading();location.href='<c:url value='/projeto/alterar/${det.id}'/>';" data-content="Alterar"> 
								<i class="write icon"></i>
							</a>
						</div> 
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/funcionario" formId="filterForm" />
	</jsp:body>
</template:admin>