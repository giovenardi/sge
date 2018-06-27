<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="cargo.id" type="hidden" value="${cargo.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="eight wide field required">
				<label>Nome</label>
				<input type="text" maxlength="80" class="campo-form" name="cargo.nome" value="${cargo.nome}">
			</div>
		</div>
	</div>
</div>