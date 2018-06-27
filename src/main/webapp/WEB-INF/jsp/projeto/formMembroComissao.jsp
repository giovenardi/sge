<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi"%>
<div class="ui small modal" id="modalMembroComissao">
	<div class="ui icon header">
		<i class="glyphicon glyphicon-education pencilNovo"></i> 
		<span id="tituloModalMembroComissao">Incluir um Membro de Comissão</span>
	</div>
	<div class="content">
		<form role="form" id="formMembroComissao" method="POST" action='<c:url value="/membroComissao/salvar"/>'>
			<input name="membroComissao.comissaoFormatura.id" id="membroComissaoComissaoId" type="hidden" value=""> 
			<input name="membroComissao.id"	id="membroComissaoId" type="hidden" value="">
			<div class="ui segment">
				<div class="ui form">
					<lummi:pf label="Nome" obrigatorio="true" prefixo="membroComissao" funcao="inserirEditarPessoaMembroComissao()" />
					<div class="fields separador">
						<div class="eight wide field">
							<label>Função</label>
							<div class="ui selection dropdown funcaoMembroComissao">
								<input name="membroComissao.funcao.id" id="funcaoMembroComissao" class="select" type="hidden" value="">
								<div class="default text">Selecione</div>
								<i class="dropdown icon"></i>
								<div class="menu">
									<c:forEach items="${listaFuncoesComissao}" var="funcao">
										<div class="item" data-value="${funcao.id}">${funcao.nome}</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<div class="fields separador">
						<div class="eight wide field">
							<label>E-mail Principal</label>
							<input type="text" class="campo-form" id="emailPrincipalMembro" name="membroComissao.emailPrincipal" value="">
						</div>
						<div class="eight wide field">
							<label>E-mail Secundário</label>
							<input type="text" class="campo-form" id="emailSecundarioMembro" name="membroComissao.emailSecundario" value="">
						</div>
					</div>
					<div class="fields separador">
						<div class="six wide field">
							<label>Telefone Fixo</label>
							<input type="text" class="campo-form telefone" id="telefoneFixoMembro" name="membroComissao.telefoneFixo" maxlength="15" autocomplete="off" value="">
						</div>
						<div class="five wide field">
							<label>Celular Principal</label>
							<input type="text" class="campo-form telefone" id="celularPrincipalMembro" name="membroComissao.celularPrincipal" value="">
						</div>
						<div class="five wide field">
							<label>Celular Secundário</label>
							<input type="text" class="campo-form telefone" id="celularSecundarioMembro" name="membroComissao.celularSecundario" value="">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="actions" style="text-align: center">
		<a class="ui red basic cancel button"> 
			<i class="remove icon"></i> Cancelar
		</a> 
		<a id="btnConfirmMembroComissao" class="ui green ok inverted button" href="#"> 
			<i class="checkmark icon"></i>
			Salvar
		</a>
	</div>
</div>