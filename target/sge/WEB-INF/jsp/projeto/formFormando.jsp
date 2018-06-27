<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi" %>
<div class="ui small modal" id="modalFormando">
    <div class="ui icon header">
    	<i id="iconeFormando" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloFormando'>Cadastro de Formando</span>
    </div>
    <form role="form" id="formFormando" method="POST" action='<c:url value="/formando/cadastro"/>'>
		<input name="formando.id" type="hidden" value="${formando.id}">
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
			    	<lummi:pf label="Aluno" obrigatorio="true" id="pessoaFormandoId"/>
					<div class="fields separador">
				 		<div class="sixteen wide field required">
							<label>Turma</label>
							<div class="ui selection dropdown turmaFormando">
								<input name="formando.turma.id" id="turmaFormando" class="select" type="hidden" value="">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${projeto.turmas}" var="turma">
										<div class="item <c:if test="${formando.turma.id.equals(turma.id)}">active selected</c:if>" data-value="${turma.id}">${turma.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
					<div class="fields separador">
				 		<div class="sixteen wide field required">
							<label>Plano de Pagamento</label>
							<div class="ui selection dropdown planoPagamentoFormando">
								<input name="formando.planoPagamento.id" id="planoPagamentoFormando" class="select" type="hidden" value="">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${projeto.planosPagamento}" var="planoPagamento">
										<div class="item <c:if test="${formando.planoPagamento.id.equals(planoPagamento.id)}">active selected</c:if>" data-value="${planoPagamento.id}">${planoPagamento.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
					<div class="fields">
				 		<div class="four wide field required">
							<label>Valor Total</label>
							<input type="text" id="maskedValorTotalFormando" class="campo-form dinheiro" value='<fmt:formatNumber value="${formando.valor}" type="currency"></fmt:formatNumber>'>
						</div>
						<input type="hidden" id="valorTotalFormando" name="formando.valorTotal" value="${formando.valorTotal}">
				 		<div class="three wide field required">
							<label>Taxa Boleto</label>
							<input type="text" id="maskedTaxaBoletoFormando" class="campo-form dinheiro" value='<fmt:formatNumber value="${formando.taxaBoleto}" type="currency"></fmt:formatNumber>'>
						</div>
						<input type="hidden" id="taxaBoletoFormando" name="formando.taxaBoleto" value="${formando.taxaBoleto}">
				 		<div class="three wide field">
							<label>Número Havaiana</label>
							<input type="text" maxlength="2" class="campo-form numero2" name="formando.numeroHavaiana" value='${formando.numeroHavaiana}'>
						</div>
				 		<div class="three wide field">
							<label>Qtd. Parcelas</label>
							<input type="text" maxlength="2" class="campo-form numero2" name="formando.numeroHavaiana" value='${formando.numeroHavaiana}'>
						</div>
				 		<div class="three wide field">
							<label>Dia Pagamento</label>
							<input type="text" maxlength="2" class="campo-form numero2" name="formando.numeroHavaiana" value='${formando.numeroHavaiana}'>
						</div>
					</div>
				</div>
			</div>
		    <div class="actions" style="text-align: center"> 
		      	<a class="ui red basic cancel button">
		        	<i class="remove icon"></i>
		        	Cancelar
		      	</a>
		      	<a id="btnConfirmFormando" class="ui green ok inverted button" href="#">
		        	<i class="checkmark icon"></i>
		        	Salvar
		      	</a>
			</div>
		</div>
	</form>
</div>