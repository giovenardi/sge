<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="formaCaptacao.id" type="hidden" value="${formaCaptacao.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="eight wide field required">
				<label>Nome</label>
				<input type="text" maxlength="50" class="campo-form disabled" name="formaCaptacao.nome" value="${formaCaptacao.nome}">
			</div>
		</div>
	</div>
</div>