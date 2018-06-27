$(document).ready(function(){ 	
	$(".ordenacaoTabela th").click(function(){
		var ordenacaoAsc = true;
		var dataSort = $(this).attr('data-sort');
		if(dataSort == undefined){
			return;
		}
		if($(this).is('[ordenacao-asc]')){
			ordenacaoAsc = $(this).attr('ordenacao-asc') == "true" ? false : true;
		}
		ordenacao(dataSort,ordenacaoAsc);
	});
	configOrdenacao(); 
}); 

function configOrdenacao() {
	var dataSort = $('#dataSort').val();
	var ordenacaoAsc= $('#ordenacaoAsc').val();
	var $thDataSort = $('[data-sort="'+ dataSort +'"]');
	$thDataSort.attr('ordenacao-asc',  ordenacaoAsc);
	if(ordenacaoAsc == "true") {
		$thDataSort.addClass('sorted ascending');
	} else {
		$thDataSort.addClass('sorted descending');
	}
}

function ordenacao (campo,ordenacaoAsc){
	$('#dataSort').val(campo);
	$('#ordenacaoAsc').val(ordenacaoAsc);
	$('#get').val(true);
//	var page = $('#currentPage').attr('data-current-page');
//	var filterFormAction = $('#filterForm').attr('action');
//	$('#formImpressao').attr('target', "");
//	$('#formImpressao').attr('action', filterFormAction + '?page=' + (page-1));
	$('#filterForm').submit();
}

