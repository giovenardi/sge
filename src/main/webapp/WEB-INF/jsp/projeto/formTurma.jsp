<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="acao" scope="request" value="alterar" />
<div class="ui small modal" id="modalTurma">
    <div class="ui icon header" id="tituloModalTurma">
    	<i class="glyphicon glyphicon-education pencilNovo"></i>
      	Incluir uma Turma
    </div>
    <form role="form" id="formTurma" method="POST" action='<c:url value="/turma/incluir"/>'>
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<input name="turma.projeto.id" id="projetoTurmaId" type="hidden" value="${projeto.id}">
						<input name="turma.projeto.tipo" id="projetoTurmaTipo" type="hidden" value="${projeto.tipo}">
				 		<div class="eight wide field required">
							<label>Instituição</label>
							<div class="ui selection dropdown instituicaoTurma">
								<input name="turma.unidadeInstituicao.instituicao.id" id="instituicaoTurma" class="select" type="hidden" value="">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaInstituicoes}" var="instituicao">
										<div class="item" data-value="${instituicao.id}">${instituicao.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
				 		<div class="eight wide field required">
							<label>Unidade</label>
							<div class="ui selection dropdown unidadeInstituicao">
								<input name="turma.unidadeInstituicao.id" id="unidadeInstituicao" class="select" type="hidden" value="">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaUnidades}" var="instituicao">
										<div class="item <c:if test="${instituicao.id.equals(turma.instituicao.id)}">active selected</c:if>" data-value="${instituicao.id}">${instituicao.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
					</div>
					<div class="fields separador">
				 		<div class="six wide field FORMATURA_SUPERIOR <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Curso</label>
							<div class="ui selection dropdown curso <c:if test='${acao eq "show"}'>disabled</c:if>">
								<input name="turma.curso.id" id="curso" class="select" type="hidden" value="${turma.curso.id}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaCursos}" var="curso">
										<div class="item <c:if test="${curso.id.equals(turma.curso.id)}">active selected</c:if>" data-value="${curso.id}">${curso.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
				 		<div class="six wide field FORMATURA_SUPERIOR <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Semestre</label>
							<div class="ui selection dropdown semestre <c:if test='${acao eq "show"}'>disabled</c:if>">
								<input name="turma.semestre" id="semestre" class="select" type="hidden" value="${turma.semestre}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaSemestres}" var="semestre">
										<div class="item <c:if test="${semestre.ordinal() eq turma.semestre.ordinal()}">active selected</c:if>" data-value="${semestre}">${semestre.descricao}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
				 		<div class="six wide field FORMATURA_FUNDAMENTAL_MEDIO FORMATURA_FUNDAMENTAL FORMATURA_MEDIO FORMATURA_INFANTIL <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Nível</label>
							<div class="ui selection dropdown nivel <c:if test='${acao eq "show"}'>disabled</c:if>">
								<input name="turma.nivel" id="nivel" class="select" type="hidden" value="${turma.nivel}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaNiveis}" var="nivel">
										<div class="item <c:if test="${nivel.name() eq turma.nivel.name()}">active selected</c:if>" data-value="${nivel.name()}">${nivel.descricao}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
				 		<div class="four wide field dateYYYY <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Ano</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" id="ano" name="turma.ano" value="${turma.ano}">
						</div>
					</div>
					<div class="fields separador">
				 		<div class="six wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Turno</label>
							<div class="ui selection dropdown turno <c:if test='${acao eq "show"}'>disabled</c:if>">
								<input name="turma.turno.id" id="turno" class="select" type="hidden" value="${turma.turno.id}">
				  				<div class="default text">Selecione</div>
				  				<i class="dropdown icon"></i>
				  				<div class="menu">
									<c:forEach items="${listaTurnos}" var="turno">
										<div class="item <c:if test="${turno.id eq turma.turno.id}">active selected</c:if>" data-value="${turno.id}">${turno.nome}</div>
									</c:forEach>
				  				</div>
				 			</div>
						</div>
				 		<div class="three wide field">
							<label>Número</label>
							<input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form" id="numero" name="turma.numero" value="${turma.numero}">
						</div>
					</div>
				</div>
			</div>
        </div>
	    <div class="actions" style="text-align: center"> 
	      	<a class="ui red basic cancel button">
	        	<i class="remove icon"></i>
	        	Cancelar
	      	</a>
	      	<a id="btnConfirmTurma" class="ui green ok inverted button" href="#">
	        	<i class="checkmark icon"></i>
	        	Salvar
	      	</a>
		</div>
	</form>
</div>