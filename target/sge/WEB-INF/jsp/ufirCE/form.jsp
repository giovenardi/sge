<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<input type="hidden" name="ufirCE.id" value="${ufirCE.id}"/>
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
			<c:if test="${acao eq 'add'}">
				<div class="ui dateANO three wide field required">
					<label>Ano de Vigência</label>
					<input class="ui fluid campo-form-filtro" name="ufirCE.anoVigencia" value="${ufirCE.anoVigencia}" >
				</div>
			</c:if>
			<c:if test="${acao ne 'add'}">
				<div class="ui date three wide field required">
					<label>Início de Vigência</label>
					<input type="hidden" name="ufirCE.inicioVigencia" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${ufirCE.inicioVigencia}' />" >
					<input type="text" class="ui fluid campo-form-filtro" disabled name="ufirCE.inicioVigencia" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${ufirCE.inicioVigencia}' />" >
				</div>
			</c:if>
		</div>
		<div class="fields">
	 		<div class="three wide field required">
				<label>Valor</label>
				<input type="text" name="ufirCE.valorString" value='${ufirCE.valorString}' class="campo-form ufir">
			</div>
		</div>
	</div>
</div>