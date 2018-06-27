<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:login>
	<jsp:body>
		<script type="text/javascript">
			function limpar(){
				$(".campo-form-login").val('');
			}
		</script>
		<form class="boxLogin ui form" role="form" action="<c:url value='/auth/redefinir'/>" method="POST">
			<div class="topoLogin"><span class="glyphicon glyphicon-log-in"></span><br />ESQUECEU SUA SENHA?</div>
			<c:if test="${not empty mensagem}">			
				<div class="ui yellow message">${mensagem}</div>
			</c:if>
			<div class="field">
			    <label>CPF</label>
			    <input type="text" name="usuario.cpf" class="campo-form-login cpf" id="usuario.cpf" value="${usuario.cpf}" placeholder="CPF"/>
		    </div>
			<button class="ui button green" type="submit">Enviar</button>
			<a class="ui cinza button" href="<c:url value='/auth'/>">Cancelar</a>
		</form>
</jsp:body>
</template:login>