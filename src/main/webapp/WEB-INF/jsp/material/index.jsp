<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
	</jsp:attribute>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
		<script src="<c:url value='/assets/js/material.js'/>"></script>
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
			  <div class="active section">Materiais</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Materiais</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/material/add'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/material/imprimirLista'/>', '<c:url value='/material'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
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
			<form class="ui form" action="<c:url value='/material' />" method="post" id="filterForm">
				<div class="fields">
					<div class="four wide field" id="valorPeriodo">
						<label>Tipo de Material</label>
						<div class="ui selection dropdown tipo">
							<input name="material.subgrupoMaterial.grupoMaterial.tipoMaterial" type="hidden" id="tipo" value="${material.subgrupoMaterial.grupoMaterial.tipoMaterial}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaTipos}" var="tipo">
									<div class="item <c:if test="${tipo.name().equals(material.subgrupoMaterial.grupoMaterial.tipoMaterial.name())}">active selected</c:if>" data-value="${tipo.name()}">${tipo.descricao}</div>
								</c:forEach>
			  				</div>
			 			</div>
					</div>
					<div class="six wide field" id="valorPeriodo">
						<label>Grupo de Material</label>
						<div class="ui selection dropdown grupo">
							<input name="material.subgrupoMaterial.grupoMaterial.id" id="grupo" type="hidden" value="${material.subgrupoMaterial.grupoMaterial.id}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaGrupos}" var="grupo">
									<div class="item <c:if test="${grupo.id.equals(material.subgrupoMaterial.grupoMaterial.id)}">active selected</c:if>" data-value="${grupo.id}">${grupo.descricao}</div>
								</c:forEach>
			  				</div>
			 			</div>
					</div>
					<div class="six wide field" id="valorPeriodo">
						<label>Subgrupo de Material</label>
						<div class="ui selection dropdown subgrupo">
							<input name="material.subgrupoMaterial.id" id="subgrupo" type="hidden" value="${material.subgrupoMaterial.id}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaSubgrupos}" var="subgrupo">
									<div class="item <c:if test="${subgrupo.id.equals(material.subgrupoMaterial.id)}">active selected</c:if>" data-value="${subgrupo.id}">${subgrupo.descricao}</div>
								</c:forEach>
			  				</div>
			 			</div>
					</div>
				</div>
				<div class="fields">
					<div class="ten wide field">
						<label>Nome do Material</label>
						<input type="text" name="material.nome" value='${material.nome}' class="campo-form-filtro">
					</div>
					<div class="three wide field" id="valorPeriodo">
						<label>Situação</label>
						<div class="ui selection dropdown">
							<input name="material.status" type="hidden" value="${material.status}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaStatus}" var="status">
									<div class="item <c:if test="${status.name().equals(material.status.name())}">active selected</c:if>" data-value="${status.name()}">${status.descricao}</div>
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
       	        <th class="two wide">Código</th>
                   <th class="nine wide">Descrição do Material</th>
                   <th class="three wide">Situação</th>
                   <th class="two wide"></th>
               </tr>
        </thead>
		<tbody>
			<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
       			<tr class="cell-content-selectable">
                 	<td onclick="modalLoading();relocar('<c:url value='/material/show/${det.id}'/>');">${det.id}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/material/show/${det.id}'/>';">${det.descricaoAbreviada()}</td>
               		<td onclick="modalLoading();location.href='<c:url value='/material/show/${det.id}'/>';"><div class="ui label ${det.status.name()}">${det.status.descricao}</div></td>
					<td>
						<div class="ui icon buttons">
							<a class="ui button" onclick="modalLoading();location.href='<c:url value='/material/edit/${det.id}'/>';" data-content="Editar"> 
								<i class="write icon"></i>
							</a>
							<c:if test="${det.status.name() eq 'A'}">
								<input id="urlContextInactive${count.index}" value="<c:url value='/material/inactive/${det.id}'/>" type="hidden" />
		                      	<a onclick="modalInactive(${count.index})" class="ui button" data-content="Inativar" data-position="top right">
			                        <i class="remove circle red icon"></i>
			                   	</a>
							</c:if>
							<c:if test="${det.status.name() eq 'I'}">
								<input id="urlContextActive${count.index}" value="<c:url value='/material/active/${det.id}'/>" type="hidden" />
		                      	<a onclick="modalActive(${count.index})" class="ui button" data-content="Reativar" data-position="top right">
			                        <i class="check circle green icon"></i>
			                   	</a>
							</c:if>
							<input id="urlContext${count.index}" value="<c:url value='/material/remove/${det.id}'/>" type="hidden" />
	                      	<a onclick="modalConfirm(${count.index})" class="ui button" data-content="Excluir" data-position="top right">
		                        <i class="trash alternate red icon"></i>
		                   	</a>
						</div> 
					</td> 
              	</tr>
           	</c:forEach>
        </tbody>
    </table> 
    <template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/material" formId="filterForm" />
</jsp:body>
</template:admin>