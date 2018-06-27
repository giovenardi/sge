<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="cargo.id" type="hidden" value="${cargo.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="eight wide field  <c:if test='${acao ne "mostrar"}'>required</c:if>">
				<label>Nome</label>
				<input type="text" maxlength="80" class="campo-form disabled" <c:if test='${acao eq "mostrar"}'>disabled</c:if> name="cargo.nome" value="${cargo.nome}">
			</div>
		</div>
	</div>
</div>