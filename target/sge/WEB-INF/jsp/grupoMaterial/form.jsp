<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<input type="hidden" name="grupoMaterial.id" value="${grupoMaterial.id}"/>
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
			<c:if test="${acao ne 'add'}">
				<div class="one wide field required">
					<label>Código</label>
					<input type="text" name="grupoMaterial.id" value='${grupoMaterial.id}' disabled class="campo-form">
				</div>
			</c:if>
			<div class="five wide field required" id="valorPeriodo">
				<label>Tipo de Material</label>
				<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="grupoMaterial.tipoMaterial" type="hidden" value="${grupoMaterial.tipoMaterial}">
		  			<div class="default text">Selecione</div>
		  			<i class="dropdown icon"></i>
		  			<div class="menu">
						<c:forEach items="${listaTipos}" var="tipo">
							<div class="item <c:if test="${tipo.name().equals(grupoMaterial.tipoMaterial.name())}">active selected</c:if>" data-value="${tipo.name()}">${tipo.descricao}</div>
						</c:forEach>
			  		</div>
		 		</div>
			</div>
		</div>
		<div class="fields">
	 		<div class="six wide field required">
				<label>Descrição do Grupo</label>
				<input maxlength="255" type="text" <c:if test='${acao eq "show"}'>disabled</c:if> name="grupoMaterial.descricao" value='${grupoMaterial.descricao}' class="campo-form">
			</div>
		</div>
	</div>
</div>