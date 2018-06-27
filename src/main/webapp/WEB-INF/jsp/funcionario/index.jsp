<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
 	</jsp:attribute>
 	<jsp:attribute name="extraScripts">
 		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
		<script src="<c:url value='/assets/js/pessoa.js'/>"></script>
 		<script src="<c:url value='/assets/js/funcionario.js'/>"></script>
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
			  <div class="section">Recursos Humanos</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Funcionários</div>
 		</div>
 		<div class="ui grid">
 			<div class="eight wide column">
 				<h2 class="ui header" style="padding-top: 10px">Funcionários</h2>
			</div>
			<div class="eight wide column">
				<div class="iconsTop">
					<a class="ui blue button" id="novoFuncionario">Incluir</a>
					<div class="pipe"></div>
					<div class="ui icon buttons">
						<a target="_blank" class="ui cinza button" onclick="imprimir('<c:url value='/funcionario/imprimirLista'/>', '<c:url value='/funcionario'/>')" data-content="Imprimir" data-position="top right"><i class="print icon"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="scrolling content">
			<table class="ui black unstackable table">
				<thead class="teste">
					<tr>
						<th class="two wide">Matrícula</th>
						<th class="eight wide">Nome</th>
						<th class="six wide">Cargo</th>
						<th class="two wide"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${funcionarioList}" var="det" varStatus="count">
						<tr class="cell-content-selectable">
							<td onclick="modalLoading();location.href='<c:url value='/funcionario/show/${det.id}'/>';">${det.matricula}</td>
							<td onclick="modalLoading();location.href='<c:url value='/funcionario/show/${det.id}'/>';">${det.pessoa.nome}</td>
							<td onclick="modalLoading();location.href='<c:url value='/funcionario/show/${det.id}'/>';">${det.cargo.nome}</td>
							<td>
								<div class="ui icon buttons">
									<a class="ui button" onclick="editarFuncionario(${det.id})" data-content="Alterar"> 
									<i class="write icon"></i>
								</a>
							</div> 
						</tr>
					</c:forEach>
				</tbody>
			</table> 
		</div>
		<jsp:include page="formFuncionario.jsp" />
		<jsp:include page="../pessoaFisica/tela.jsp" />
	</jsp:body>
</template:admin>