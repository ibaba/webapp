<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />

    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath}/static/css/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <c:url value="/" var="indexUrl"/>
          <a class="navbar-brand" href="${indexUrl}" target="_blank">Project name</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <c:forEach var="item" items="${menu}">
            	<c:url value="/${item.simpleName}/index" var="url"/>
            	<li><a class="popup" data-target="${item.simpleName}" href="${url}">${item.simpleName}</a></li>
            </c:forEach>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li class="dropdown">
          		<a href="#" class="dropdown-toggle" data-toggle="dropdown">${pageContext.request.remoteUser} <span class="caret"></span></a>
          		<ul class="dropdown-menu" role="menu">
          			<li> <c:url value="/profile" var="profileUrl"/> <a href="${profileUrl}">Profile</a></li>
          			<li> <c:url value="/settings" var="settingsUrl"/> <a href="${settingsUrl}">Settings</a></li>
          			<li> <c:url value="/logout" var="logoutUrl"/> <a href="${logoutUrl}">Logout</a></li>
          		</ul>
          	</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <c:forEach var="item" items="${menu}">
		<div class="dialog" id="${item.simpleName}" title="Basic dialog">
		  <span class="content"></span>
		</div>
      </c:forEach>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <script src="${pageContext.servletContext.contextPath}/static/js/jquery.form.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/page_link.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/page_load.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/form_submit.js"></script>
    <script src="${pageContext.servletContext.contextPath}/static/js/form_valida.js"></script>
  </body>
</html>
