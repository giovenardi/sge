function buscarUnidadesInstituicao() {
	$('.ui.dropdown.unidadeInstituicao').api('set loading');
	var formURL = baseUrl + "unidadeInstituicao/buscarPorInstituicao";
	var idInstituicao = $('#instituicaoTurma').val();
	var instituicao = {
		"instituicao.id" : idInstituicao
	};
	clearSemanticDropDown("unidadeInstituicao", 'Selecione');
	if (idInstituicao != "") {
		$.ajax({
			url : formURL,
			type : "POST",
			data : instituicao,
			success : function(json) {
				if (typeof json.list != 'undefined') {
					adicionarUnidades(json.list);
				}
				$('.ui.dropdown.unidadeInstituicao').api('remove loading');

			}
		});
	} else {
		$('.ui.dropdown.unidadeInstituicao').api('remove loading');
	}
}

function buscarNiveis() {
	$('.ui.dropdown.nivel').api('set loading');
	var formURL = baseUrl + "instituicao/buscarNiveis";
	var idInstituicao = $('#instituicaoTurma').val();
	var dados = {
		"instituicao.id" : idInstituicao,
		"tipo" : $('#projetoTurmaTipo').val()
	};
	clearSemanticDropDown("nivel", 'Selecione');
	if (idInstituicao != "") {
		$.ajax({
			url : formURL,
			type : "POST",
			data : dados,
			success : function(json) {
				if (typeof json.list != 'undefined') {
					adicionarNiveis(json.list);
				}
				$('.ui.dropdown.nivel').api('remove loading');

			}
		});
	} else {
		$('.ui.dropdown.nivel').api('remove loading');
	}
}

function removerTurma() {
	if (idRemove != "") {
		var turma = {
			"turma.id" : idRemove
		};
		$.ajax({
			url : $("#urlContext"+idRemove).val(),
			type : "POST",
			data : turma,
			success : function(json) {
				if (json.retornoJson.obj){
					$("#nomeProjeto").val(json.retornoJson.obj.projeto.nome);
				}
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#turma" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

function adicionarUnidades(lista) {
	$.each(lista, function(chave, valor) {
		$(".ui.dropdown.unidadeInstituicao .menu").append(
				"<div class='item' data-value='" + valor.id + "'>" + valor.nome	+ "</div>");
	})
}

function adicionarNiveis(lista) {
	$.each(lista, function(chave, nivel) {
		$(".ui.dropdown.nivel .menu").append(
				"<div class='item' data-value='" + nivel.valor + "'>" + nivel.descricao	+ "</div>");
	})
}

$(".ui.dropdown.instituicaoTurma").on('change', function() {
	buscarUnidadesInstituicao();
	buscarNiveis();
});

$("#formTurma").on('inclusao:ok', function(event, json) {
	$("#modalTurma").modal('hide');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRTurma(obj);
	$("#nomeProjeto").val(obj.projeto.nome)
	var trEx = $("#turma" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyTurmas").append(tr);
	}
});

function montarTRTurma(obj) {
	var tr = "<tr id='turma" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
    tr 	+= 	"		<input id=\"urlContext"+obj.id+"\" value=\"/sge/turma/excluir\" hidden=\"true\">";
    tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerTurma)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
    tr 	+= 	"			<i class=\"erase alternate red icon\"></i>";
    tr 	+= 	"		</a>";
    tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#novaTurma').on("click", function(evt){
	var projetoTurmaId = $("#projetoTurmaId").val();
	var projetoTurmaTipo = $("#projetoTurmaTipo").val();
    $("#formTurma").form('clear');
    $("#projetoTurmaId").val(projetoTurmaId);
    $("#projetoTurmaTipo").val(projetoTurmaTipo);
    $(".pencilEdicao, .pencilNovo").remove();
	$("#tituloTurma").remove();
	$("<i class='glyphicon glyphicon-education pencilNovo'></i><span id='tituloTurma'></span>")
        .appendTo("#contatoModalTitle");
    $("#tituloTurma").text("Incluir nova Turma");
	$("#btnSalvarTurma").text("Adicionar Turma");
	$("#turma_id").val('');
	$("#modalTurma").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	$('#btnConfirmTurma').off('click');
	$('#btnConfirmTurma').click(function() {return submeterFormAjax('formTurma', 'inclusao:ok')});
	$('.FORMATURA_SUPERIOR').hide();
	$('.FORMATURA_FUNDAMENTAL_MEDIO').hide();
	$('.'+projetoTurmaTipo).show();

});