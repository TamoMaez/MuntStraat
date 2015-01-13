// menu-dropdown clicks
$(document).click(function(){
	$( 'nav li a.active' ).removeClass('active').siblings("div").slideUp( "fast" );
});

$( 'nav li' ).click(function(e){ 
		$(this).children("a").toggleClass('active').siblings("div").slideToggle( "fast" );
		e.stopPropagation();
	}
);

//for each element that is classed as 'pull-down', set its margin-top to the difference between its own height and the height of its parent
$('.pull-down').each(function() {
    $(this).css('margin-top', $(this).parent().height()-$(this).height());
    (this).css('margin-bottom', "0px")
});

// maar 1 button in de group active
$(".btn-group button").click(function () {
    $(this).toggleClass("active").siblings("button").removeClass('active');
});

// highlight filter result
$( ".form-control" ).keyup(function( event ) {
	$(".highlighted" ).delay( 200 ).effect("highlight", {}, 2500);
	});

$body = $("body");

    ajaxStart= function() { $body.addClass("loading"); }   
    ajaxStop= function() { 
    	setTimeout(function() {
    		$body.removeClass("loading");
    	}, 500);
   }    


$( document ).ready(function() {
	ajaxStart();
	setTimeout(function() {
	$( ".cutout, .cutout-content" ).css('transform', 'matrix(1, 0, 0, 1, 0, 0)');
	}, 100);
	})