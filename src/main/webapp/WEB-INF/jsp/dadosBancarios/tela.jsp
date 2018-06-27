<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<div class="ui" id="dadosBancarios" style="height: 100%">
	<input type="hidden" id="dadosBancarios_id" name="${prefixoDB}.id">
	<div class="ui form">
		<div class="fields separador">
			<div class="ten wide field">
				<label>Banco</label>
				<div class="ui selection dropdown banco">
					<input id="dadosBancarios_banco_id" name="${prefixoDB}.banco.id"type="hidden">
					<div class="default text">Selecione</div>
					<i class="dropdown icon"></i>
					<div class="menu">
						<c:forEach items="${bancos}" var="banco">
							<div class="item" data-value="${banco.id}">${banco.numero + " - " + banco.nome}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="fields separador">
			<div class="ten wide field">
				<label>Agência</label>
				<input id="dadosBancarios_conta" type="text" maxlength="40" class="campo-form" name="${prefixoDB}.agencia">
			</div>
		</div>
		<div class="fields separador">
			<div class="ten wide field">
				<label>Conta</label>
				<input id="dadosBancarios_conta" type="text" maxlength="40" class="campo-form" name="${prefixoDB}.conta">
			</div>
		</div>
	</div>
</div>
