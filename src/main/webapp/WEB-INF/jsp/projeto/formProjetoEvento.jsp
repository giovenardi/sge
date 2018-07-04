<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="acao" scope="request" value="alterar" />
<div class="ui long modal" id="modalProjetoEvento">
    <div class="ui icon header" id="tituloModalProjetoEvento">
    	<i class="glyphicon glyphicon-education pencilNovo"></i>
      	Incluir um ProjetoEvento
    </div>
    <div class="ui scrollable content">
	    <form role="form" id="formProjetoEvento" method="POST" action='<c:url value="/projetoEvento/incluir"/>'>
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<input name="projetoEvento.projeto.id" id="projetoProjetoEventoId" type="hidden" value="${projetoEvento.projeto.id}">
				 		<div class="sixteen wide field required">
							<label>Evento</label>
							<div class="ui selection dropdown eventoProjetoEvento">
								<input name="projetoEvento.evento.id" id="eventoProjetoEvento" class="select" type="hidden" value="">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaEventos}" var="evento">
										<div class="item" data-value="${evento.id}">${evento.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
					<div class="fields separador">
						<div class="eight datetime wide field required">
							<label>Início</label>
							<input type="text" class="campo-form datetime" name="projetoEvento.inicio" value='<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${projetoEvento.inicio}" />'>
						</div>
					</div>
					<div class="fields separador">
						<div class="eight datetime wide field required">
							<label>Final</label>
							<input type="text" class="campo-form datetime" name="projetoEvento.fim" value='<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${projetoEvento.fim}" />'>
						</div>
					</div>
				</div>
			</div>
		</form>
    </div>
    <div class="actions" style="text-align: center"> 
      	<a class="ui red basic cancel button">
        	<i class="remove icon"></i>
        	Cancelar
      	</a>
      	<a id="btnConfirmProjetoEvento" class="ui green ok inverted button" href="#">
        	<i class="checkmark icon"></i>
        	Salvar
      	</a>
	</div>
</div>