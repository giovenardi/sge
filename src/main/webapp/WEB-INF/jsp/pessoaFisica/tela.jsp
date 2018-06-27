<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="ui small modal" id="modalPessoa">
    <div class="ui icon header">
    	<i id="iconeFormando" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloFormando'>Cadastro de Pessoa Física</span>
    </div>
    <div id="selecaoPF">
		<div class="ui segment" style="height:445px">
			<div class="ui form">
				<div class="fields">
					<div class="eight wide field cpf required">
						<label>CPF</label>
						<input type="text" id="cpf" class="campo-form cpf" name='captadorExterno.pessoa.cpf' >
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="formPF" action='<c:url value="/pessoaFisica/salvar"/>'>
		<div id="formularioPF" style="display:none">
			<input type="hidden" id="pessoa_id" name="pessoa.id">
			<input type="hidden" id="pessoa_cpf" name="pessoa.cpf">
			<div class="ui top attached steps tabular">
				<div class="step active" data-tab="turma_tab" id="selpf1">
					<i class="user icon"></i>
					<div class="content">
						Dados Pessoais
					</div>
				</div>
				<div class="ui form step" id="selpf2">
					<i class="home icon"></i>
					<div class="content">
						Endereço
					</div>
				</div>
				<div class="step" id="selpf3">
					<i class="money icon"></i>
					<div class="content">
						Dados Financeiros
					</div>
				</div>
			</div>
			<div class="ui attached abapessoa" style="height:312px" id="pf1">
				<div class="ui">
					<div class="ui form">
						<div class="fields">
							<div class="seven wide field required">
								<label>Nome</label>
								<input id="pessoa_nome" type="text"  maxlength="100" class="campo-form" name="pessoa.nome">
							</div>
							<div class="five wide field required">
								<label>Sexo</label>
								<div class="ui selection dropdown ">
									<input id="pessoa_sexo" name="pessoa.sexo" type="hidden">
									<div class="default text">Selecione</div>
									<i class="dropdown icon"></i>
									<div class="menu">
										<c:forEach items="${sexos}" var="sexo">
											<div class="item" data-value="${sexo.name()}">${sexo.descricao}</div>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="four date wide field required">
								<label>Data de Nascimento</label>
								<input id="pessoa_dataNascimento" type="text"  class="campo-form" name="pessoa.dataNascimento">
							</div>
						</div>
						<div class="fields">
							<div class="five wide field required">
								<label>Estado Civil</label>
								<div class="ui selection dropdown ">
									<input id="pessoa_estadoCivil" name="pessoa.estadoCivil" type="hidden">
									<div class="default text">Selecione</div>
									<i class="dropdown icon"></i>
									<div class="menu">
										<c:forEach items="${estadosCivis}" var="estadocivil">
											<div class="item" data-value="${estadocivil.name()}">${estadocivil.descricao}</div>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="four wide field required">
								<label>RG</label>
								<input id="pessoa_rg" type="text"  maxlength="14" class="campo-form" name="pessoa.rg">
							</div>
							<div class="three wide field required">
								<label>Orgão Emissor</label>
								<input id="pessoa_orgaoExpedidorRG" type="text"  maxlength="15" class="campo-form" name="pessoa.orgaoExpedidorRG">
							</div>
						</div>
						<div class="fields">
							<div class="eight wide field">
								<label>Nome da Mãe</label>
								<input id="pessoa_nomeMae" type="text"  maxlength="100" class="campo-form" name="pessoa.nomeMae">
							</div>
							<div class="eight wide field">
								<label>Nome do Pai</label>
								<input id="pessoa_nomePai" type="text"  maxlength="100" class="campo-form" name="pessoa.nomePai">
							</div>
						</div>
						<div class="fields">
							<div class="eight wide field required">
								<label>E-mail Principal</label>
								<input id="pessoa_emailPrincipal" type="text"  maxlength="100" class="campo-form" name="pessoa.emailPrincipal">
							</div>
							<div class="eight wide field">
								<label>E-mail Secundário</label>
								<input id="pessoa_emailSecundario" type="text"  maxlength="100" class="campo-form" name="pessoa.emailSecundario">
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:set var="prefixoEnd" scope="request" value="pessoa.endereco" />
			<div class="ui attached abapessoa" style="display:none;height:312px" id="pf2">
				<jsp:include page="../endereco/tela.jsp" />
			</div>
			<c:set var="prefixoDB" scope="request" value="pessoa.dadosBancarios" />
			<div class="ui attached abapessoa" style="display:none;height:312px" id="pf3">
				<jsp:include page="../dadosBancarios/tela.jsp" />
			</div>
		    <div class="ui bottom attached actions" style="text-align: center;"> 
		      	<button class="ui labeled green icon button" type="button" style="float: left" id="btnPFPrev" disabled>
		        	<i class="arrow left icon"></i>
		        	Anterior
		      	</button>
		      	<a class="ui red basic cancel button" id="btnPFCancel">
		        	<i class="remove icon"></i>
		        	Cancelar
		      	</a>
		      	<button class="ui right green labeled icon button" type="button" style="float: right" id="btnPFNext">
		        	Próximo
		        	<i class="arrow right icon"></i>
		      	</button>
		      	<button class="ui right green labeled icon button" type="button" style="float: right" id="btnPFConf">
		        	Concluir
		        	<i class="arrow right icon"></i>
		      	</button>
			</div>
		</div>
	</form>
</div>