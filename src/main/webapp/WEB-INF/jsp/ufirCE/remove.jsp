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
			  <a href="<c:url value='/ufirCE'/>">UFIRCEs</a>
			  <i class="right arrow icon divider"></i>
			  <div class="active section">Excluir UFIRCE</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Excluir UFIRCE</h2>
			</div>
		</div>
		<hr> 
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
			 		<div class="six wide field">
						<label>Início Vigência - Valor</label>
						<input type="text" value='${descufir}' readonly class="campo-form">
					</div>
				</div>
			</div>
		</div>
		<hr>
        <form role="form" action="<c:url value='/ufirCE/remove'/>" method="POST" onsubmit="return validarForm()">
        	<input type="hidden" name="ufirCE.id" value="${id}"/>
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="ui sixteen wide field required">
							<label>Motivo da Exclusão</label>
							<input type="text" maxlength="255" class="ui fluid campo-form-filtro" name="ufirCE.motivoExclusao" value="">
						</div>
					</div>
				</div>
			</div>
            <a class="ui cinza button" href="<c:url value='/ufirCE'/>">Voltar</a>
            <button class="ui green button" type="submit">Salvar</button>
        </form>
    </jsp:body>
</template:admin>