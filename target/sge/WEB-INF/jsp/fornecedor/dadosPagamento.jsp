<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="ui segment">
	<div class="ui form">
		<div class="fields">
			<div class="six wide field">
				<label>Banco</label>
				<div class="ui selection dropdown subgrupo <c:if test="${acao eq 'detalhar'}">disabled</c:if>">
					<input name="fornecedor.dadosPagamento.banco.id" id="banco" value="${fornecedor.dadosPagamento.banco.id}" type="hidden">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<div class="item active selected" data-value=""></div>
						<c:forEach items="${listaBancos}" var="banco">
							<div class="item <c:if test="${banco.id.equals(fornecedor.dadosPagamento.banco.id)}">active selected</c:if>" data-value="${banco.id}">${banco.codigo} - ${banco.nome}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="two wide field">
				<label>Agência</label>
				<input type="text" maxlength="4" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.dadosPagamento.agencia" value="${fornecedor.dadosPagamento.agencia}">
			</div>
			<div class="three wide field">
				<label>Conta-Corrente</label>
				<input type="text" maxlength="13" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.dadosPagamento.contaCorrente" value="${fornecedor.dadosPagamento.contaCorrente}">
			</div>
		</div>
	</div>
</div>