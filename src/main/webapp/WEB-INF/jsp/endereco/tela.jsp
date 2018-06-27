<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<div class="ui" id="endereco" style="height: 100%">
	<input type="hidden" name="${prefixoEnd}.id" value="${endereco.id}">
	<div class="ui form">
		<div class="fields">
			<div class="four wide field">
				<label>CEP</label>
				<input id="endereco_cep" type="text" class="campo-form cep" name="${prefixoEnd}.cep">
			</div>
			<div class="eight wide field">
				<label>Logradouro</label>
				<input id="endereco_logradouro" type="text" maxlength="40" class="campo-form" name="${prefixoEnd}.logradouro">
			</div>
			<div class="two wide field">
				<label>Número</label>
				<input id="endereco_numero" type="text" maxlength="10" class="campo-form" name="${prefixoEnd}.numero">
			</div>
		</div>
		<div class="fields">
			<div class="eight wide field">
				<label>Complemento</label>
				<input id="endereco_complemento" type="text" maxlength="40" class="campo-form" name="${prefixoEnd}.complemento">
			</div>
			<div class="eight wide field">
				<label>Bairro</label>
				<input id="endereco_bairro" type="text" maxlength="40" class="campo-form" name="${prefixoEnd}.bairro">
			</div>
		</div>
		<div class="fields">
			<div class="eight wide field">
				<label>Cidade</label>
				<input id="endereco_cidade" type="text" maxlength="40" class="campo-form" name="${prefixoEnd}.cidade">
			</div>
			<div class="eight wide field">
				<label>UF</label>
				<div class="ui selection dropdown estado">
					<input id="endereco_uf_id" name="${prefixoEnd}.uf.id"type="hidden" value="${endereco.uf.id}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${ufs}" var="uf">
							<div class="item" data-value="${uf.id}">${uf.nome}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
