<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<link rel="shortcut icon" type="image/x-icon" href="<c:url value='/assets/imagens/iconLogo.png'/>">  
		<title>Lummi Control - Gestão de Eventos</title>
		<title>Autenticação</title>
		<link rel="stylesheet" href="<c:url value='/assets/css/detran-style.css'/>">
		<link rel="stylesheet" href="<c:url value='/assets/css/semantic.min.css'/>">
		<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>">
		<link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">
	    <!-- Biblioteca Mensagem de Notificao -->		
	    <link rel="stylesheet" href="<c:url value='/assets/css/lobibox.min.css'/>">
	</head>
	<body class="login-page">
		<header id="header" >
			<div class="headerbar">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand" >
							<div class="brand-holder">
								<img src="<c:url value='/assets/imagens/logomarca.png'/>" alt="" />
							</div>
						</li>
					</ul>
				</div>
                        	<input type="text" id="msgSuccess" value="${success}" hidden="true" />
							<input type="text" id="msgWarning" value="${warning}" hidden="true" />
							<input type="text" id="msgError" value="${error}" hidden="true" />
							<input type="text" id="msgModal" value="${modal}" hidden="true" />
				
				<div class="brand-holder" style="text-align: center; font-size: 20px; margin-top: 20px">
					<span class="text-primary">Lummi Control - Gestão de Eventos</span>
				</div>
				<div class="headerbar-right" style="margin: -31px 15px 0 0">
				</div><!--end #header-navbar-collapse -->
			</div>
		</header>
		<div style="clear: both;"></div>
		<div style="float: left; padding-top: 70px">
		</div>		
		<div style="float: right; padding-top: 70px">
		</div>			
		<div id="content">
			<section>
				<div class="section-body">
					<div class="row">
						<jsp:doBody />
					</div>
				</div>
			</section>
		</div>
		<footer class="page-footer" id="footer-painel">
			<div class="ui">
				<div class="ui form">
				<div class="fields">
					<div class="one wide field">
					</div>
					<div class="five wide field">
				    	SRTVS Qd. 701 Bloco K - Edifício Embassy Tower. Salas 614 a 620.
						<br/>Asa Sul Brasília-DF. CEP: 70.340-908
						<br/>Tel.: 61 3039-2505
					</div>
					<div class="four wide field">
					</div>
					<div class="five wide field">
					    Rua 30, Qd. G15, 163
						<br/>Setor Marista Goiânia-GO. CEP: 74.150-100
						<br/>Tel.: 62 3086-4525
					</div>
					<div class="one wide field">
					</div>
				</div>
			</div>
		</div>
		</footer>
		<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>"></script>
		<script src="<c:url value='/assets/js/semantic.min.js'/>"></script>
		<script src="<c:url value='/assets/js/SgdComponents.js'/>"></script> 
		<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
		<script src="<c:url value='/assets/js/lobibox.min.js'/>" charset="UTF-8"></script>
		<script src="<c:url value='/assets/js/jquery.maskedinput.js'/>" charset="UTF-8"></script>
		<script type="text/javascript">
			$('.cpf').mask('999.999.999-99');
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
	</body>
</html>