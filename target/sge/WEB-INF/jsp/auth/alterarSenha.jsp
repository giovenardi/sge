<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
	<jsp:body>
		<script type="text/javascript">
			function limpar(){
				$(".campo-form-login").val('');
			}
		</script>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right chevron icon divider"></i>
			<div class="section">Usuário</div>
			<i class="right arrow icon divider"></i>
			<a href="<c:url value='/auth/alterarSenha'/>">Alterar Senha</a>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
				<h2 class="ui header" style="padding-top: 10px">Alterar Senha</h2>
			</div>
		</div>
		<hr>
		<div class="ui mini form">
		<form class="boxLogin ui form" role="form" action="<c:url value='/auth/trocaSenha'/>" method="POST">
			<div class="three fields">
				<div class="field"><div class="two fields"></div></div>
				<div class="field">
					<div class="ui segment">
						<div class="two fields">
							<div class="field">
							    <label>Nome do Usuário</label>
							    <input type="text" disabled class="campo-form-login" value="${usuarioLogado.usuario.funcionario.pessoa.nome}"/>
						    </div>
						</div>
						<div class="two fields">
							<div class="field">
							    <label>Lotação</label>
							    <input type="text" disabled class="campo-form-login" value="${usuarioLogado.usuario.lotacao}" />
						    </div>
						</div>
						<div class="two fields">
							<div class="field">
							    <label>Matrícula</label>
							    <input type="text" disabled class="campo-form-login" value="${usuarioLogado.usuario.funcionario.matricula}" />
						    </div>
						</div>
						<div class="two fields">
							<div class="field">
							    <label>Senha Atual</label>
							    <input type="password" name="usuario.senhaAtual" class="campo-form-login" id="usuario.senhaAtual" value="${usuario.senhaAtual}" placeholder="SENHA ATUAL"/>
						    </div>
						</div>
						<div class="two fields">
							<div class="field">
							    <label>Nova Senha</label>
							    <input type="password" name="usuario.senha" class="campo-form-login" id="usuario.senha" value="${usuario.senha}" placeholder="NOVA SENHA"/>
						    </div>
						</div>
						<div class="two fields">
							<div class="field">
							    <label>Confirmação da Senha</label>
							    <input type="password" name="usuario.cpf" class="campo-form-login" id="usuario.confSenha" value="${usuario.confSenha}" placeholder="CONFIRMAR SENHA"/>
						    </div>
						</div>
						<div class="four fields">
							<div class="field">
							<button class="ui button green" type="submit">Enviar</button>
						    </div>
							<div class="field">
							<a class="ui cinza button" href="<c:url value='/auth'/>">Cancelar</a>
						    </div>
						</div>
					</div>
				</div>
				<div class="field"></div>
			</div>
		</form>
		</div>
</jsp:body>
</template:admin>