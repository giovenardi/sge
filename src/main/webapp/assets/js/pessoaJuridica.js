var aba = 1;
$(document).ready(function() {
	criarHandlerPJ();
	mudarAbaPJ();
	$('#btnPJPrev').on('click', function(){
		if (validarForm('formPJ')) {
			--aba;
			mudarAbaPJ();
		}
	});
	$('#btnPJNext').on('click', function(){
		if (validarForm('formPJ')) {
			++aba;
			mudarAbaPJ();
		}
	});
	$('#btnPJCancel').on('click', function(){
		resetFormPJ();
	});
	$('#btnPJConf').on('click', function(){
		salvarPessoaJuridica();
	});
});

function limparPJ() {
	$('#pJId').val("");
	$('#pJNome').val("");
}

function mudarAbaPJ() {
	$('.step').removeClass('active');
	$('#btnPJPrev').prop("disabled", aba == 1);
	if (aba == 3) {
		$('#btnPJNext').hide();
		$('#btnPJConf').show();
	} else {
		$('#btnPJNext').show();
		$('#btnPJConf').hide();
	}
	$('.abapj').hide();
	$('#pj'+aba).show();
	$('#selpj'+aba).addClass('active');
}

function resetFormPJ() {
	$('#formPJ').form('reset');
	$("#cnpj").val('');
	$('#formularioPJ').hide();
	$('#selecaoPJ').show();
	aba = 1;
	mudarAbaPJ();
}

function criarHandlerPJ() {
	$("#cnpj").on('change', function() {
		var cnpj = $(this).val();
		var prefixo = $('#prefixoPes').val();
		if (cnpj != '') {
			buscarPJ(cnpj, prefixo);
		}
	});
}

function buscarPJ(cnpj, prefixo) {
	$('#cnpj').api('set loading');
	var formURL = baseUrl + "pessoaJuridica/buscarPorCNPJ/" + cnpj;
	$.ajax({
		url : formURL,
		type : "GET",
		success : function(json) {
			montarFormPJ(json.retornoJson.obj);
			$('#selecaoPJ').hide();
			$('#formularioPJ').show();
		}
	});
}

function buscarPJPorId(id) {
	$('#cnpj').api('set loading');
	var formURL = baseUrl + "pessoaJuridica/buscarPorId/" + id;
	$.ajax({
		url : formURL,
		type : "GET",
		success : function(json) {
			montarFormPJ(json.retornoJson.obj);
			$('#selecaoPJ').hide();
			$('#formularioPJ').show();
		}
	});
}

function montarFormPJ(pessoa) {
	$('#pj_id').val(pessoa.id);
	$('#pj_cnpj').val(pessoa.cnpj);
	$('#pj_nome').val(pessoa.nome);
	$('#pj_dataAbertura').val(pessoa.dataAbertura);
	$('#pj_inscricaoEstadual').val(pessoa.inscricaoEstadual);
	$('#pj_inscricaoMunicipal').val(pessoa.inscricaoMunicipal);
	$('#pj_nomeFantasia').val(pessoa.nomeFantasia);
	$('#pj_contato').val(pessoa.contato);
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