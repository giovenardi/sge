<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="ui unstackable table">
	<thead class="teste">
		<tr>
			<th class="four wide">Nome</th>
			<th class="three wide">Celular</th>
			<th class="four wide">E-mail</th>
			<th class="three wide">Função</th>
			<th class="two wide"><a class="ui gold button icon" id="novoMembroComissao"><i class="plus icon"></i></a></th>
		</tr>
	</thead>
	<tbody id="bodyMembrosComissao">
		<c:forEach items="${projeto.comissaoFormatura.membros}" var="membroComissao">
			<tr id='membroComissao${membroComissao.id}' class="cell-content-selectable">
				<td>${membroComissao.pessoa.nome}</td>
				<td>${membroComissao.celularPrincipal}</td>
				<td>${membroComissao.emailPrincipal}</td>
				<td>${membroComissao.funcao.nome}</td>
				<td>
                     <input id="urlContextMembroComissao${membroComissao.id}" value="<c:url value='/membroComissao/excluir'/>" hidden="true" />
                     <a onclick="modalConfirmAjax(${membroComissao.id}, removerMembroComissao)" class="ui button" data-content="Excluir" data-position="top right">
                       <i class="trash alternate red icon"></i>
                     </a>
					<a class="ui button" onclick="editarMembroComissao(${membroComissao.id})" data-content="Alterar">
                       <i class="pencil alternate blue icon"></i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="formMembroComissao.jsp" />