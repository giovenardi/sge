$('#taxaAdministrativa').val(($('#maskedTaxaAdministrativa').maskMoney('unmasked')[0]+"").replace('.', ','));
$('#maskedTaxaAdministrativa').on('change', function() {
	$('#taxaAdministrativa').val(($('#maskedTaxaAdministrativa').maskMoney('unmasked')[0]+"").replace('.', ','));
});

$('#valorIngressoExtra').val(($('#maskedValorIngressoExtra').maskMoney('unmasked')[0]+"").replace('.', ','));
$('#maskedValorIngressoExtra').on('change', function() {
	$('#valorIngressoExtra').val(($('#maskedValorIngressoExtra').maskMoney('unmasked')[0]+"").replace('.', ','));
});

function abrirJanela(formURL) {
	$.ajax({
		url : formURL,
		type : "GET",
		success : function(html) {
			$(html).modal('show');
		},
		error: function(jqXHR, status, error) {
			var mensagem = jqXHR.responseText.substring(jqXHR.responseText.indexOf("SgeException") + 14);
			mensagem = mensagem.substring(0, mensagem.indexOf("!") + 1);
			msgNotify('error', mensagem);
		}
	});
}