<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<input type="hidden" name="taxaSelic.id" value="${taxaSelic.id}"/>
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
			<c:if test="${acao eq 'add'}">
				<div class="ui dateMES two wide field required">
					<label>Mês de Referência</label>
					<input class="ui fluid campo-form-filtro" name="taxaSelic.mesReferencia" value="<fmt:formatNumber value='${taxaSelic.mesReferencia}' minIntegerDigits='2'/>" >
				</div>
				<div class="ui dateANO two wide field required">
					<label>Ano de Referência</label>
					<input class="ui fluid campo-form-filtro" name="taxaSelic.anoReferencia" value="${taxaSelic.anoReferencia}" >
				</div>
			</c:if>
			<c:if test="${acao ne 'add'}">
				<div class="ui dateMES two wide field">
					<label>Mês de Referência</label>
					<input class="ui fluid campo-form-filtro" disabled name="taxaSelic.mesReferencia" value="<fmt:formatNumber value='${taxaSelic.mesReferencia}' minIntegerDigits='2'/>" >
					<input type="hidden" name="taxaSelic.mesReferencia" value="<fmt:formatNumber value='${taxaSelic.mesReferencia}' minIntegerDigits='2'/>" >
				</div>
				<div class="ui dateANO two wide field">
					<label>Ano de Referência</label>
					<input class="ui fluid campo-form-filtro" disabled name="taxaSelic.anoReferencia" value="${taxaSelic.anoReferencia}" >
					<input type="hidden" name="taxaSelic.anoReferencia" value="${taxaSelic.anoReferencia}" >
				</div>
			</c:if>
	 		<div class="two wide field required">
				<label>Valor da Taxa Selic</label>
				<input type="text" name="taxaSelic.valorString" value='${taxaSelic.valorString}' class="campo-form selic">
			</div>
		</div>
	</div>
</div>