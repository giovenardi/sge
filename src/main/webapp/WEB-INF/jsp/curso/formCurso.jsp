<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi"%>
<div class="ui small modal" id="modalCurso">
	<div class="ui icon header">
		<i id="iconeCurso" class="glyphicon glyphicon-education pencilNovo"></i> 
		<span id='tituloCurso'>Cadastro de Curso</span>
	</div>
	<div class="content">
		<form role="form" id="formCurso" method="POST" action='<c:url value="/curso/salvar"/>'>
			<input name="curso.id" id="cursoId" type="hidden" value="${curso.id}">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Nome</label> <input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="250"
								class="campo-form" id="cursoNome" name="curso.nome" value="">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div id="botoesForm" class="actions" style="text-align: center">
		<a class="ui red inverted cancel button"> <i class="remove icon"></i> Cancelar
		</a> <a id="btnConfirmCurso" class="ui green ok inverted button" href="#"> <i class="checkmark icon"></i> Salvar
		</a>
	</div>
	<div id="botaoFechar" class="actions" style="text-align: center">
		<a class="ui red inverted cancel button"> <i class="remove icon"></i> Fechar
		</a>
	</div>
</div>