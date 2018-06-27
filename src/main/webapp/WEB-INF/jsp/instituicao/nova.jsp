<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" scope="request" value="novo" />
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">Cadastro</div>
			<i class="right chevron icon divider"></i>
			<a href="<c:url value='/instituicao/'/>" class="section">Instituição</a>
			<i class="right chevron icon divider"></i>
			<div class="active section">Nova</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Nova Instituição</h2>
			</div>
		</div>
		<hr>
		<form class="ui form segment" id="formAdd" action="<c:url value='/instituicao/nova'/>" method="POST" onsubmit="return validarForm()">
			<jsp:include page="form.jsp" />
			<a class="ui cinza button" href="<c:url value='/instituicao/'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
		</form>
		<div>
			<table class="ui black unstackable table">
				<thead class="teste">
					<tr>
						<th class="fourteen wide">Nome</th>
	                   	<th class="two wide"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${instituicao.unidades}" var="uni" varStatus="count">
						<tr class="cell-content-selectable">
							<td>${uni.nome}</td>
							<td>
								<div class="ui icon buttons">
									<a class="ui button" onclick="modalLoading();location.href='<c:url value='/instituicao/alterar/${det.id}'/>';" data-content="Alterar"> 
										<i class="write icon"></i>
									</a>
								</div>
							</td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</template:admin>