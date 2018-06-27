$('#novoEvento').on('click', function(evt){
    $('#formEvento').form('clear');
    $('#iconeEvento').removeClass('pencilEdicao');
    $('#iconeEvento').addClass('pencilNovo');
    $("#tituloEvento").text("Incluir novo Evento");
	$("#modalEvento").modal('show');
	$('#btnConfirmEvento').off('click');
	$('#btnConfirmEvento').click(function() {return submeterFormAjax('formEvento', 'inclusao:ok')});
	ativarDesativarCampos(true);
});

$("#modalEvento").modal('setting', 'closable', false);

function editarEvento(id){
    $('#formEvento').form('clear');
    $("#eventoId").val(id);
    $("#tituloEvento").text("Alterar Evento");
	$('#btnConfirmEvento').off('click');
	$('#btnConfirmEvento').click(function() {return submeterFormAjax('formEvento', 'edicao:ok')});
	ativarDesativarCampos(true);
	submeterFormAjax('formEvento', 'busca:ok', "/sge/evento/buscar", "GET");
}

function ativarDesativarCampos(valor) {
	$('#eventoNome').attr('disabled',!valor);
	$('#botoesForm').css('display', valor?'block':'none');
	$('#botaoFechar').css('display', valor?'none':'block');
}

function visualizarEvento(id){
    $('#formEvento').form('clear');
    $("#eventoId").val(id);
    $("#tituloEvento").text("Visualizar Evento");
	$('#btnConfirmEvento').off('click');
	$('#btnConfirmEvento').click($('#modalEvento').modal('close'));
	ativarDesativarCampos(false);
	submeterFormAjax('formEvento', 'busca:ok', "/sge/evento/buscar", "GET");
}

$("#formEvento").on('busca:ok', function(event, json) {
	var evento = json.retornoJson.obj;
	$('#eventoNome').val(evento.nome);
	$("#modalEvento").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formEvento").on('inclusao:ok', function(event, json) {
	location.reload(true);
});

$("#formEvento").on('edicao:ok', function(event, json) {
	location.reload(true);
});
