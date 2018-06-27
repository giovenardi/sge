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
	$('.field.cpf').api('set loading');
	var formURL = baseUrl + "captadorExterno/buscarPorCPF/" + cpf;
	document.location.href=formURL;
}