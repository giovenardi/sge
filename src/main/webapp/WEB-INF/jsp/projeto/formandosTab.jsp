<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui bottom attached tab segment" data-tab="formandos_tab">
	<table class="ui unstackable table">
		<thead class="teste">
			<tr>
				<th class="fourteen wide">Nome</th>
				<th class="two wide"><a class="ui gold button icon" id="novoFormando"><i class="plus icon"></i></a></th>
			</tr>
		</thead>
		<tbody id="bodyFormandos">
			<c:forEach items="${projeto.formandos}" var="formando">
				<tr id='formando${formando.id}' class="cell-content-selectable">
					<td>${formando.pessoa.nome}</td>
					<td>
                      <input id="urlContextFormando${formando.id}" value="<c:url value='/formando/excluir'/>" hidden="true" />
                      <a onclick="modalConfirmAjax(${formando.id}, removerFormando)" class="ui button" data-content="Excluir" data-position="top right">
                        <i class="trash alternate red icon"></i>
                      </a>
						<a class="ui button" onclick="editarFormando(${formando.id})" data-content="Alterar"> 
                        <i class="pencil alternate blue icon"></i>
                      </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="formFormando.jsp" />
