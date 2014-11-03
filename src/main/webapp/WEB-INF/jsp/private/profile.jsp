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
          <a class="navbar-brand" href="#"><x:Settings key="geral.titulo"/> | Perfil</a>
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

      <sec:authorize access="isAnonymous()">
	      <div class="starter-template">
	        <h1>isAnonymous</h1>
	        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
	      </div>
      </sec:authorize>
      
      <sec:authorize access="isAuthenticated()">
	      <div class="starter-template">
	        <h1>isAuthenticated</h1>
	        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
	      </div>
      </sec:authorize>

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
