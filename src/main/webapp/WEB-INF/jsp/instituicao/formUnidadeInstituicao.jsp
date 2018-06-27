<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="acao" scope="request" value="alterar" />
<div class="ui small modal" id="modalUnidadeInstituicao">
    <div class="ui icon header">
    	<i id="iconeUnidadeInstituicao" class="glyphicon glyphicon-education pencilNovo"></i>
      	<span id='tituloUnidadeInstituicao'>Cadastro de Unidade</span>
    </div>
    <form role="form" id="formUnidadeInstituicao" method="POST" action='<c:url value="/unidadeInstituicao/incluir"/>'>
	    <div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="fields">
						<input name="unidadeInstituicao.instituicao.id" id="instituicaoUnidadeId" type="hidden" value="">
						<input id="unidadeInstituicaoId" name="unidadeInstituicao.id" type="hidden" value="">
				 		<div class="eight wide field required">
							<label>Nome</label>
							<input type="text" class="campo-form" id="unidadeInstituicaoNome" name="unidadeInstituicao.nome" value="">
				 		</div>
                    </div>
				</div>
			    <div class="actions" style="text-align: center; border-top:none"> 
			      	<a class="ui red basic cancel button">
			        	<i class="remove icon"></i>
			        	Fechar
			      	</a>
			      	<a id="btnConfirmUnidadeInstituicao" class="ui ok inverted button gold" href="#">
			        	<i class="checkmark icon"></i>
			        	Salvar
			      	</a>
			      	
				</div>
			</div>
		</div>
	</form>
</div>
