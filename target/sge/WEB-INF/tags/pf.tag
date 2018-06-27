<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="id" type="String" required="true" %>
<%@ attribute name="label" type="String" required="true" %>
<%@ attribute name="obrigatorio" type="Boolean" required="false" %>
<%@ attribute name="prefixo" required="false" rtexprvalue="true" %>
<%@ attribute name="pessoa" required="false" rtexprvalue="true" %>
<div class="fields">
	<div class="twelve wide field ${obrigatorio ne null and obrigatorio.booleanValue()?'required':''}">
		<label>${label}</label>
		<input name="${prefixo}.pessoa.id" id="${id}" type="hidden" value="${formando.pessoa.id}">
		<input type="text" readOnly class="campo-form" id="pfNomePessoa" name="${prefixo}.pessoa.nome" value="${formando.pessoa.nome}">
	</div>
	<div class="four wide field left floated">
		<label>&nbsp;</label>
		<div class="fields">
			<div class="five wide field">
				<a id="pfBtnAddPessoa" class="ui button icon" data-content="Adicionar Pessoa" data-position="top right">
					<i class="add user outline black icon"></i>
				</a>						
			</div>
			<div class="five wide field">
				<a id="pfBtnEditPessoa" class="ui button icon" data-content="Editar Dados" data-position="top right">
					<i class="edit outline black icon"></i>
				</a>						
			</div>
			<div class="five wide field">
				<a id="pfBtnViewPessoa" class="ui button icon" data-content="Visualizar Dados" data-position="top right">
					<i class="expand outline black icon"></i>
				</a>
			</div>
		</div>						
	</div>
</div>