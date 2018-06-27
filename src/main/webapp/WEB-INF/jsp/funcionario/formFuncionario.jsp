<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi" %>
<div class="ui small modal" id="modalFuncionario">
    <div class="ui icon header">
    	<i id="iconeFuncionario" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloFuncionario'>Cadastro de Funcionário</span>
    </div>
	<div class="content">
	    <form role="form" id="formFuncionario" method="POST" action='<c:url value="/funcionario/salvar"/>'>
			<input name="funcionario.id" id="funcionarioId" type="hidden" value="${funcionario.id}">
			<div class="ui segment">
				<div class="ui form">
			    	<lummi:pf label="Nome" obrigatorio="true" prefixo="funcionario" funcao="inserirEditarPessoaFuncionario()"/>
					<div class="fields separador">
						<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
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
					</div>
					<div class="fields separador">
						<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Setor</label>
							<div class="ui selection dropdown setor <c:if test='${acao eq "show"}'>disabled</c:if>">
								<input name="funcionario.setor.id" id="setor" type="hidden" class="select" value="${funcionario.setor.id}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${setores}" var="setor">
										<div class="item <c:if test="${setor.id.equals(funcionario.setor.id)}">active selected</c:if>" data-value="${setor.id}">${setor.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
					<div class="fields">
				 		<div class="six wide field">
							<label>Matrícula</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="10" class="campo-form" id="matricula" name="funcionario.matricula" value="${funcionario.matricula}">
						</div>
				 		<div class="five wide field">
							<label>CTPS</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="20" class="campo-form" id="ctps" name="funcionario.ctps" value="${funcionario.ctps}">
						</div>
				 		<div class="five wide field">
							<label>Série CTPS</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="5" class="campo-form" id="serieCtps" name="funcionario.serieCtps" value="${funcionario.serieCtps}">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="actions" style="text-align: center"> 
		<a class="ui red inverted cancel button">
			<i class="remove icon"></i>
		    Cancelar
		</a>
      	<a id="btnConfirmFuncionario" class="ui green ok inverted button" href="#">
        	<i class="checkmark icon"></i>
        	Salvar
      	</a>
	</div>
</div>