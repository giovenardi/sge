<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="ui bottom attached tab segment" data-tab="eventos_tab">
	<table class="ui unstackable table">
		<thead class="teste">
			<tr>
				<th class="ten wide">Evento</th>
				<th class="three wide">Início</th>
				<th class="three wide">Final</th>
				<th class="four wide"><a class="ui gold button icon" id="novoProjetoEvento"><i class="plus icon"></i></a></th>
			</tr>
		</thead>
		<tbody id="bodyProjetoEvento">
			<c:forEach items="${projeto.eventos}" var="projetoEvento">
				<tr id='projetoEvento${projetoEvento.id}' class="cell-content-selectable">
					<td>${projetoEvento.evento.nome}</td>
					<td>
						<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${projetoEvento.inicio}" />
					</td>
					<td>
						<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${projetoEvento.fim}" />
					</td>
					<td>
                      <input id="urlContext${projetoEvento.id}" value="<c:url value='/projetoEvento/excluir'/>" hidden="true" />
                      <a id="buttonModal" onclick="modalConfirmAjax(${projetoEvento.id}, removerProjetoEvento)" class="ui button icon" data-content="Excluir" data-position="top right">
                        <i class="trash alternate red icon"></i>
                      </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="formProjetoEvento.jsp" />
