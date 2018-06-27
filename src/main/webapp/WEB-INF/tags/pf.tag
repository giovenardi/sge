<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="label" type="String" required="true" %>
<%@ attribute name="obrigatorio" type="Boolean" required="false" %>
<%@ attribute name="prefixo" required="true" rtexprvalue="true" %>
<%@ attribute name="pessoa" required="false" rtexprvalue="true" %>
<%@ attribute name="funcao" required="true" rtexprvalue="true" %>
<div class="fields">
	<div class="twelve wide field ${obrigatorio ne null and obrigatorio.booleanValue()?'required':''}">
		<label>${label}</label>
		<input name="${prefixo}.pessoa.id" class="pfId" type="hidden" value="">
		<input type="text" readOnly class="campo-form pfNome" value="">
	</div>
	<div class="four wide field left floated">
		<label>&nbsp;</label>
		<div class="fields">
			<div class="five wide field">
				<a id="pfBtnAddPessoa" class="ui button icon" onclick="${funcao}" data-content="Adicionar/Editar Pessoa" data-position="top right">
					<i class="add user outline black icon"></i>
				</a>						
			</div>
		</div>						
	</div>
</div>
