function removerProjetoEvento() {
	if (idRemove != "") {
		var projetoEvento = {
			"projetoEvento.id" : idRemove
		};
		$.ajax({
			url : $("#urlContext"+idRemove).val(),
			type : "POST",
			data : projetoEvento,
			success : function(json) {
				if (typeof json.retornoJson.success != 'undefined') {
					msgNotify('success', json.retornoJson.success);
					$("#projetoEvento" + idRemove).remove();
				} else {
					msgNotify('error', json.retornoJson.error);
				}
			}
		});
	}
}

$("#formProjetoEvento").on('inclusao:ok', function(event, json) {
	$("#modalProjetoEvento").modal('hide');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var tr = montarTRProjetoEvento(obj);
	var trEx = $("#projetoEvento" + id);
	if (trEx.length > 0) {
		trEx.replaceWith(tr);
	} else {
		$("#bodyProjetoEvento").append(tr);
	}
});

function montarTRProjetoEvento(obj) {
	var tr = "<tr id='projetoEvento" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.evento.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.inicio;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.fim;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
    tr 	+= 	"		<input id=\"urlContext"+obj.id+"\" value=\"/sge/projetoEvento/excluir\" hidden=\"true\">";
    tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerProjetoEvento)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
    tr 	+= 	"			<i class=\"trash alternate red icon\"></i>";
    tr 	+= 	"		</a>";
    tr 	+= 	"	</td>";
	tr 	+= 	" </tr>";
	return tr;
}

$('#novoProjetoEvento').on("click", function(evt){
    $("#formProjetoEvento").form('clear');
    $("#projetoProjetoEventoId").val($("#projeto_id").val());
    $(".pencilEdicao, .pencilNovo").remove();
	$("#tituloProjetoEvento").remove();
	$("<i class='glyphicon glyphicon-education pencilNovo'></i><span id='tituloProjetoEvento'></span>")
        .appendTo("#projetoEventoModalTitle");
    $("#tituloProjetoEvento").text("Incluir novo Evento");
	$("#btnSalvarProjetoEvento").text("Adicionar Evento");
	$("#projetoEvento_id").val('');
	$("#modalProjetoEvento").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	$('#btnConfirmProjetoEvento').off('click');
	$('#btnConfirmProjetoEvento').click(function() {return submeterFormAjax('formProjetoEvento', 'inclusao:ok')});
});