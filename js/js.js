$(document).ready(function(){
	$(".header-nav-item a, .button").click(function (e) { // binding onclick
	$(this).addClass('selected').parent().addClass('active');
	$("body").addClass('menu-active');
	e.stopPropagation();
	toggleElement($(this).parent());
	});
	$("#left-nav-categories ul li").click(function (e) {
		e.stopPropagation();
		$(this).find("ul").slideToggle( "fast" );
	})
})


$(document).click(function(){                   
  $(".active").removeClass("active").children(".selected").removeClass("selected");
  $("body").removeClass('menu-active');
});

function toggleElement(element) {
	//console.log(element);
	$(element).find("ul").css("display", "none").fadeIn("fast");
}

function buttonText(element) {
	$(element).parent().children(".selected").removeClass("selected");
	$(".button.selected span").html($(element).text());
	$(element).addClass("selected");
}