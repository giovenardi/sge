<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="ui segment" id="endereco">
	<div class="ui form">
		<div class="fields">
			<input type="hidden" id="enderecoValido" value="${fornecedor.endereco.enderecoValidado}" > 
			<div class="four wide field <c:if test='${acao ne "detalhar"}'>required</c:if>">
				<label>CEP</label>
				<input type="text" class="campo-form cep" <c:if test="${acao eq 'detalhar'}">disabled</c:if> id="cep" name="fornecedor.endereco.cep" value="${fornecedor.endereco.cep}" onblur="getEndereco('fornecedor');">
			</div>
			<div class="six wide field <c:if test='${acao ne detalhar}'>required</c:if>">
				<label>Logradouro</label>
				<input type="text" id="logradouro" <c:if test="${acao eq 'detalhar'}">disabled</c:if> <c:if test='${fornecedor.endereco.enderecoValidado eq true and not empty fornecedor.endereco.logradouro}'>readOnly</c:if> maxlength="255" class="campo-form" name="fornecedor.endereco.logradouro" value="${fornecedor.endereco.logradouro}">
			</div>
			<div class="two wide field <c:if test='${acao ne detalhar}'>required</c:if>">
				<label>Número</label>
				<input type="text" maxlength="10" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.endereco.numero" value="${fornecedor.endereco.numero}">
			</div>
			<div class="four wide field">
				<label>Complemento</label>
				<input type="text" maxlength="255" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.endereco.complemento" value="${fornecedor.endereco.complemento}">
			</div>
		</div>
		<div class="fields">
			<div class="four wide field <c:if test='${acao ne detalhar}'>required</c:if>">
				<label>UF</label>
				<div class="ui selection dropdown estado <c:if test='${fornecedor.endereco.enderecoValidado eq true or acao eq "detalhar"}'>disabled</c:if>">
					<input name="fornecedor.endereco.bairroMunicipioUf.uf.id" id="estado" type="hidden" value="${fornecedor.endereco.bairroMunicipioUf.uf.id}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${listaUfsCombo}" var="uf">
							<div class="item <c:if test="${uf.id.equals(fornecedor.endereco.bairroMunicipioUf.uf.id)}">active selected</c:if>" data-value="${uf.id}">${uf.sigla}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four wide field municipio <c:if test='${acao ne detalhar}'>required</c:if>">
				<label>Cidade</label>
				<div class="ui selection dropdown municipio <c:if test='${fornecedor.endereco.enderecoValidado eq true or acao eq "detalhar"}'>disabled</c:if>">
					<input name="fornecedor.endereco.bairroMunicipioUf.municipio.id" id="municipio" type="hidden" value="${fornecedor.endereco.bairroMunicipioUf.municipio.id}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${listaMunicipiosCombo}" var="municipio">
							<div class="item <c:if test="${municipio.id.equals(fornecedor.endereco.bairroMunicipioUf.municipio.id)}">active selected</c:if>" data-value="${municipio.id}">${municipio.nome}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four wide field <c:if test='${acao ne detalhar}'>required</c:if>">
				<label>Bairro</label>
				<div class="ui selection dropdown bairro <c:if test='${fornecedor.endereco.enderecoValidado eq true or acao eq "detalhar"}'>disabled</c:if>">
					<input name="fornecedor.endereco.bairroMunicipioUf.bairro.id" id="bairro" type="hidden" value="${fornecedor.endereco.bairroMunicipioUf.bairro.id}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${listaBairrosCombo}" var="bairro">
							<div class="item <c:if test="${bairro.id.equals(fornecedor.endereco.bairroMunicipioUf.bairro.id)}">active selected</c:if>" data-value="${bairro.id}">${bairro.nome}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
