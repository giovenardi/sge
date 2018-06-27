<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:login>
	<jsp:body>
		<script type="text/javascript">
			(function() {if (!window['___grecaptcha_cfg']) { window['___grecaptcha_cfg'] = {}; };if (!window['___grecaptcha_cfg']['render']) { window['___grecaptcha_cfg']['render'] = 'onload'; };window['__google_recaptcha_client'] = true;var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;po.src = 'https://www.gstatic.com/recaptcha/api2/r20170315121834/recaptcha__pt.js'; var elem = document.querySelector('script[nonce]');var nonce = elem && (elem['nonce'] || elem.getAttribute('nonce'));if (nonce) { po.setAttribute('nonce', nonce); }var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);})();

			function limpar(){
				$(".campo-form-login").val('');
			}
		</script>
		<form class="boxLogin ui form" role="form" action="<c:url value='/auth/logar'/>" method="POST">
			<div class="topoLogin"><span class="glyphicon glyphicon-log-in"></span><br />LOGIN</div>
			<c:if test="${not empty mensagem}">			
				<div class="ui yellow message">${mensagem}</div>
			</c:if>
			<div class="field">
			    <label>Usuário</label>
			    <input type="text" name="usuario.login" class="campo-form-login" id="usuario.login" value="${usuario.login}" placeholder="Usuário"/>
		    </div>
		    <div class="field">
			    <label>Senha</label>
			    <input type="password" name="usuario.senha" class="campo-form-login" id="usuario.senha" value="${usuario.senha}" placeholder="Senha"/>
		    </div>
			<button class="ui button gray" type="submit">Entrar</button>
			<button class="ui button gray" onclick="limpar();" type="button">Limpar</button>
			<br><br><a href="<c:url value='/auth/redefinir'/>"><span class="label">Esqueci minha senha</span></a>
			<!-- div class="g-recaptcha" data-sitekey="6LcvKRoUAAAAAHwrIWdVY37w1XVwejzdF4BUYXlm" data-site="compact" data-theme="dark"></div -->
		</form>
</jsp:body>
</template:login>