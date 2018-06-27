<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			  <div class="section">Gestão Financeira</div>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Cadastros Corporativos</div>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Taxas Selic</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Taxas Selic</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/taxaSelic/add'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/taxaSelic/imprimirLista'/>', '<c:url value='/taxaSelic'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
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
			<form class="ui form" action="<c:url value='/taxaSelic' />" method="post" id="filterForm">
				<div class="fields">
					<div class="ui dateMES three wide field">
						<label>Mês de Referência</label>
						<input class="ui fluid campo-form-filtro" name="taxaSelic.mesReferencia" value="<fmt:formatNumber value='${taxaSelic.mesReferencia}' minIntegerDigits='2'/>">
					</div>
					<div class="ui dateANO three wide field">
						<label>Ano de Referência</label>
						<input class="ui fluid campo-form-filtro" name="taxaSelic.anoReferencia" value="${taxaSelic.anoReferencia}">
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
                   <th class="one wide">Código</th>
                   <th class="four wide">Mês/Ano de Referência</th>
                   <th class="four wide">Valor</th>
                   <th class="four wide">Data de Cadastro</th>
                   <th class="three wide"></th>
               </tr>
        </thead>
		<tbody>
			<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
       			<tr class="cell-content-selectable">
                 	<td onclick="modalLoading();location.href='<c:url value='/taxaSelic/show/${det.id}'/>';">${det.id}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/taxaSelic/show/${det.id}'/>';"><fmt:formatNumber value="${det.mesReferencia}" minIntegerDigits="2"/> / ${det.anoReferencia}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/taxaSelic/show/${det.id}'/>';">${det.valorString}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/taxaSelic/show/${det.id}'/>';"><fmt:formatDate pattern='dd/MM/yyyy' value='${det.createdAt}' /></td>
					<td>
						<div class="ui icon buttons">
							<a class="ui button" onclick="modalLoading();location.href='<c:url value='/taxaSelic/edit/${det.id}'/>';" data-content="Editar"> 
								<i class="write icon"></i>
							</a>
						</div> 
					</td> 
              	</tr>
           	</c:forEach>
        </tbody>
    </table> 
    <template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/taxaSelic" formId="filterForm" />
</jsp:body>
</template:admin>