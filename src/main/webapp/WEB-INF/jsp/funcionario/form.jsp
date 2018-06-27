<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input name="funcionario.id" type="hidden" value="${funcionario.id}">
<div id="divfunci" <c:if test='${acao eq "novo" and funcionario.pessoa.cpf eq null}'>style="display:none"</c:if>>
	<div class="ui horizontal divider">Dados Funcionais</div>
	<div class="ui segment">
		<div class="ui form">
			<div class="fields separador">
		 		<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
					<label>Matrícula</label>
					<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="10" class="campo-form" name="funcionario.matricula" value="${funcionario.matricula}">
				</div>
		 		<div class="five wide field <c:if test='${acao ne "show"}'>required</c:if>">
					<label>Cargo</label>
					<div class="ui selection dropdown cargo <c:if test='${acao eq "show"}'>disabled</c:if>">
						<input name="funcionario.cargo.id" id="cargo" type="hidden" class="select" value="${funcionario.cargo.id}">
		  				<div class="default text">Selecione</div>
		  				<i class="dropdown icon"></i>
		  				<div class="menu">
							<c:forEach items="${cargos}" var="cargo">
								<div class="item <c:if test="${cargo.id.equals(funcionario.cargo.id)}">active selected</c:if>" data-value="${cargo.id}">${cargo.nome}</div>
							</c:forEach>
		  				</div>
		 			</div>
				</div>
		 		<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
					<label>CTPS</label>
					<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="20" class="campo-form" name="funcionario.ctps" value="${funcionario.ctps}">
				</div>
		 		<div class="two wide field <c:if test='${acao ne "show"}'>required</c:if>">
					<label>Série CTPS</label>
					<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="5" class="campo-form" name="funcionario.serieCtps" value="${funcionario.serieCtps}">
				</div>
			</div>
		</div>
	</div>
	
	<c:set var="pessoa" scope="request" value="${funcionario.pessoa}" />
	<c:set var="prefixoPes" scope="request" value="funcionario.pessoa" />
	<div class="ui horizontal divider">Dados Pessoais</div>
	<jsp:include page="../pessoaFisica/tela.jsp" />
</div>