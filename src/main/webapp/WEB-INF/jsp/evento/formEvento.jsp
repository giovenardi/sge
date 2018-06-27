<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi" %>
<div class="ui small modal" id="modalEvento">
    <div class="ui icon header">
    	<i id="iconeEvento" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloEvento'>Cadastro de Funcionário</span>
    </div>
    <form role="form" id="formEvento" method="POST" action='<c:url value="/evento/salvar"/>'>
		<input name="evento.id" id="eventoId" type="hidden" value="${evento.id}">
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Nome</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="250" class="campo-form" id="eventoNome" name="evento.nome" value="">
						</div>
					</div>
				</div>
			</div>
		    <div id="botoesForm" class="actions" style="text-align: center"> 
		      	<a class="ui red basic cancel button">
		        	<i class="remove icon"></i>
		        	Cancelar
		      	</a>
		      	<a id="btnConfirmEvento" class="ui green ok inverted button" href="#">
		        	<i class="checkmark icon"></i>
		        	Salvar
		      	</a>
			</div>
		    <div id="botaoFechar" class="actions" style="text-align: center"> 
		      	<a class="ui red basic cancel button">
		        	<i class="remove icon"></i>
		        	Fechar
		      	</a>
			</div>
		</div>
	</form>
</div>