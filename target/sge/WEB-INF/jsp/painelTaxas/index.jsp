<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<c:set var="acao" value="add" scope="request" />
<template:admin>
	<jsp:body>
		<div class="ui small breadcrumb">
			<a href="<c:url value='/'/>" class="section">Início</a>
			<i class="right arrow icon divider"></i>
			<div class="section">Gestão Financeira</div>
			<i class="right arrow icon divider"></i>
			<div class="section">Receitas</div>
			<i class="right arrow icon divider"></i>
			<div class="active section">Painel de Taxas</div>
		</div>
		<div class="ui grid">
			<div class="eight wide column">
					<h2 class="ui header" style="padding-top: 10px">Painel de Taxas</h2>
			</div>
		</div>
		<hr>
      
       <!-- 
       <script type="text/javascript" src="http://localhost/pentaho/plugin/pentaho-cdf-dd/api/renderer/cde-embed.js"></script>		

       <script type="text/javascript">
	
		require(['dash!/public/Receitas/Dashboards/receitas.wcdf'
			], function(SampleDash) {
			var sampleDash = new SampleDash("content1");
  			sampleDash.render();
			});
		</script>

		<div id = "content1"></div>
        -->
        
        <div style="padding-bottom: 200%" class="ui embed"
			data-url="http://172.25.136.150/pentaho/api/repos/%3Apublic%3AOpenReports%3AReceitas%3ADashboards%3Ataxas.wcdf/generatedContent"></div>
      
        
      
    </jsp:body>
</template:admin>