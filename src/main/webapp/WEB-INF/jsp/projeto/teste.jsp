<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="acao" value="add" scope="request" />
<template:admin>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/contato.js'/>"></script>
	</jsp:attribute>
    <jsp:body>
	     <div class="ui small breadcrumb">
			  <a href="<c:url value='/'/>" class="section">Início</a>
			  <i class="right arrow icon divider"></i>
			  <div class="section">Projetos</div>
			  <i class="right chevron icon divider"></i>
			  <div class="active section">Registro de Projeto</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Registro de Projeto</h2>
			</div>
		</div>
		<div class="ui styled accordion">
  			<div class="active title">
    			<i class="dropdown icon"></i>
	    		Painel
  			</div>
  			<div class="active content">
        		<form role="form" action="<c:url value='/material/add'/>" method="POST" onsubmit="return validarForm()">
  					<div class="ui form">
						<div class="fields">
							<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Número</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="two date wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Data de Ativação</label>
								<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" name="${prefixoPes}.dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${pessoa.dataNascimento}" />">
							</div>
					 		<div class="six wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nome</label>
								<input type="text" readOnly class="campo-form" id="nomeProjeto" name="contatoEvento.nomeProjeto" value="${contatoEvento.nomeProjeto}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Situação</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
						</div>
						<div class="fields">
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Vendedor</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Gerente</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Captador</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
						</div>
						<div class="fields">
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Forma de Captação</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Tipo de Projeto</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
							<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Meta de Formandos</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
						</div>
						<div class="fields">
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Luxo</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Semi-luxo</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Simples</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Online</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
						</div>		
						<div class="fields separador">
					 		<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Forma de Captação</label>
								<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.formaCaptacao.id" class="select" type="hidden" value="${contatoEvento.formaCaptacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${formasCaptacao}" var="formaCaptacao">
											<div class="item <c:if test="${formaCaptacao.id.equals(contatoEvento.formaCaptacao.id)}">active selected</c:if>" data-value="${formaCaptacao.id}">${formaCaptacao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="two wide field">
								<label>&nbsp;</label>
								<div class="ui checkbox <c:if test='${acao eq "show"}'>disabled</c:if>" id="indicacao">
											<input type="checkbox" ${contatoEvento.houveIndicacao?'checked':''} name="contatoEvento.houveIndicacao" value="true"><label>Houve Indicação</label>
								</div>
							</div>
					 		<div id="divindicacao" class="five wide field <c:if test='${acao ne "show"}'>required</c:if>" <c:if test="${!contatoEvento.houveIndicacao}">style="display: none"</c:if>><label>Tipo de Indicação</label>
								<div class="ui selection dropdown tipoIndicacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.tipoIndicacao" id="tipoIndicacao" class="select" type="hidden" value="${contatoEvento.tipoIndicacao.name()}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${tiposIndicacao}" var="tipoIndicacao">
											<div class="item <c:if test="${tipoIndicacao.name().equals(contatoEvento.tipoIndicacao.name())}">active selected</c:if>" data-value="${tipoIndicacao}">${tipoIndicacao.descricao}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_ASSISTENTE" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_ASSISTENTE"}'>style="display: none"</c:if>>
					 			<label>Funcionário Captador</label>
								<div class="ui selection dropdown funcionarioComissao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.funcionarioComissao.id" class="select" type="hidden" value="${contatoEvento.funcionarioComissao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${funcionariosComissao}" var="funcionario">
											<div class="item <c:if test="${funcionario.id.equals(contatoEvento.funcionarioComissao.id)}">active selected</c:if>" data-value="${funcionario.id}">${funcionario.pessoa.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_CAPTADOR_FUNCIONARIO" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_CAPTADOR_FUNCIONARIO"}'>style="display: none"</c:if>>
					 			<label>Funcionário Captador</label>
								<div class="ui selection dropdown funcionarioBonificacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.funcionarioBonificacao.id" class="select" type="hidden" value="${contatoEvento.funcionarioBonificacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${funcionariosBonificacao}" var="funcionario">
											<div class="item <c:if test="${funcionario.id.equals(contatoEvento.funcionarioBonificacao.id)}">active selected</c:if>" data-value="${funcionario.id}">${funcionario.pessoa.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_CAPTADOR_EXTERNO" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_CAPTADOR_EXTERNO"}'>style="display: none"</c:if>>
					 			<label>Captador Externo</label>
								<div class="ui selection dropdown captadorBonificacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.captadorBonificacao.id" class="select" type="hidden" value="${contatoEvento.captadorBonificacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${captadoresBonificacao}" var="captador">
											<div class="item <c:if test="${captador.id.equals(contatoEvento.captadorBonificacao.id)}">active selected</c:if>" data-value="${captador.id}">${captador.pessoa.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_PROJETO" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_PROJETO"}'>style="display: none"</c:if>>
					 			<label>Projeto Captador</label>
								<div class="ui selection dropdown projetoBonificacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.projetoBonificacao.id" class="select" type="hidden" value="${contatoEvento.projetoBonificacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${projetosBonificacao}" var="projeto">
											<div class="item <c:if test="${projeto.id.equals(contatoEvento.projetoBonificacao.id)}">active selected</c:if>" data-value="${projeto.id}">${projeto.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
						</div>
					</div>
		        </form>
			</div>
  			<div class="title">
    			<i class="dropdown icon"></i>
	    		Contatos
  			</div>
  			<div class="content">
				<table class="ui black unstackable table">
					<thead class="teste">
						<tr>
							<th class="one wide">Data</th>
							<th class="four wide">Nome</th>
							<th class="one wide">Celular</th>
							<th class="two wide">Email</th>
							<th class="three wide">Instituição</th>
							<th class="three wide">Curso</th>
							<th class="one wide">Alunos</th>
							<th class="one wide">Interessados</th>
						</tr>
					</thead>
					<tbody>
						<tr class="cell-content-selectable">
							<td>25/04/2017</td>
							<td>João Carlos</td>
							<td>(99) 99999-8888</td>
							<td>joaocsilva@gmail.com</td>
							<td>UNIP</td>
							<td>Direito</td>
							<td>30</td>
							<td>50</td>
						</tr>
					</tbody>
				</table>
  			</div>
  			<div class="title">
    			<i class="dropdown icon"></i>
	    		Turmas
  			</div>
  			<div class="content">
				<table class="ui black unstackable table">
					<thead class="teste">
						<tr>
							<th class="four wide">Instituição</th>
							<th class="four wide">Unidade</th>
							<th class="two wide">Curso</th>
							<th class="two wide">Semestre</th>
							<th class="two wide">Turno</th>
							<th class="two wide">Nº da Turma</th>
						</tr>
					</thead>
					<tbody>
						<tr class="cell-content-selectable">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
  			</div>
  			<div class="title">
    			<i class="dropdown icon"></i>
	    		Comissão
  			</div>
  			<div class="content">
				<table class="ui black unstackable table">
					<thead class="teste">
						<tr>
							<th class="four wide">Aluno</th>
							<th class="four wide">Celular</th>
							<th class="four wide">E-mail</th>
							<th class="four wide">Função</th>
						</tr>
					</thead>
					<tbody>
						<tr class="cell-content-selectable">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
  			</div>
  			<div class="active title">
    			<i class="dropdown icon"></i>
	    		Cerimonial
  			</div>
  			<div class="active content">
        		<form role="form" action="<c:url value='/material/add'/>" method="POST" onsubmit="return validarForm()">
  					<div class="ui form">
						<div class="fields">
							<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Número</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="two date wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Data de Ativação</label>
								<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" name="${prefixoPes}.dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${pessoa.dataNascimento}" />">
							</div>
					 		<div class="six wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nome</label>
								<input type="text" readOnly class="campo-form" id="nomeProjeto" name="contatoEvento.nomeProjeto" value="${contatoEvento.nomeProjeto}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Situação</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
						</div>
						<div class="fields">
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Vendedor</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Gerente</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Captador</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
						</div>
						<div class="fields">
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Forma de Captação</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Tipo de Projeto</label>
								<div class="ui selection dropdown instituicao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.instituicao.id" id="instituicao" class="select" type="hidden" value="${contatoEvento.instituicao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${listaInstituicoes}" var="instituicao">
											<div class="item <c:if test="${instituicao.id.equals(contatoEvento.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
							<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Meta de Formandos</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
						</div>
						<div class="fields">
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Luxo</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Semi-luxo</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Simples</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
							<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Nº Convites Gráficos Online</label>
								<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
							</div>
						</div>		
						<div class="fields separador">
					 		<div class="three wide field <c:if test='${acao ne "show"}'>required</c:if>">
								<label>Forma de Captação</label>
								<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.formaCaptacao.id" class="select" type="hidden" value="${contatoEvento.formaCaptacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${formasCaptacao}" var="formaCaptacao">
											<div class="item <c:if test="${formaCaptacao.id.equals(contatoEvento.formaCaptacao.id)}">active selected</c:if>" data-value="${formaCaptacao.id}">${formaCaptacao.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div class="two wide field">
								<label>&nbsp;</label>
								<div class="ui checkbox <c:if test='${acao eq "show"}'>disabled</c:if>" id="indicacao">
											<input type="checkbox" ${contatoEvento.houveIndicacao?'checked':''} name="contatoEvento.houveIndicacao" value="true"><label>Houve Indicação</label>
								</div>
							</div>
					 		<div id="divindicacao" class="five wide field <c:if test='${acao ne "show"}'>required</c:if>" <c:if test="${!contatoEvento.houveIndicacao}">style="display: none"</c:if>><label>Tipo de Indicação</label>
								<div class="ui selection dropdown tipoIndicacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.tipoIndicacao" id="tipoIndicacao" class="select" type="hidden" value="${contatoEvento.tipoIndicacao.name()}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${tiposIndicacao}" var="tipoIndicacao">
											<div class="item <c:if test="${tipoIndicacao.name().equals(contatoEvento.tipoIndicacao.name())}">active selected</c:if>" data-value="${tipoIndicacao}">${tipoIndicacao.descricao}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_ASSISTENTE" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_ASSISTENTE"}'>style="display: none"</c:if>>
					 			<label>Funcionário Captador</label>
								<div class="ui selection dropdown funcionarioComissao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.funcionarioComissao.id" class="select" type="hidden" value="${contatoEvento.funcionarioComissao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${funcionariosComissao}" var="funcionario">
											<div class="item <c:if test="${funcionario.id.equals(contatoEvento.funcionarioComissao.id)}">active selected</c:if>" data-value="${funcionario.id}">${funcionario.pessoa.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_CAPTADOR_FUNCIONARIO" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_CAPTADOR_FUNCIONARIO"}'>style="display: none"</c:if>>
					 			<label>Funcionário Captador</label>
								<div class="ui selection dropdown funcionarioBonificacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.funcionarioBonificacao.id" class="select" type="hidden" value="${contatoEvento.funcionarioBonificacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${funcionariosBonificacao}" var="funcionario">
											<div class="item <c:if test="${funcionario.id.equals(contatoEvento.funcionarioBonificacao.id)}">active selected</c:if>" data-value="${funcionario.id}">${funcionario.pessoa.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_CAPTADOR_EXTERNO" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_CAPTADOR_EXTERNO"}'>style="display: none"</c:if>>
					 			<label>Captador Externo</label>
								<div class="ui selection dropdown captadorBonificacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.captadorBonificacao.id" class="select" type="hidden" value="${contatoEvento.captadorBonificacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${captadoresBonificacao}" var="captador">
											<div class="item <c:if test="${captador.id.equals(contatoEvento.captadorBonificacao.id)}">active selected</c:if>" data-value="${captador.id}">${captador.pessoa.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
					 		<div id="INDICACAO_PROJETO" class="five wide field <c:if test='${acao ne "show"}'>required</c:if> indicacao" <c:if test='${contatoEvento.tipoIndicacao.name() ne "INDICACAO_PROJETO"}'>style="display: none"</c:if>>
					 			<label>Projeto Captador</label>
								<div class="ui selection dropdown projetoBonificacao <c:if test='${acao eq "show"}'>disabled</c:if>">
									<input name="contatoEvento.projetoBonificacao.id" class="select" type="hidden" value="${contatoEvento.projetoBonificacao.id}">
					  				<div class="default text">Selecione</div>
					  				<i class="dropdown icon"></i>
					  				<div class="menu">
										<c:forEach items="${projetosBonificacao}" var="projeto">
											<div class="item <c:if test="${projeto.id.equals(contatoEvento.projetoBonificacao.id)}">active selected</c:if>" data-value="${projeto.id}">${projeto.nome}</div>
										</c:forEach>
					  				</div>
					 			</div>
							</div>
						</div>
					</div>
		        </form>
			</div>
		</div>
   	</jsp:body>
</template:admin>
