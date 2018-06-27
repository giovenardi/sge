function removerFormando() {
	if (idRemove != "") {
		var formando = {
			"formando.id" : idRemove
		};
		$.ajax({
			url : $("#urlContext"+idRemove).val(),
			type : "POST",
			data : formando,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#formando" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

$("#formFormando").on('inclusao:ok', function(event, json) {
	$("#modalFormando").modal('hide');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRFormando(obj);
	var trEx = $("#formando" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyFormandos").append(tr);
	}
});

$("#formFormando").on('alteracao:ok', function(event, json) {
	$("#modalFormando").modal('hide');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRFormando(obj);
	var trEx = $("#formando" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyFormandos").append(tr);
	}
});

$("#formPF").on('inclusaoPFF:ok', function(event, json) {
	var tela = $("#modalFormando");
	tela.modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var nome = json.retornoJson.obj.nome;
	var cpf = json.retornoJson.obj.cpf;
	tela.find(".pfId").val(id);
	tela.find(".pfNome").val(nome);
	msgNotify('success', 'Pessoa associada com sucesso');
	resetFormPF();
});

$("#formPF").on('alteracaoPFF:ok', function(event, json) {
	var tela = $("#modalFormando");
	tela.modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var nome = json.retornoJson.obj.nome;
	var cpf = json.retornoJson.obj.cpf;
	tela.find(".pfId").val(id);
	tela.find(".pfNome").val(nome);
	msgNotify('success', 'Pessoa alterada com sucesso');
	resetFormPF();
});

function montarTRFormando(obj) {
	var tr = "<tr id='formando" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.pessoa.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
    tr 	+= 	"		<input id=\"urlContextFormando"+obj.id+"\" value=\"/sge/formando/excluir\" hidden=\"true\">";
    tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerFormando)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
    tr 	+= 	"			<i class=\"erase alternate red icon\"></i>";
    tr 	+= 	"		</a>";
    tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#novoFormando').on('click', function(evt){
    $('#formFormando').form('clear');
    $('#iconeFormando').removeClass('pencilEdicao');
    $('#iconeFormando').addClass('pencilNovo');
    $("#tituloFormando").text("Incluir novo Formando");
	$("#modalFormando").modal('show');
	$('#btnConfirmFormando').off('click');
	$('#btnConfirmFormando').click(function() {return submeterFormAjax('formFormando', 'inclusao:ok')});
});

function editarFormando(id){
    $('#formFormando').form('clear');
    $('#iconeFormando').removeClass('pencilNovo');
    $('#iconeFormando').addClass('pencilEdicao');
    $("#tituloFormando").text("Alterar Formando");
//	$("#modalFormando").modal('show');
	$('#btnConfirmFormando').off('click');
	$('#btnConfirmFormando').click(function() {return submeterFormAjax('formFormando', 'alteracao:ok')});
	$('#formandoId').val(id);
	submeterFormAjax('formFormando', 'busca:ok', "/sge/formando/editar", "GET");
}

$("#formFormando").on('busca:ok', function(event, json) {
	var formando = json.retornoJson.obj;
	$('.pfId').val(formando.pessoa.id);
	$('.pfNome').val(formando.pessoa.nome);
	if (formando.turma && formando.turma.id) {
		$('#turmaFormando').val(formando.turma.id);
		$('.dropdown.turmaFormando').dropdown('set selected', formando.turma.id);
	}
	if (formando.planoPagamento && formando.planoPagamento.id) {
		$('#planoPagamentoFormando').val(formando.planoPagamento.id);
		$('.dropdown.planoPagamentoFormando').dropdown('set selected', formando.planoPagamento.id);
	}
	$('#maskedValorTotalFormando').maskMoney('mask', formando.valorTotal)

	$("#valorTotalFormando").val(formando.valorTotal);
	$("#status").val(formando.status);
	$("#situacao").val(formando.situacao);
	$("#numeroHavaiana").val(formando.numeroHavaiana);
	$("#quantidadeParcelas").val(formando.quantidadeParcelas);
	$("#modalFormando").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});
$('#maskedValorTotalFormando').on('change', function() {
	$('#valorTotalFormando').val(($('#maskedValorTotalFormando').maskMoney('unmasked')[0]+"").replace('.', ','));
})

$("#modalFormando").modal('setting', 'closable', false);
$("#modalPF").modal('setting', 'closable', false);

function inserirEditarPessoaFormando() {
	var id = $('#pfId').val();
	if (!(id)) {
		inserirPessoaFormando();
	} else {
		editarPessoaFormando(id)
	}
}


function inserirPessoaFormando() {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'inclusaoPFF:ok')});
	$('#modalPF').modal('show');
}

function editarPessoaFormando(id) {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'alteracaoPFF:ok')});
	$('#modalPF').modal('show');
	buscarPFPorId(id);
}

