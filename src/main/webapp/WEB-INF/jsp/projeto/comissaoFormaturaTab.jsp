<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui bottom attached tab segment" data-tab="comissao_tab">
	<form role="form" id="formComissao" action="<c:url value='/projeto/comissaoFormatura'/>" method="POST" onsubmit="return validarForm('formComissao')">
		<input name="projeto.comissaoFormatura.id"	id="comissaoId" type="hidden" value="${projeto.comissaoFormatura.id}">
		<div class="ui segment">
			<div class="ui form">
				<div class="fields">
					<div class="eight wide field <c:if test='${acao ne "show"}'>required</c:if>">
						<label>Email Comissão</label>
						<input type="text" maxlength="255" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form email" name="projeto.comissaoFormatura.email" value="">
					</div>
				</div>
			</div>
		</div>
	</form>
	<jsp:include page="listaMembrosComissao.jsp" />
</div>
