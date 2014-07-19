function swapImages(){
		
		var $activeThumbnail = $("#thumbnailContainer .activeThumbnail");
		var $nextThumbnail = $("#thumbnailContainer .activeThumbnail").next();
		var $active = $("#carousel .active");
		var $next = ($("#carousel .active").next().length >
		0) ? $("#carousel .active").next() : $("#carousel img:first");
		
		var $nextThumbnail = ($("#thumbnailContainer .activeThumbnail").next().length >
		0) ? $("#thumbnailContainer .activeThumbnail").next() : $("#thumbnailContainer div:first");
		
		$active.fadeOut(function(){
			
			$activeThumbnail.removeClass("activeThumbnail");
			$nextThumbnail.addClass("activeThumbnail");
			$active.removeClass("active");
			$next.fadeIn().addClass("active");
			
		}); // end fadeOut
		
	} // end swapImages
	
function checkWindowSize(){
	
	// assign "window" variable to JQuery's window object
	var $window = $(window);
	// create windowWidth variable
	var windowWidth = $window.width();
	// create windowHeight variable
	var windowHeight = $window.height();
	
	
	// switch to sampleResponsiveBase.css if window width > or = 845
	if (windowWidth >= 845)
	{
		$("#CSStag").attr("href","standard.css");
	}
	
	// switch to adaptive if window width < 845
	if (windowWidth < 845)
	{
		
		$("#carousel").css("width",.949*windowWidth);
		$("#carousel").css("height",.594*windowWidth);
		$("#carousel img").css({"height": .59*windowWidth, "width": .94*windowWidth});
		
		// shift thumbnails down on screen if they can't all fit horizontally
		if (windowWidth < 356)
		{
			$("#thumbnailContainer").css("width",.99*windowWidth);
		}
		else
		{
			$("#thumbnailContainer").css("width","336px");
		}
		
	}
	
} // end checkWindowSize()

$(document).ready(function(){
	
	// run checkWindowSize on document ready
	checkWindowSize();
	
	// run checkWindowSize when window is re-sized
	$(window).resize(function()
	{
		checkWindowSize();
	}); // end window.resize
	
	// run swapImages() function for image slide show
	setInterval("swapImages()", 4000);
	
	$(document).mousemove(function(event)
	{
		$("#x").text(event.pageX + ",");
		$("#y").text(event.pageY);
	});
	
}); // end document ready