<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui small modal" id="modalSolicitarAprovacao">
    <div class="ui icon header">
    	<i class="glyphicon glyphicon-transfer"></i>
      	Solicitar Aprovação da Diretoria
    </div>
    <form role="form" id="formSolicitarAprovacao" method="POST" action='<c:url value="/contatoEvento/solicitarAprovacao"/>'>
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<input name="contatoEvento.id" id="contatoEventoId" type="hidden">
				 		<div class="eight wide field">
							<label>Nome do Contato</label>
							<input type="text" disabled maxlength="100" id="contatoEventoNome" class="campo-form" name="contatoEvento.nome">
						</div>
				 		<div class="eight wide field">
							<label>Tipo de Projeto</label>
							<div class="ui selection dropdown tipoProjeto disabled">
								<input name="contatoEvento.tipoProjeto" id="tipoProjeto" type="hidden" class="select">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${tiposProjeto}" var="tipoProjeto">
										<div class="item" data-value="${tipoProjeto.name()}">${tipoProjeto.descricao}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
					<div class="fields separador">
				 		<div class="sixteen wide field">
							<label>Nome do Projeto</label>
							<input type="text" readOnly class="campo-form" id="nomeProjeto" name="contatoEvento.nomeProjeto">
						</div>
					</div>
				</div>
			</div>
        </div>
	    <div class="actions" style="text-align: center"> 
	      	<a class="ui red basic cancel button">
	        	<i class="remove icon"></i>
	        	Cancelar
	      	</a>
	      	<a id="btnConfirmSolicitarAprovacao" class="ui green ok inverted button" href="#">
	        	<i class="checkmark icon"></i>
	        	Solicitar
	      	</a>
		</div>
	</form>
</div>