$(document).ready(function(){
	/*进入介绍页面的链接形式为page.jsp?pageId=1001*/
	var str   =   window.location.href;
	var newsId = str.substring(str.length,str.lastIndexOf ('newsId=')+7);
	$.ajaxSetup ({cache: false});
	$.getJSON("engNewsAction!queryNews?newsId="+newsId,function(data){
		var engNews = data.engNews;
		$("#engPage-newsTitle").append(engNews.newsTitle);
		$("#engPage-newsInfo").append(engNews.newsDate.substring(0,10)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+engNews.newsAuthor);
		if(engNews.isPicNews==1){
			var newsDisplay = document.createElement('div');
		 	newsDisplay.setAttribute("id", "index3-newsContent");
			newsDisplay.innerHTML=""+
				"<img style='margin-left:100px' height='300px' width='500px' src =.."+engNews.picPath+"><br/>"+
				"<span class='index3-newsContent-Content'>&nbsp;&nbsp;&nbsp;&nbsp;"+engNews.newsContent+"</span>"
			$("#engPage-newsContent").append(newsDisplay);	
		}
		else{
		$("#engPage-newsContent").append(engNews.newsContent);
		}
		
		if(engNews.isAttach==1){
			$("#index3-download").append("<span><strong>download</strong></span>");
			
			var link=engNews.attachPath;
			//var name = news.attachName;
			var d = ',';  //用于分隔多个附件
			var n =0;  //用于记录附件字段中有多少哥逗号
			var filelink = link.substring(link.length,link.lastIndexOf ('/')+1);
			
			
			if(link.indexOf(',')==-1){
				$("#index3-download").append("<br/><a href='down.jsp?fname="+filelink+"'>"+filelink+"</a>");						
			}
			else{
				for(i=0;i<link.length;i++){
					  index=d.indexOf(link.charAt(i));
					  if(index==-1){							    
					  }else{n++;}
					}
				
				for(i=0;i<=n;i++){
					if(i==n){
						var flink = filelink.substring(0,filelink.length);								
					}else{
						var flink = filelink.substring(0,filelink.indexOf (','));								
					}							
					filelink = filelink.substring(filelink.indexOf (',')+1,filelink.length);													
					$("#index3-download").append("<br/><br/><a href='down.jsp?fname="+flink+"'>"+flink+"</a>");
				}
				
			}
			
		}
		
	});
	
});