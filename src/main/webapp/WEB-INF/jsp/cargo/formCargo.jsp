<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="lummi"%>
<div class="ui small modal" id="modalCargo">
	<div class="ui icon header">
		<i id="iconeCargo" class="glyphicon glyphicon-education pencilNovo"></i> <span id='tituloCargo'>Cadastro de
			Funcionário</span>
	</div>
	<div class="content">
		<form role="form" id="formCargo" method="POST" action='<c:url value="/cargo/salvar"/>'>
			<input name="cargo.id" id="cargoId" type="hidden" value="${cargo.id}">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields separador">
						<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
							<label>Nome</label> <input type="text" <c:if test='${acao eq "show"}'>disabled</c:if> maxlength="250"
								class="campo-form" id="cargoNome" name="cargo.nome" value="">
						</div>
					</div>
					<div class="fields separador">
						<div class="five wide field check">
							<div class="field">
								<div class="ui toggle checkbox vendedor">
									<input id="cargoVendedor" type="checkbox" name="cargo.vendedor" value="true" ${cargo.vendedor?'checked':''}>
									<label>Vendedor</label>
								</div>
							</div>
						</div>
						<div class="five wide field check">
							<div class="field">
								<div class="ui toggle checkbox captador">
									<input id="cargoCaptador" type="checkbox" name="cargo.captador" value="true" ${cargo.captador?'checked':''}>
									<label>Captador</label>
								</div>
							</div>
						</div>
						<div class="five wide field check">
							<div class="field">
								<div class="ui toggle checkbox gerente">
									<input id="cargoGerente" type="checkbox" name="cargo.gerente" value="true" ${cargo.gerente?'checked':''}>
									<label>Gerente</label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div id="botoesForm" class="actions" style="text-align: center">
		<a class="ui red inverted cancel button"> <i class="remove icon"></i> Cancelar
		</a> <a id="btnConfirmCargo" class="ui blue ok inverted button" href="#"> <i class="checkmark icon"></i> Salvar
		</a>
	</div>
	<div id="botaoFechar" class="actions" style="text-align: center">
		<a class="ui red inverted cancel button"> <i class="remove icon"></i> Fechar
		</a>
	</div>
</div>