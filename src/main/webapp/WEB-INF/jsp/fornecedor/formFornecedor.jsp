<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi" %>
<div class="ui small modal" id="modalFornecedor">
    <div class="ui icon header">
    	<i id="iconeFornecedor" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloFornecedor'>Cadastro de Fornecedor</span>
    </div>
    <form role="form" id="formFornecedor" method="POST" action='<c:url value="/fornecedor/salvar"/>'>
		<input name="fornecedor.id" id="fornecedorId" type="hidden" value="${fornecedor.id}">
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
			    	<lummi:pf label="Nome" obrigatorio="true" prefixo="fornecedor" funcao="inserirEditarPFFornecedor()" esconder="${fornecedor.pessoa eq null || fornecedor.pessoa.tipo.name() eq 'PF'}"/>
			    	<lummi:pj label="Nome" obrigatorio="true" prefixo="fornecedor" funcao="inserirEditarPJFornecedor()" esconder="${fornecedor.pessoa ne null && fornecedor.pessoa.tipo.name() eq 'PJ'}"/>
				</div>
			</div>
		    <div class="actions" style="text-align: center"> 
		      	<a class="ui red basic cancel button">
		        	<i class="remove icon"></i>
		        	Cancelar
		      	</a>
		      	<a id="btnConfirmFornecedor" class="ui green ok inverted button" href="#">
		        	<i class="checkmark icon"></i>
		        	Salvar
		      	</a>
				</div>
		</div>
	</form>
</div>
