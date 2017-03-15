$(document).ready(function(){
	/*进入介绍页面的链接形式为page.jsp?pageId=1001*/
	var str   =   window.location.href;
	var pageId = str.substring(str.length,str.lastIndexOf ('pageId=')+7);
	$.ajaxSetup ({cache: false});
	$.getJSON("pageAction!queryPageById?pageId="+pageId,function(data){
		var page = data.page;
		var isList = page.isList;
	

		$("#index3-news-header").append("<span class='part-name'>&nbsp;"+page.pageTitle+"</span>");
		
		if(isList == 1){
			$.getJSON("pageAction!queryPagesByUpperPage?upperPage="+pageId,function(data){
				var pageList = data.pageList;
				$("#index3-newsContent").append("<br/><br/><table id='pageList' style='float:left;margin-left:20px;margin-bottom:20px;width:600px'></table>");
				
				$.each(pageList,function(i){
						var pageTitle = pageList[i].pageTitle;
						var id = pageList[i].pageId;
			            var tbl = document.getElementById('pageList');   
			            var row = tbl.insertRow(0);   
			         
				        row.insertCell(0).innerHTML=""+
			            	"<img src='../icons/point.jpg' width='8' height='8' />";
				        row.insertCell(1).innerHTML=""+
			            	"<span class='index2-right-title'><a href='page.jsp?pageId="+id+"' target=_blank>&nbsp;"+pageTitle+"</a></span>";
				});
			});
		}
		else{
			if(page.pageContent==null){
				$("#index3-newsContent").append("</br></br><p>该信息正在更新…………</p></br></br>");
			}else{
				$("#index3-newsContent").append("</br></br>"+page.pageContent+"</br></br></br></br>");
			}
			
			
		}

	});



	

});