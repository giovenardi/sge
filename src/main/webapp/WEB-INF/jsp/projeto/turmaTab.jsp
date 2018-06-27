<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui bottom attached tab segment" data-tab="turma_tab">
	<table class="ui unstackable table">
		<thead class="teste">
			<tr>
				<th class="fourteen wide">Nome</th>
				<th class="two wide"><a class="ui gold button icon" id="novaTurma"><i class="plus icon"></i></a></th>
			</tr>
		</thead>
		<tbody id="bodyTurmas">
			<c:forEach items="${projeto.turmas}" var="turma">
				<tr id='turma${turma.id}' class="cell-content-selectable">
					<td>${turma.nome}</td>
					<td>
                      <input id="urlContext${turma.id}" value="<c:url value='/turma/excluir'/>" hidden="true" />
                      <a id="buttonModal" onclick="modalConfirmAjax(${turma.id}, removerTurma)" class="ui button icon" data-content="Excluir" data-position="top right">
                        <i class="erase outline red icon"></i>
                      </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="formTurma.jsp" />
