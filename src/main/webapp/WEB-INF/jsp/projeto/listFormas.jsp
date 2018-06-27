<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui small modal" id="modalListFormas">
    <div class="ui icon header">
    	<i id="iconeListFormas" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloPlano'>Cadastro de Formas de Pagamento</span>
    </div>
    <div class="content">
		<table class="ui unstackable small table">
			<thead class="teste">
				<tr>
					<th class="six wide">Título</th>
					<th class="three wide">Data Início</th>
					<th class="three wide">Parcelas</th>
					<th class="three wide">Parcelamento</th>
					<th class="one wide">
						<a id="buttonNovaFormaPagamentoPlano" class="ui button icon" data-content="Nova Forma de Pagamento" data-position="top right">
	                    	<i class="plus outline blue icon"></i>
	                    </a>
					</th>
				</tr>
			</thead>
			<tbody id="bodyFormasPagamento">
				<c:forEach items="${plano.formasPagamento}" var="formaPagamento">
					<tr id='formaPagamento${formaPagamento.id}' class="cell-content-selectable">
						<td>${formaPagamento.titulo}</td>
						<td>${formaPagamento.dataInicio}</td>
						<td>${formaPagamento.parcelas}</td>
						<td>${formaPagamento.formaParcelamento.descricao}</td>
						<td>
	                      <input id="urlContext${formaPagamento.id}" value="<c:url value='/formaPagamento/excluir'/>" hidden="true" />
	                      <a id="buttonModal" onclick="modalConfirmAjax(${formaPagamento.id}, removerFormaPagamento)" class="ui button icon" data-content="Excluir" data-position="top right">
	                        <i class="trash outline red icon"></i>
	                      </a>
						</td>
					</tr>
				</c:forEach>
					<tr class="cell-content-selectable">
						<td>30 Parcelas Mensais</td>
						<td>01/07/2017</td>
						<td>30</td>
						<td>Mensal</td>
						<td>
	                      <input id="urlContext" value="<c:url value='/formaPagamento/excluir'/>" hidden="true" />
	                      <a id="buttonModal" class="ui button icon" data-content="Excluir" data-position="top right">
	                        <i class="trash outline red icon"></i>
	                      </a>
						</td>
					</tr>
					<tr class="cell-content-selectable">
						<td>30 Parcelas Mensais</td>
						<td>01/07/2017</td>
						<td>30</td>
						<td>Mensal</td>
						<td>
	                      <input id="urlContext" value="<c:url value='/formaPagamento/excluir'/>" hidden="true" />
	                      <a id="buttonModal" class="ui button icon" data-content="Excluir" data-position="top right">
	                        <i class="trash outline red icon"></i>
	                      </a>
						</td>
					</tr>
					<tr class="cell-content-selectable">
						<td>30 Parcelas Mensais</td>
						<td>01/07/2017</td>
						<td>30</td>
						<td>Mensal</td>
						<td>
	                      <input id="urlContext" value="<c:url value='/formaPagamento/excluir'/>" hidden="true" />
	                      <a id="buttonModal" class="ui button icon" data-content="Excluir" data-position="top right">
	                        <i class="trash outline red icon"></i>
	                      </a>
						</td>
					</tr>
			</tbody>
		</table>
	    <div class="actions" style="text-align: center; border-top:none"> 
	      	<a class="ui red basic cancel button">
	        	<i class="remove icon"></i>
	        	Fechar
	      	</a>
		</div>
	</div>
</div>
<jsp:include page="formFormaPagamentoPlano.jsp" />
