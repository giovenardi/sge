<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<input type="hidden" name="${prefixoPes}.id" value="${pessoa.id}">
<div class="ui small modal" id="modalPessoa">
    <div class="ui icon header">
    	<i id="iconeFormando" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloFormando'>Cadastro de Pessoa Física</span>
    </div>
	<div class="ui top attached steps tabular">
		<div class="step active" data-tab="turma_tab">
			<i class="user icon"></i>
			<div class="content">
				Dados Pessoais
			</div>
		</div>
		<div class="ui form step">
			<i class="home icon"></i>
			<div class="content">
				Endereço
			</div>
		</div>
		<div class="step disabled">
			<i class="money icon"></i>
			<div class="content">
				Dados Financeiros
			</div>
		</div>
	</div>
	<div class="ui attached">
	<div class="ui segment">
	<div class="ui form segment">
		<div class="fields">
			<div class="seven wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Nome</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="100" class="campo-form" name="${prefixoPes}.nome" value="${pessoa.nome}">
			</div>
			<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Sexo</label>
				<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="${prefixoPes}.sexo" type="hidden" value="${pessoa.sexo}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${sexos}" var="sexo">
							<div class="item <c:if test="${sexo.name().equals(pessoa.sexo.name())}">active selected</c:if>" data-value="${sexo.name()}">${sexo.descricao}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four date wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Data de Nascimento</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" name="${prefixoPes}.dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${pessoa.dataNascimento}" />">
			</div>
		</div>
		<div class="fields">
			<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Estado Civil</label>
				<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="${prefixoPes}.estadoCivil" type="hidden" value="${pessoa.estadoCivil}">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${estadosCivis}" var="estadocivil">
							<div class="item <c:if test="${estadocivil.name().equals(pessoa.estadoCivil.name())}">active selected</c:if>" data-value="${estadocivil.name()}">${estadocivil.descricao}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>RG</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="14" class="campo-form" name="${prefixoPes}.rg" value="${pessoa.rg}">
			</div>
			<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Orgão Emissor</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="15" class="campo-form" name="${prefixoPes}.orgaoExpedidorRG" value="${pessoa.orgaoExpedidorRG}">
			</div>
		</div>
		<div class="fields">
			<div class="eight wide field">
				<label>Nome da Mãe</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="100" class="campo-form" name="${prefixoPes}.nomeMae" value="${pessoa.nomeMae}">
			</div>
			<div class="eight wide field">
				<label>Nome do Pai</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="100" class="campo-form" name="${prefixoPes}.nomePai" value="${pessoa.nomePai}">
			</div>
		</div>
		<div class="fields">
			<div class="eight wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>E-mail Principal</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="100" class="campo-form" name="${prefixoPes}.emailPrincipal" value="${pessoa.emailPrincipal}">
			</div>
			<div class="eight wide field">
				<label>E-mail Secundário</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="100" class="campo-form" name="${prefixoPes}.emailSecundario" value="${pessoa.emailSecundario}">
			</div>
		</div>
	</div>
</div>
<c:set var="endereco" scope="request" value="${pessoa.endereco}" />
<c:set var="prefixoEnd" scope="request" value="${prefixoPes}.endereco" />
<div class="ui attached"><jsp:include page="../endereco/tela.jsp" /></div>
</div>
		    <div class="ui bottom attached actions" style="text-align: center"> 
		      	<button class="ui labeled green icon button" style="float: left">
		        	<i class="arrow left icon"></i>
		        	Anterior
		      	</button>
		      	<button class="ui labeled inverted red icon button">
		        	<i class="stop icon"></i>
		        	Cancelar
		      	</button>
		      	<button id="btnConfirmPessoa" class="ui right green labeled icon button" style="float: right">
		        	Próximo
		        	<i class="arrow right icon"></i>
		      	</button>
			</div>
</div>