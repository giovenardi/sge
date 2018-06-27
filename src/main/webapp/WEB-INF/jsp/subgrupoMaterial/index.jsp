<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
	</jsp:attribute>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
		<script src="<c:url value='/assets/js/grupoMaterial.js'/>"></script>
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
			  <div class="section">Gestão Logística</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Almoxarifado</div>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Cadastro Base</div>
			  
			  <i class="right arrow icon divider"></i>
			  <div class="section">Subgrupos de Materiais</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Subgrupos de Materiais</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/subgrupoMaterial/add'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/subgrupoMaterial/imprimirLista'/>', '<c:url value='/subgrupoMaterial'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
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
			<form class="ui form" action="<c:url value='/subgrupoMaterial' />" method="post" id="filterForm">
				<div class="fields">
					<div class="four wide field" id="valorPeriodo">
						<label>Grupo</label>
						<div class="ui selection dropdown">
							<input name="subgrupoMaterial.grupoMaterial.id" type="hidden" value="${subgrupoMaterial.grupoMaterial.id}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaGrupos}" var="grupo">
									<div class="item <c:if test="${grupo.id eq subgrupoMaterial.grupoMaterial.id}">active selected</c:if>" data-value="${grupo.id}">${grupo.descricao}</div>
								</c:forEach>
			  				</div>
			 			</div>
					</div>
					<div class="six wide field">
						<label>Subgrupo</label>
						<input type="text" name="subgrupoMaterial.descricao" value='${subgrupoMaterial.descricao}' class="campo-form-filtro">
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
	       	        <th class="two wide">Código</th>
                   <th class="seven wide">Grupo</th>
                   <th class="seven wide">Subgrupo</th>
                   <th class="two wide"></th>
               </tr>
        </thead>
		<tbody>
			<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
       			<tr class="cell-content-selectable">
                 	<td onclick="modalLoading();location.href='<c:url value='/subgrupoMaterial/show/${det.id}'/>';">${det.id}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/subgrupoMaterial/show/${det.id}'/>';">${det.grupoMaterial.descricao}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/subgrupoMaterial/show/${det.id}'/>';">${det.descricao}</td>
					<td>
						<div class="ui icon buttons">
							<a class="ui button" onclick="modalLoading();location.href='<c:url value='/subgrupoMaterial/edit/${det.id}'/>';" data-content="Editar"> 
								<i class="write icon"></i>
							</a>
							<input id="urlContext${count.index}" value="<c:url value='/subgrupoMaterial/remove/${det.id}'/>" type="hidden" />
	                      	<a onclick="modalConfirm(${count.index})" class="ui button" data-content="Excluir" data-position="top right">
		                        <i class="trash outline red icon"></i>
		                   	</a>
						</div> 
					</td> 
              	</tr>
           	</c:forEach>
        </tbody>
    </table> 
    <template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/subgrupoMaterial" formId="filterForm" />
</jsp:body>
</template:admin>