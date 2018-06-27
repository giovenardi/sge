$('#novoCurso').on('click', function(evt){
    $('#formCurso').form('clear');
    $('#iconeCurso').removeClass('pencilEdicao');
    $('#iconeCurso').addClass('pencilNovo');
    $("#tituloCurso").text("Incluir novo Curso");
	$("#modalCurso").modal('show');
	$('#btnConfirmCurso').off('click');
	$('#btnConfirmCurso').click(function() {return submeterFormAjax('formCurso', 'inclusao:ok')});
	ativarDesativarCampos(true);
});

$("#modalCurso").modal('setting', 'closable', false);

function editarCurso(id){
    $('#formCurso').form('clear');
    $("#cursoId").val(id);
    $("#tituloCurso").text("Alterar Curso");
	$('#btnConfirmCurso').off('click');
	$('#btnConfirmCurso').click(function() {return submeterFormAjax('formCurso', 'edicao:ok')});
	ativarDesativarCampos(true);
	submeterFormAjax('formCurso', 'busca:ok', "/sge/curso/buscar", "GET");
}

function ativarDesativarCampos(valor) {
	$('#cursoNome').attr('disabled',!valor);
	$('#botoesForm').css('display', valor?'block':'none');
	$('#botaoFechar').css('display', valor?'none':'block');
}

function visualizarCurso(id){
    $('#formCurso').form('clear');
    $("#cursoId").val(id);
    $("#tituloCurso").text("Visualizar Curso");
	$('#btnConfirmCurso').off('click');
	$('#btnConfirmCurso').click($('#modalCurso').modal('close'));
	ativarDesativarCampos(false);
	submeterFormAjax('formCurso', 'busca:ok', "/sge/curso/buscar", "GET");
}

$("#formCurso").on('busca:ok', function(event, json) {
	var curso = json.retornoJson.obj;
	$('#cursoNome').val(curso.nome);
	$("#modalCurso").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
});

$("#formCurso").on('inclusao:ok', function(event, json) {
	location.reload(true);
});

$("#formCurso").on('edicao:ok', function(event, json) {
	location.reload(true);
});
