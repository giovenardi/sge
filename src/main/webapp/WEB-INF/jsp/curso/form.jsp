<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="curso.id" type="hidden" value="${curso.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="four wide field <c:if test='${acao ne "mostrar"}'>required</c:if>">
				<label>Nome</label>
				<input type="text" maxlength="40" class="campo-form" <c:if test='${acao eq "mostrar"}'>disabled</c:if> name="curso.nome" value="${curso.nome}">
			</div>
		</div>
	</div>
</div>