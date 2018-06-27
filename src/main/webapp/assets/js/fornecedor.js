$("#formPF").on('inclusaoPF:ok', function(event, json) {
	var tela = $("#modalFornecedor");
	tela.modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var nome = json.retornoJson.obj.nome;
	tela.find(".pfId").val(id);
	tela.find(".pfNome").val(nome);
	msgNotify('success', 'Pessoa associada com sucesso');
	resetFormPF();
});

$("#formPJ").on('inclusaoPJ:ok', function(event, json) {
	var tela = $("#modalFornecedor");
	tela.modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var nome = json.retornoJson.obj.nome;
	tela.find(".pjId").val(id);
	tela.find(".pjNome").val(nome);
	msgNotify('success', 'Pessoa associada com sucesso');
	resetFormPJ();
});

$("#formPF").on('alteracaoPF:ok', function(event, json) {
	var tela = $("#modalFornecedor");
	tela.modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var nome = json.retornoJson.obj.nome;
	tela.find(".pfId").val(id);
	tela.find(".pfNome").val(nome);
	msgNotify('success', 'Pessoa alterada com sucesso');
	resetFormPF();
});

$("#formPJ").on('alteracaoPJ:ok', function(event, json) {
	var tela = $("#modalFornecedor");
	tela.modal('show');
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	var nome = json.retornoJson.obj.nome;
	tela.find(".pjId").val(id);
	tela.find(".pjNome").val(nome);
	msgNotify('success', 'Pessoa alterada com sucesso');
	resetFormPJ();
});

$("#formFornecedor").on('inclusao:ok', function(event, json) {
	var tela = $("#modalFornecedor");
	tela.modal('hide');
});

$('#novoFornecedor').on('click', function(evt){
    $('#formFornecedor').form('clear');
    $('#iconeFornecedor').removeClass('pencilEdicao');
    $('#iconeFornecedor').addClass('pencilNovo');
    $("#tituloFornecedor").text("Incluir novo Fornecedor");
	$("#modalFornecedor").modal('show');
	$('#btnConfirmFornecedor').off('click');
	$('#btnConfirmFornecedor').click(function() {return submeterFormAjax('formFornecedor', 'inclusao:ok')});
});

$("#modalFornecedor").modal('setting', 'closable', false);
$("#modalPF").modal('setting', 'closable', false);
$("#modalPJ").modal('setting', 'closable', false);

function inserirEditarPFFornecedor() {
	var id = $('#pfId').val();
	if (!(id)) {
		inserirPFFornecedor();
	} else {
		editarPFFornecedor(id)
	}
}

function inserirEditarPJFornecedor() {
	var id = $('#pjId').val();
	if (!(id)) {
		inserirPJFornecedor();
	} else {
		editarPJFornecedor(id)
	}
}

function inserirPFFornecedor() {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'inclusaoPF:ok')});
	$('#btnPFCancel').off('click');
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$('#modalFornecedor').modal('show');
	});
	$('#modalPF').modal('show');
}

function inserirPJFornecedor() {
	$('#btnPJConf').off('click');
	$('#btnPJConf').click(function() {return submeterFormAjax('formPJ', 'inclusaoPJ:ok')});
	$('#btnPJCancel').off('click');
	$('#btnPJCancel').on('click', function(){
		resetFormPJ();
		$('#modalFornecedor').modal('show');
	});
	$('#modalPJ').modal('show');
}

function editarPFFornecedor(id) {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'alteracaoPF:ok')});
	$('#btnPFCancel').off('click');
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$('#modalFornecedor').modal('show');
	});
	$('#modalPF').modal('show');
	buscarPFPorId(id);
}

function editarPJFornecedor(id) {
	$('#btnPJConf').off('click');
	$('#btnPJConf').click(function() {return submeterFormAjax('formPJ', 'alteracaoPJ:ok')});
	$('#btnPJCancel').off('click');
	$('#btnPJCancel').on('click', function(){
		resetFormPJ();
		$('#modalFornecedor').modal('show');
	});
	$('#modalPJ').modal('show');
	buscarPJPorId(id);
}

function editarFornecedor(id){
    $('#formFornecedor').form('clear');
    $("#fornecedorId").val(id);
    $('#iconeFornecedor').removeClass('pencilNovo');
    $('#iconeFornecedor').addClass('pencilEdicao');
    $("#tituloFornecedor").text("Alterar Fornecedor");
	$('#btnConfirmFornecedor').off('click');
	$('#btnConfirmFornecedor').click(function() {return submeterFormAjax('formFornecedor', 'edicao:ok')});
	submeterFormAjax('formFornecedor', 'busca:ok', "/sge/fornecedor/editar", "GET");
}

$("#formFornecedor").on('busca:ok', function(event, json) {
	var fornecedor = json.retornoJson.obj;
	$('.pfId').val(fornecedor.pessoa.id);
	$('.pfNome').val(fornecedor.pessoa.nome);
	if (fornecedor.cargo && fornecedor.cargo.id) {
		$('#cargo').val(fornecedor.cargo.id);
		$('.dropdown.cargo').dropdown('set selected', fornecedor.cargo.id);
	}
	if (fornecedor.setor && fornecedor.setor.id) {
		$('#setor').val(fornecedor.setor.id);
		$('.dropdown.setor').dropdown('set selected', fornecedor.setor.id);
	}
	$('#matricula').val(fornecedor.matricula);
	$('#ctps').val(fornecedor.ctps);
	$('#serieCtps').val(fornecedor.serieCtps);
	$("#modalFornecedor").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});
