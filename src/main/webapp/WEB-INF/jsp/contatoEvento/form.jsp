<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<input name="contatoEvento.id" type="hidden" value="${contatoEvento.id}">
<input name="contatoEvento.status" type="hidden" value="${contatoEvento.status}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Nome do Contato</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="100" class="campo-form" name="contatoEvento.nome" value="${contatoEvento.nome}">
			</div>
	 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Tipo de Projeto</label>
				<div class="ui selection dropdown tipoProjeto <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="contatoEvento.tipoProjeto" id="tipoProjeto" type="hidden" class="select" value="${contatoEvento.tipoProjeto}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${tiposProjeto}" var="tipoProjeto">
							<div class="item <c:if test="${tipoProjeto.name().equals(contatoEvento.tipoProjeto.name())}">active selected</c:if>" data-value="${tipoProjeto.name()}">${tipoProjeto.descricao}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="six wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Nome do Projeto</label>
				<input type="text" readOnly class="campo-form" id="nomeProjeto" name="contatoEvento.nomeProjeto" value="${contatoEvento.nomeProjeto}">
			</div>
		</div>
		<div class="fields separador">
	 		<div class="five wide field">
				<label>Telefone Fixo</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="15" class="campo-form telefone" name="contatoEvento.telefone" value="${contatoEvento.telefone}">
			</div>
	 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Celular</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="15" class="campo-form telefone" name="contatoEvento.celular" value="${contatoEvento.celular}">
			</div>
	 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Email</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="255" class="campo-form" name="contatoEvento.email" value="${contatoEvento.email}">
			</div>
		</div>
		<div class="fields separador complementar" <c:if test='${!fn:containsIgnoreCase(contatoEvento.tipoProjeto.name(), "FORMATURA")}'>style="display:none"</c:if>>
	 		<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Instituição</label>
				<div class="ui selection dropdown instituicaoTurma <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="contatoEvento.unidadeInstituicao.instituicao.id" id="instituicaoTurma" class="select" type="hidden" value="${contatoEvento.unidadeInstituicao.instituicao.id}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaInstituicoes}" var="instituicao">
							<div class="item <c:if test="${instituicao.id.equals(contatoEvento.unidadeInstituicao.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="three wide field required">
				<label>Unidade</label>
				<div class="ui selection dropdown unidadeInstituicao">
					<input name="contatoEvento.unidadeInstituicao.id" id="unidadeInstituicao" class="select" type="hidden" value="${contatoEvento.unidadeInstituicao.id}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaUnidades}" var="unidadeInstituicao">
							<div class="item <c:if test="${unidadeInstituicao.id.equals(contatoEvento.unidadeInstituicao.id)}">active selected</c:if>" data-value="${unidadeInstituicao.id}">${unidadeInstituicao.nome}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="three wide field FORMATURA_FUNDAMENTAL_MEDIO FORMATURA_FUNDAMENTAL FORMATURA_MEDIO FORMATURA_INFANTIL <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Nível</label>
				<div class="ui selection dropdown nivel <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="contatoEvento.nivel.id" id="nivel" class="select" type="hidden" value="${contatoEvento.nivel.id}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaNiveis}" var="nivel">
							<div class="item <c:if test="${nivel.name() eq contatoEvento.nivel.name()}">active selected</c:if>" data-value="${nivel.name()}">${nivel.descricao}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="three wide field FORMATURA_SUPERIOR <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Curso</label>
				<div class="ui selection dropdown curso <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="contatoEvento.curso.id" id="curso" class="select" type="hidden" value="${contatoEvento.curso.id}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaCursos}" var="curso">
							<div class="item <c:if test="${curso.id.equals(contatoEvento.curso.id)}">active selected</c:if>" data-value="${curso.id}">${curso.nome}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="two wide field FORMATURA_SUPERIOR <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Semestre</label>
				<div class="ui selection dropdown semestre <c:if test='${acao eq "show"}'>disabled</c:if>" style="min-width:10em!important">
					<input name="contatoEvento.semestre" id="semestre" class="select" type="hidden" value="${contatoEvento.semestre}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaSemestres}" var="semestre">
							<div class="item <c:if test="${semestre.ordinal() eq contatoEvento.semestre.ordinal()}">active selected</c:if>" data-value="${semestre}">${semestre.descricao}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="one wide field dateYYYY <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Ano</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" id="ano" name="contatoEvento.ano" value="${contatoEvento.ano}">
			</div>
	 		<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Turno</label>
				<div class="ui selection dropdown turno <c:if test='${acao eq "show"}'>disabled</c:if>" style="min-width:7em!important">
					<input name="contatoEvento.turno.id" id="turno" class="select" type="hidden" value="${contatoEvento.turno.id}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaTurnos}" var="turno">
							<div class="item <c:if test="${turno.id eq contatoEvento.turno.id}">active selected</c:if>" data-value="${turno.id}">${turno.nome}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
	 		<div class="one wide field FORMATURA_SUPERIOR">
				<label>Número</label>
				<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" id="numero" name="contatoEvento.numeroTurma" value="${contatoEvento.numeroTurma}">
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
	 		<div class="three wide field">
				<label>&nbsp;</label>
				<div class="ui toggle checkbox <c:if test='${acao eq "show"}'>disabled</c:if>" id="indicacao">
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
	 			<label>Funcionário</label>
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
	 			<label>Funcionário</label>
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
		<div class="fields separador">
	 		<div class="sixteen wide field">
				<label>Observação</label>
				<textarea name="contatoEvento.observacao" ${(acao eq "show")?"disabled":""} rows="3">${contatoEvento.observacao}</textarea>
	 		</div>
		</div>
 	</div>
</div>