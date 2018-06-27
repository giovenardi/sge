<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="ui segment">
	<div class="ui form">
		<div class="fields">
			<div class="six wide field required">
				<label>Representante</label>
				<input type="text" maxlength="100" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.representante.nome" value="${fornecedor.representante.nome}">
			</div>
			<div class="six wide field required">
				<label>E-mail</label>
				<input type="text" maxlength="100" <c:if test="${acao eq 'detalhar'}">disabled</c:if> class="campo-form" name="fornecedor.representante.email" value="${fornecedor.representante.email}">
			</div>
		</div>
		<div class="fields">
			<div class="four wide field required">
				<label>Telefone Fixo</label>
				<input type="text" class="campo-form telefone" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.representante.telefone" value="${fornecedor.representante.telefone}">
			</div>
			<div class="four wide field required">
				<label>Celular</label>
				<input type="text" class="campo-form telefone" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.representante.celular" value="${fornecedor.representante.celular}">
			</div>
			<div class="four wide field">
				<label>Fax</label>
				<input type="text" class="campo-form telefone" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.representante.fax" value="${fornecedor.representante.fax}">
			</div>
			<div class="four wide field">
				<label>Ramal</label>
				<input type="text" class="campo-form ramal" <c:if test="${acao eq 'detalhar'}">disabled</c:if> name="fornecedor.representante.ramal" value="${fornecedor.representante.ramal}">
			</div>
		</div>
	</div>
</div>
