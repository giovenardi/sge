<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<c:set var="acao" value="add" scope="request" />
<template:admin>
    <jsp:body>
     	<div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right chevron icon divider"></i>
			  <div class="section">Gestão Financeira</div>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Cadastros Corporativos</div>
			  <i class="right arrow icon divider"></i>
			  <a href="<c:url value='/taxaSelic'/>">Taxas Selic</a>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Excluir Taxa Selic</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Excluir Taxa Selic</h2>
			</div>
		</div>
		<hr> 
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
			 		<div class="six wide field">
						<label>Início Vigência - Valor</label>
						<input type="text" value='${descselic}' readonly class="campo-form">
					</div>
				</div>
			</div>
		</div>
		<hr>
        <form role="form" action="<c:url value='/taxaSelic/remove'/>" method="POST" onsubmit="return validarForm()">
        	<input type="hidden" name="taxaSelic.id" value="${id}"/>
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="ui sixteen wide field required">
							<label>Motivo da Exclusão</label>
							<input type="text" maxlength="255" class="ui fluid campo-form-filtro" name="taxaSelic.motivoExclusao" value="">
						</div>
					</div>
				</div>
			</div>
            <a class="ui cinza button" href="<c:url value='/taxaSelic'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
        </form>
    </jsp:body>
</template:admin>