<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="ui small modal" id="modalPJ">
    <div class="ui icon header">
    	<i id="iconePJ" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloPJ'>Cadastro de Pessoa Jurídica</span>
    </div>
    <div id="selecaoPJ">
		<div class="ui segment" style="height:445px">
			<div class="ui form">
				<div class="fields">
					<div class="eight wide field cnpj required">
						<label>CNPJ</label>
						<input type="text" id="cnpj" class="campo-form cnpj">
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="formPJ" action='<c:url value="/pessoaJuridica/salvar"/>'>
		<div id="formularioPJ" style="display:none">
			<input type="hidden" id="pj_id" name="pessoa.id">
			<div class="ui top attached steps tabular">
				<div class="step active" id="selpj1">
					<i class="user icon"></i>
					<div class="content">
						Dados da Empresa
					</div>
				</div>
				<div class="ui form step" id="selpj2">
					<i class="home icon"></i>
					<div class="content">
						Endereço
					</div>
				</div>
				<div class="step" id="selpj3">
					<i class="money icon"></i>
					<div class="content">
						Dados Financeiros
					</div>
				</div>
			</div>
			<div class="ui attached abapj" style="height:312px" id="pj1">
				<div class="ui">
					<div class="ui form">
						<div class="fields">
							<div class="eight wide field cnpj required">
								<label>CNPJ</label>
								<input type="text" class="campo-form cnpj" id="pj_cnpj" name='pessoa.cnpj' >
							</div>
							<div class="seven wide field required">
								<label>Razão Social</label>
								<input id="pj_nome" type="text"  maxlength="100" class="campo-form" name="pessoa.nome">
							</div>
						</div>
						<div class="fields">
							<div class="four date wide field required">
								<label>Data de Abertura</label>
								<input id="pj_dataAbertura" type="text"  class="campo-form" name="pessoa.dataAbertura">
							</div>
							<div class="four wide field required">
								<label>Inscrição Estadual</label>
								<input id="pj_inscricaoEstadual" type="text"  maxlength="14" class="campo-form" name="pessoa.inscricaoEstadual">
							</div>
							<div class="three wide field required">
								<label>Inscrição Municipal</label>
								<input id="pj_inscricaoMunicipal" type="text"  maxlength="15" class="campo-form" name="pessoa.inscricaoMunicipal">
							</div>
						</div>
						<div class="fields">
							<div class="eight wide field">
								<label>Nome Fantasia</label>
								<input id="pj_nomeFantasia" type="text"  maxlength="100" class="campo-form" name="pessoa.nomeFantasia">
							</div>
							<div class="eight wide field">
								<label>Contato</label>
								<input id="pj_contato" type="text"  maxlength="100" class="campo-form" name="pessoa.contato">
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:set var="prefixoEnd" scope="request" value="pessoa.endereco" />
			<div class="ui attached abapj" style="display:none;height:312px" id="pj2">
				<jsp:include page="../endereco/tela.jsp" />
			</div>
			<c:set var="prefixoDB" scope="request" value="pessoa.dadosBancarios" />
			<div class="ui attached abapj" style="display:none;height:312px" id="pj3">
				<jsp:include page="../dadosBancarios/tela.jsp" />
			</div>
		    <div class="ui bottom attached actions" style="text-align: center;"> 
		      	<button class="ui labeled green icon button" type="button" style="float: left" id="btnPJPrev" disabled>
		        	<i class="arrow left icon"></i>
		        	Anterior
		      	</button>
		      	<a class="ui red basic cancel button" id="btnPJCancel">
		        	<i class="remove icon"></i>
		        	Cancelar
		      	</a>
		      	<button class="ui right green labeled icon button" type="button" style="float: right" id="btnPJNext">
		        	Próximo
		        	<i class="arrow right icon"></i>
		      	</button>
		      	<button class="ui right green labeled icon button" type="button" style="float: right" id="btnPJConf">
		        	Concluir
		        	<i class="arrow right icon"></i>
		      	</button>
			</div>
		</div>
	</form>
</div>