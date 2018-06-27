$(document).ready(function() {
	montarComboValor();
});

function imprimir(contextImpressao, contextBusca) {
	$('#filterForm').prop('action', contextImpressao);
	$('#filterForm').prop('target', "_blank");
	$('#filterForm').submit();
	$('#filterForm').prop('action', contextBusca);
	$('#filterForm').prop('target', "");
}

$('.ui.checkbox.tipo input').on('change', function() {
	buscarTaxas();
});

$('.radio.checkbox input').on('change', function() {
	$('#valorPeriodo input').val('');
	montarComboValor();
});

function montarComboValor() {
	$('#valorPeriodo').removeClass('required');
	$('#valorPeriodo').hide();
	$('#valorPeriodo div.text').text('Selecione');
	if ($('.radio.checkbox input:checked').val() == 0) {
		$('#valorPeriodo label').text('Mês');
		$('#valorPeriodo div.menu').html(
				'<div class="item" data-value="1">Janeiro</div>' +
				'<div class="item" data-value="2">Fevereiro</div>' +
				'<div class="item" data-value="3">Março</div>' +
				'<div class="item" data-value="4">Abril</div>' +
				'<div class="item" data-value="5">Maio</div>' +
				'<div class="item" data-value="6">Junho</div>' +
				'<div class="item" data-value="7">Julho</div>' +
				'<div class="item" data-value="8">Agosto</div>' +
				'<div class="item" data-value="9">Setembro</div>' +
				'<div class="item" data-value="10">Outubro</div>' +
				'<div class="item" data-value="11">Novembro</div>' +
				'<div class="item" data-value="12">Dezembro</div>');
		$('#valorPeriodo').addClass('required');
		$('#valorPeriodo').show();
	} else if ($('.radio.checkbox input:checked').val() == 1) {
		$('#valorPeriodo label').text('Trimestre');
		$('#valorPeriodo div.menu').html(
					'<div class="item" data-value="1">1° Trimestre</div>' +
					'<div class="item" data-value="2">2° Trimestre</div>' +
					'<div class="item" data-value="3">3° Trimestre</div>' +
					'<div class="item" data-value="4">4° Trimestre</div>');
		$('#valorPeriodo').addClass('required');
		$('#valorPeriodo').show();
	} else if ($('.radio.checkbox input:checked').val() == 2) {
		$('#valorPeriodo label').text('Semestre');
		$('#valorPeriodo div.menu').html(
					'<div class="item" data-value="1">1° Semestre</div>' +
					'<div class="item" data-value="2">2° Semestre</div>');
		$('#valorPeriodo').addClass('required');
		$('#valorPeriodo').show();
	}
	$('.ui.dropdown').dropdown();
}

function buscarTaxas() {
	if ($('.ui.checkbox.tipo :checked').length == 1) {
		var formURL = baseUrl + 'comparativoTaxas' + "/taxas/";
		var idTipoTaxa = $('.ui.checkbox.tipo :checked').val();
		formURL = formURL + idTipoTaxa;
		if (idTipoTaxa) {
			$.ajax({
				url : formURL,
				type : "GET",
				success : function(html) {
					if (html != undefined) {
						$("#taxa").html(html);
						$(".dropdown.taxa").dropdown();
					} else {
						$("#taxa").html("");
					}
				}
			});
		}
	} else {
		$("#taxa").html("");
	}
}
