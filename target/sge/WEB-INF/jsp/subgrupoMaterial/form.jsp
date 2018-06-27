<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<input type="hidden" name="subgrupoMaterial.id" value="${subgrupoMaterial.id}"/>
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
			<c:if test="${acao ne 'add'}">
				<div class="one wide field required">
					<label>Código</label>
					<input type="text" name="subgrupoMaterial.id" value='${subgrupoMaterial.id}' disabled class="campo-form">
				</div>
			</c:if>
			<div class="five wide field required" id="valorPeriodo">
				<label>Grupo</label>
				<div class="ui selection dropdown <c:if test='${acao eq "show"}'>disabled</c:if>">
					<input name="subgrupoMaterial.grupoMaterial.id" type="hidden" value="${subgrupoMaterial.grupoMaterial.id}">
		  			<div class="default text">Selecione</div>
		  			<i class="dropdown icon"></i>
		  			<div class="menu">
						<c:forEach items="${listaGrupos}" var="grupo">
							<div class="item <c:if test="${grupo.id eq subgrupoMaterial.grupoMaterial.id}">active selected</c:if>" data-value="${grupo.id}">${grupo.descricao}</div>
						</c:forEach>
			  		</div>
		 		</div>
			</div>
		</div>
		<div class="fields">
	 		<div class="six wide field required">
				<label>Subgrupo</label>
				<input type="text" maxlength="255" <c:if test='${acao eq "show"}'>disabled</c:if> name="subgrupoMaterial.descricao" value='${subgrupoMaterial.descricao}' class="campo-form">
			</div>
		</div>
	</div>
</div>