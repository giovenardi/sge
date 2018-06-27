function removerUnidade() {
	if (idRemove != "") {
		var unidade = {
			"unidade.id" : idRemove
		};
		$.ajax({
			url : $("#urlContext"+idRemove).val(),
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
    $("#instituicaoUnidadeId").val($("#instituicao_id").val());
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
	$("#modalUnidadeInstituicao").modal('hide');
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
	tr 	+= 	"			<a onclick=\"modalConfirmAjax("+obj.id+", removerUnidade))\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
	tr 	+= 	"		  		<i class=\"trash outline red icon\"></i>";
	tr 	+= 	"			</a>";
	tr 	+= 	"    		<a onclick=\"editarUnidade("+obj.id+")\" class=\"ui button icon\" data-content=\"Alterar\" data-position=\"top right\">";
	tr 	+= 	"    			<i class=\"pencil outline blue icon\"></i>";
	tr 	+= 	"    		</a>";
	tr  +=  "		</div>";
	tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#novaUnidade').on('click', function(evt){
    $('#formUnidadeInstituicao').form('clear');
    $("#instituicaoUnidadeId").val($("#instituicao_id").val());
    $('#iconeUnidadeInstituicao').removeClass('pencilEdicao');
    $('#iconeUnidadeInstituicao').addClass('pencilNovo');
    $("#tituloUnidadeInstituicao").text("Incluir nova Unidade");
	$("#modalUnidadeInstituicao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	$('#btnConfirmUnidadeInstituicao').off('click');
	$('#btnConfirmUnidadeInstituicao').click(function() {return submeterFormAjax('formUnidadeInstituicao', 'inclusao:ok')});
});

