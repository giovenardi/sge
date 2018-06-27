<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:if test="${!empty(listaTaxas)}">
		<label>Taxa</label>
		<div class="ui selection dropdown taxa">
			<input name="filtroComparativoTaxas.especificacao" type="hidden" value="${filtroComparativoTaxas.especificacao}">
 				<div class="default text">Selecione</div>
 				<i class="dropdown icon"></i>
 				<div class="menu">
				<c:forEach items="${listaTaxas}" var="taxa">
					<div class="item <c:if test="${taxa eq filtroComparativoTaxas.especificacao}">active selected</c:if>" data-value="${taxa}">${taxa}</div>
				</c:forEach>
 				</div>
			</div>
	</c:if>
