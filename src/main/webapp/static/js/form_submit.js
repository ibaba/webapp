$(document).on('submit', '.form', function (event) {
	event.preventDefault();

	var $form = $( this ), url = $form.attr( "action" );
	
	var posting = $.post( url, $(this).serialize() );
	posting.done(function( data ) {
	    if(data == "") {
	    	$(".alert-success").show();
	    } else {
	    	var $temp  = $('<div/>', {html:data});
	    	$(".alert-danger").empty();
	    	$(".alert-danger").html( $temp.remove('head').html() );
	    }
		
		$(".form").each (function(){
			this.reset();
		});
	});
});