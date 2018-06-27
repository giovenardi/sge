<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<script type="text/javascript">
	function limpar(){
		var id=$('#idfiltro').val();
		$("form").form('clear');
		$('#idfiltro').val(id);
	}
</script>
		 <table class="ui black unstackable table">
	         <thead>
	             <tr>
          			<th>Ação</th>
                    <th>Data/Hora</th>
					<th>Usuário</th>
					<th></th>
                </tr>
             </thead>
             <tbody>    
              	<c:forEach var="auditoria" items="${paginatedList.currentList}" varStatus="count">
               		<tr>
	           			<td>${auditoria.acao.descricao}</td>
	                 	<td><fmt:formatDate value="${auditoria.createdAt}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
	           			<td>${auditoria.usuario.getNomeParaRelatorio()}</td>
               			<td>
               				<a class="ui icon button" href="<c:url value="/${funcPrincipal}/log/${auditoria.id}/${descricao}" />" data-content="Visualizar Log"><i class="fa fa-eye"></i></a>
               			</td>
               		</tr>
               	</c:forEach>	
			</tbody>
        </table>
        <template:paginationForFilter paginatedList="${paginatedList}" page="${param.page}" action="/${funcPrincipal}/historico/${filtroAuditoria.idObjeto}" formId="" />
        <br/><br/>

