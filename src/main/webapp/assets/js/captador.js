$('#valor').val(($('#maskedValor').maskMoney('unmasked')[0]+"").replace('.', ','));
$('#maskedValor').on('change', function() {
	$('#valor').val(($('#maskedValor').maskMoney('unmasked')[0]+"").replace('.', ','));
})