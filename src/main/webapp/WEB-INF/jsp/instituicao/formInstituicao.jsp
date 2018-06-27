<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi" %>
<div class="ui longer modal" id="modalInstituicao">
    <div class="ui icon header">
    	<i id="iconeInstituicao" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloInstituicao'>Cadastro de Funcionário</span>
    </div>
    <form role="form" id="formInstituicao" method="POST" action='<c:url value="/instituicao/salvar"/>'>
		<input name="instituicao.id" id="instituicaoId" type="hidden" value="${instituicao.id}">
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="sixteen wide field required">
							<label>Nome</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="250" class="campo-form" id="instituicaoNome" name="instituicao.nome" value="">
						</div>
					</div>
					<div class="fields separador">
						<div class="sixteen wide field required">
							<label>Nome Completo</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="250" class="campo-form" id="instituicaoNomeCompleto" name="instituicao.nomeCompleto" value="">
						</div>
					</div>
		<div class="fields separador">
			<div class="four wide field check">
				<div class="field">
					<div class="ui checkbox toggle instituicaoEI">
						<input id="instituicaoEI" type="checkbox" name="instituicao.educacaoInfantil" value="true">
						<label>Educação Infantil</label>
					</div>
				</div>
			</div>
			<div class="four wide field check">
				<div class="field">
					<div class="ui checkbox toggle instituicaoEF">
						<input id="instituicaoEM" type="checkbox" name="instituicao.ensinoFundamental" value="true">
						<label>Ensino Fundamental</label>
					</div>
				</div>
			</div>
			<div class="four wide field check">
				<div class="field">
					<div class="ui checkbox toggle instituicaoEM">
						<input id="instituicaoEM" type="checkbox" name="instituicao.ensinoMedio" value="true">
						<label>Ensino Médio</label>
					</div>
				</div>
			</div>
			<div class="four wide field check">
				<div class="field">
					<div class="ui checkbox toggle instituicaoES">
						<input id="instituicaoES" type="checkbox" name="instituicao.ensinoSuperior" value="true">
						<label>Ensino Superior</label>
					</div>
				</div>
			</div>
			<div class="four wide field check">
				<div class="field">
					<div class="ui checkbox toggle instituicaoCF">
						<input id="instituicaoCF" type="checkbox" name="instituicao.cursosFormacao" value="true">
						<label>Cursos de Formação</label>
					</div>
				</div>
			</div>
		</div>
				</div>
			</div>
		    <div id="botoesForm" class="actions" style="text-align: center"> 
		      	<a class="ui red basic cancel button">
		        	<i class="remove icon"></i>
		        	Cancelar
		      	</a>
		      	<a id="btnConfirmInstituicao" class="ui green ok inverted button" href="#">
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
<table id="listaUnidades" class="ui black unstackable table">
	<thead class="teste">
		<tr>
			<th colspan="2" class="sixteen wide center aligned"><h2 class="ui green sub header">Unidades</h2></th>
		</tr>
		<tr>
			<th class="sixteen wide">Nome</th>
			<c:if test='${acao ne "mostrar"}'>
				<th class="two wide"><a class="ui gold button icon" data-content="Nova Unidade" id="novaUnidade" data-position="top right"><i class="plus icon"></i></a></th>
			</c:if>
		</tr>
	</thead>
	<tbody id="bodyUnidades">
		<c:forEach items="${instituicao.unidades}" var="uni" varStatus="count">
			<tr class="cell-content-selectable" id="unidade${uni.id}">
				<td>${uni.nome}</td>
				<c:if test='${acao ne "mostrar"}'>
					<td>
						<div class="ui icon buttons">
	                   		<input id="urlContextUni${uni.id}" value="<c:url value='/instituicao/excluirUnidade'/>" hidden="true" />
	                      	<a onclick="modalConfirmAjax(${uni.id}, removerUnidade)" class="ui button icon" data-content="Excluir" data-position="top right">
		                        <i class="trash alternate red icon"></i>
		                   	</a>
	                      	<a onclick="editarUnidade(${uni.id})" class="ui button icon" data-content="Alterar" data-position="top right">
		                    	<i class="pencil alternate blue icon"></i>
		                	</a>
						</div>
					</td> 
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>