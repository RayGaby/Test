$(function(){ 
   $(".nav").accordion({ 
        speed: 500, 
        closedSign: ' [+]', 
        openedSign: ' [-]' 
    }); 
    
    // 切换栏目事件
	$(".nav a").click(function() {
		var url = $(this).data("url");		
		$(".main-container .page").attr("src", url);
		
		//$(".nav a").removeClass("section-active");
		//$(this).addClass("section-active");
	});
});