//Chamada componentes Semantic UI
var validar = true;
inicializar();
function inicializar() {
	$('.ui.dropdown').dropdown({
		fullTextSearch : true,
		message : {
			noResults : 'Nenhum resultado encontrado.'
		}
	});
	// $('table.sortable').tablesort();
	$('.ui.accordion').accordion({
		onChange : function() {
			if (typeof redimensiona == 'function') {
				redimensiona();
			}
		}
	});
	$('.max.example.ui.normal.dropdown').dropdown();
	$('.ui').popup();
	$('.ui.checkbox').checkbox();
	$('.ui.embed').embed();
	$('.menu .item').tab();
	$('.tabular .item').tab();
	deficiencia();
	$(".ui.dropdown.estado").on('change', function() {
		buscarMunicipiosUf();
	});
	$('.ui.dropdown.municipio').on('change', function() {
		buscarBairrosMunicipioUf()
	});
	$('.message .close')
	  .on('click', function() {
	    $(this)
	      .closest('.message')
	      .transition('fade');
	});
}

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
					if (typeof json.retornoJson.success != 'undefined') {
						msgNotify('success', json.retornoJson.success);
					}
				}
			},
			error: function(jqXHR, status, error) {
				msgNotify('error', "Problemas ao submeter o formulário");
			}

		});
	}
	return false;
}

function imprimir(contextImpressao, contextBusca) {
	$('#filterForm').prop('action', contextImpressao);
	$('#filterForm').prop('target', "_blank");
	$('#filterForm').submit();
	$('#filterForm').prop('action', contextBusca);
	$('#filterForm').prop('target', "");
}

function relocar(url) {
	var complemento = JSON.stringify($('form').serializeArray());
	location.href=url+'?formIn='+btoa(complemento);
}

function deficiencia(){
	$('#checkDeficiencia').checkbox({
		// check all children
		onChecked : function() {
			$('#deficiente').addClass("required");
			$('#deficiente').removeClass("hide");
		},
		// uncheck all children
		onUnchecked : function() {
			$('#deficiente input').val("");
			$('#deficiente').removeClass("required");
			$('#deficiente').addClass("hide");
		}
	});

}

function modalConfirm(id, msg) {
	$('#btnConfirmRemoved').attr("href", $('#urlContext' + id).val());
	if (typeof msg != 'undefined') {
		$('.ui.modalRemove .content p').text(msg);
		$('.ui.modalRemove .header').remove();
	}
	$('.ui.modalRemove').modal('show');

}

var idRemove;


function modalConfirmAjax(id, callback) {
	idRemove = id;
	$('#btnConfirmRemoved').off();
	$('#btnConfirmRemoved').on("click", callback);
	$('.ui.modalRemove').modal('show');
}

function modalRenovar() {
	$('#btnConfirmRenovar').attr("href", baseUrl + $('#msgModal').val());
	$('.ui.modalRenovar').modal('show');
}

function modalInactive(id) {
	$('#btnConfirmInactive').attr("href", $('#urlContextInactive' + id).val());
	$('.ui.modalInactive').modal('show');
}

function modalActive(id) {
	$('#btnConfirmActive').attr("href", $('#urlContextActive' + id).val());
	$('.ui.modalActive').modal('show');
}

function modalLoading() {
	$('.ui.modalLoading').modal('show');
}

function modalPendencies(id) {

	var content = '<p>Nome: <strong>'
			+ $("#pendencia-razao-social-" + id).val()
			+ '</strong></p>\n\
				   <p>Situação Cadastral: <strong>'
			+ $("#pendencia-situacao-" + id).val()
			+ '</strong></p>\n\
				   <p>Motivo: <strong>'
			+ $("#pendencia-motivo-" + id).val()
			+ '</strong></p>\n\
				   <p>Data: <strong>'
			+ $("#pendencia-data-hora-" + id).val()
			+ '</strong></p>\n\
				   ';

	$('.ui.modalPendencies').modal('show');
	$('.ui.modalPendencies .content').html(content);

}

// Modelo de interface das Mensagens
// 'warning', 'info', 'success', 'error'
function msgNotify(msgType, msg) {
	Lobibox.notify(msgType, {
		delay: 2000,
		messageHeight : 'auto',
		height : 'auto',
		msg : msg,
		size : 'mini',
		position : 'top center',
		hideClass : 'fadeUpDown',
		showClass : 'fadeInDown',
		sound : false
	});
}

function validarForm(form) {
	var idForm = '';
	if (form) {
		idForm = '#'+form+' ';
	}
	var valida = true;
	if (validar) {
		$(idForm + '.error').removeClass('error');
		$(idForm + '.uploadFoto').each(function() {
			if ($(this).is(':visible')) {
				if ($(this).hasClass('required')) {
					if ($('#foto').attr('src') == '') {
						valida = false;
						$($(this).find('.button.field')).addClass('error');
					}
				}
			}
		});
		$(idForm + '.required input:not(.search,.date,.datetime,.select,.file,.check)').each(
				function() {
					if ($(this).is(':visible')) {
						if ($(this).val() == '') {
							valida = false;
							$(this.parentNode).addClass('error');
						}
					}
				})

		$(idForm + '.required textarea').each(
				function() {
					if ($(this).is(':visible')) {
						if ($(this).val() == '') {
							valida = false;
							$(this.parentNode).addClass('error');
						}
					}
				})

		$(idForm + '.required.check').each(function() {
			var checks = $(this).find(':checked');
			if ($(this).is(':visible')) {
				if (checks.length == 0) {
					valida = false;
					$(this).addClass('error');
				}
			}
		})

		$(idForm + '.required input.date').each(function() {
			if ($(this).is(':visible')) {
				if ($(this).val() == '') {
					valida = false;
					$(this.parentNode.parentNode).addClass('error');
				}
			}
		})

		$(idForm + '.required input.datetime').each(function() {
			if ($(this).is(':visible')) {
				if ($(this).val() == '') {
					valida = false;
					$(this.parentNode).addClass('error');
				}
			}
		})

		$(idForm + '.required input.select').each(function() {

			if ($(this.parentElement).is(':visible')) {
				if (this.value == '') {
					valida = false;
					$(this.parentNode.parentNode).addClass('error');
				}
			}
		})

		$(idForm + '.required select')
				.each(
						function() {
							if ($(this).is(':visible')) {
							
								if (typeof $(this).attr("exclusiveValue") != 'undefined'
										&& this.value != $(this).attr(
												"exclusiveValue")) {
	
									if ($(this).attr("msg") != 'undefined') {
										if (this.value != $(this).attr(
												"exclusiveValue")) {
											msgNotify("warning", $(this)
													.attr("msg"));
											valida = false;
											$(this.parentNode.parentNode).addClass(
													'error');
										}
									} else {
										msgNotify("warning",
												"Defina Atribuno msg para o campo de valor "
														+ this.value);
									}
	
								}
	
								if (this.selectedIndex == 0 && this.value == '') {
									valida = false;
									$(this.parentNode.parentNode).addClass('error');
								}
							}
						})

		if (!valida) {
			msgNotify("warning", "Campo(s) Obrigatório(s) não informado(s)");
		}
	}

	return valida;
}

function clearSemanticDropDown(id, label) {
	$('.dropdown.'+id+' input').val('');
	$('.dropdown.'+id).dropdown('set placeholder text', 'Selecione');
	$('.dropdown.'+id).dropdown('clear');
	$('.dropdown.'+id+' .menu .item').remove();
}

function setValueSemanticDropDown($element, value) {

	setTimeout(function() {
		$element.parent().find(".menu .item").each(function() {
			if ($(this).attr("data-value") == value) {
				$(this).click();
			}
		}).val(value);

	}, 200);

}

function getEnderecoGenerico() {

	$('.ui.dropdown.estado').api('set loading');
	$
			.ajax({
				url : baseUrl + "endereco/getEndereco",
				data : {
					cep : $("#cep").val()
				},
				dataType : 'json',
				type : "get",
				success : function(json) {

					if (typeof json.endereco.bairroMunicipioUfId != 'undefined') {

						$("#transportadora-bairroMunicUf-id").val(
								json.endereco.bairroMunicipioUfId);

						$("#logradouro").val(json.endereco.logradouro);

						$("#estado").html(
								"<option value='" + json.endereco.ufId + "'>"
										+ json.endereco.uf + "</option>");
						setValueSemanticDropDown($("#estado"),
								json.endereco.ufId);

						$("#municipio").html(
								"<option value='" + json.endereco.municipioId
										+ "'>" + json.endereco.municipio
										+ "</option>");
						setValueSemanticDropDown($("#municipio"),
								json.endereco.municipioId);

						$("#bairro").html(
								"<option value='" + json.endereco.bairroId
										+ "'>" + json.endereco.bairro
										+ "</option>").val(
								json.endereco.bairroId);
						setValueSemanticDropDown($("#bairro"),
								json.endereco.bairroId);

						$("#logradouro").prop("readonly", true);
						$("#estado,#municipio,#bairro").addClass("disabled");
						$('.ui.dropdown.estado').api('remove loading');

						if (window.location.pathname.indexOf("/show/") > -1) {
							$("#cep,#estado,#logradouro,#municipio,#bairro")
									.prop("disabled", true);
							$(
									'.ui.dropdown.estado, .ui.dropdown.municipio, .ui.dropdown.bairro')
									.addClass("disabled");
						}

					} else {
						$("#logradouro").prop("readonly", false);
						$("#estado,#municipio,#bairro").removeClass("disabled");

						$("#bairro,#municipio").html('');
						$("#bairro,#municipio").parent().find(".text").html('');

						$.ajax({
							url : baseUrl + "endereco/getEstados",
							type : "get",
							dataType : 'json',
							success : function(json) {

								clearSemanticDropDown("estado", 'UF');

								if (typeof json.lista != 'undefined') {
									$.each(json.lista, function(chave, valor) {
										$("#estado").append(
												"<option value='" + valor.id
														+ "'>" + valor.sigla
														+ "</option>");
									});
									$('.ui.dropdown.estado').api(
											'remove loading');
								}
							}
						});

					}

				},
				error : function(ab, cd, InvalidJSON) {
					$("#cep,#estado,#logradouro,#municipio,#bairro")
							.removeClass("loading");
				}
			});
}

function getMunicipios() {
	buscarMunicipiosUf();
}

function getBairros() {

	buscarBairrosMunicipioUf();
}
var texto;
function getEndereco(controller) {
	$("#cep,#estado,#logradouro,#municipio,#bairro").addClass("loading");
	$.ajax({
		url : baseUrl + controller + "/endereco",
		data : {
			cep : $("#cep").val()
		},
		dataType : 'html',
		type : "get",
		success : function(html) {
			$('#endereco').html(html);
			$(".ui.dropdown.estado").dropdown({
				fullTextSearch : true,
				message : {
					noResults : 'Nenhum resultado encontrado.'
				}
			});
			$('.ui.dropdown.municipio').dropdown({
				fullTextSearch : true,
				message : {
					noResults : 'Nenhum resultado encontrado.'
				}
			});
			$('.ui.dropdown.bairro').dropdown({
				fullTextSearch : true,
				message : {
					noResults : 'Nenhum resultado encontrado.'
				}
			});
			$('.ui.dropdown.tipoEndereco').dropdown({
				fullTextSearch : false,
				message : {
					noResults : 'Nenhum resultado encontrado.'
				}
			});
			$(".ui.dropdown.estado").on('change', function() {
				buscarMunicipiosUf();
			});
			$('.ui.dropdown.municipio').on('change', function() {
				buscarBairrosMunicipioUf()
			});

			$('.numero').mask('9?999999');
			$('.cep').mask('99999-999');
			
			if($("#enderecoValido").val() == "false") {
				msgNotify('warning',
					"O CEP informado não foi localizado na base dos correios");
			}
		}
	});

}

function buscarMunicipiosUf() {
	$('.ui.dropdown.municipio').api('set loading');
	var formURL = baseUrl + "endereco/buscarMunicipiosUf";
	var idUf = $('#estado').val();
	var uf = {
		"uf.id" : idUf
	};
	clearSemanticDropDown("municipio", 'Cidade');
	clearSemanticDropDown("bairro", 'Bairro');
	if (idUf != "") {
		$.ajax({
			url : formURL,
			type : "GET",
			data : uf,
			success : function(json) {

				if (typeof json.list != 'undefined') {
					$.each(json.list, function(chave, valor) {
						$("#municipio").append(
								"<option value='" + valor.id + "'>"
										+ valor.nome + "</option>");
					});

				}

				$('.ui.dropdown.municipio').api('remove loading');
				$("#contact-fields-loading").removeClass("active").addClass(
						"disabled");

			}
		});
	}
}

function adicionarMunicipios(lista) {
	$.each(lista, function(chave, valor) {
		$(".ui.dropdown.municipio .menu").append(
				"<div class='item' data-value='" + valor.id + "'>" + valor.nome
						+ "</div>");
	})
}

function buscarBairrosMunicipioUf() {

	$('.ui.dropdown.bairro').api('set loading');
	var formURL = baseUrl + "endereco/buscarBairrosMunicipioUf";
	var idUf = $('#estado').val();
	var idMunicipio = $('#municipio').val();
	var municipio_uf = {
		"municipio.id" : idMunicipio,
		"uf.id" : idUf
	};
	clearSemanticDropDown("bairro", 'Bairro');
	if (idUf != "") {
		$.ajax({
			url : formURL,
			type : "GET",
			data : municipio_uf,
			success : function(json) {
				if (typeof json.bairros != 'undefined') {
					$.each(json.bairros, function(chave, valor) {

						$("#bairro").append(
								"<option value='" + valor.id + "'>"
										+ valor.nome + "</option>");
					});

				}
				$('.ui.dropdown.bairro').api('remove loading');

			}
		});
	}
}

function adicionarBairros(lista) {

	$.each(lista, function(chave, valor) {
		$(".ui.dropdown.bairro .menu").append(
				"<div class='item' data-value='" + valor.id + "'>" + valor.nome
						+ "</div>");
	})
}

function buscarCooperadosTransportadora(radical) {
	$('.ui.dropdown.cooperado').api('set loading')
	var formURL = baseUrl + (radical?radical:'cooperados') + "/buscarCooperadosTransportadora";
	var idTransportadora = $('#transportadora').val();
	var transportadora = {
		"transportadora.id" : idTransportadora
	};
	clearSemanticDropDown("cooperado", 'Selecione');
	if (idTransportadora != "") {
		$.ajax({
			url : formURL,
			type : "GET",
			data : transportadora,
			success : function(json) {
				if (json != undefined && json.list != undefined) {
					adicionarCooperados(json.list);
				}
				$('.ui.dropdown.cooperado').api('remove loading');
			}
		});
	}
}

function buscarAreasAtuacaoTransportadora(radical) {
	$('.ui.dropdown.transportadora').api('set loading')
	var formURL = baseUrl + "cooperados/buscarAreasAtuacaoTransportadora";
	var idTransportadora = $('#transportadora').val();
	var transportadora = {
		"transportadora.id" : idTransportadora
	};
	$('.areaatuacao .ui.checkbox').remove();
	$('.labelAreaAtuacao').show();
	if (idTransportadora != "") {
		$.ajax({
			url : formURL,
			type : "GET",
			data : transportadora,
			success : function(json) {
				if (json != undefined && json.list != undefined) {
					adicionarAreasAtuacao(json.list, radical?radical:'cooperadoTransportadora');
					if (json.list.length > 0) {
						$('.labelAreaAtuacao').hide();
					}
				}
				$('.ui.dropdown.transportadora').api('remove loading');
				$('.ui.checkbox').checkbox();
				deficiencia();
			}
		});
	}
}

function buscarServicosTransportadora(radical) {
	$('.ui.dropdown.transportadora').api('set loading')
	var formURL = baseUrl + "veiculos/buscarServicosTransportadora";
	var idTransportadora = $('#transportadora').val();
	var transportadora = {
			"transportadora.id" : idTransportadora
	};
	$('.servico .ui.checkbox').remove();
	$('.labelServico').show();
	if (idTransportadora != ""  ) {
		$.ajax({
			url : formURL,
			type : "GET",
			data : transportadora,
			success : function(json) {
				if (json != undefined && json.list != undefined) {
					adicionarServicos(json.list, radical);
					if (json.list.length > 0) {
						$('.labelServico').hide();
					}
				}
				$('.ui.dropdown.transportadora').api('remove loading');
				$('.ui.checkbox').checkbox();
			}
		});
	}
}

function buscarMarcaModelo() {
	var formURL = baseUrl + "veiculos/buscarMarcaModelo";
	var idMarca = $('#marca').val();
	if (idMarca) {
		$('.ui.dropdown.modelo').api('set loading')
		var marca = {
				"marca.id" : idMarca
		};
		clearSemanticDropDown("modelo", 'Selecione');
		if (idMarca != "") {
			$.ajax({
				url : formURL,
				type : "GET",
				data : marca,
				success : function(json) {
					if (json != undefined && json.list != undefined) {
						adicionarModelos(json.list);
					}
					$('.ui.dropdown.modelo').api('remove loading');
				}
			});
		}
	}
}

function adicionarAreasAtuacao(lista, radical) {
	$
			.each(
					lista,
					function(chave, valor) {
						$(".areaatuacao .itens")
								.append(
										"<div class='ui checked checkbox'><input type='checkbox' name='"+radical+".areasAtuacao["
												+ chave
												+ "].id' value='"
												+ valor.id
												+ "'><label>"
												+ valor.descricao
												+ "</label></div>");
					})
}

function adicionarServicos(lista, radical) {
	$
			.each(
					lista,
					function(chave, valor) {
						$(".servico .itens")
								.append(
										"<div class='ui radio checkbox'><input id='servico"+chave+"' type='radio' checked class='check hidden' name='"+radical+".servico.id' value='"
												+ valor.id
												+ "'><label>"
												+ valor.descricao
												+ "</label></div>");
					})
}

function adicionarCooperados(lista) {
	$.each(lista, function(chave, valor) {
		$("#cooperado").append(
				"<option value='" + valor.id + "'>"
						+ valor.codigo + " - " + valor.cooperado.nome + "</option>");
	});
}

function adicionarModelos(lista) {
	$.each(lista, function(chave, valor) {
		$("#modelo").append(
				"<option value='" + valor.id + "'>"
						+ valor.nome + "</option>");
	});
}

function validarViProc() {
	var formURL = baseUrl + "util/consultaViProc";
	var numeroViProc = $('#viproc').val();
	$('#obsViProc').val('');
	$('#hiddenAssunto').val('');
	$("#botaoSalvar").prop('disabled', 'disabled')
	if (numeroViProc != '') {
		var dados = {
				"numeroViProc" : numeroViProc
			}
			$.ajax({
				url : formURL,
				type : "Post",
				data : dados,
				success : function(json) {
					if (json.erroVproc) {
						msgNotify("warning", json.erroVproc);
						$('#viproc').val("")
					} else {
						$('#obsViProc').val(json.observacaoViProc);
						$('#hiddenAssunto').val(json.observacaoViProc);
						$("#botaoSalvar").prop('disabled', '')
					}
				}
			});
	}
}

function verificaRestricaoDividaAtva() {
	var formURL = baseUrl + "transportadora/verificaRestricaoDividaAtiva";
	var idTransportadora = $('#transportadora').val();
	var dados = {
			"idTransportadora" : idTransportadora
	};
	
	if(idTransportadora != "") {
		$.ajax({
			url : formURL,
			type : "GET",
			data : dados,
			success : function(json) {
				if (json.restricaoDividaAtiva != undefined) {
					msgNotify("warning", json.restricaoDividaAtiva);
					$('.ui.dropdown.transportadora').dropdown('clear');
				}
			}
		});
	}
}