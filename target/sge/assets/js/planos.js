function removerPlano() {
	if (idRemove != "") {
		var plano = {
				"plano.id" : idRemove
		};
		$.ajax({
			url : $("#urlContextPlano"+idRemove).val(),
			type : "POST",
			data : plano,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#plano" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

function removerFormaPagamento() {
	if (idRemove != "") {
		var formaPagamento = {
			"formaPagamento.id" : idRemove
		};
		$.ajax({
			url : $("#urlContextPlano"+idRemove).val(),
			type : "POST",
			data : plano,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#FfrmaPagamento" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

$("#formPlano").on('inclusao:ok', function(event, json) {
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRPlano(obj);
	$("#planoId").val(id);
	var trEx = $("#plano" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyPlanos").append(tr);
	}
	$('#btnFormasPagamento').removeClass('disabled');
});

$("#formPlano").on('busca:ok', function(event, json) {
	var obj = json.retornoJson.obj;
	$.each(obj.formasPagamento, function(i, forma) {
		var id = forma.id;
		var tr = montarTRFormaPagamento(forma);
		var trEx = $("#formaPagamento" + id);
		if (trEx.length > 0) {
			trEx.replaceWith(tr);
		} else {
			$("#bodyFormasPagamento").append(tr);
		}
	});
	$('#valorTotalPlano').val(obj.valor);
	$('#maskedValorTotalPlano').maskMoney('mask', obj.valor)
	$('#planoNome').val(obj.nome);
	$('#planoConvidados').val(obj.convidados);
	$('#planoConvitesLuxo').val(obj.convitesLuxo);
	$('#planoConvitesSemiLuxo').val(obj.convitesSemiLuxo);
	$('#planoConvitesSimples').val(obj.convitesSimples);
	$('#btnFormasPagamento').removeClass('disabled');
	$("#modalPlano").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formFormaPagamentoPlano").on('inclusao:ok', function(event, json) {
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRFormaPagamento(obj);
	var trEx = $("#formaPagamentoPlano" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyFormasPagamento").append(tr);
	}
	$("#modalListFormas").modal('show');
});

function montarTRPlano(obj) {
	var tr = "<tr id='plano" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 	"		<input id=\"urlContextPlano"+obj.id+"\" value=\"/sge/planoPagamento/excluir\" hidden=\"true\" />";
	tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerPlano)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
	tr 	+= 	"		  <i class=\"erase outline red icon\"></i>";
	tr 	+= 	"		</a>";
	tr 	+= 	"    <a onclick=\"editarPlano("+obj.id+")\" class=\"ui button icon\" data-content=\"Alterar\" data-position=\"top right\">";
	tr 	+= 	"    	<i class=\"pencil outline blue icon\"></i>";
	tr 	+= 	"    </a>";
	tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

function montarTRFormaPagamento(obj) {
	var tr = "<tr id='formaPagamento" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.titulo;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.dataInicio;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.parcelas;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.formaParcelamento;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
    tr 	+= 	"		<input id=\"urlContextFormaPagamento"+obj.id+"\" value=\"/sge/formaPagamento/excluir\" hidden=\"true\" />";
    tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerFormaPagamento)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
    tr 	+= 	"		  <i class=\"erase outline red icon\"></i>";
    tr 	+= 	"		</a>";
    tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#buttonNovaFormaPagamentoPlano').on("click", function(evt){
    $("#formFormaPagamentoPlano").form('clear');
    $("#planoFormaPagamentoId").val($("#planoId").val());
    $("#modalFormaPagamentoPlano").modal('show');
});

$('#btnConfirmFormaPagamentoPlano').on('click', function() {
	return submeterFormAjax('formFormaPagamentoPlano', 'inclusao:ok')
});

$('#novoPlano').on('click', function(evt){
	$('#btnFormasPagamento').addClass('disabled');
    $('#formPlano').form('clear');
	$('#bodyFormasPagamento').find('tr').remove();
    $("#projetoPlanoId").val($("#projeto_id").val());
    $('#iconePlano').removeClass('pencilEdicao');
    $('#iconePlano').addClass('pencilNovo');
    $("#tituloPlano").text("Incluir novo Plano");
	$("#modalPlano").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	$('#btnConfirmPlano').off('click');
	$('#btnConfirmPlano').click(function() {return submeterFormAjax('formPlano', 'inclusao:ok')});
});

function editarPlano(id){
    $('#formPlano').form('clear');
	$('#bodyFormasPagamento').find('tr').remove();
    $("#projetoPlanoId").val($("#projeto_id").val());
    $("#planoId").val(id);
    $('#iconePlano').removeClass('pencilNovo');
    $('#iconePlano').addClass('pencilEdicao');
    $("#tituloPlano").text("Alterar Plano");
	$('#btnConfirmPlano').off('click');
	$('#btnConfirmPlano').click(function() {return submeterFormAjax('formPlano', 'inclusao:ok')});
	submeterFormAjax('formPlano', 'busca:ok', "/sge/planoPagamento/editar", "GET");
}

$('#modalListFormas').modal('setting', 'transition', 'vertical flip').modal('setting', 'closable', false).modal('attach events', '#btnFormasPagamento', 'show').modal('attach events', '#modalFormaPagamentoPlano .button.cancel', 'show');

$("#modalFormaPagamentoPlano").modal('setting', 'closable', false);

$('#valorTotalPlano').val(($('#maskedValorTotalPlano').maskMoney('unmasked')[0]+"").replace('.', ','));

$('#maskedValorTotalPlano').on('change', function() {
	$('#valorTotalPlano').val(($('#maskedValorTotalPlano').maskMoney('unmasked')[0]+"").replace('.', ','));
});
