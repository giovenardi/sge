<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="acao" scope="request" value="alterar" />
<div class="ui small modal" id="modalFormaPagamentoCerimonial">
    <div class="ui icon header">
    	<i id="iconeFormaPagamentoCerimonial" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloFormaPagamentoCerimonial'>Cadastro de Forma de Pagamento</span>
    </div>
    <form role="form" id="formFormaPagamentoCerimonial" method="POST" action='<c:url value="/formaPagamento/incluir"/>'>
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
						<input name="formaPagamento.cerimonial.id" id="cerimonialFormaPagamentoId" type="hidden" value="${projeto.cerimonial.id}">
						<input id="formaPagamentoCerimonialId" name="formaPagamento.id" type="hidden" value="${projeto.cerimonial.formaPagamento.id}">
					<div class="fields separador">
				 		<div class="sixteen wide field required">
							<label>Título</label>
							<input type="text" maxlength="100" class="campo-form" name="formaPagamento.titulo" value="${projeto.cerimonial.formaPagamento.titulo}">
				 		</div>
                    </div>
					<div class="fields separador">
				 		<div class="four wide field date required">
							<label>Data Início</label>
							<input type="text" name="formaPagamento.dataInicio" class="campo-form date" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.cerimonial.formaPagamento.dataInicio}"/>'>
						</div>
				 		<div class="four wide field required">
							<label>Parcelas</label>
							<input type="text" class="campo-form numero4" name="formaPagamento.parcelas" value='${projeto.cerimonial.formaPagamento.parcelas}'>
						</div>
				 		<div class="eight wide field required">
							<label>Parcelamento</label>
							<div class="ui selection dropdown">
								<input name="formaPagamento.formaParcelamento" class="select" type="hidden" value="${projeto.cerimonial.formaPagamento.formaParcelamento}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaFormasParcelamento}" var="parcelamento">
										<div class="item" data-value="${parcelamento.name()}">${parcelamento.descricao}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
				</div>
			    <div class="actions" style="text-align: center; border-top:none"> 
			      	<a class="ui red basic cancel button">
			        	<i class="remove icon"></i>
			        	Fechar
			      	</a>
			      	<a id="btnConfirmFormaPagamentoCerimonial" class="ui ok inverted button gold" href="#">
			        	<i class="checkmark icon"></i>
			        	Salvar
			      	</a>
				</div>
			</div>
		</div>
	</form>
</div>
