$(document).ready(function() {
	$('#crc').change(validaDublicado);
});

function validaDublicado() {
	var fornecedor = {
		'fornecedor.crc' : $('#crc').val()	
	}
	
	$.ajax({
		url : baseUrl + "fornecedor/validaDublicado",
		type : "GET",
		data : fornecedor,
		dataType: "json",
		success : function(json) {
			if (typeof json.warning != 'undefined') {
				$('#crc').val("");
				msgNotify('error', json.warning);
			}
		}
	});
}

function montarForm() {
	var url = $('#formAdd').prop('action') + "/" + $("#tipo").val() + "?crc=" + $("#crc").val();
	document.location.href = url;
}

$('.ui.dropdown.tipoPessoa').on('change', function() {
	montarForm();
});

$('.ui.dropdown.tipo').on('change', function() {
	$('#cpfcnpj').val("");
	$('#campocpfcnpj').hide();
	if ($('#tipo').val() == 'J') {
		$('#cpfcnpj').mask("99.999.999/9999-99");
		$('#lbcpfcnpj').text('CNPJ');
		$('#campocpfcnpj').show();
	} else if ($('#tipo').val() == 'F') {
		$('#cpfcnpj').mask('999.999.999-99');
		$('#lbcpfcnpj').text('CPF');
		$('#campocpfcnpj').show();
	} else {
		
	}
});

