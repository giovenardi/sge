<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="acao" scope="request" value="alterar" />
<div class="ui small modal" id="modalPlano">
    <div class="ui icon header">
    	<i id="iconePlano" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloPlano'>Cadastro de Plano</span>
    </div>
    <form role="form" id="formPlano" method="POST" action='<c:url value="/planoPagamento/incluir"/>'>
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields">
						<input name="plano.projeto.id" id="projetoPlanoId" type="hidden" value="">
						<input id="planoId" name="plano.id" type="hidden" value="">
						<input type="hidden" id="valorTotalPlano" name="plano.valor" value="">
				 		<div class="twelve wide field required">
							<label>Nome</label>
							<input type="text" class="campo-form" id="planoNome" name="plano.nome" value="">
				 		</div>
				 		<div class="four wide field required">
							<label>Valor Total</label>
							<input type="text" id="maskedValorTotalPlano" class="campo-form dinheiro" value="">
						</div>
                    </div>
					<div class="fields separador">
			 			<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<h4 class="ui dividing header">Quantidades</h4>
						</div>
					</div>
					<div class="fields">
				 		<div class="four wide field required">
							<label>Convidados</label>
							<input type="text" class="campo-form numero4" id="planoConvidados" name="plano.convidados" value=''>
						</div>
				 		<div class="four wide field">
							<label>Convites Luxo</label>
							<input type="text" maxlength="2" class="campo-form numero2" id="planoConvitesLuxo" name="plano.convitesLuxo" value=''>
						</div>
				 		<div class="four wide field">
							<label>Convites Semiluxo</label>
							<input type="text" maxlength="2" class="campo-form numero2" id="planoConvitesSemiLuxo" name="plano.convitesSemiLuxo" value=''>
						</div>
				 		<div class="four wide field">
							<label>Convites Simples</label>
							<input type="text" maxlength="2" class="campo-form numero2" id="planoConvitesSimples" name="plano.convitesSimples" value=''>
						</div>
					</div>
				</div>
			    <div class="actions" style="text-align: center; border-top:none"> 
			      	<a class="ui red basic cancel button">
			        	<i class="remove icon"></i>
			        	Fechar
			      	</a>
			      	<a id="btnConfirmPlano" class="ui ok inverted button gold" href="#">
			        	<i class="checkmark icon"></i>
			        	Salvar
			      	</a>
			      	<a id="btnFormasPagamento" class="ui green inverted button" href="#">
			        	<i class="dollar icon"></i>
			        	Formas de Pagamento
			      	</a>
				</div>
			</div>
		</div>
	</form>
</div>
<jsp:include page="listFormas.jsp" />
