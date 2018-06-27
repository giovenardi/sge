<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="label" type="String" required="true" %>
<%@ attribute name="obrigatorio" type="Boolean" required="false" %>
<%@ attribute name="prefixo" required="true" rtexprvalue="true" %>
<%@ attribute name="pessoa" required="false" rtexprvalue="true" %>
<%@ attribute name="esconder" type="Boolean" required="false"%>
<%@ attribute name="funcao" required="true" rtexprvalue="true" %>
<div class="fields" id="pjTag" ${esconder ne null and esconder eq true ? 'style="display:none"' : '' }>
	<div class="twelve wide field ${obrigatorio ne null and obrigatorio.booleanValue()?'required':''}">
		<label>${label}</label>
		<input name="${prefixo}.pessoa.id" class="pjId" id="pjId" type="hidden" value="">
		<input type="text" id="pjNome" readOnly class="campo-form pfNome" value="">
	</div>
	<div class="four wide field left floated">
		<label>&nbsp;</label>
		<div class="fields">
			<div class="four wide field">
				<a id="pfBtnAddPessoa" class="ui button icon" onclick="${funcao}" data-content="Adicionar/Editar Pessoa" data-position="top right">
					<i class="add user alternate black icon"></i>
				</a>						
			</div>
			<div class="three wide field">
				<a id="pfBtnLimpar" class="ui button red icon" onclick="limparPJ()" data-content="Limpar Pessoa" data-position="top right">
					<i class="remove user alternate black icon"></i>
				</a>
			</div>
		</div>						
	</div>
</div>
