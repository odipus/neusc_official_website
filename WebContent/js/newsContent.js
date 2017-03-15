
$(document).ready(function(){
/*进入主页三级页面的链接形式为newsContent.jsp?sectionId=10002&newsId=24*/
	var str   =   window.location.href;
	var newsId = str.substring(str.length,str.lastIndexOf ('newsId=')+7);
	

	displayNewsContent(newsId);


		
/*显示三级页面的新闻内容*/
		function displayNewsContent(newsId){
			var section;
			var amount;
			var page;
			var news;
		
			
			$.getJSON("newsAction!queryNews?newsId="+newsId,function(data){
				news = data.news;
				section = data.news.section;
				$("#index3-news-header").append("<span class='part-name'>"+section.sectionName+"--新闻列表</span>");
				$("#newsContent-Guide").append("<p class='commonlink' style='margin-left:40px;'>当前位置：<a href='../index.jsp' class='newsContent-Guide'>首页</a>&nbsp;&gt;&nbsp;<a href='newsList.jsp?id="+section.sectionId+"&page=1' class='newsContent-Guide'>"+section.sectionName+"</a>&nbsp;&gt;&nbsp;新闻内容</p>");			
				if(news.isPicNews==1){
					var newsDisplay = document.createElement('div');
				 	newsDisplay.setAttribute("id", "index3-newsContent");
					newsDisplay.innerHTML=""+
						"<span class='index3-newsContent-Title'>"+news.newsTitle+"</span>"+
						"<span class='index3-newsContent-Info'>发布者：<span class='newsContent-Editor'>"+news.newsAuthor+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"+news.newsDate.substring(0,10)+"&nbsp;"+news.newsDate.substring(11,16)+"&nbsp;&nbsp;&nbsp;<span class='print' style='text-decoration: none; cursor: hand;'  onmousedown='javascript:print()'><img src='../icons/print.png'>打印</span></span>"+
						"<br/><br/><img style='margin-left:100px' height='300px' width='500px' src ='data:image/png;base64,"+news.newsHtmlPath+"'><br/>"+
						"<span class='index3-newsContent-Content'>&nbsp;&nbsp;&nbsp;&nbsp;"+news.newsContent+"</span>"
					$("#index3-news-content").append(newsDisplay);	
				}else{
					var newsDisplay = document.createElement('div');
				 	newsDisplay.setAttribute("id", "index3-newsContent");
					newsDisplay.innerHTML=""+
						"<span class='index3-newsContent-Title'>"+news.newsTitle+"</span>"+
						"<span class='index3-newsContent-Info'>发布者：<span class='newsContent-Editor'>"+news.newsAuthor+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"+news.newsDate.substring(0,10)+"&nbsp;"+news.newsDate.substring(11,16)+"&nbsp;&nbsp;&nbsp;<span class='print' style='text-decoration: none; cursor: hand;'  onmousedown='javascript:print()'><img src='../icons/print.png'>打印</span></span>"+
						"<br/><br/>"+
						"<span class='index3-newsContent-Content'>&nbsp;&nbsp;&nbsp;&nbsp;"+news.newsContent+"</span>"
					$("#index3-news-content").append(newsDisplay);	
					
				}
				
				if(news.isAttach==1){
					$("#index3-download").append("<span>相关文件下载</span>");
					
					var link=news.attachPath;
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
							$("#index3-download").append("<br/><a href='down.jsp?fname="+flink+"'>"+flink+"</a>");
						}
						

					}
					
				}
			});
			
		}	   

		function daysBetween(DateOne,DateTwo)   
		{   
			var OneYear = DateOne.substring(0,DateOne.indexOf ('年')); 	
		    var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('月'));
		    var OneDay = DateOne.substring(DateOne.length-1,DateOne.lastIndexOf ('月')+1); 
		 
		    var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-')); 
		    var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));   	
		    var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1); 

		    var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);    
		    return Math.abs(cha);   
		} 

	
   
	
});