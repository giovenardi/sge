<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:login>
	<jsp:body>
		<script type="text/javascript">
			function limpar(){
				$(".campo-form-login").val('');
			}
		</script>
		<form class="boxLogin ui form" role="form" action="<c:url value='/auth/trocaSenha'/>" method="POST">
			<div class="topoLogin"><span class="glyphicon glyphicon-log-in"></span><br />ESQUECEU SUA SENHA?</div>
			<c:if test="${not empty mensagem}">			
				<div class="ui yellow message">${mensagem}</div>
			</c:if>
			<div class="field">
			    <label>Código</label>
			    <input type="text" name="usuario.token" class="campo-form-login" id="usuario.token" value="${usuario.token}" placeholder="INFORME O CÓDIGO"/>
			    <input type="hidden" name="usuario.identidadedetran" value="${usuario.identidadedetran}"/>
		    </div>
			<div class="field">
			    <label>Nova Senha</label>
			    <input type="password" name="usuario.senha" class="campo-form-login" id="usuario.senha" value="${usuario.senha}" placeholder="NOVA SENHA"/>
		    </div>
			<div class="field">
			    <label>Confirmação da Senha</label>
			    <input type="password" name="usuario.confSenha" class="campo-form-login" id="usuario.confSenha" value="${usuario.confSenha}" placeholder="CONFIRMAR SENHA"/>
		    </div>
			<button class="ui button green" type="submit">Enviar</button>
			<a class="ui cinza button" href="<c:url value='/auth'/>">Cancelar</a>
		</form>
</jsp:body>
</template:login>