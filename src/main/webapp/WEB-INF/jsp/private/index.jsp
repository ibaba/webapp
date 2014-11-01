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
	  	
	  	<tbody>
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
$(document).ready(function(){
	var atributos = [];
	$("thead").find("th").each(function(){
		atributos.push($(this).text());
	});
	
	var url = '<c:url value="/${classe}/lista.json"/>';
	$.get(url, function(data) {
		$.each(data, function(index, item) {
			var row = $('<tr>');
			for(var i=0; i<atributos.length; i++) {
				if(atributos[i] == '#')
					row.append('<td>'+item.id+'</td>');
				else if(atributos[i] == '...') {
				    var col = $('<td>');
				    var grupo = $('<div class="btn-group">');
				    $(".cmd").each(function(){
					    var nome = $(this).html();
					    var action = $(this).data("action") + "/" + item.id;
					    grupo.append('<button type="button" class="btn btn-default link" data-action="'+action+'">'+nome+'</button>');
				    });
				    col.append(grupo);
				    row.append(col);
				}
				else
					row.append('<td>'+item[atributos[i]]+'</td>');
			}
			$("tbody").append(row);
		});
	});
	
	$(document).on("click", "button.link", function(event){
		event.preventDefault();
		var link = $(this).data("action");
		$.ajax({
			type: 'GET',
			url: link
		}).done(function(data){
			var $temp  = $('<div/>', {html:data});
			$(".content").empty();
			$(".content").html( $temp.remove('head').html() );
		});
	});
});
</script>

  </body>
</html>
