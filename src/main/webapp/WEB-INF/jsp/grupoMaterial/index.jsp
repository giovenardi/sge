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
			  <div class="active section">Grupos de Materiais</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Grupos de Materiais</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/grupoMaterial/add'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/grupoMaterial/imprimirLista'/>', '<c:url value='/grupoMaterial'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
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
			<form class="ui form" action="<c:url value='/grupoMaterial' />" method="post" id="filterForm">
				<div class="fields">
					<div class="three wide field" id="valorPeriodo">
						<label>Tipo de Material</label>
						<div class="ui selection dropdown">
							<input name="grupoMaterial.tipoMaterial" type="hidden" value="${grupoMaterial.tipoMaterial}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaTipos}" var="tipo">
									<div class="item <c:if test="${tipo.name().equals(grupoMaterial.tipoMaterial.name())}">active selected</c:if>" data-value="${tipo.name()}">${tipo.descricao}</div>
								</c:forEach>
			  				</div>
			 			</div>
					</div>
					<div class="six wide field">
						<label>Descrição do Grupo</label>
						<input type="text" name="grupoMaterial.descricao" value='${grupoMaterial.descricao}' class="campo-form-filtro">
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
                   <th class="three wide">Tipo de Material</th>
                   <th class="nine wide">Descrição do Grupo</th>
                   <th class="two wide"></th>
               </tr>
        </thead>
		<tbody>
			<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
       			<tr class="cell-content-selectable">
                 	<td onclick="modalLoading();location.href='<c:url value='/grupoMaterial/show/${det.id}'/>';">${det.id}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/grupoMaterial/show/${det.id}'/>';">${det.tipoMaterial.descricao}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/grupoMaterial/show/${det.id}'/>';">${det.descricao}</td>
					<td>
						<div class="ui icon buttons">
							<a class="ui button" onclick="modalLoading();location.href='<c:url value='/grupoMaterial/edit/${det.id}'/>';" data-content="Editar"> 
								<i class="write icon"></i>
							</a>
							<input id="urlContext${count.index}" value="<c:url value='/grupoMaterial/remove/${det.id}'/>" type="hidden" />
	                      	<a onclick="modalConfirm(${count.index})" class="ui button" data-content="Excluir" data-position="top right">
		                        <i class="trash alternate red icon"></i>
		                   	</a>
						</div> 
					</td> 
              	</tr>
           	</c:forEach>
        </tbody>
    </table> 
    <template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/grupoMaterial" formId="filterForm" />
</jsp:body>
</template:admin>