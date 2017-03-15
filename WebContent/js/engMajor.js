$(document).ready(function(){
	/*进入介绍页面的链接形式为page.jsp?pageId=1001*/

	$.ajaxSetup ({cache: false});
	$.getJSON("engPageAction!queryPagesByUpperPage?upperPage="+1002,function(data){
		var list = data.pageList;
		$.each(list,function(i){
			var pageTitle = list[i].pageTitle;
			var s = pageTitle.substring(0,pageTitle.indexOf(":"));
			
			if(s=="Undergraduate"){
				$("#undergraduate").append("<p><a class='degree' href='engPage?pageId="+list[i].pageId+"'>"+pageTitle.substring(pageTitle.indexOf(":")+1,pageTitle.length)+"</a></p>");			
				}
			else if(s=="Postgraduate"){
				$("#postgraduate").append("<p><a class='degree' href='engPage?pageId="+list[i].pageId+"'>"+pageTitle.substring(pageTitle.indexOf(":")+1,pageTitle.length)+"</a></p>");			
			}else{
				$("#phd").append("<p><a class='degree' href='engPage?pageId="+list[i].pageId+"'>"+pageTitle.substring(pageTitle.indexOf(":")+1,pageTitle.length)+"</a></p>");			
			}
			});
			
	});
	
});