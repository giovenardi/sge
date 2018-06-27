<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<input type="hidden" name="${prefixoEnd}.id" value="${endereco.id}">
<div class="ui segment" id="endereco">
	<div class="ui form segment">
		<div class="fields">
			<div class="four wide field">
				<label>CEP</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form cep" id="cep" name="${prefixoEnd}.cep" value="${endereco.cep}">
			</div>
			<div class="six wide field">
				<label>Logradouro</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> id="logradouro" maxlength="40" class="campo-form" name="${prefixoEnd}.logradouro" value="${endereco.logradouro}">
			</div>
			<div class="two wide field">
				<label>Número</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="10" class="campo-form" name="${prefixoEnd}.numero" value="${endereco.numero}">
			</div>
			<div class="four wide field">
				<label>Complemento</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="40" class="campo-form" name="${prefixoEnd}.complemento" value="${endereco.complemento}">
			</div>
		</div>
		<div class="fields">
			<div class="four wide field">
				<label>Bairro</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> id="bairro" maxlength="40" class="campo-form" name="${prefixoEnd}.bairro" value="${endereco.bairro}">
			</div>
			<div class="four wide field">
				<label>Cidade</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> id="cidade" maxlength="40" class="campo-form" name="${prefixoEnd}.cidade" value="${endereco.cidade}">
			</div>
			<div class="four wide field">
				<label>UF</label>
				<div class="ui selection dropdown estado <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="${prefixoEnd}.uf.id" id="estado" type="hidden" value="${endereco.uf.id}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${ufs}" var="uf">
							<div class="item <c:if test="${uf.id.equals(endereco.uf.id)}">active selected</c:if>" data-value="${uf.id}">${uf.sigla}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
