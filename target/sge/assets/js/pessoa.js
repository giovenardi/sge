criarHandler();

function criarHandler() {
	$("#cpf").on('change', function() {
		var cpf = $(this).val();
		var prefixo = $('#prefixoPes').val();
		if (cpf != '') {
			buscarPF(cpf, prefixo);
		}

	});
}

function buscarPF(cpf, prefixo) {
	$('#cpf').api('set loading');
	var formURL = baseUrl + "pessoaFisica/buscarPorCPF/" + cpf + "/" + prefixo;
	$.ajax({
		url : formURL,
		type : "GET",
		success : function(html) {
			$('#divpessoa').html(html);
			initComponents();
			inicializar();
			criarHandler();
		}
	});
}