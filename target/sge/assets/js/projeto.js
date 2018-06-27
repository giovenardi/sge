function submeterFormAjax(formId, evento, urlform, tipo) {
	var formURL = '';
	if (validarForm(formId)) {
		$.ajax({
			url : !urlform ? $("#"+formId).prop('action') : urlform,
			type : !tipo ? "POST" : tipo,
			data : $("#"+formId).serializeArray(),
			success : function(json) {
				if (json.retornoJson.warning) {
					msgNotify('warning', json.retornoJson.warning);
				} else if (json.retornoJson.error) {
					msgNotify('error', json.retornoJson.error);
				} else {
					$("#"+formId).trigger(evento, [json]);
					msgNotify('success', json.retornoJson.success);
				}
			},
			error: function(jqXHR, status, error) {
				msgNotify('error', "Problemas ao submeter o formulário");
			}

		});
	}
	return false;
}

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