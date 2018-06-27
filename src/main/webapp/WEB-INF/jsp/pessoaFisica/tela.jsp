<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="ui longer modal" id="modalPF">
	<div class="ui icon header">
		<i id="iconePF" class="glyphicon glyphicon-education pencilNovo"></i>
		<span id='tituloPF'>Cadastro de Pessoa Física</span>
	</div>
	<div id="selecaoPF">
		<div class="ui segment" style="height: 445px">
			<div class="ui form">
				<div class="fields">
					<div class="eight wide field required">
						<label>CPF</label> <input type="text" id="cpf"
							class="campo-form cpf">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="scrolling content" id="formularioPF" style="display: none">
		<form id="formPF" action='<c:url value="/pessoaFisica/salvar"/>'>
			<div class="ui raised segment" id="pf1">
				<a class="ui blue ribbon label">Dados Pessoais</a> <input
					type="hidden" id="pessoa_id" name="pessoa.id">
				<div class="ui">
					<div class="ui form">
						<div class="fields">
							<div class="eight wide field required">
								<label>CPF</label> <input type="text" class="campo-form cpf"
									id="pessoa_cpf" name='pessoa.cpf'>
							</div>
							<div class="seven wide field required">
								<label>Nome</label> <input id="pessoa_nome" type="text"
									maxlength="100" class="campo-form" name="pessoa.nome">
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
						</div>
						<div class="fields">
							<div class="four date wide field required">
								<label>Data de Nascimento</label> <input
									id="pessoa_dataNascimento" type="text" class="campo-form"
									name="pessoa.dataNascimento">
							</div>
							<div class="five wide field required">
								<label>Estado Civil</label>
								<div class="ui selection dropdown ">
									<input id="pessoa_estadoCivil" name="pessoa.estadoCivil"
										type="hidden">
									<div class="default text">Selecione</div>
									<i class="dropdown icon"></i>
									<div class="menu">
										<c:forEach items="${estadosCivis}" var="estadocivil">
											<div class="item" data-value="${estadocivil.name()}">${estadocivil.descricao}</div>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="four wide field">
								<label>RG</label> <input id="pessoa_rg" type="text"
									maxlength="14" class="campo-form" name="pessoa.rg">
							</div>
							<div class="three wide field required">
								<label>Orgão Emissor</label> <input id="pessoa_orgaoExpedidorRG"
									type="text" maxlength="15" class="campo-form"
									name="pessoa.orgaoExpedidorRG">
							</div>
						</div>
						<div class="fields">
							<div class="eight wide field">
								<label>Nome da Mãe</label> <input id="pessoa_nomeMae"
									type="text" maxlength="100" class="campo-form"
									name="pessoa.nomeMae">
							</div>
							<div class="eight wide field">
								<label>Nome do Pai</label> <input id="pessoa_nomePai"
									type="text" maxlength="100" class="campo-form"
									name="pessoa.nomePai">
							</div>
						</div>
						<div class="fields">
							<div class="eight wide field required">
								<label>E-mail Principal</label> <input
									id="pessoa_emailPrincipal" type="text" maxlength="100"
									class="campo-form" name="pessoa.emailPrincipal">
							</div>
							<div class="eight wide field">
								<label>E-mail Secundário</label> <input
									id="pessoa_emailSecundario" type="text" maxlength="100"
									class="campo-form" name="pessoa.emailSecundario">
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:set var="prefixoEnd" scope="request" value="pessoa.endereco" />
			<div class="ui raised segment" id="pf2">
				<a class="ui blue ribbon label">Endereço</a>
				<jsp:include page="../endereco/tela.jsp" />
			</div>
			<c:set var="prefixoDB" scope="request" value="pessoa.dadosBancarios" />
			<div class="ui raised segment" id="pf3">
				<a class="ui blue ribbon label">Dados Financeiros</a>
				<jsp:include page="../dadosBancarios/tela.jsp" />
			</div>
		</form>
	</div>
	<div class="ui bottom attached actions" style="text-align: center;">
		<a class="ui red inverted cancel button" id="btnPFCancel"> <i
			class="remove icon"></i> Cancelar
		</a> <a class="ui green inverted button" id="btnPFConf"> <i
			class="check icon"></i> Confirmar
		</a>
	</div>
</div>