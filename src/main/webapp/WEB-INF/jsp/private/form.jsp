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

<br/>

<x:Form>
	<c:forEach var="item" items="${command.fields}">
		<c:forEach var="item2" items="${item['class'].annotations}">
			<c:choose>
				<c:when test="${item2['class'].annotationType() == 'Checkbox'}">
					<x:Checkbox/>
				</c:when>
				<c:when test="${item2['class'].annotationType() == 'DataList'}">
					<x:DataList/>
				</c:when>
				<c:when test="${item2['class'].annotationType() == 'Input'}">
					<x:Input/>
				</c:when>
				<c:when test="${item2['class'].annotationType() == 'Radiobutton'}">
					<x:Radiobutton/>
				</c:when>
				<c:when test="${item2['class'].annotationType() == 'Select'}">
					<x:Select/>
				</c:when>
				<c:when test="${item2['class'].annotationType() == 'Textarea'}">
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
	form.hide();
});
</script>
  </body>
</html>
