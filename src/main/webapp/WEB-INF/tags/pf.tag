<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="label" type="String" required="true" %>
<%@ attribute name="obrigatorio" type="Boolean" required="false" %>
<%@ attribute name="prefixo" required="true" rtexprvalue="true" %>
<%@ attribute name="pessoa" required="false" rtexprvalue="true" %>
<%@ attribute name="esconder" type="Boolean" required="false"%>
<%@ attribute name="funcao" required="true" rtexprvalue="true" %>
<div class="ui unstackable fields" id="pfTag" ${esconder ne null and esconder eq true ? 'style="display:none"' : '' }>
	<div class="twelve wide field ${obrigatorio ne null and obrigatorio.booleanValue()?'required':''}">
		<label>${label}</label>
		<input name="${prefixo}.pessoa.id" class="pfId" id="pfId" type="hidden" value="">
		<input type="text" id="pfNome" readOnly class="campo-form pfNome" value="">
	</div>
	<div class="four wide field left floated">
		<label>&nbsp;</label>
		<div class="ui buttons fields">
			<a id="pfBtnAddPessoa" class="ui button icon" onclick="${funcao}" data-content="Adicionar/Editar Pessoa" data-position="top right">
				<i class="add user alternate black icon"></i>
			</a>			
			<a class="or" data-text="ou"></a>			
			<a id="pfBtnLimpar" class="ui button red icon" onclick="limparPF()" data-content="Limpar Pessoa" data-position="top right">
				<i class="remove user alternate black icon"></i>
			</a>						
		</div>						
	</div>
</div>
