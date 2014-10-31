<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>${classe}</title>
  </head>
  <body>

<div class="panel panel-default">
  <div class="panel-heading">${classe}</div>
  <div class="panel-body">
    Panel content
  </div>
  <table class="table">
  	<thead>
	  	<tr>
	  		<c:forEach var="item" items="${header}">
	  			<th>${item}</th>
	  		</c:forEach>
	  	</tr>
  	</thead>
  	
  	<tbody class="content">
  		<tr>
  			<td></td>
  		</tr>
  	</tbody>
  	
  	<tfoot>
  		<tr>
  			<c:forEach var="item" items="${header}">
  				<td>${item}</td>
  			</c:forEach>
  		</tr>
  	</tfoot>  	
  </table>
</div>

  </body>
</html>
