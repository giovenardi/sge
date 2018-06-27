<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="setor.id" type="hidden" value="${setor.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="eight wide field required">
				<label>Nome</label>
				<input type="text" maxlength="50" class="campo-form disabled" name="setor.nome" value="${setor.nome}">
			</div>
		</div>
		<div class="fields separador">
	 		<div class="four wide field required">
				<label>Sigla</label>
				<input type="text" maxlength="10" class="campo-form disabled" name="setor.sigla" value="${setor.sigla}">
			</div>
		</div>
	</div>
</div>