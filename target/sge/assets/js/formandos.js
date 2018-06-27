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

function montarTRFormando(obj) {
	var tr = "<tr id='formando" + obj.id + "' class='cell-content-selectable'>";
	tr 	+= 	"	<td>";
	tr 	+= 			obj.pessoa.nome;
	tr 	+= 	"	</td>";
	tr 	+= 	"	<td>";
    tr 	+= 	"		<input id=\"urlContextFormando"+obj.id+"\" value=\"/sge/formando/excluir\" hidden=\"true\">";
    tr 	+= 	"		<a onclick=\"modalConfirmAjax("+obj.id+", removerFormando)\" class=\"ui button icon\" data-content=\"Excluir\" data-position=\"top right\">";
    tr 	+= 	"			<i class=\"erase outline red icon\"></i>";
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

$("#modalFormando").modal('setting', 'closable', false);
$("#modalPessoa").modal('setting', 'closable', false);