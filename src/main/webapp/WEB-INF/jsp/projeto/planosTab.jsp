<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui bottom attached tab segment" data-tab="planos_tab">
	<table class="ui unstackable table">
		<thead class="teste">
			<tr>
				<th class="fourteen wide">Nome</th>
				<th class="two wide"><a class="ui gold button icon" id="novoPlano"><i class="plus icon"></i></a><a class="ui gold button icon" id="atualizarContratos"><i class="plus icon"></i>Atualizar Contratos</a></th>
			</tr>
		</thead>
		<tbody id="bodyPlanos">
			<c:forEach items="${projeto.planosPagamento}" var="plano">
				<tr id='plano${plano.id}' class="cell-content-selectable">
					<td>${plano.nome}</td>
					<td>
                      <input id="urlContextPlano${plano.id}" value="<c:url value='/planoPagamento/excluir'/>" hidden="true" />
                      <a onclick="modalConfirmAjax(${plano.id}, removerPlano)" class="ui button icon" data-content="Excluir" data-position="top right">
                        <i class="erase alternate red icon"></i>
                      </a>
                      <a onclick="editarPlano(${plano.id})" class="ui button icon" data-content="Alterar" data-position="top right">
                        <i class="pencil alternate blue icon"></i>
                      </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="formPlano.jsp" />
