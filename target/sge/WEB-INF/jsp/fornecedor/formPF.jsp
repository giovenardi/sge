<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<input type="hidden" name="material.id" value="${material.id}" />
<div class="ui segment">
	<div class="ui form">
		<div class="fields">
			<div class="three wide field required">
				<label>CPF</label>
				<input type="text" class="campo-form cpf" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.cpf" value="${fornecedor.pessoaFisica.cpf}">
			</div>
			<div class="six wide field required">
				<label>Nome</label>
				<input type="text" maxlength="100" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.nome" value="${fornecedor.pessoaFisica.nome}">
			</div>
			<div class="three wide field required">
				<label>Sexo</label>
				<div class="ui selection dropdown subgrupo <c:if test="${acao eq 'detalhar'}">disabled</c:if>">
					<input name="fornecedor.pessoaFisica.sexo" type="hidden" value="${fornecedor.pessoaFisica.sexo}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${listaSexos}" var="sexo">
							<div class="item <c:if test="${sexo.name().equals(fornecedor.pessoaFisica.sexo.name())}">active selected</c:if>" data-value="${sexo.name()}">${sexo.descricao}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four date wide field required">
				<label>Data de Nascimento</label>
				<input type="text" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${fornecedor.pessoaFisica.dataNascimento}" />">
			</div>
		</div>
		<div class="fields">
			<div class="three wide field required">
				<label>Estado Civil</label>
				<div class="ui selection dropdown subgrupo <c:if test="${acao eq 'detalhar'}">disabled</c:if>">
					<input name="fornecedor.pessoaFisica.estadoCivil" type="hidden" value="${fornecedor.pessoaFisica.estadoCivil}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${listaEstadosCivis}" var="estadocivil">
							<div class="item <c:if test="${estadocivil.name().equals(fornecedor.pessoaFisica.estadoCivil.name())}">active selected</c:if>" data-value="${estadocivil.name()}">${estadocivil.descricao}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four wide field required">
				<label>RG</label>
				<input type="text" maxlength="14" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.rg" value="${fornecedor.pessoaFisica.rg}">
			</div>
			<div class="two wide field required">
				<label>Orgão Emissor</label>
				<input type="text" maxlength="15" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.orgaoEmissorRG" value="${fornecedor.pessoaFisica.orgaoEmissorRG}">
			</div>
			<div class="three wide field required">
				<label>UF</label>
				<div class="ui selection dropdown subgrupo <c:if test="${acao eq 'detalhar'}">disabled</c:if>">
					<input name="fornecedor.pessoaFisica.ufRG.id" type="hidden" value="${fornecedor.pessoaFisica.ufRG.id}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${listaUfsCombo}" var="uf">
							<div class="item <c:if test="${uf.id.equals(fornecedor.pessoaFisica.ufRG.id)}">active selected</c:if>" data-value="${uf.id}">${uf.sigla}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four date wide field required">
				<label>Data de Emissão</label>
				<input type="text" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.dataEmissaoRG" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${fornecedor.pessoaFisica.dataEmissaoRG}'/>">
			</div>
		</div>
		<div class="fields">
			<div class="six wide field">
				<label>Nome do Mãe</label>
				<input type="text" maxlength="100" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.nomeMae" value="${fornecedor.pessoaFisica.nomeMae}">
			</div>
			<div class="six wide field">
				<label>Nome do Pai</label>
				<input type="text" maxlength="100" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.nomePai" value="${fornecedor.pessoaFisica.nomePai}">
			</div>
			<div class="four wide field required">
				<label>E-mail Principal</label>
				<input type="text" maxlength="100" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaFisica.email" value="${fornecedor.pessoaFisica.email}">
			</div>
		</div>
	</div>
</div>
<div class="ui horizontal divider">Endereço</div>
<jsp:include page="../endereco/tela.jsp" />
<div class="ui horizontal divider">Dados de Pagamento</div>
<jsp:include page="dadosPagamento.jsp" />
<div class="ui horizontal divider">Representante</div>
<jsp:include page="representante.jsp" />