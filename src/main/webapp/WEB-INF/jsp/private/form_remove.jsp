<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/customTag.tld" prefix="x" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title></title>
  </head>
  <body>

<c:url value="/${command['class'].simpleName}/index" var="url"/>
<button type="button" class="btn btn-default link" data-action="${url}">Voltar</button>

<hr/>

<c:set value="delete" var="action"/>
<x:Form>
	<div class="panel panel-default pergunta">
		<div class="panel-heading">Remo&ccedil;&atilde;o</div>
		
		<div class="panel-body">
			<p>Confirma remo&ccedil;&atilde;o do registro abaixo?</p>
		</div>
		
		<ul class="list-group">
			<c:forEach var="item" items="${command['class'].declaredFields}" varStatus="status">
				<c:set var="index" value="${status.index}"/>
				<c:forEach var="item2" items="${item.declaredAnnotations}">
					<c:choose>
						<c:when test="${item2.annotationType().simpleName == 'Input'}">
							<li class="list-group-item"><strong>${item.name}</strong>: ${command[item.name]}</li>
						</c:when>
					</c:choose>
				</c:forEach>
			</c:forEach>
		</ul>
		
		<div class="panel-footer">
			<button type="submit" class="btn btn-lg btn-link">Sim</button>
			<button type="button" class="btn btn-lg btn-link remove">N&atilde;o</button>
		</div>
	</div>
</x:Form>

<div class="alert alert-success" id="yes" role="alert" style="display: none;">Registro removido com sucesso!</div>
<div class="alert alert-danger" id="not" role="alert" style="display: none;">...</div>

  </body>
</html>
