	$(".ui.dropdown.tipoProjeto").on('change', function() {
		montarDadosComplementares($('#tipoProjeto').val());
	});

	$(".ui.dropdown.tipoIndicacao").on('change', function() {
		montarDadosIndicacao($('#tipoIndicacao').val());
	});

	$(".ui.dropdown.instituicaoTurma").on('change', function() {
		setTimeout(montarNomeProjeto, 500);
	});

	$(".ui.dropdown.unidadeInstituicao").on('change', function() {
		setTimeout(montarNomeProjeto, 500);
	});

	$(".ui.dropdown.turno").on('change', function() {
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

	$("#numero").on('change', function() {
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
		$('.FORMATURA_SUPERIOR').hide();
		$('.FORMATURA_FUNDAMENTAL_MEDIO').hide();
		$('.complementar').hide();
		$('.complementar input').val("");
		$('.complementar .text').addClass("default");
		$('.complementar .text').html("Selecione");
		$('.complementar .item').removeClass("active");
		$('.complementar .item').removeClass("selected");
		$('.'+tipoProjeto).show();
		if (tipoProjeto.indexOf('FORMATURA') > -1) {
			$('.complementar').show();
		}
		buscarInstituicoes();
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
			var instituicao = $('.instituicaoTurma').dropdown('get text');
			var unidadeInstituicao = $('.unidadeInstituicao').dropdown('get text');
			var turno = $('.turno').dropdown('get text');
			var curso = $('.curso').dropdown('get text');
			var nivel = $('.nivel').dropdown('get text');
			var semestre = $('.semestre').dropdown('get text');
			var semestreStr = '';
			var numero = $('#numero').val();
			if (numero != '') {
				numero = " " + numero;
			}
			if (!!semestre && semestre != 'Anual' && semestre != 'Selecione') {
				semestreStr = semestre.substring(0,1) + '/';
			}
			var ano = $('#ano').val();
			var nomeProjeto = '';
			if (unidadeInstituicao != 'Selecione' && instituicao != 'Selecione' && (curso != 'Selecione' || nivel != 'Selecione') && !!ano && turno != 'Selecione') {
				nomeProjeto = ((curso != 'Selecione')?curso + " ":"") + ((nivel != 'Selecione')?nivel + " ":"") + instituicao + " " + unidadeInstituicao + " " + semestreStr + ano + " " + turno + numero;
				$('#nomeProjeto').val(nomeProjeto);
			}
		}
	}

	function solicitarAprovacao(id){
	    $('#formSolicitarAprovacao').form('clear');
	    $("#contatoEventoId").val(id);
		$('#btnConfirmSolicitarAprovacao').off('click');
		$('#btnConfirmSolicitarAprovacao').click(function() {return submeterFormAjax('formSolicitarAprovacao', 'solicitacao:ok')});
		submeterFormAjax('formSolicitarAprovacao', 'busca:ok', "/sge/contatoEvento/buscar", "GET");
	}

	$("#formSolicitarAprovacao").on('busca:ok', function(event, json) {
		var contatoEvento = json.retornoJson.obj;
		$('#contatoEventoId').val(contatoEvento.id);
		$('#contatoEventoNome').val(contatoEvento.nome);
		$('#tipoProjeto').val(contatoEvento.tipoProjeto);
		$('.dropdown.tipoProjeto').dropdown('set selected', contatoEvento.tipoProjeto);
		$('#nomeProjeto').val(contatoEvento.nomeProjeto);
		$("#modalSolicitarAprovacao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	});
	
	$("#formSolicitarAprovacao").on('solicitacao:ok', function(event, json) {
		location.reload(true);
	});

	function solicitarAtivacao(id){
	    $('#formSolicitarAtivacao').form('clear');
	    $("#contatoEventoId").val(id);
		$('#btnConfirmSolicitarAtivacao').off('click');
		$('#btnConfirmSolicitarAtivacao').click(function() {return submeterFormAjax('formSolicitarAtivacao', 'solicitacao:ok')});
		submeterFormAjax('formSolicitarAtivacao', 'busca:ok', "/sge/contatoEvento/buscar", "GET");
	}

	$("#formSolicitarAtivacao").on('busca:ok', function(event, json) {
		var contatoEvento = json.retornoJson.obj;
		$('#contatoEventoId').val(contatoEvento.id);
		$('#contatoEventoNome').val(contatoEvento.nome);
		$('#tipoProjeto').val(contatoEvento.tipoProjeto);
		$('.dropdown.tipoProjeto').dropdown('set selected', contatoEvento.tipoProjeto);
		$('#vendedor').val(contatoEvento.vendedor.id);
		$('.dropdown.vendedor').dropdown('set selected', contatoEvento.vendedor.id);
		$('#nomeProjeto').val(contatoEvento.nomeProjeto);
		$("#modalSolicitarAtivacao").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	});
	
	$("#formSolicitarAtivacao").on('solicitacao:ok', function(event, json) {
		location.reload(true);
	});

	function aprovar(id){
	    $('#formAprovar').form('clear');
	    $("#contatoEventoId").val(id);
		$('#btnConfirmAprovar').off('click');
		$('#btnConfirmAprovar').click(function() {return submeterFormAjax('formAprovar', 'aprovacao:ok')});
		submeterFormAjax('formAprovar', 'busca:ok', "/sge/contatoEvento/buscar", "GET");
	}

	$("#formAprovar").on('busca:ok', function(event, json) {
		var contatoEvento = json.retornoJson.obj;
		$('#contatoEventoId').val(contatoEvento.id);
		$('#contatoEventoNome').val(contatoEvento.nome);
		$('#tipoProjeto').val(contatoEvento.tipoProjeto);
		$('.dropdown.tipoProjeto').dropdown('set selected', contatoEvento.tipoProjeto);
		$('#nomeProjeto').val(contatoEvento.nomeProjeto);
		$("#modalAprovar").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	});

	$("#formAprovar").on('aprovacao:ok', function(event, json) {
		location.reload(true);
	});

	function ativar(id){
	    $('#formAtivar').form('clear');
	    $("#contatoEventoId").val(id);
		$('#btnConfirmAtivar').off('click');
		$('#btnConfirmAtivar').click(function() {return submeterFormAjax('formAtivar', 'aprovacao:ok')});
		submeterFormAjax('formAtivar', 'busca:ok', "/sge/contatoEvento/buscar", "GET");
	}

	$("#formAtivar").on('busca:ok', function(event, json) {
		var contatoEvento = json.retornoJson.obj;
		$('#contatoEventoId').val(contatoEvento.id);
		$('#contatoEventoNome').val(contatoEvento.nome);
		$('#tipoProjeto').val(contatoEvento.tipoProjeto);
		$('.dropdown.tipoProjeto').dropdown('set selected', contatoEvento.tipoProjeto);
		$('#vendedor').val(contatoEvento.vendedor.id);
		$('.dropdown.vendedor').dropdown('set selected', contatoEvento.vendedor.id);
		$('#nomeProjeto').val(contatoEvento.nomeProjeto);
		$("#modalAtivar").modal("setting", "closable", false).modal("setting", "transition", 'vertical flip').modal('show');
	});

	$("#formAtivar").on('aprovacao:ok', function(event, json) {
		location.reload(true);
	});
	
	$(".ui.dropdown.instituicaoTurma").on('change', function() {
		buscarUnidadesInstituicao();
		if ($('#tipoProjeto').val().indexOf('FORMATURA') > -1 && $('#tipoProjeto').val().indexOf('SUPERIOR') < 0) {
			buscarNiveis();
		}

	});

	function buscarUnidadesInstituicao() {
		$('.ui.dropdown.unidadeInstituicao').api('set loading');
		var formURL = baseUrl + "unidadeInstituicao/buscarPorInstituicao";
		var idInstituicao = $('#instituicaoTurma').val();
		var instituicao = {
			"instituicao.id" : idInstituicao
		};
		clearSemanticDropDown("unidadeInstituicao", 'Selecione');
		if (idInstituicao != "") {
			$.ajax({
				url : formURL,
				type : "POST",
				data : instituicao,
				success : function(json) {
					if (typeof json.list != 'undefined') {
						adicionarUnidades(json.list);
					}
					$('.ui.dropdown.unidadeInstituicao').api('remove loading');

				}
			});
		} else {
			$('.ui.dropdown.unidadeInstituicao').api('remove loading');
		}
	}

	function buscarNiveis() {
		$('.ui.dropdown.nivel').api('set loading');
		var formURL = baseUrl + "instituicao/buscarNiveis";
		var idInstituicao = $('#instituicaoTurma').val();
		var dados = {
			"instituicao.id" : idInstituicao,
			"tipo" : $('#tipoProjeto').val()
		};
		clearSemanticDropDown("nivel", 'Selecione');
		if (idInstituicao != "") {
			$.ajax({
				url : formURL,
				type : "POST",
				data : dados,
				success : function(json) {
					if (typeof json.list != 'undefined') {
						adicionarNiveis(json.list);
					}
					$('.ui.dropdown.nivel').api('remove loading');

				}
			});
		} else {
			$('.ui.dropdown.nivel').api('remove loading');
		}
	}

	function buscarInstituicoes() {
		$('.ui.dropdown.instituicaoTurma').api('set loading');
		var formURL = baseUrl + "instituicao/buscarPorTipoProjeto";
		var tipoProjeto = $('#tipoProjeto').val();
		var dados = {
				"tipoProjeto" : tipoProjeto
		}

		clearSemanticDropDown("instituicaoTurma", 'Selecione');
		if (tipoProjeto != "") {
			$.ajax({
				url : formURL,
				type : "POST",
				data : dados,
				success : function(json) {
					if (typeof json.list != 'undefined') {
						adicionarInstituicoes(json.list);
					}
					$('.ui.dropdown.instituicaoTurma').api('remove loading');

				}
			});
		} else {
			$('.ui.dropdown.instituicaoTurma').api('remove loading');
		}
	}

	function adicionarInstituicoes(lista) {
		$.each(lista, function(chave, valor) {
			$(".ui.dropdown.instituicaoTurma .menu").append(
					"<div class='item' data-value='" + valor.id + "'>" + valor.nome	+ "</div>");
		})
	}

	function adicionarUnidades(lista) {
		$.each(lista, function(chave, valor) {
			$(".ui.dropdown.unidadeInstituicao .menu").append(
					"<div class='item' data-value='" + valor.id + "'>" + valor.nome	+ "</div>");
		})
	}

	function adicionarNiveis(lista) {
		$.each(lista, function(chave, nivel) {
			$(".ui.dropdown.nivel .menu").append(
					"<div class='item' data-value='" + nivel.valor + "'>" + nivel.descricao	+ "</div>");
		})
	}
