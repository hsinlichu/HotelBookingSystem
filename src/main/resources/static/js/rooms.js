(function($) {
    'use strict';
    
    var calculate = function(){
    	console.log($("#numofSingle").val());
    	console.log($("#singleprice").text());

    	return $("#numofSingle").val() * $("#singleprice").text() + $("#numofDouble").val() * $("#doubleprice").text() + $("#numofQuad").val() * $("#quadprice").text(); 
    }

    $("#numofSingle").change(function() {
    	$("#totalprice").attr("value",calculate());
    });
    $("#numofDouble").change(function() {
    	$("#totalprice").attr("value",calculate());
    });
    $("#numofQuad").change(function() {
    	$("#totalprice").attr("value",calculate());
    });
    
    var modify = function(){
    	if($("#singleprice").text() == -1)
    		$("#singlecol").hide();//.css('visibility', 'hidden');
		if($("#doubleprice").text() == -1)
    		$("#singlecol").hide();//.css('visibility', 'hidden');
		if($("#quadprice").text() == -1)
    		$("#singlecol").hide();//.css('visibility', 'hidden');
    }
    modify();
})(jQuery);




