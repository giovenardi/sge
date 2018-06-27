function removerMembroComissao() {
	if (idRemove != "") {
		var membroComissao = {
			"membroComissao.id" : idRemove
		};
		$.ajax({
			url : $("#urlContextMembroComissao"+idRemove).val(),
			type : "POST",
			data : membroComissao,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#membroComissao" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

$("#formMembroComissao").on('inclusao:ok', function(event, json) {
	$("#modalMembroComissao").modal('hide');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRMembroComissao(obj);
	var trEx = $("#membroComissao" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyMembrosComissao").append(tr);
	}
});

$("#formMembroComissao").on('alteracao:ok', function(event, json) {
	$("#modalMembroComissao").modal('hide');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRMembroComissao(obj);
	var trEx = $("#membroComissao" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyMembrosComissao").append(tr);
	}
});

$("#formPF").on('inclusaoPFM:ok', function(event, json) {
	var tela = $("#modalMembroComissao");
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

$("#formPF").on('alteracaoPFM:ok', function(event, json) {
	var tela = $("#modalMembroComissao");
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

function montarTRMembroComissao(obj) {
	var tr = "<tr id='membroComissao" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.pessoa.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.celularPrincipal?obj.celularPrincipal:"";
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.emailPrincipal?obj.emailPrincipal:"";
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.funcao.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
    tr 	+= 	"		<input id=\"urlContextMembroComissao"+obj.id+"\" value=\"/sge/membroComissao/excluir\" hidden=\"true\">";
    tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerMembroComissao)\" class=\"ui button\" data-content=\"Excluir\" data-position=\"top right\">";
    tr 	+= 	"			<i class=\"trash alternate red icon\"></i>";
    tr 	+= 	"		</a>";
    tr 	+= 	"		<a class=\"ui button\" onclick=\"editarMembroComissao("+obj.id+")\" data-content=\"Alterar\">";
    tr 	+= 	"			<i class=\"pencil alternate blue icon\"></i>";
    tr 	+= 	"		</a>";
    tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#novoMembroComissao').on('click', function(evt){
    $('#formMembroComissao').form('clear');
    limparPF();
    $('#iconeMembroComissao').removeClass('pencilEdicao');
    $('#iconeMembroComissao').addClass('pencilNovo');
    $("#tituloMembroComissao").text("Incluir novo Membro de Comissão");
	$("#modalMembroComissao").modal('show');
	$('#btnConfirmMembroComissao').off('click');
	$('#btnConfirmMembroComissao').click(function() {return submeterFormAjax('formMembroComissao', 'inclusao:ok')});
	$('#membroComissaoComissaoId').val($('#comissaoId').val());
});

function editarMembroComissao(id){
    $('#formMembroComissao').form('clear');
    $('#iconeMembroComissao').removeClass('pencilNovo');
    $('#iconeMembroComissao').addClass('pencilEdicao');
    $("#tituloMembroComissao").text("Alterar Membro de Comissão");
	$('#btnConfirmMembroComissao').off('click');
	$('#btnConfirmMembroComissao').click(function() {return submeterFormAjax('formMembroComissao', 'alteracao:ok')});
	$('#membroComissaoId').val(id);
	submeterFormAjax('formMembroComissao', 'busca:ok', "/sge/membroComissao/editar", "GET");
}

$("#formMembroComissao").on('busca:ok', function(event, json) {
	var membroComissao = json.retornoJson.obj;
	$('.pfId').val(membroComissao.pessoa.id);
	$('.pfNome').val(membroComissao.pessoa.nome);
	if (membroComissao.funcao && membroComissao.funcao.id) {
		$('#funcaoMembroComissao').val(membroComissao.funcao.id);
		$('.dropdown.funcaoMembroComissao').dropdown('set selected', membroComissao.funcao.id);
	}
	if (membroComissao.comissaoFormatura && membroComissao.comissaoFormatura.id) {
		$('#membroComissaoComissaoId').val(membroComissao.comissaoFormatura.id);
	}
	$('#emailPrincipalMembro').val(membroComissao.emailPrincipal);
	$('#emailSecundarioMembro').val(membroComissao.emailSecundario);
	$('#telefoneFixoMembro').val(membroComissao.telefoneFixo);
	$('#celularPrincipalMembro').val(membroComissao.celularPrincipal);
	$('#celularSecundarioMembro').val(membroComissao.celularSecundario);

	$("#modalMembroComissao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});
$('#maskedValorTotalMembroComissao').on('change', function() {
	$('#valorTotalMembroComissao').val(($('#maskedValorTotalMembroComissao').maskMoney('unmasked')[0]+"").replace('.', ','));
})

$("#modalMembroComissao").modal('setting', 'closable', false);
$("#modalPF").modal('setting', 'closable', false);

function inserirEditarPessoaMembroComissao() {
	var id = $('#pfId').val();
	if (!(id)) {
		inserirPessoaMembroComissao();
	} else {
		editarPessoaMembroComissao(id)
	}
}


function inserirPessoaMembroComissao() {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'inclusaoPFM:ok')});
	$('#btnPFCancel').off('click');
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$("#modalMembroComissao").modal('show');
	});
	$('#modalPF').modal('show');
}

function editarPessoaMembroComissao(id) {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'alteracaoPFM:ok')});
	$('#btnPFCancel').off('click');
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$("#modalMembroComissao").modal('show');
	});
	$('#modalPF').modal('show');
	buscarPFPorId(id);
}

