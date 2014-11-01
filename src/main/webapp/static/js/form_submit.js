$(document).ready(function(){
	$("form.form").each(function(){
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
});
