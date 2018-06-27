var aba = 1;
$(document).ready(function() {
	criarHandler();
	mudarAba();
	$('#btnPFPrev').on('click', function(){
		if (validarForm('formPF')) {
			--aba;
			mudarAba();
		}
	});
	$('#btnPFNext').on('click', function(){
		if (validarForm('formPF')) {
			++aba;
			mudarAba();
		}
	});
	$('#btnPFCancel').on('click', function(){
		resetFormPF();
		$('#modalFormando').modal('show');
	});
	$('#btnPFConf').on('click', function(){
		salvarPessoa();
	});
});

function mudarAba() {
	$('.step').removeClass('active');
	$('#btnPFPrev').prop("disabled", aba == 1);
	if (aba == 3) {
		$('#btnPFNext').hide();
		$('#btnPFConf').show();
	} else {
		$('#btnPFNext').show();
		$('#btnPFConf').hide();
	}
	$('.abapessoa').hide();
	$('#pf'+aba).show();
	$('#selpf'+aba).addClass('active');
}

function resetFormPF() {
	$('#formPF').form('reset');
	$("#cpf").val('');
	$('#formularioPF').hide();
	$('#selecaoPF').show();
	aba = 1;
	mudarAba();
}

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
	var formURL = baseUrl + "pessoaFisica/buscarPorCPF/" + cpf;
	$.ajax({
		url : formURL,
		type : "GET",
		success : function(json) {
			montarFormPF(json.retornoJson.obj);
			$('#selecaoPF').hide();
			$('#formularioPF').show();
		}
	});
}

function montarFormPF(pessoa) {
	$('#pessoa_id').val(pessoa.id);
	$('#pessoa_cpf').val(pessoa.cpf);
	$('#pessoa_nome').val(pessoa.nome);
	setValueSemanticDropDown($('#pessoa_sexo'), pessoa.sexo);
	$('#pessoa_dataNascimento').val(pessoa.dataNascimento);
	setValueSemanticDropDown($('#pessoa_estadoCivil'), pessoa.estadoCivil);
	$('#pessoa_rg').val(pessoa.rg);
	$('#pessoa_orgaoExpedidorRG').val(pessoa.orgaoExpedidorRG);
	$('#pessoa_nomePai').val(pessoa.nomePai);
	$('#pessoa_nomeMae').val(pessoa.nomeMae);
	$('#pessoa_emailPrincipal').val(pessoa.emailPrincipal);
	$('#pessoa_emailSecundario').val(pessoa.emailSecundario);
	if (pessoa.endereco) {
		$('#endereco_cep').val(pessoa.endereco.cep);
		$('#endereco_logradouro').val(pessoa.endereco.logradouro);
		$('#endereco_numero').val(pessoa.endereco.numero);
		$('#endereco_complemento').val(pessoa.endereco.complemento);
		$('#endereco_bairro').val(pessoa.endereco.bairro);
		$('#endereco_cidade').val(pessoa.endereco.cidade);
		if (pessoa.endereco.uf) {
			setValueSemanticDropDown($('#endereco_uf_id'), pessoa.endereco.uf.id);
		}
	}
}