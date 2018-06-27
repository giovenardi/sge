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
			  <div class="active section">UFIRCEs</div>
		</div>
		<div class="ui grid">
		<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">UFIRCEs</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/ufirCE/add'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/ufirCE/imprimirLista'/>', '<c:url value='/ufirCE'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>	
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
			<form class="ui form" action="<c:url value='/ufirCE' />" method="post" id="filterForm">
				<div class="fields">
					<div class="ui dateANO three wide field required">
						<label>Ano Vigência</label>
						<input class="ui fluid campo-form-filtro" name="ufirCE.anoVigencia" value="${ufirCE.anoVigencia}">
					</div>
					<div class="four wide field" id="valorPeriodo">
						<label>Situação</label>
						<div class="ui selection dropdown">
							<input name="ufirCE.status" type="hidden" value="${ufirCE.status.name()}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaStatus}" var="status">
									<div class="item <c:if test="${status.name() eq ufirCE.status.name()}">active selected</c:if>" data-value="${status.name()}">${status.descricao}</div>
								</c:forEach>
			  				</div>
			 			</div>
					</div>
					<div class="four wide field" id="valorPeriodo">
						<label>Aplicada</label>
						<div class="ui selection dropdown">
							<input name="ufirCE.aplicada" type="hidden" value="${ufirCE.aplicada.name()}">
			  				<div class="default text">Selecione</div>
			  				<i class="dropdown icon"></i>
			  				<div class="menu">
								<c:forEach items="${listaSimNao}" var="aplicada">
									<div class="item <c:if test="${aplicada.name() eq ufirCE.aplicada.name()}">active selected</c:if>" data-value="${aplicada.name()}">${aplicada.descricao}</div>
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
                   <th class="one wide">Código</th>
                   <th class="two wide">Início da Vigência</th>
                   <th class="two wide">Valor da UFIRCE</th>
                   <th class="two wide">Fator Multiplicador</th>
                   <th class="three wide">Data de Cadastro</th>
                   <th class="two wide">Situação</th>
                   <th class="two wide">Aplicada</th>
                   <th class="two wide"></th>
               </tr>
        </thead>
		<tbody>
			<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
       			<tr class="cell-content-selectable">
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';">${det.id}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';"><fmt:formatDate pattern='dd/MM/yyyy' value='${det.inicioVigencia}' /></td>
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';">${det.valorString}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';">${det.percentualAcrescimoString}</td>
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';"><fmt:formatDate pattern='dd/MM/yyyy HH:mm:ss' value='${det.createdAt}' /></td>
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';"><div class="ui label ${det.status.name()}">${det.status.descricao}</div></td>
                 	<td onclick="modalLoading();location.href='<c:url value='/ufirCE/show/${det.id}'/>';">${det.aplicada.descricao}</td>
					<td>
						<div class="ui icon buttons">
							<c:if test="${det.aplicada.name() eq 'N'}">
								<a class="ui button" onclick="modalLoading();location.href='<c:url value='/ufirCE/edit/${det.id}'/>';" data-content="Editar"> 
									<i class="write icon"></i>
								</a>
								<c:if test="${det.status.name() eq 'A'}">
			                      	<a href="<c:url value='/ufirCE/remove/${det.id}'/>" class="ui button" data-content="Excluir" data-position="top right">
				                        <i class="trash outline red icon"></i>
				                   	</a>
			                   	</c:if>
		                   	</c:if>
						</div> 
					</td> 
              	</tr>
           	</c:forEach>
        </tbody>
    </table> 
    <template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/ufirCE" formId="filterForm" />
</jsp:body>
</template:admin>