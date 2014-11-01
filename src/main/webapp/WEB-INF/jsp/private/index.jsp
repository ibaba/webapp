<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>${classe}</title>
  </head>
  <body>

<div class="content">

<div class="panel panel-default">
  <div class="panel-heading">${classe}</div>
  <div class="panel-body">
    <c:forEach var="item" items="${menu}">
    	<sec:authorize access="hasPermission(#user, '${item}_${classe}')">
    		<c:url value="/${classe}/${item}" var="action"/>
    		<button type="button" class="btn btn-default link" data-action="${action}">${item}</button>
    	</sec:authorize>
    </c:forEach>
  </div>
  <table class="table">
  	<thead>
	  	<tr>
	  		<th>#</th>
	  		<c:forEach var="item" items="${colunas}">
	  			<th>${item}</th>
	  		</c:forEach>
	  		<th>...</th>
	  	</tr>
  	</thead>
  	
  	<tbody class="content">
  		<tr>
  			<td></td>
  		</tr>
  	</tbody>
  	
  	<tfoot>
  		<tr>
  			<td></td>
  			<c:forEach var="item" items="${colunas}">
  				<td>${item}</td>
  			</c:forEach>
  			<td></td>
  		</tr>
  	</tfoot>  	
  </table>
</div>

<div style="display: none;">
	<c:forEach var="item" items="${item}">
		<sec:authorize access="hasPermission(#user, '${item}_${classe}')">
			<c:url value="/${classe}/${item}" var="action"/>
			<div class="cmd" data-action="${action}">${item}</div>
		</sec:authorize>
	</c:forEach>
</div>

<script>
	load_content();
</script>

</div>

  </body>
</html>
