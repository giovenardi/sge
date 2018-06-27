<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input id="instituicao_id" name="instituicao.id" type="hidden" value="${instituicao.id}">
<div class="ui segment">
	<div class="ui form">
		<div class="fields separador">
	 		<div class="four wide field <c:if test='${acao ne "mostrar"}'>required</c:if>">
				<label>Nome</label>
				<input type="text" maxlength="40" class="campo-form" <c:if test='${acao eq "mostrar"}'>disabled</c:if> name="instituicao.nome" value="${instituicao.nome}">
			</div>
		</div>
		<div class="fields separador">
	 		<div class="eight wide field <c:if test='${acao ne "mostrar"}'>required</c:if>">
				<label>Nome Completo</label>
				<input type="text" maxlength="80" class="campo-form" <c:if test='${acao eq "mostrar"}'>disabled</c:if> name="instituicao.nomeCompleto" value="${instituicao.nomeCompleto}">
			</div>
		</div>
		<div class="fields separador">
			<div class="three wide field check">
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" name="instituicao.educacaoInfantil" value="true" ${instituicao.educacaoInfantil?'checked':''}>
						<label>Educação Infantil</label>
					</div>
				</div>
			</div>
			<div class="three wide field check">
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" name="instituicao.ensinoFundamentalMedio" value="true" ${instituicao.ensinoFundamentalMedio?'checked':''}>
						<label>Ensino Fundamental/Médio</label>
					</div>
				</div>
			</div>
			<div class="three wide field check">
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" name="instituicao.ensinoSuperior" value="true" ${instituicao.ensinoSuperior?'checked':''}>
						<label>Ensino Superior</label>
					</div>
				</div>
			</div>
			<div class="three wide field check">
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" name="instituicao.cursosFormacao" value="true" ${instituicao.cursosFormacao?'checked':''}>
						<label>Cursos de Formação</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>