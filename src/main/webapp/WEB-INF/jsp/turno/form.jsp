<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="turno.id" type="hidden" value="${turno.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="four wide field <c:if test='${acao ne "mostrar"}'>required</c:if>">
				<label>Nome</label>
				<input type="text" maxlength="40" class="campo-form" <c:if test='${acao eq "mostrar"}'>disabled</c:if> name="turno.nome" value="${turno.nome}">
			</div>
		</div>
		<div class="fields separador">
	 		<div class="two wide field <c:if test='${acao ne "mostrar"}'>required</c:if>">
				<label>Sigla</label>
				<input type="text" maxlength="5" class="campo-form" <c:if test='${acao eq "mostrar"}'>disabled</c:if> name="turno.sigla" value="${turno.sigla}">
			</div>
		</div>
	</div>
</div>