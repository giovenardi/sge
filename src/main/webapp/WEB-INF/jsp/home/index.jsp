<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
<jsp:body>
	<div class="ui small breadcrumb">
	      <a href="<c:url value='/'/>" class="section">Início</a>
	</div>
	<div class="ui success message">
	  <b>${usuarioLogado.usuario.funcionario.pessoa.nome}</b>, Bem-vindo(a). <br>
	</div>
	<div class="ui info message">
	  Navegue no sistema utilizando o menu ao lado.<br />
	  Nunca esqueça de sair do sistema quando não estiver mais utilizando.
	</div>
</jsp:body>
</template:admin>