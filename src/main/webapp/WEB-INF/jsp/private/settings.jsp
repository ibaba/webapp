<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="/WEB-INF/customTag.tld" prefix="x" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title></title>

    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />

    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath}/static/css/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <c:url value="/" var="indexUrl"/><a class="navbar-brand" href="${indexUrl}"><x:Settings key="geral.titulo"/> | Configura&ccedil;&otilde;es</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAnonymous()">
            	<li> <c:url value="/signin" var="signinUrl"/><a href="${signinUrl}">Sign-in</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            	<li> <c:url value="/admin" var="adminUrl"/><a href="${adminUrl}">${user.nome} ${user.sobrenome}</a> </li>
            </sec:authorize>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
  <c:forEach var="item" items="${settings}" varStatus="status">
  	<c:choose>
  		<c:when test="${status.index == 1}">
  			<li role="presentation" class="active"><a href="#${item.simpleName}" role="tab" data-toggle="tab">${item.simpleName}</a></li>
  		</c:when>
  		<c:otherwise>
  			<li role="presentation"><a href="#${item.simpleName}" role="tab" data-toggle="tab">${item.simpleName}</a></li>
  		</c:otherwise>
  	</c:choose>
  </c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">
	<hr/>
	
	<c:forEach var="item" items="${settings}" varStatus="status">
		<div role="tabpanel" class="tab-pane <c:if test="${status.index == 1}">active</c:if>" id="${item.simpleName}">
			<x:FormSettings classe="${item.simpleName}">
				<c:forEach var="item2" items="${item.declaredFields}" varStatus="status2">
					<c:set var="index" value="${status2.index}"/>
					<c:forEach var="item3" items="${item2.declaredAnnotations}">
						<c:choose>
							<c:when test="${item3.annotationType().simpleName == 'Checkbox'}">
								<x:Checkbox/>
							</c:when>
							<c:when test="${item3.annotationType().simpleName == 'DataList'}">
								<x:DataList/>
							</c:when>
							<c:when test="${item3.annotationType().simpleName == 'Input'}">
								<x:Input/>
							</c:when>
							<c:when test="${item3.annotationType().simpleName == 'Radiobutton'}">
								<x:Radiobutton/>
							</c:when>
							<c:when test="${item3.annotationType().simpleName == 'Select'}">
								<x:Select/>
							</c:when>
							<c:when test="${item3.annotationType().simpleName == 'Textarea'}">
								<x:Textarea/>
							</c:when>
						</c:choose>
					</c:forEach>
				</c:forEach>
				
				<button type="submit" class="btn btn-default">Salvar</button>
			</x:FormSettings>
		</div>
	</c:forEach>
</div>

<div class="alert alert-success" id="yes" role="alert" style="display: none;">Formul&aacute;rio enviado com sucesso!</div>
<div class="alert alert-danger" id="not" role="alert" style="display: none;">...</div>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <script src="${pageContext.servletContext.contextPath}/static/js/page_link.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/page_load.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/form_submit.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/form_valida.js"></script>
  </body>
</html>
