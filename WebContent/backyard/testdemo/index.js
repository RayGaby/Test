//var headers = ["H1", "H2", "H3", "H4", "H5", "H6"];
var headers = ["H1", "H2"];

$(".accordion").click(function(e) {
	var target = e.target,
		name = target.nodeName.toUpperCase();
		
	if($.inArray(name, headers) > -1) {
		var subItem = $(target).next();

		//slideUp all elements (except target) at current depth or greater
		var depth = $(subItem).parents().length;
		
		var allAtDepth = $(".accordion p, .accordion div").filter(function() {
//			  console.log("start")
//			  console.log($(this).parents().length)
//			  console.log(depth)
//				console.log(this)
//				console.log(subItem.get(0))
//				console.log("end")
			if($(this).parents().length >= depth && this !== subItem.get(0)) {
				
				return true;
			}
		});
//		console.log(allAtDepth)
		$(allAtDepth).slideUp("fast");

		//slideToggle target content and adjust bottom border if necessary
		subItem.slideToggle("fast", function() {
			$(".accordion :visible:last").css("border-radius", "0 0 10px 10px");
		});
		$(target).css({ "border-bottom-right-radius": "0", "border-bottom-left-radius": "0" });
	}
});