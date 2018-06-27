$("#formCerimonial").on('alteracao:ok', function(event, json) {
	var id = json.retornoJson.obj.id;
	$("#cerimonialId").val(id);
	$("#cerimonialFormaPagamentoId").val(id);
	$("#planoFormaPagamentoId").val(id);
});

$("#formFormaPagamentoCerimonial").on('inclusao:ok', function(event, json) {
	var obj = json.retornoJson.obj;
	var id = json.retornoJson.obj.id;
	$("#formaPagamentoCerimonialId").val(id);
});

$('#btnFormaPagamentoCerimonial').on("click", function(evt){
    $("#modalFormaPagamentoCerimonial").modal('show');
});

$('#btnConfirmFormaPagamentoCerimonial').on('click', function() {
	return submeterFormAjax('formFormaPagamentoCerimonial', 'inclusao:ok')
});

$("#modalFormaPagamentoCerimonial").modal('setting', 'closable', false);

$('#maskedCerimonialValor').on('change', function() {
	$('#cerimonialValor').val(($('#maskedCerimonialValor').maskMoney('unmasked')[0]+"").replace('.', ','));
})

$('#maskedCerimonialValorConvidadoExtra').on('change', function() {
	$('#cerimonialValorConvidadoExtra').val(($('#maskedCerimonialValorConvidadoExtra').maskMoney('unmasked')[0]+"").replace('.', ','));
})
