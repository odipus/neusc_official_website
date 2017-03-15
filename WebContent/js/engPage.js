$(document).ready(function(){
	/*进入介绍页面的链接形式为page.jsp?pageId=1001*/
	var str   =   window.location.href;
	var pageId = str.substring(str.length,str.lastIndexOf ('pageId=')+7);
	$.ajaxSetup ({cache: false});
	$.getJSON("engPageAction!queryPageById?pageId="+pageId,function(data){
		var page = data.engPage;
		var isList = page.isList;
		$("#engPage-newsTitle").append(page.pageTitle);
		$("#engPage-newsContent").append(page.pageContent);
	});
	
});