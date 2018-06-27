$(function() {
	$('table').tablesort();
})
$('#novoCargo').on('click', function(evt){
    $('#formCargo').form('clear');
    $('#iconeCargo').removeClass('pencilEdicao');
    $('#iconeCargo').addClass('pencilNovo');
    $("#tituloCargo").text("Incluir novo Cargo");
	$("#modalCargo").modal('show');
	$('#btnConfirmCargo').off('click');
	$('#btnConfirmCargo').click(function() {return submeterFormAjax('formCargo', 'inclusao:ok')});
	ativarDesativarCampos(true);
});

$("#modalCargo").modal('setting', 'closable', false);

function editarCargo(id){
    $('#formCargo').form('clear');
    $("#cargoId").val(id);
    $("#tituloCargo").text("Alterar Cargo");
	$('#btnConfirmCargo').off('click');
	$('#btnConfirmCargo').click(function() {return submeterFormAjax('formCargo', 'edicao:ok')});
	ativarDesativarCampos(true);
	submeterFormAjax('formCargo', 'busca:ok', "/sge/cargo/buscar", "GET");
}

function ativarDesativarCampos(valor) {
	$('#cargoNome').attr('disabled',!valor);
	$('#cargoVendedor').attr('disabled',!valor);
	$('#cargoCaptador').attr('disabled',!valor);
	$('#cargoGerente').attr('disabled',!valor);
	$('#botoesForm').css('display', valor?'block':'none');
	$('#botaoFechar').css('display', valor?'none':'block');
}

function visualizarCargo(id){
    $('#formCargo').form('clear');
    $("#cargoId").val(id);
    $("#tituloCargo").text("Visualizar Cargo");
	$('#btnConfirmCargo').off('click');
	$('#btnConfirmCargo').click($('#modalCargo').modal('close'));
	ativarDesativarCampos(false);
	submeterFormAjax('formCargo', 'busca:ok', "/sge/cargo/buscar", "GET");
}

$("#formCargo").on('busca:ok', function(event, json) {
	var cargo = json.retornoJson.obj;
	$('#cargoNome').val(cargo.nome);
	if (cargo.vendedor)
		$('.ui.toggle.checkbox.vendedor').checkbox('check');
	if (cargo.captador)
		$('.ui.toggle.checkbox.captador').checkbox('check');
	if (cargo.gerente)
		$('.ui.toggle.checkbox.gerente').checkbox('check');
	$("#modalCargo").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formCargo").on('inclusao:ok', function(event, json) {
	location.reload(true);
});

$("#formCargo").on('edicao:ok', function(event, json) {
	location.reload(true);
});
