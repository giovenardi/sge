function removerInstituicao() {
	if (idRemove != "") {
		var instituicao = {
			"instituicao.id" : idRemove
		};
		$.ajax({
			url : $("#urlContextInst"+idRemove).val(),
			type : "POST",
			data : instituicao,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#instituicao" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

function removerUnidade() {
	if (idRemove != "") {
		var unidade = {
			"unidade.id" : idRemove
		};
		$.ajax({
			url : $("#urlContextUni"+idRemove).val(),
			type : "POST",
			data : unidade,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#unidade" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

function editarUnidade(id){
    $('#formUnidadeInstituicao').form('clear');
    $("#instituicaoUnidadeId").val($("#instituicaoId").val());
    $("#unidadeInstituicaoId").val(id);
    $('#iconeUnidadeInstituicao').removeClass('pencilNovo');
    $('#iconeUnidadeInstituicao').addClass('pencilEdicao');
    $("#tituloUnidadeInstituicao").text("Alterar Unidade");
	$('#btnConfirmUnidadeInstituicao').off('click');
	$('#btnConfirmUnidadeInstituicao').click(function() {return submeterFormAjax('formUnidadeInstituicao', 'inclusao:ok')});
	submeterFormAjax('formUnidadeInstituicao', 'busca:ok', "/sge/unidadeInstituicao/editar", "GET");
}

$("#formUnidadeInstituicao").on('busca:ok', function(event, json) {
	var obj = json.retornoJson.obj;
	$('#unidadeInstituicaoNome').val(obj.nome);
	$("#modalUnidadeInstituicao").modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formUnidadeInstituicao").on('inclusao:ok', function(event, json) {
	$("#modalInstituicao").modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRUnidadeInstituicao(obj);
	var trEx = $("#unidade" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyUnidades").append(tr);
	}
});

function montarTRUnidadeInstituicao(obj) {
	var tr = "<tr id='unidade" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr  +=  "		<div class='ui icon buttons'>";
	tr 	+= 	"			<input id=\"urlContext"+obj.id+"\" value=\"/sge/instituicao/excluirUnidade\" hidden=\"true\" />";
	tr 	+= 	"			<a onclick=\"modalConfirmAjax("+obj.id+", removerUnidade)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
	tr 	+= 	"		  		<i class=\"trash alternate red icon\"></i>";
	tr 	+= 	"			</a>";
	tr 	+= 	"    		<a onclick=\"editarUnidade("+obj.id+")\" class=\"ui button icon\" data-content=\"Alterar\" data-position=\"top right\">";
	tr 	+= 	"    			<i class=\"pencil alternate blue icon\"></i>";
	tr 	+= 	"    		</a>";
	tr  +=  "		</div>";
	tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#novaUnidade').on('click', function(evt){
    $('#formUnidadeInstituicao').form('clear');
    $("#instituicaoUnidadeId").val($("#instituicaoId").val());
    $('#iconeUnidadeInstituicao').removeClass('pencilEdicao');
    $('#iconeUnidadeInstituicao').addClass('pencilNovo');
    $("#tituloUnidadeInstituicao").text("Incluir nova Unidade");
	$("#modalUnidadeInstituicao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	$('#btnConfirmUnidadeInstituicao').off('click');
	$('#btnConfirmUnidadeInstituicao').click(function() {return submeterFormAjax('formUnidadeInstituicao', 'inclusao:ok')});
});

$('#novoInstituicao').on('click', function(evt){
	$("#bodyUnidades").html('<tbody id="bodyUnidades"><\tbody>');
    $('#formInstituicao').form('clear');
    $('#iconeInstituicao').removeClass('pencilEdicao');
    $('#iconeInstituicao').addClass('pencilNovo');
    $("#tituloInstituicao").text("Incluir nova Instituição");
	$("#modalInstituicao").modal('show');
	$('#btnConfirmInstituicao').off('click');
	$('#btnConfirmInstituicao').click(function() {return submeterFormAjax('formInstituicao', 'inclusao:ok')});
	ativarDesativarCampos(true, false);
});

$("#modalInstituicao").modal('setting', 'closable', false);

function editarInstituicao(id){
	$("#bodyUnidades").html('<tbody id="bodyUnidades"><\tbody>');
    $('#formInstituicao').form('clear');
    $("#instituicaoId").val(id);
    $("#tituloInstituicao").text("Alterar Instituição");
	$('#btnConfirmInstituicao').off('click');
	$('#btnConfirmInstituicao').click(function() {return submeterFormAjax('formInstituicao', 'edicao:ok')});
	ativarDesativarCampos(true,true);
	submeterFormAjax('formInstituicao', 'busca:ok', "/sge/instituicao/buscar", "GET");
}

function ativarDesativarCampos(valor1, valor2) {
	$('#instituicaoNome').attr('disabled',!valor1);
	$('#instituicaoNomeCompleto').attr('disabled',!valor1);
	$('#instituicaoVendedor').attr('disabled',!valor1);
	$('#instituicaoCaptador').attr('disabled',!valor1);
	$('#instituicaoGerente').attr('disabled',!valor1);
	$('#botoesForm').css('display', valor1?'block':'none');
	$('#botaoFechar').css('display', valor1?'none':'block');
	$('#listaUnidades').css('display', valor2?'block':'none');
}

function visualizarInstituicao(id){
	$("#bodyUnidades").html('<tbody id="bodyUnidades"><\tbody>');
	$('#formInstituicao').form('clear');
    $("#instituicaoId").val(id);
    $("#tituloInstituicao").text("Visualizar Instituição");
	$('#btnConfirmInstituicao').off('click');
	$('#btnConfirmInstituicao').click($('#modalInstituicao').modal('close'));
	ativarDesativarCampos(false, true);
	submeterFormAjax('formInstituicao', 'busca:ok', "/sge/instituicao/buscar", "GET");
}

$("#formInstituicao").on('busca:ok', function(event, json) {
	var instituicao = json.retornoJson.obj;
	$('#instituicaoNome').val(instituicao.nome);
	$('#instituicaoNomeCompleto').val(instituicao.nomeCompleto);
	if (instituicao.educacaoInfantil)
		$('.ui.toggle.checkbox.instituicaoEI').checkbox('check');
	if (instituicao.ensinoMedio)
		$('.ui.toggle.checkbox.instituicaoEM').checkbox('check');
	if (instituicao.ensinoFundamental)
		$('.ui.toggle.checkbox.instituicaoEF').checkbox('check');
	if (instituicao.ensinoSuperior)
		$('.ui.toggle.checkbox.instituicaoES').checkbox('check');
	if (instituicao.cursosFormacao)
		$('.ui.toggle.checkbox.instituicaoCF').checkbox('check');
	instituicao.unidades.forEach(function(valor){
		$("#bodyUnidades").append(montarTRUnidadeInstituicao(valor))
	});
	$("#modalInstituicao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formInstituicao").on('inclusao:ok', function(event, json) {
	location.reload(true);
});

$("#formInstituicao").on('edicao:ok', function(event, json) {
	location.reload(true);
});

