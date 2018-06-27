<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="ui bottom attached tab segment" data-tab="cerimonial_tab">
	<form id="formCerimonial" role="form" action="<c:url value='/cerimonial/salvar'/>" method="POST">
		<input name="cerimonial.id" id="cerimonialId" type="hidden" value="${projeto.cerimonial.id}">
		<input name="cerimonial.valor" id="cerimonialValor" type="hidden" value="<fmt:formatNumber value="${projeto.cerimonial.valor}" minFractionDigits="2" maxFractionDigits="2"></fmt:formatNumber>">
		<input name="cerimonial.valorConvidadoExtra" id="cerimonialValorConvidadoExtra" type="hidden" value="<fmt:formatNumber value="${projeto.cerimonial.valorConvidadoExtra}" minFractionDigits="2" maxFractionDigits="2"></fmt:formatNumber>">
		<input name="cerimonial.projeto.id" type="hidden" value="${projeto.id}">
		<div class="ui form">
			<div class="fields separador">
		 		<div class="three wide field">
					<label>Valor Total</label>
					<input type="text" maxlength="18" id="maskedCerimonialValor" class="campo-form dinheiro" value="<fmt:formatNumber value="${projeto.cerimonial.valor}" type="currency"></fmt:formatNumber>">
				</div>
	 			<div class="two wide field">
					<label>Previsão Convidados</label>
					<input type="text" maxlength="4"  class="campo-form numero4" name="cerimonial.previsaoConvidados" value="${projeto.cerimonial.previsaoConvidados}">
				</div>
		 		<div class="three wide field">
					<label>Valor Convidado Extra</label>
					<input type="text" maxlength="18" id="maskedCerimonialValorConvidadoExtra"  class="campo-form dinheiro" value="<fmt:formatNumber value="${projeto.cerimonial.valorConvidadoExtra}" type="currency"></fmt:formatNumber>">
				</div>
 				<div class="three wide field">
					<label>Responsabilidade Financeira</label>
					<div class="ui selection dropdown responsabilidade <c:if test='${acao eq "show"}'>disabled</c:if>">
						<input name="cerimonial.responsabilidadeFinanceira" id="responsabilidade" class="select" type="hidden" value="${projeto.cerimonial.responsabilidadeFinanceira}">
  						<div class="default text">Selecione</div>
  						<i class="dropdown icon"></i>
  						<div class="menu">
							<c:forEach items="${listaResponsabilidades}" var="resp">
								<div class="item <c:if test="${resp.name().equals(projeto.cerimonial.responsabilidadeFinanceira.name())}">active selected</c:if>" data-value="${resp.name()}">${resp.descricao}</div>
							</c:forEach>
  						</div>
 					</div>
				</div>
 				<div class="three wide field">
					<label>Meio de Pagamento</label>
					<div class="ui selection dropdown responsabilidade <c:if test='${acao eq "show"}'>disabled</c:if>">
						<input name="cerimonial.meioPagamento" id="meioPagamento" class="select" type="hidden" value="${projeto.cerimonial.meioPagamento}">
  						<div class="default text">Selecione</div>
  						<i class="dropdown icon"></i>
  						<div class="menu">
							<c:forEach items="${meiosPagamento}" var="resp">
								<div class="item <c:if test="${resp.name().equals(projeto.cerimonial.responsabilidadeFinanceira.name())}">active selected</c:if>" data-value="${resp.name()}">${resp.descricao}</div>
							</c:forEach>
  						</div>
 					</div>
				</div>
			</div>
			<br/>
	        <button class="ui gold button" type="button" onclick="submeterFormAjax('formCerimonial', 'alteracao:ok')">Salvar</button>
	      	<a id="btnFormaPagamentoCerimonial" class="ui gold inverted button" href="#"><i class="dollar icon"></i>Forma de Pagamento</a>
		</div>
	</form>
	<br/>
			<div class="fields">
	 			<div class="sixteen wide field">
					<h4 class="ui centered dividing header">Programação financeira</h4>
				</div>
			</div>
	<table class="ui unstackable table">
		<thead class="teste">
			<tr>
				<th class="one wide">Parcela</th>
				<th class="two wide">Data Vencimento</th>
				<th class="three wide">Valor</th>
				<th class="two wide">Status</th>
				<th class="seven wide">Observação</th>
				<th class="one wide">
					<a id="buttonGerar" onclick="gerarProgramacao()" class="ui gold button icon" data-content="Gerar Programação Financeira" data-position="top right">
                    	<i class="wizard outline icon"></i>
                    </a>
				</th>
			</tr>
		</thead>
		<tbody id="bodyProgramacaoProjeto">
			<c:forEach items="${projeto.programacoesFinanceiras}" var="programacao">
				<tr id='programacao${programacao.id}' class="cell-content-selectable">
					<td>${programacao.numeroParcela}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${programacao.dataVencimento}" /></td>
					<td>${programacao.valor}</td>
					<td>${programacao.status}</td>
					<td>${programacao.observacao}</td>
					<td>
                      <input id="urlContext${programacao.id}" value="<c:url value='/programacaoFinanceiraProjeto/excluir'/>" hidden="true" />
                      <a id="buttonProgramacaoProjetoModal" onclick="modalConfirmAjax(${programacao.id}, removerProgramacaoProjeto)" class="ui button" data-content="Excluir" data-position="top right">
                        <i class="erase outline red icon"></i>
                      </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="formFormaPagamentoCerimonial.jsp" />