criarHandler();

function criarHandler() {
	$("#cpf").on('change', function() {
		var cpf = $(this).val();
		if (cpf != '') {
			buscarPF(cpf);
		}

	});
}

function buscarPF(cpf) {
//	$('#cpf').api('set loading');
	var formURL = baseUrl + "funcionario/buscarPorCPF/" + cpf;
	document.location.href=formURL;
//	$.ajax({
//		url : formURL,
//		type : "GET",
//		success : function(html) {
//			$('#divfunci').html(html);
//			initComponents();
//			inicializar();
//			criarHandler();
//		},
//		error: function(jqXHR, status, error) {
//			var mensagem = jqXHR.responseText.substring(jqXHR.responseText.indexOf("SgeException") + 14);
//			mensagem = mensagem.substring(0, mensagem.indexOf("!") + 1);
//			msgNotify('error', mensagem);
//		}
//	});
}