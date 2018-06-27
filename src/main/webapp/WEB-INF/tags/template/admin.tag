<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<jsp:useBean id="now" class="java.util.Date" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="utf-8">
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="shortcut icon" type="image/x-icon" href="<c:url value='/assets/imagens/iconLogo.png'/>">  
<title>Lummi Control - Gestão de Eventos</title>
  
  <!-- Biblioteca Detran -->		
  <link rel="stylesheet" href="<c:url value='/assets/css/detran-style.css'/>">
        
  <!-- Biblioteca Semantic UI -->		
  <link rel="stylesheet" href="<c:url value='/assets/css/semantic.min.css'/>">
  
  <!-- Biblioteca Mensagem de Notificao -->		
  <link rel="stylesheet" href="<c:url value='/assets/css/lobibox.min.css'/>">
        
  <!-- Biblioteca Adicionais -->		
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap-datepicker.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/font-awesome.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/material-design-iconic-font.min.css'/>">
  
  <!-- Style Paginao
  <jsp:invoke fragment="extraStyles"/>
  -->
</head>

<body style="min-height:100%">
	<!--
	<header id="header" >
		<div class="headerbar">
			<div class="headerbar-left">
				<ul class="header-nav header-nav-options">
					<li class="header-nav-brand" >
						<div class="brand-holder">
							<img src="<c:url value='/assets/imagens/logomarca.png'/>" alt="" />
						</div>
					</li>
				</ul>
			</div>
			<div class="brand-holder" style="text-align: center; font-size: 20px; margin-top: 20px">
				<span class="text-primary">Lummi Control - Gestão de Eventos</span>
			</div>
			<div class="headerbar-right">
				<ul class="header-nav header-nav-profile" style="margin-top: -38px">
					<li class="dropdown">
						<a href="javascript:void(0);" class="dropdown-toggle ink-reaction profile dropdown-usuario" data-toggle="dropdown">
							<img src="<c:url value='/assets/img/iconProfile.png'/>" alt="" />
						</a>
						<ul class="dropdown-menu animation-dock dropdown-usuario-lista">
							<li class="dropdown-header">Nome</li>
							<li><a href="#">${usuarioLogado.usuario.funcionario.pessoa.nome}</a></li>
							<li class="dropdown-header">Lotação</li>
							<li><a href="#">DETRAN</a></li>
							<li class="dropdown-header">Configuração</li>
							<li><a href="#">Meu perfil</a></li>
							<li class="divider"></li>
							<li><a href="<c:url value='/auth/alterarSenha'/>"><i class="fa fa-fw fa-lock"></i>Alterar Senha</a></li>
							<li class="divider"></li>
							<li><a href="<c:url value='/auth/sair'/>"><i class="fa fa-fw fa-power-off text-danger"></i> Sair</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</header>
	 BEGIN HEADER-->
	<!-- END HEADER-->
	<div>
		<!-- BEGIN BASE-->
		<div id="base" class="context pagina">
			<div id="" class="ui fields content form inverted top attached demo menu">
		        <a class="one wide field item itemhead"><i class="sidebar big icon"></i></a>
				<div class="one wide field">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand" >
							<div class="brand-holder">
								<img src="<c:url value='/assets/imagens/logomarca.png'/>" alt="" />
							</div>
						</li>
					</ul>
				</div>
				<div class="twelve wide field" style="text-align: center; font-size: 20px; padding-top: 20px">
					<span class="text-primary">Lummi Control - Gestão de Eventos</span>
				</div>
			<div class="two wide field">
				<ul class="header-nav header-nav-profile">
					<li class="dropdown">
						<a href="javascript:void(0);" class="dropdown-toggle ink-reaction profile dropdown-usuario" data-toggle="dropdown">
							<img src="<c:url value='/assets/img/iconProfile.png'/>" alt="" />
						</a>
						<ul class="dropdown-menu animation-dock dropdown-usuario-lista">
							<li class="dropdown-header">Nome</li>
							<li><a href="#">${usuarioLogado.usuario.funcionario.pessoa.nome}</a></li>
							<li class="dropdown-header">Lotação</li>
							<li><a href="#">DETRAN</a></li>
							<li class="dropdown-header">Configuração</li>
							<li><a href="#">Meu perfil</a></li>
							<li class="divider"></li>
							<li><a href="<c:url value='/auth/alterarSenha'/>"><i class="fa fa-fw fa-lock"></i>Alterar Senha</a></li>
							<li class="divider"></li>
							<li><a href="<c:url value='/auth/sair'/>"><i class="fa fa-fw fa-power-off text-danger"></i> Sair</a></li>
						</ul>
					</li>
				</ul>
			</div>
			</div>
			<!-- BEGIN CONTENT-->
			<!-- END CONTENT -->
		<div class="ui bottom attached segment pushable" style="min-height: 672px">
	        <div class="ui inverted labeled icon left inline vertical sidebar menu" style="z-index: 4; overflow: visible!important">
		       	<div class="ui vertical accordion left">
			        <a href="<c:url value='/'/>" class="title item" style="text-align:left!important; color: white; width:200px"><i class="home icon" style="float: right"></i> <span style="width:200px">Início</span> </a>
		          	<div class="content">
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="checked calendar icon" style="float: right"></i> Agenda Lummi </a>
		          	<div class="content">
		          	</div>
		          	<a class="title item" style="text-align:left;"><i class="cubes icon" style="float: right"></i> Cadastro </a>
		          	<div class="content">
						<a class="item" style="text-align: left!important" href="<c:url value='/captadorExterno'/>" ><span style="font-size: 12px; margin-left: 20px">Captador Externo</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/cargo/'/>" ><span style="font-size: 12px; margin-left: 20px">Cargo</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/curso/'/>" ><span style="font-size: 12px; margin-left: 20px">Curso</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/formaCaptacao/'/>" ><span style="font-size: 12px; margin-left: 20px">Forma de Captação</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/instituicao/'/>" ><span style="font-size: 12px; margin-left: 20px">Instituição</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/setor/'/>" ><span style="font-size: 12px; margin-left: 20px">Setor</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/turno/'/>" ><span style="font-size: 12px; margin-left: 20px">Turno</span></a>
		          	</div>
		          	<a class="title item" style="text-align:left;"><i class="graduation cap icon" style="float: right"></i> Projetos </a>
		          	<div class="content">
						<a class="item" style="text-align: left!important" href="<c:url value='/projeto'/>" ><span style="font-size: 12px; margin-left: 20px">Painel Projetos</span></a>
		          	</div>
					<a class="title item" style="text-align:left;"><i class="shopping bag icon" style="float: right"></i> Comercial </a>
		          	<div class="content">
						<a class="item" style="text-align: left!important" href="<c:url value='/contatoEvento/aatribuir'/>" ><span style=" font-size: 12px; margin-left: 20px">Contatos não Atribuídos</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/contatoEvento/novo'/>" ><span style="font-size: 12px; margin-left: 20px">Novo Contato</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/projeto/emAtendimento'/>" ><span style="font-size: 12px; margin-left: 20px">Projetos em Atendimento</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/projeto/meusProjetos'/>" ><span style="font-size: 12px; margin-left: 20px">Meus Projetos</span></a>
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="settings icon" style="float: right"></i> Gerencial </a>
		          	<div class="content">
						<a class="item" style="text-align: left!important" href="<c:url value='/projeto/meusProjetos'/>" ><span style="font-size: 12px; margin-left: 20px">Meus Projetos</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/projeto/meuCalendario'/>" ><span style="font-size: 12px; margin-left: 20px">Meu Calendário</span></a>
						<a class="item" style="text-align: left!important" href="<c:url value='/projeto/calendario'/>" ><span style="font-size: 12px; margin-left: 20px">Calendário de Eventos Geral</span></a>
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="calculator icon" style="float: right"></i> Financeiro Lummi </a>
		          	<div class="content">
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="money icon" style="float: right"></i> Financeiro Projetos </a>
		          	<div class="content">
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="line chart icon" style="float: right"></i> Marketing </a>
		          	<div class="content">
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="users icon" style="float: right"></i> Recursos Humanos </a>
		          	<div class="content">
						<a class="item" style="text-align: left!important" href="<c:url value='/funcionario/'/>" ><span style=" font-size: 12px; margin-left: 20px">Funcionários</span></a>
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="cubes icon" style="float: right"></i> Patrimônio </a>
		          	<div class="content">
		          	</div>
			        <a class="title item" style="text-align:left;"><i class="calendar icon" style="float: right"></i> Calendário de Eventos </a>
		          	<div class="content">
		          	</div>
		        </div>
	        </div>
			<div id="content" class="pusher">
							
				<section>
					<div class="">
						<div class="row">
                        	
                        	<input type="hidden" id="msgSuccess" value="${success}"  />
							<input type="hidden" id="msgWarning" value="${warning}"  />
							<input type="hidden" id="msgError" value="${error}"  />
							<input type="hidden" id="msgModal" value="${modal}"  />
							
                            <!-- CONTENT PAGES -->
							<jsp:doBody />
							
							<div class="ui small basic test modal modalRemove">
							    <div class="ui icon header">
							      <i class="trash outline icon"></i>
							      Excluir
							    </div>
							    <div class="content" style="text-align: center">
							      <p>Deseja realmente excluir este registro?</p>
							    </div>
							    <div class="actions" style="text-align: center"> 
							      <a class="ui red basic cancel inverted button">
							        <i class="remove icon"></i>
							        Cancelar
							      </a>
							      <a id="btnConfirmRemoved" class="ui green ok inverted button" href="#">
							        <i class="checkmark icon"></i>
							        Confirmar
							      </a>
							    </div>
							</div> 
							
							<div class="ui small basic test modal modalActive">
							    <div class="ui icon header">
							      <i class="check circle icon"></i>
							      Reativar
							    </div>
							    <div class="content" style="text-align: center">
							      <p>Deseja realmente reativar este registro?</p>
							    </div>
							    <div class="actions" style="text-align: center"> 
							      <a class="ui red basic cancel inverted button">
							        <i class="remove icon"></i>
							        Cancelar
							      </a>
							      <a id="btnConfirmActive" class="ui green ok inverted button" href="#">
							        <i class="checkmark icon"></i>
							        Confirmar
							      </a>
							    </div>
							</div>
							
							<div class="ui small basic test modal modalInactive">
							    <div class="ui icon header">
							      <i class="remove circle icon"></i>
							      Inativar
							    </div>
							    <div class="content" style="text-align: center">
							      <p>Deseja realmente inativar este registro?</p>
							    </div>
							    <div class="actions" style="text-align: center"> 
							      <a class="ui red basic cancel inverted button">
							        <i class="remove icon"></i>
							        Cancelar
							      </a>
							      <a id="btnConfirmInactive" class="ui green ok inverted button" href="#">
							        <i class="checkmark icon"></i>
							        Confirmar
							      </a>
							    </div>
							</div>
							
							<div class="ui small basic test modal modalRenovar">
							    <div class="ui icon header">
							      <i class="remove circle icon"></i>
							      Renovar
							    </div>
							    <div class="content" style="text-align: center">
							      <p>Deseja imprimir a carteira padrão?</p>
							    </div>
							    <div class="actions" style="text-align: center"> 
							      <a class="ui red basic cancel inverted button"  href="#" >
							        <i class="remove icon"></i>
							        Cancelar
							      </a>
							      <a id="btnConfirmRenovar" target="_blank" class="ui green ok inverted button" href="#">
							        <i class="checkmark icon"></i>
							        Confirmar
							      </a>
							    </div>
							</div>
							
							<div class="ui modal modalPendencies">
							  <div class="header">Pendências</div>
							  <div class="content">
							   
							  </div>
							</div>
							
							<div class="ui modal modalLoading">
							  <div id="dimmer" class="ui active dimmer">
								<div class="ui text loader">Obtendo informações</div>
							  </div>
							</div>					
						</div><!--end .row -->
					</div><!--end .section-body -->
				</section>
			</div><!--end #content-->
      </div>			</div>
			
			<!-- BEGIN MENUBAR
			<div id="menubar" style="margin-top: 64px" class="menubar-inverse">
				<div class="menubar-scroll-panel">
					<ul id="main-menu" class="gui-controls">
						<li>
							<a href="<c:url value='/'/>">
								<span class="gui-icon"><i class="md md-home"></i></span>
								<span class="title">Início</span>
							</a>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-calendar-check-o"></i></div>
								<span class="title">AGENDA Lummi</span>
							</a> 
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-cubes"></i></div>
								<span class="title">Cadastro</span>
							</a> 
							<ul>
								<li><a href="<c:url value='/captadorExterno'/>" ><span class="title">Captador Externo</span></a></li>
							</ul>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-graduation-cap"></i></div>
								<span class="title">PROJETOS</span>
							</a>
							<ul>
								<li><a href="<c:url value='/contatoEvento/aatribuir'/>" ><span class="title">Contatos não Atribuídos</span></a></li>
								<li><a href="<c:url value='/contatoEvento/novo'/>" ><span class="title">Novo Contato</span></a></li>
								<li><a href="<c:url value='/projeto'/>" ><span class="title">Painel Projetos</span></a></li>
							</ul>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-shopping-bag"></i></div>
								<span class="title">COMERCIAL</span>
							</a>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-gears"></i></div>
								<span class="title">GERENCIAL</span>
							</a>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-money"></i></div>
								<span class="title">FINANCEIRO Lummi</span>
							</a>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-bank"></i></div>
								<span class="title">FINANCEIRO PROJETOS</span>
							</a>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-line-chart"></i></div>
								<span class="title">MARKETING</span>
							</a>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-users"></i></div>
								<span class="title">RECURSOS HUMANOS</span>
							</a>
							<ul>
								<li><a href="<c:url value='/funcionario/'/>" ><span class="title">Funcionários</span></a></li>
								<li><a href="<c:url value='/cargo/'/>" ><span class="title">Cargos</span></a></li>
							</ul>
						</li>
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-cubes"></i></div>
								<span class="title">PATRIMÔNIO</span>
							</a>
						</li>
						<li>
							<a href="<c:url value='/'/>">
								<span class="gui-icon"><i class="fa fa-calendar"></i></span>
								<span class="title">CALENDÁRIO DE EVENTOS</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			-->

		</div>
		
	
<script>
 baseUrl = "<c:url value='/'/>";
</script>
	
<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/semantic.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/SgdComponents.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/lobibox.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/jquery.nanoscroller.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/bootstrap-datepicker.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/App.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/AppNavigation.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/AppNavSearch.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/jquery.maskedinput.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/jquery.tablesort.min.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/language_pt_BR.js'/>" charset="UTF-8"></script>
<script src="<c:url value='/assets/js/jquery.maskMoney.min.js'/>"></script>
<script src="<c:url value='/assets/js/jquery.base64.js'/>"></script>
<script src="<c:url value='/assets/js/FileSaver.js'/>"></script>
<script src="<c:url value='/assets/js/tableExport.js'/>"></script>
<script src="<c:url value='/assets/js/ordenacao.js'/>"></script>

<script>
$(document).ready(function() {
	initComponents();
});
function initComponents(){
//	$('.ui.sidebar').sidebar('setting', {
//        dimPage: false 
//      });
//	$(".modulos").on("click", function() {
//		$('.ui.sidebar').sidebar('toggle');
//	});
	// get current URL path and assign 'active' class
	var pathname = window.location.pathname;
		
	$("#main-menu li").each(function(){
		$(this).removeClass("active");
	});	
	
	var aPathName = pathname.split("/");
	
	var iRoot = 0;
	var pathNameMenu = "";
	for(var i = 0; i < aPathName.length ; i ++){
		if(aPathName[i].indexOf("sit") > -1){
			iRoot = i+2;
		}
	}
	
	var aPathMenu = new Array();
	for(var i = 0; i < iRoot ; i ++){
		aPathMenu[i] = aPathName[i];
	}
	
	var pathMenu = aPathMenu.join("/");
	
	$("#main-menu li").each(function(){
		if(typeof $(this).find('a[href="'+pathMenu+'"]').attr("href") != "undefined"){
			$(this).addClass("active");
		}
	});
	
	$('.input-daterange input').each(function() {
    	$(this).datepicker( {
    		language: 'pt-BR',
    	    orientation: "left bottom",
    		autoclose: true
    	});
	});
	
	$('.date input').each(function() {
    	$(this).datepicker( {
    		language: 'pt-BR',
    		orientation: 'left bottom',
    		autoclose: true
    	});
	});

	$('.dateANO input').each(function() {
    	$(this).datepicker( {
    		startDate: "${1900 + now.getYear()}",
    		language: 'pt-BR',
    		format: 'yyyy',
    		orientation: 'left bottom',
    		minViewMode: 2,
    		maxViewMode: 2,
    		autoclose: true,
    		todayHighlight: true
    	});
	});

	$('.dateMES input').each(function() {
    	$(this).datepicker( {
    		language: 'pt-BR',
    		format: 'mm',
    		orientation: 'left bottom',
    		minViewMode: 1,
    		maxViewMode: 1,
    		autoclose: true,
    		todayHighlight: true
    	});
	});

	$('.dateMESANO input').each(function() {
    	$(this).datepicker( {
    		language: 'pt-BR',
    		format: 'mm/yyyy',
    		orientation: 'left bottom',
    		minViewMode: 1,
    		maxViewMode: 2,
    		autoclose: true
    	});
	});

	$('.dateYYYY input').each(function() {
    	$(this).datepicker( {
    		startDate: "${1900 + now.getYear()}",
    		language: 'pt-BR',
    		format: 'yyyy',
    		orientation: 'left bottom',
    		minViewMode: 2,
    		maxViewMode: 2,
    		autoclose: true,
    		todayHighlight: true
    	});
	});
	$.mask.definitions['K'] = "[A-Za-z0-9\/\\-\]";
	$.mask.definitions['L'] = "[A-Za-z]";
	$('.viproc').mask('9999999/9999');
	$('.cnh').mask('99999?999999999');
	$('.rg').mask('K?KKKKKKKKKKKKK');
	$('.placa').mask('LLL9999');
	$('.veiculo_ordem').mask('9?99999');
	//$('.num_logradouro').mask('K?KKKKKKKKK');
	$('.multiplicador').mask('9?999');
	$('.codigoSeplag').mask('9?9999999999999');
	$('.quantidade').mask('9?9999999');
	$('.numero2').attr('maxlength',2).maskMoney({allowEmpty:true,allowZero:true,defaultZero:false, showSymbol:false, thousands:".",precision:0});
	$('.numero4').attr('maxlength',4).maskMoney({allowEmpty:true,allowZero:true,defaultZero:false, showSymbol:false, thousands:".",precision:0});
	$('.numero').mask('9?999999');
	$('.codigo').mask('9?99');
	$('.linha').mask('9?9999');
	$('.ramal').mask('9?9999');
	$('.crc').mask('9?9999');
	$('.regJC').mask('99999999999')
	$('.inscricao-estatual').mask('999?9999999999');
	$('.endereco-numero').mask('9?99999');
	$('.potencia-motor').mask('9?9999');
	$('.cep').mask('99999-999');
	$('.cpf').mask('999.999.999-99');
	$('.cnpj').mask("99.999.999/9999-99");
	$('.date').mask('99/99/9999');
	$('.telefone').mask('(99) 9999-9999?9');
	$('.celular').mask('(99) 99999-9999?9');
	$('.numdocpag').mask('9?999999999');
	$('.form-control-capacidade').mask('9?99');
	$('.form-control-ano').mask('9?999');
	$('.dateMES input').mask('99');
	$('.dateANO input').mask('9999');
	$('.dinheiro').attr('maxlength',14).maskMoney({showSymbol:true, prefix:"R$ ", decimal:",", thousands:".",precision:2});
	$('.dinheiro').maskMoney('mask');
	$('.selic').attr('maxlength',6).maskMoney({allowEmpty:true,defaultZero:false, showSymbol:true, suffix:"%", decimal:",", thousands:"",precision:2});
}

</script>


<script type="text/javascript">
	$('.context.pagina .ui.sidebar')
		.sidebar({context: $('.context.pagina .bottom.segment')})
		.sidebar('setting', {dimPage: false, transition: 'overlay'})
		.sidebar('attach events', '.context.pagina .menu .itemhead');
	$('.accordion').accordion({selector:{trigger: '.title'}});
	var msg = $('#msgSuccess').val();
	var msgWarning = $('#msgWarning').val();
	var msgError = $('#msgError').val();
	var msgModal = $('#msgModal').val();
	if(msg != null && msg != "" && msg !== undefined && msgError == "")
		msgNotify('success', msg);
	if(msgWarning != null && msgWarning != "" && msgWarning !== undefined && msgError == "")
		msgNotify('warning', msgWarning);
	if(msgError != null && msgError != "" && msgError !== undefined)
		msgNotify('error', msgError);
	if(msgModal != null && msgModal != "" && msgModal !== undefined)
		modalRenovar();
	if($('#msgErrors input').val() != null && $('#msgErrors input').val() != "" && $('#msgErrors input').val() !== undefined){
        var inputs = new Array();
        $('#msgErrors input').each(function(){
          inputs.push($(this).val());
      });
        msgNotify('warning', inputs);
  	}
</script>	

<jsp:invoke fragment="extraScripts"/>
</body>
</html>