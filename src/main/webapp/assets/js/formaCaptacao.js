$('#novoFormaCaptacao').on('click', function(evt){
    $('#formFormaCaptacao').form('clear');
    $('#iconeFormaCaptacao').removeClass('pencilEdicao');
    $('#iconeFormaCaptacao').addClass('pencilNovo');
    $("#tituloFormaCaptacao").text("Incluir nova Forma de Captação");
	$("#modalFormaCaptacao").modal('show');
	$('#btnConfirmFormaCaptacao').off('click');
	$('#btnConfirmFormaCaptacao').click(function() {return submeterFormAjax('formFormaCaptacao', 'inclusao:ok')});
	ativarDesativarCampos(true);
});

$("#modalFormaCaptacao").modal('setting', 'closable', false);

function editarFormaCaptacao(id){
    $('#formFormaCaptacao').form('clear');
    $("#formaCaptacaoId").val(id);
    $("#tituloFormaCaptacao").text("Alterar Forma de Captação");
	$('#btnConfirmFormaCaptacao').off('click');
	$('#btnConfirmFormaCaptacao').click(function() {return submeterFormAjax('formFormaCaptacao', 'edicao:ok')});
	ativarDesativarCampos(true);
	submeterFormAjax('formFormaCaptacao', 'busca:ok', "/sge/formaCaptacao/buscar", "GET");
}

function ativarDesativarCampos(valor) {
	$('#formaCaptacaoNome').attr('disabled',!valor);
	$('#botoesForm').css('display', valor?'block':'none');
	$('#botaoFechar').css('display', valor?'none':'block');
}

function visualizarFormaCaptacao(id){
    $('#formFormaCaptacao').form('clear');
    $("#formaCaptacaoId").val(id);
    $("#tituloFormaCaptacao").text("Visualizar Forma de Captação");
	$('#btnConfirmFormaCaptacao').off('click');
	$('#btnConfirmFormaCaptacao').click($('#modalFormaCaptacao').modal('close'));
	ativarDesativarCampos(false);
	submeterFormAjax('formFormaCaptacao', 'busca:ok', "/sge/formaCaptacao/buscar", "GET");
}

$("#formFormaCaptacao").on('busca:ok', function(event, json) {
	var formaCaptacao = json.retornoJson.obj;
	$('#formaCaptacaoNome').val(formaCaptacao.nome);
	$("#modalFormaCaptacao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formFormaCaptacao").on('inclusao:ok', function(event, json) {
	location.reload(true);
});

$("#formFormaCaptacao").on('edicao:ok', function(event, json) {
	location.reload(true);
});
