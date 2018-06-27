	$(".ui.dropdown.tipoProjeto").on('change', function() {
		montarDadosComplementares($('#tipoProjeto').val());
	});

	$(".ui.dropdown.tipoIndicacao").on('change', function() {
		montarDadosIndicacao($('#tipoIndicacao').val());
	});

	$(".ui.dropdown.instituicao").on('change', function() {
		setTimeout(montarNomeProjeto, 500);
	});

	$(".ui.dropdown.curso").on('change', function() {
		setTimeout(montarNomeProjeto, 500);
	});

	$(".ui.dropdown.semestre").on('change', function() {
		setTimeout(montarNomeProjeto, 500);
	});

	$("#ano").on('change', function() {
		setTimeout(montarNomeProjeto, 500);
	});

	$("#indicacao").click(function() {
		$('.indicacao').hide();
		$('.indicacao input').val("");
		$('.indicacao .text').html("");
		$('.indicacao .item').removeClass("active");
		$('.indicacao .item').removeClass("selected");
		if ($("#indicacao input:checkbox").prop('checked')) {
			$('#divindicacao').show();
		} else {
			$('#divindicacao').hide();
			$('#divindicacao input').val("");
			$('#divindicacao .text').addClass("default");
			$('#divindicacao .text').html("Selecione");
			$('#divindicacao .item').removeClass("active");
			$('#divindicacao .item').removeClass("selected");
		}
	});

	function montarDadosComplementares(tipoProjeto) {
		$('.complementar').hide();
		$('.complementar input').val("");
		$('.complementar .text').addClass("default");
		$('.complementar .text').html("Selecione");
		$('.complementar .item').removeClass("active");
		$('.complementar .item').removeClass("selected");
		$('#'+tipoProjeto).show();
	}

	function montarDadosIndicacao(tipoIndicacao) {
		$('.indicacao').hide();
		$('.indicacao input').val("");
		$('.indicacao .text').addClass("default");
		$('.indicacao .text').html("Selecione");
		$('.indicacao .item').removeClass("active");
		$('.indicacao .item').removeClass("selected");
		$('#'+tipoIndicacao).show();
	}

	function montarNomeProjeto() {
		if ($('#tipoProjeto')) {
			var instituicao = $('.instituicao').dropdown('get text');
			var curso = $('.curso').dropdown('get text');
			var semestre = $('.semestre').dropdown('get text');
			var semestreStr = '';
			if (!!semestre && semestre != 'Anual' && semestre != 'Selecione') {
				semestreStr = semestre.substring(0,1) + '/';
			}
			var ano = $('#ano').val();
			var nomeProjeto = '';
			if (!!instituicao && !!curso && !!ano) {
				nomeProjeto = curso + " " + instituicao + " " + semestreStr + ano;
				$('#nomeProjeto').val(nomeProjeto);
			}
		}
	}
