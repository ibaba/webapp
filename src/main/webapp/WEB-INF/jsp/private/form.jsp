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

<x:Form>
	<c:forEach var="item" items="${command['class'].declaredFields}" varStatus="status">
		<h3>${item.name}</h3>
		<c:forEach var="item2" items="${item['class'].annotations}">
			<h4>${item2.name}</h4>
			<c:choose>
				<c:when test="${item2['class'].simpleName == 'Checkbox'}">
					<x:Checkbox/>
				</c:when>
				<c:when test="${item2['class'].simpleName == 'DataList'}">
					<x:DataList/>
				</c:when>
				<c:when test="${item2['class'].simpleName == 'Input'}">
					<x:Input/>
				</c:when>
				<c:when test="${item2['class'].simpleName == 'Radiobutton'}">
					<x:Radiobutton/>
				</c:when>
				<c:when test="${item2['class'].simpleName == 'Select'}">
					<x:Select/>
				</c:when>
				<c:when test="${item2['class'].simpleName == 'Textarea'}">
					<x:Textarea/>
				</c:when>
			</c:choose>
		</c:forEach>
	</c:forEach>
	
	<button type="submit" class="btn btn-default">Enviar</button>
</x:Form>

<div class="alert alert-success" role="alert" style="display: none;">${command['class'].simpleName} enviado com sucesso!</div>
<div class="alert alert-danger" role="alert" style="display: none;">...</div>

<script>
$('form.form').each(function(){
	var form = this;
	$(form).ajaxForm(function(data) { 
	    if(data == "") {
	    	$(".alert-success").show();
	    } else {
	    	var $temp  = $('<div/>', {html:data});
	    	$(".alert-danger").empty();
	    	$(".alert-danger").html( $temp.remove('head').html() );
	    }
	});
});
</script>
  </body>
</html>
