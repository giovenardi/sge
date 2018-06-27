	$(".ui.dropdown.grupo").on('change', function() {
		buscarSubgrupos();
	});

	$(".ui.dropdown.tipo").on('change', function() {
		buscarGrupos();
		buscarSubgrupos();
	});

	function buscarGrupos() {
		$('.ui.dropdown.grupo').api('set loading');
		var formURL = baseUrl + "grupoMaterial/buscarGrupos";
		var tipoMaterial = $('#tipo').val();
		var tipo = {
			"tipoMaterial" : tipoMaterial
		};
		$('#grupo').val("");
		$('.ui.dropdown.grupo .item').remove();
		$('.ui.dropdown.grupo').dropdown('set placeholder text', 'Selecione');
		if (tipoMaterial != "") {
			$.ajax({
				url : formURL,
				type : "GET",
				data : tipo,
				success : function(json) {

					if (typeof json.list != 'undefined') {
						$.each(json.list, function(chave, valor) {
							$(".ui.dropdown.grupo .menu").append(
									"<div class='item' data-value='" + valor.id + "'>" + valor.descricao
											+ "</div>");
						});

					}
					$('.ui.dropdown.grupo').api('remove loading');
				}
			});
		} else {
			$('.ui.dropdown.grupo').api('remove loading');
		}
	}

	function buscarSubgrupos() {
		$('.ui.dropdown.subgrupo').api('set loading');
		var formURL = baseUrl + "subgrupoMaterial/buscarSubgrupos";
		var idGrupo = $('#grupo').val();
		var tipoMaterial = $('#tipo').val();
		var grupo = {
				"grupoMaterial.id" : idGrupo,
				"grupoMaterial.tipoMaterial" : tipoMaterial
		};
		$('#subgrupo').val("");
		$('.ui.dropdown.subgrupo .item').remove();
		$('.ui.dropdown.subgrupo').dropdown('set placeholder text', 'Selecione');
		if (idGrupo != "" || tipoMaterial != "") {
			$.ajax({
				url : formURL,
				type : "GET",
				data : grupo,
				success : function(json) {

					if (typeof json.list != 'undefined') {
						$.each(json.list, function(chave, valor) {
							$(".ui.dropdown.subgrupo .menu").append(
									"<div class='item' data-value='" + valor.id + "'>" + valor.descricao
											+ "</div>");
						});

					}
					$('.ui.dropdown.subgrupo').api('remove loading');
				}
			});
		} else {
			$('.ui.dropdown.subgrupo').api('remove loading');
		}
	}

