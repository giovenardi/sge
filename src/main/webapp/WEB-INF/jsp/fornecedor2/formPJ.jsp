<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="ui segment">
	<div class="ui form">
		<div class="fields">
			<div class="four wide field required">
				<label>CNPJ</label> 
				<input type="text" class="campo-form cnpj" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaJuridica.cnpj" value="${fornecedor.pessoaJuridica.cnpj}">
			</div>
			<div class="six wide field required">
				<label>Razão Social</label>
				<input type="text" maxlength="100" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.pessoaJuridica.razaoSocial" value="${fornecedor.pessoaJuridica.razaoSocial}">
			</div>
			<div class="four wide field date required">
				<label>Data Abertura</label> 
				<input type="text" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaJuridica.dataAbertura" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${fornecedor.pessoaJuridica.dataAbertura}'/>">
			</div>
		</div>
		<div class="fields">
			<div class="six wide field">
				<label>Nome Fantasia</label>
				<input type="text" maxlength="100" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.pessoaJuridica.nomeFantasia" value="${fornecedor.pessoaJuridica.nomeFantasia}">
			</div>
			<div class="four wide field">
				<label>Nº Registro Junta Comercial</label> 
				<input type="text" class="campo-form regJC" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaJuridica.registroJuntaComercial" value="${fornecedor.pessoaJuridica.registroJuntaComercial}">
			</div>
		</div>
		<div class="fields">
			<div class="four wide field required">
				<label>E-mail Principal</label>
				<input type="text" class="campo-form" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.pessoaJuridica.email" value="${fornecedor.pessoaJuridica.email}">
			</div>
		</div>
	</div>
</div>
<div class="ui horizontal divider">Endereço</div>
<jsp:include page="endereco.jsp" />
<div class="ui horizontal divider">Dados de Pagamento</div>
<jsp:include page="dadosPagamento.jsp" />
<div class="ui horizontal divider">Representante</div>
<jsp:include page="representante.jsp" />