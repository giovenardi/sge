$("#formPF").on('inclusaoPFF:ok', function(event, json) {
	var tela = $("#modalFuncionario");
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

$("#formPF").on('alteracaoPFF:ok', function(event, json) {
	var tela = $("#modalFuncionario");
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

$("#formFuncionario").on('inclusao:ok', function(event, json) {
	location.reload(true);
//	var tela = $("#modalFuncionario");
//	tela.modal('hide');
});

$("#formFuncionario").on('edicao:ok', function(event, json) {
	location.reload(true);
//	var tela = $("#modalFuncionario");
//	tela.modal('hide');
});

$('#novoFuncionario').on('click', function(evt){
    $('#formFuncionario').form('clear');
    $('#iconeFuncionario').removeClass('pencilEdicao');
    $('#iconeFuncionario').addClass('pencilNovo');
    $("#tituloFuncionario").text("Incluir novo Funcionário");
	$("#modalFuncionario").modal('show');
	$('#btnConfirmFuncionario').off('click');
	$('#btnConfirmFuncionario').click(function() {return submeterFormAjax('formFuncionario', 'inclusao:ok')});
});

$("#modalFuncionario").modal('setting', 'closable', false);
$("#modalPF").modal('setting', 'closable', false);

function inserirEditarPessoaFuncionario() {
	var id = $('#pfId').val();
	if (!(id)) {
		inserirPessoaFuncionario();
	} else {
		editarPessoaFuncionario(id)
	}
}

function inserirPessoaFuncionario() {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'inclusaoPFF:ok')});
	$('#btnPFCancel').off('click');
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$('#modalFuncionario').modal('show');
	});
	$('#modalPF').modal('show');
}

function editarPessoaFuncionario(id) {
	$('#btnPFConf').off('click');
	$('#btnPFConf').click(function() {return submeterFormAjax('formPF', 'alteracaoPFF:ok')});
	$('#btnPFCancel').off('click');
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$('#modalFuncionario').modal('show');
	});
	$('#modalPF').modal('show');
	buscarPFPorId(id);
}

function editarFuncionario(id){
    $('#formFuncionario').form('clear');
    $("#funcionarioId").val(id);
    $('#iconeFuncionario').removeClass('pencilNovo');
    $('#iconeFuncionario').addClass('pencilEdicao');
    $("#tituloFuncionario").text("Alterar Funcionário");
	$('#btnConfirmFuncionario').off('click');
	$('#btnConfirmFuncionario').click(function() {return submeterFormAjax('formFuncionario', 'edicao:ok')});
	submeterFormAjax('formFuncionario', 'busca:ok', "/sge/funcionario/editar", "GET");
}

$("#formFuncionario").on('busca:ok', function(event, json) {
	var funcionario = json.retornoJson.obj;
	$('.pfId').val(funcionario.pessoa.id);
	$('.pfNome').val(funcionario.pessoa.nome);
	if (funcionario.cargo && funcionario.cargo.id) {
		$('#cargo').val(funcionario.cargo.id);
		$('.dropdown.cargo').dropdown('set selected', funcionario.cargo.id);
	}
	if (funcionario.setor && funcionario.setor.id) {
		$('#setor').val(funcionario.setor.id);
		$('.dropdown.setor').dropdown('set selected', funcionario.setor.id);
	}
	$('#matricula').val(funcionario.matricula);
	$('#ctps').val(funcionario.ctps);
	$('#serieCtps').val(funcionario.serieCtps);
	$("#modalFuncionario").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});
