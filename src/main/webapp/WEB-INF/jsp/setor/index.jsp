<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
 	</jsp:attribute>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
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
			  <div class="section">Cadastro</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Setor</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Setores</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/setor/novo'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/setor/imprimirLista'/>', '<c:url value='/setor'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
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
				<form class="ui form" action="<c:url value='/setor/' />" method="post" id="filterForm">
					<div class="fields separador">
				 		<div class="five wide field required">
							<label>Nome</label>
							<input type="text" maxlength="50" class="campo-form" name="setor.nome" value="${setor.nome}">
						</div>
					</div>
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
					<th class="two wide">Código</th>
					<th class="nine wide">Nome</th>
					<th class="three wide">Sigla</th>
                   	<th class="two wide"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
					<tr class="cell-content-selectable">
						<td onclick="modalLoading();location.href='<c:url value='/setor/mostrar/${det.id}'/>';">${det.id}</td>
						<td onclick="modalLoading();location.href='<c:url value='/setor/mostrar/${det.id}'/>';">${det.nome}</td>
						<td onclick="modalLoading();location.href='<c:url value='/setor/mostrar/${det.id}'/>';">${det.sigla}</td>
						<td>
							<div class="ui icon buttons">
								<a class="ui button" onclick="modalLoading();location.href='<c:url value='/setor/alterar/${det.id}'/>';" data-content="Alterar"> 
								<i class="write icon"></i>
							</a>
						</div> 
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/setor" formId="filterForm" />
	</jsp:body>
</template:admin>