<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<input type="hidden" name="material.id" value="${material.id}"/>
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
			<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Subgrupo de Material</label>
				<div class="ui selection dropdown subgrupo <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="material.subgrupoMaterial.id" id="subgrupo" type="hidden" value="${material.subgrupoMaterial.id}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaSubgrupos}" var="subgrupo">
							<div class="item <c:if test="${subgrupo.id.equals(material.subgrupoMaterial.id)}">active selected</c:if>" data-value="${subgrupo.id}">${subgrupo.descricao}&nbsp;&nbsp;<div class="ui label I">${subgrupo.grupoMaterial.descricao}</div></div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
		</div>
		<div class="fields">
	 		<div class="ten wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Nome do Material</label>
				<input type="text" maxlength="100" class="campo-form" <c:if test='${acao eq "show"}'>disabled</c:if> name="material.nome" value="${material.nome}">
			</div>
			<div class="six wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Código Seplag</label>
				<input type="text" maxlength="14" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form codigoSeplag" name="material.codigoSeplag" value="${material.codigoSeplag}">
			</div>
		</div>
		<div class="fields separador">
			<div class="sixteen wide field <c:if test='${acao ne "show"}'>required</c:if>">
	    		<label>Descrição do Material</label>
	    		<textarea rows="2" maxlength="1000" ${(acao eq "show")?"disabled":""} class="campo-form" name="material.descricao">${material.descricao}</textarea>
	  		</div>
		</div>
		<div class="fields">
			<c:if test='${acao ne "add"}'>
				<div class="four wide field">
					<label>Situação</label>
					<div class="ui selection dropdown disabled">
						<input name="material.status" type="hidden" value="${material.status}">
		  				<div class="default text">Selecione</div>
		  				<i class="dropdown icon"></i>
		  				<div class="menu">
							<c:forEach items="${listaStatus}" var="status">
								<div class="item <c:if test="${status.name().equals(material.status.name())}">active selected</c:if>" data-value="${status.name()}">${status.descricao}</div>
							</c:forEach>
		  				</div>
		 			</div>
				</div>
			</c:if>
			<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Unidade</label>
				<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="material.unidade" type="hidden" value="${material.unidade}">
	  				<div class="default text">Selecione</div>
	  				<i class="dropdown icon"></i>
	  				<div class="menu">
						<c:forEach items="${listaUnidades}" var="unidade">
							<div class="item <c:if test="${unidade.name().equals(material.unidade.name())}">active selected</c:if>" data-value="${unidade.name()}">${unidade.descricao}</div>
						</c:forEach>
	  				</div>
	 			</div>
			</div>
			<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Fator Multiplicador</label>
				<input type="text" maxlength="4" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form multiplicador" name="material.fatorMultiplicador" value="${material.fatorMultiplicador}">
			</div>
		</div>
		<div class="fields">
			<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Estoque Máximo</label>
				<input type="text" maxlength="8" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form quantidade" name="material.estoqueMaximo" value="${material.estoqueMaximo}">
			</div>
			
			<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Estoque Mínimo</label>
				<input type="text" maxlength="8" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form quantidade" name="material.estoqueMinimo" value="${material.estoqueMinimo}">
			</div>
			
			<div class="four wide field <c:if test='${acao ne "show"}'>required</c:if>">
				<label>Ponto de Reposição</label>
				<input type="text" maxlength="8" <c:if test='${acao eq "show"}'>disabled</c:if> class="campo-form quantidade" name="material.pontoReposicao" value="${material.pontoReposicao}">
			</div>
		</div>
	</div>
</div>

<c:if test='${acao ne "add"}'>
	<table class="ui black unstackable table">
        <thead class="teste">
       		<tr class="">
       	        <th colspan="4" class="wide center aligned">Dados de Movimentação de Material</th>
           	</tr>
   	        <tr>
   	       		<th class="four wide">Data da Última Requisição</th>
                <th class="four wide">Data da Última Compra</th>
                <th class="four wide">Valor da Última Compra</th>
                <th class="four wide">Quantidade em Estoque</th>
           	</tr>
        </thead>
		<tbody>
   	        <tr>
   	       		<td class="center aligned">${material.dataUltimaRequisicao}</td>
   	       		<td class="center aligned">${material.dataUltimaCompra}</td>
   	       		<td class="center aligned">${material.valorUltimaCompra}</td>
   	       		<td class="center aligned">${material.estoqueAtual}</td>
           	</tr>
        </tbody>
    </table> 
</c:if>