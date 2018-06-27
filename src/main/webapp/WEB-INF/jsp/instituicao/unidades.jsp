<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table id="listaUnidades" class="ui black unstackable table">
	<thead class="teste">
		<tr>
			<th colspan="2" class="sixteen wide center aligned"><h2 class="ui green sub header">Unidades</h2></th>
		</tr>
		<tr>
			<th class="fourteen wide">Nome</th>
			<c:if test='${acao ne "mostrar"}'>
				<th class="two wide"><a class="ui gold button icon" data-content="Nova Unidade" id="novaUnidade" data-position="top right"><i class="plus icon"></i></a></th>
			</c:if>
		</tr>
	</thead>
	<tbody id="bodyUnidades">
		<c:forEach items="${instituicao.unidades}" var="uni" varStatus="count">
			<tr class="cell-content-selectable" id="unidade${uni.id}">
				<td>${uni.nome}</td>
				<c:if test='${acao ne "mostrar"}'>
					<td>
						<div class="ui icon buttons">
	                   		<input id="urlContext${uni.id}" value="<c:url value='/instituicao/excluirUnidade'/>" hidden="true" />
	                      	<a onclick="modalConfirmAjax(${uni.id}, removerUnidade)" class="ui button icon" data-content="Excluir" data-position="top right">
		                        <i class="trash alternate red icon"></i>
		                   	</a>
	                      	<a onclick="editarUnidade(${uni.id})" class="ui button icon" data-content="Alterar" data-position="top right">
		                    	<i class="pencil alternate blue icon"></i>
		                	</a>
						</div>
					</td> 
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
