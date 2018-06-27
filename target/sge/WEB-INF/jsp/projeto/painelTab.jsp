<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui bottom attached tab segment active" data-tab="painel_tab" style="padding:10">
	<form id="formPainel" role="form" action="<c:url value='/projeto/salvarFS'/>" method="POST">
		<input type="hidden" name="projeto.contatoEvento.id" value="${projeto.contatoEvento.id}">
		<input type="hidden" name="projeto.id" value="${projeto.id}">
		<div class="ui form">
			<div class="fields">
	 			<div class="four wide field">
					<label>Vendedor</label>
					<input type="text" disabled value="${projeto.vendedor.nome}" />
				</div>
	 			<div class="four wide field">
					<label>Gerente</label>
					<input type="text" disabled value="${projeto.gerente.nome}" />
				</div>
		 		<div class="four wide field">
					<label>Primeiro Contato</label>
					<input type="text" disabled value="${projeto.contatoEvento.primeiroContato.funcionario.pessoa.nome}" />
				</div>
		 		<div class="four wide field">
					<label>Tipo de Projeto</label>
					<input type="text" disabled value="${projeto.contatoEvento.tipoProjeto.descricao}">
				</div>
			</div>
			<div class="fields">
	 			<div class="four wide field">
					<label>Forma de Captação</label>
					<input type="text" disabled value="${projeto.contatoEvento.formaCaptacao.nome}">
				</div>
		 		<div class="two wide field">
					<label>&nbsp;</label>
					<div class="ui checkbox">
						<input type="checkbox" disabled <c:if test="${projeto.contatoEvento.houveIndicacao}">checked</c:if> name="projeto.contatoEvento.houveIndicacao" value="true"><label>Houve Indicação</label>
					</div>
				</div>
				<c:if test='${projeto.contatoEvento.houveIndicacao}'>
			 		<div class="five wide field">
		 				<label>Tipo de Indicação</label>
						<input type="text" disabled value="${projeto.contatoEvento.tipoIndicacao.descricao}">
					</div>
					<c:if test='${projeto.contatoEvento.tipoIndicacao.name().equals("INDICACAO_ASSISTENTE")}'>
				 		<div class="five wide field">
				 			<label>Funcionário Captador1</label>
							<input type="text" disabled value="${projeto.contatoEvento.funcionarioComissao.pessoa.nome}">
						</div>
					</c:if>
					<c:if test='${projeto.contatoEvento.tipoIndicacao.name() eq "INDICACAO_CAPTADOR_FUNCIONARIO"}'>
				 		<div class="five wide field">
				 			<label>Funcionário Captador2</label>
							<input type="text" disabled value="${projeto.contatoEvento.funcionarioBonificacao.pessoa.nome}">
						</div>
					</c:if>
					<c:if test='${projeto.contatoEvento.tipoIndicacao.name() eq "INDICACAO_CAPTADOR_EXTERNO"}'>
				 		<div class="five wide field">
				 			<label>Captador Externo</label>
							<input type="text" disabled value="${projeto.contatoEvento.captadorBonificacao.pessoa.nome}">
						</div>
					</c:if>
					<c:if test='${projeto.contatoEvento.tipoIndicacao.name() eq "INDICACAO_PROJETO"}'>
				 		<div class="five wide field">
				 			<label>Projeto Captador</label>
							<input type="text" disabled value="${projeto.contatoEvento.projetoBonificacao.contatoEvento.nome}">
						</div>
					</c:if>
				</c:if>
			</div>
			<div class="fields">
				<div class="two wide field">
					<label>Meta de Formandos</label>
					<input type="text" maxlength="14" class="campo-form numero4" name="projeto.metaFormandos" value="${projeto.metaFormandos}">
				</div>
				<div class="three wide field">
					<label>Nº Convites Gráficos Luxo</label>
					<input type="text" maxlength="14" class="campo-form numero4" name="projeto.numeroConvitesLuxo" value="${projeto.numeroConvitesLuxo}">
				</div>
				<div class="three wide field">
					<label>Nº Convites Gráficos Semi-luxo</label>
					<input type="text" maxlength="14" class="campo-form numero4" name="projeto.numeroConvitesSemiluxo" value="${projeto.numeroConvitesSemiluxo}">
				</div>
				<div class="three wide field">
					<label>Nº Convites Gráficos Simples</label>
					<input type="text" maxlength="14" class="campo-form numero4" name="projeto.numeroConvitesSimples" value="${projeto.numeroConvitesSimples}">
				</div>
				<div class="three wide field">
					<label>Nº Convites Gráficos Online</label>
					<input type="text" maxlength="14" class="campo-form numero4" name="projeto.numeroConvitesOnline" value="${projeto.numeroConvitesOnline}">
				</div>
			</div>		
			<br/>
	        <button class="ui gold button" type="button" onclick="submeterFormAjax('formPainel', 'alteracao:ok')">Salvar</button>
		</div>
	</form>
	
</div>
