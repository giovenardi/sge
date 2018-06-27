<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
 	</jsp:attribute>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
 		<script src="<c:url value='/assets/js/fornecedor.js'/>"></script>
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
 			<div class="active section">Fornecedores</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Fornecedores</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" href="<c:url value='/fornecedor/add'/>">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/fornecedor/imprimirLista'/>', '<c:url value='/fornecedor'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
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
				<form class="ui form" action="<c:url value='/fornecedor' />" method="post" id="filterForm">
					<div class="fields">
						<div class="one wide field">
							<label>CRC</label>
							<input type="text" name="fornecedor.crc" value='${fornecedor.crc}' class="campo-form-filtro crc">
						</div>
						<div class="six wide field">
							<label>Nome / Razão Social</label>
							<input type="text" maxlength="100" name="fornecedor.nome" value='${fornecedor.nome}' class="campo-form-filtro">
						</div>
						<div class="three wide field" id="valorPeriodo">
							<label>Situação</label>
							<div class="ui selection dropdown">
								<input name="fornecedor.status" type="hidden" value="${fornecedor.status}">
								<div class="default text">Selecione</div>
								<i class="dropdown icon"></i>
								<div class="menu">
									<c:forEach items="${listaSituacoes}" var="situacao">
										<div class="item <c:if test="${situacao.name().equals(fornecedor.status.name())}">active selected</c:if>" data-value="${situacao.name()}">${situacao.descricao}</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="three wide field">
							<label>Tipo</label>
							<div class="ui selection dropdown tipo">
								<input name="fornecedor.tipoPessoa" type="hidden" id="tipo" value="${fornecedor.tipoPessoa}">
								<div class="default text">Selecione</div>
								<i class="dropdown icon"></i>
								<div class="menu">
									<c:forEach items="${listaTiposPessoa}" var="tipo">
										<div class="item <c:if test="${tipo.name().equals(fornecedor.tipoPessoa.name())}">active selected</c:if>" data-value="${tipo.name()}">${tipo.descricao}</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div id="campocpfcnpj" class="three wide field" <c:if test="${fornecedor.tipoPessoa.name() eq null}">style="display: none"</c:if>>
							<label id="lbcpfcnpj"><c:if test="${fornecedor.tipoPessoa.name() eq 'J'}">CNPJ</c:if><c:if test="${fornecedor.tipoPessoa.name() eq 'F'}">CPF</c:if></label>
							<input type="text" id="cpfcnpj" name="fornecedor.cpfcnpj" value='${fornecedor.cpfcnpj}' class="campo-form-filtro <c:if test="${fornecedor.tipoPessoa.name() eq 'J'}">cnpj</c:if><c:if test="${fornecedor.tipoPessoa.name() eq 'F'}">cpf</c:if>">
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
					<th class="two wide">CRC</th>
					<th class="five wide">Nome do Fornecedor</th>
					<th class="three wide">CPF/CNPJ</th>
					<th class="two wide">Tipo</th>
					<th class="two wide">Situação</th>
					<th class="two wide"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paginatedList.currentList}" var="det" varStatus="count">
					<tr class="cell-content-selectable">
						<td onclick="modalLoading();location.href='<c:url value='/fornecedor/show/${det.id}'/>';">${det.crc}</td>
						<td onclick="modalLoading();location.href='<c:url value='/fornecedor/show/${det.id}'/>';">${det.nome}</td>
						<td onclick="modalLoading();location.href='<c:url value='/fornecedor/show/${det.id}'/>';">${det.cpfcnpj}</td>
						<td onclick="modalLoading();location.href='<c:url value='/fornecedor/show/${det.id}'/>';">${det.tipoPessoa.descricao}</td>
						<td onclick="modalLoading();location.href='<c:url value='/fornecedor/show/${det.id}'/>';">
							<div class="ui label ${det.status.name()}">${det.status.descricao}</div>
						</td>
						<td>
							<div class="ui icon buttons">
								<c:if test="${det.status.name() eq 'A'}">
									<a class="ui button" onclick="modalLoading();location.href='<c:url value='/fornecedor/edit/${det.id}'/>';" data-content="Editar">
										<i class="write icon"></i>
									</a>
									<input id="urlContext${count.index}" value="<c:url value='/fornecedor/remove/${det.id}'/>" type="hidden" />
									<a onclick="modalConfirm(${count.index})" class="ui button" data-content="Excluir" data-position="top right">
										<i class="trash alternate red icon"></i>
									</a>
								</c:if>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/fornecedor" formId="filterForm" />
	</jsp:body>
</template:admin>