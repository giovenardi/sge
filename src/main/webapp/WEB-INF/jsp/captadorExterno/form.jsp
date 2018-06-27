<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "pt_BR"/>
<input name="captadorExterno.id" type="hidden" value="${captadorExterno.id}">
<div id="divfunci" <c:if test='${acao eq "novo" and captadorExterno.pessoa.cpf eq null}'>style="display:none"</c:if>>
	<div class="ui horizontal divider">Dados Financeiros</div>
	<div class="ui segment">
		<div class="ui form">
			<div class="fields separador">
		 		<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
					<label>Valor do Bônus</label>
					<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="10" id="maskedValor" class="campo-form dinheiro" value='<fmt:formatNumber value="${captadorExterno.valor}" type="currency"></fmt:formatNumber>'>
				</div>
				<input type="hidden" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="10" id="valor" class="campo-form" name="captadorExterno.valor" value="${captadorExterno.valor}">
			</div>
		</div>
	</div>
	
	<c:set var="pessoa" scope="request" value="${captadorExterno.pessoa}" />
	<c:set var="prefixoPes" scope="request" value="captadorExterno.pessoa" />
	<div class="ui horizontal divider">Dados Pessoais</div>
	<jsp:include page="../pessoaFisica/tela.jsp" />
</div>