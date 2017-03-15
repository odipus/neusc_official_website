$(document).ready(function()
{
	
	var newsTitle = new Array();
	var newsHtmlPath = new Array();
	var newsDate = new Array();
	var newsSectionName = new Array();
	var newsClick = new Array();
	var picNewsTitle = new Array();
	var picPath = new Array();
	var picNewsId = new Array();
	var picNewsSectionId = new Array();
	var picNewsPath = new Array();
	var str   =   window.location.href;
	
	//进入二级页面的链接形式为newsList.jsp?id=10002&page=1
	
	var page = str.substring(str.length,str.lastIndexOf ('page=')+5);
	var id = str.substring(str.indexOf('id=')+3,str.indexOf('&'));
	
			if(id==1003)
			{
				//displayNoticeList(page);
				
				$.getJSON("engNewsAction!queryNotice?page="+page+"&size=12",function(data){
							var newslist = data.engNewsList;
							$.each(newslist,function(i){
								var title = newslist[i].newsTitle;
								if(title.gblen()>55)
									title=title.gbtrim(55, '…');
						        var tbl = document.getElementById('englist-table');   
						        var row = tbl.insertRow(i);   
						        var cell = row.insertCell(0);   
						        cell.innerHTML=""+
								"<img src='../icons/point.jpg' width='5' height='5' />"+
								"<span class='eng-list-title'><a title="+newslist[i].newsTitle+" href='engNews.jsp?newsId="+newslist[i].newsId+"' target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
						        var cell1 = row.insertCell(1);   
						        cell1.innerHTML="<font color='#585858' style='font-size:14px'>["+newslist[i].newsDate.substring(0,10)+"]</font>"; 
							});

						});
						
						$.getJSON("engNewsAction!queryNoticeAmount",function(data)
						{
							var prepage = Number(page)-Number(1);
							var propage = Number(page)+Number(1);
							var newsAmount = data.newsAmount;
							var totalPage=Math.ceil(newsAmount/12)
							if(prepage<1)prepage=1;
							if(propage>Math.ceil(newsAmount/12))propage=Math.ceil(newsAmount/12);
							
							$("#englist-Page").append("&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>&nbsp;&nbsp;" +
									"<span>"+page +"/" + totalPage+"</span>"+
									"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+totalPage+"'><img src='../icons/last.png' /></a> </p>");	
						});
			}
			else
				{
				$.ajaxSetup ({cache: false});
				
				$.getJSON("engNewsAction!queryNewsBySectionId?sectionId="+id+"&page="+page+"&size=12",
						function(data){
							var newslist = data.engNewsList;
							$.each(newslist,function(i){
								var title = newslist[i].newsTitle;
								if(title.gblen()>55)
									title=title.gbtrim(55, '…');
						        var tbl = document.getElementById('englist-table');   
						        var row = tbl.insertRow(i);   
						        var cell = row.insertCell(0);   
						        cell.innerHTML=""+
								"<img src='../icons/point.jpg' width='5' height='5' />"+
								"<span class='eng-list-title'><a title="+newslist[i].newsTitle+" href='engNews.jsp?newsId="+newslist[i].newsId+"' target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
						        var cell1 = row.insertCell(1);   
						        cell1.innerHTML="<font color='#585858' style='font-size:14px'>["+newslist[i].newsDate.substring(0,10)+"]</font>"; 
							});

						});
						
						$.getJSON("engNewsAction!queryNewsAmountBySectionId?sectionId="+id,function(data)
						{
							var prepage = Number(page)-Number(1);
							var propage = Number(page)+Number(1);
							var newsAmount = data.newsAmount;
							var totalPage=Math.ceil(newsAmount/12)
							if(prepage<1)prepage=1;
							if(propage>Math.ceil(newsAmount/12))propage=Math.ceil(newsAmount/12);
							
							$("#englist-Page").append("&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>&nbsp;&nbsp;" +
									"<span>"+page +"/" + totalPage+"</span>"+
									"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+totalPage+"'><img src='../icons/last.png' /></a> </p>");	
						});
				
				}
			
	
			
			
	
	
			
	
	/*function displayNoticeList(page)
	{
		$.getJSON("engNewsAction!queryNotice?page="+page+"&size=12",
		function(data)
		{
		var newslist = data.engNewsList;
		$.each(newslist,function(i)
		{
			var title = newslist[i].newsTitle;
			if(title.gblen()>55)
				title=title.gbtrim(55, '…');
	        var tbl = document.getElementById('englist-table');   
	        var row = tbl.insertRow(i);   
	        var cell = row.insertCell(0);   
	        cell.innerHTML=""+
			"<img src='../icons/point.jpg' width='5' height='5' />"+
			"<span class='eng-list-title'><a title="+newslist[i].newsTitle+" href='engNews.jsp?newsId="+newslist[i].newsId+"' target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
	        var cell1 = row.insertCell(1);   
	        cell1.innerHTML="<font color='#585858' style='font-size:14px'>["+newslist[i].newsDate.substring(0,10)+"]</font>"; 	
	        displayNoticeListDetail(i);		
		 });	
		
			$.getJSON("engNewsAction!queryNoticeAmount",function(data)
			{
					var prepage = Number(page)-Number(1);
					var propage = Number(page)+Number(1);
					var newsAmount = data.newsAmount;
					if(prepage<1)prepage=1;
					if(propage>Math.ceil(newsAmount/12))
						
						propage=Math.ceil(newsAmount/12);
						
					
					//$("#englist-Page").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共"+newsAmount+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newsAmount/12)+" 页" +
						//	"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'>首页</a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'>上一页</a>  <a href='engNewsList.jsp?id="+id+"&page="+propage+"'>下一页</a>  <a href='engNewsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/12)+"'>尾页</a> </p>");
				//	$("#englist-Page").append("&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>&nbsp;&nbsp;" +
				//"<span>"+page +"/" + Math.ceil(newsAmount/12)+"</span>"+
				//"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/12)+"'><img src='../icons/last.png' /></a> </p>");	
					
			});
		});	
			

			
		
	}
	
	
	
	function displayNoticeListDetail(i){

		
		var title = newsTitle[i];
		if(newsTitle[i].gblen()>45)
			title=newsTitle[i].gbtrim(45, '…');
        var tbl = document.getElementById('englist-table');   
        var row = tbl.insertRow(i);  
        
        var cell = row.insertCell(0);   
        cell.innerHTML=""+
		"<img src='../icons/point.jpg' width='5' height='5' /><span class='index2-right-title'>["+newsSectionName[i]+"]"+
		"<span class='index2-right-title'><a title="+newsTitle[i]+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
        var cell1 = row.insertCell(1);   
        cell1.innerHTML="<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;&nbsp;</font>"; 
        var cell2 = row.insertCell(2);   
        cell2.innerHTML="<font color='#585858'>["+newsDate[i].substring(0,10)+"]</font>"; 
	}
	
	
	*/
			
			
			
			
			function displayNewsList(page){
				
				$("#engPage-newsTitle").append("<span class='part-name'>Top Newslist111</span>");
				//$("#engPage-newsInfo").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前位置：<a href='../index.jsp'>首页</a>&nbsp;&gt;&nbsp;<a href=''>最新公告</a>&nbsp;&gt;&nbsp;新闻列表</p>");			
				//$("#englist-Page").append("<p>hhhh</p>);
				$.getJSON("engNewsAction!queryNewsBySectionId?sectionId="+id+"&page="+page+"&size=12",
						function(data)
						{
							var newslist = data.engNewsList;
							$.each(newslist,function(i){
								newsTitle[i] = newslist[i].newsTitle;
								newsDate[i] = newslist[i].newsDate;
								//newsSectionName[i] = newslist[i].section.sectionName;
								newsClick[i] = newslist[i].newsClick;
								newsHtmlPath[i] = "engNews.jsp?newsId="+newslist[i].newsId;
								
								displayNoticeListDetail(i);		
							});
							$.getJSON("engNewsAction!queryNewsAmountBySectionId?sectionId="+id,function(data){
								var prepage = Number(page)-Number(1);
								var propage = Number(page)+Number(1);
								var newsAmount = data.newsAmount;
								var totalPage=Math.ceil(newsAmount/12);
								if(prepage<1)prepage=1;
								if(propage>Math.ceil(newsAmount/12))propage=Math.ceil(newsAmount/12);
							//	$("#englist-Page").append(hhhh);
								
								$("#englist-Page").append("&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>&nbsp;&nbsp;" +
										"<span>"+page +"/" + totalPage+"</span>"+
										"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/12)+"'><img src='../icons/last.png' /></a> </p>");	
								//$("#englist-Page").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newsAmount+" item&nbsp;&nbsp; "+page+"/"+totalPage+" page" +
									//	"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/8)+"'><img src='../icons/last.png' /></a> </p>");
							});	
						});	
					
			
				

				
			}
		function displayNewsListDetail(i){

				
				var title = newsTitle[i];
				if(newsTitle[i].gblen()>45)
					title=newsTitle[i].gbtrim(45, '…');
		        var tbl = document.getElementById('englist-table');   
		        var row = tbl.insertRow(i);  
		        
		        var cell = row.insertCell(0);   
		        cell.innerHTML=""+
				"<img src='../icons/point.jpg' width='5' height='5' /><span class='index2-right-title'>["+newsSectionName[i]+"]"+
				"<span class='index2-right-title'><a title="+newsTitle[i]+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
		        var cell1 = row.insertCell(1);   
		       // cell1.innerHTML="<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;&nbsp;</font>"; 
		        var cell2 = row.insertCell(2);   
		        cell2.innerHTML="<font color='#585858'>["+newsDate[i].substring(0,10)+"]</font>"; 
			}

			
	
function displayNoticeList(page){
		
		$("#engPage-newsTitle").append("<span class='part-name'>Top Newslist111</span>");
		//$("#engPage-newsInfo").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前位置：<a href='../index.jsp'>首页</a>&nbsp;&gt;&nbsp;<a href=''>最新公告</a>&nbsp;&gt;&nbsp;新闻列表</p>");			
		//$("#englist-Page").append("<p>hhhh</p>);
		$.getJSON("engNewsAction!queryNotice?page="+page+"&size=12",function(data)
				{
					var newslist = data.engNewsList;
					$.each(newslist,function(i){
						newsTitle[i] = newslist[i].newsTitle;
						newsDate[i] = newslist[i].newsDate;
						//newsSectionName[i] = newslist[i].section.sectionName;
						newsClick[i] = newslist[i].newsClick;
						newsHtmlPath[i] = "engNews.jsp?newsId="+newslist[i].newsId;
						
						displayNoticeListDetail(i);		
					});
					$.getJSON("engNewsAction!queryNoticeAmount",function(data){
						var prepage = Number(page)-Number(1);
						var propage = Number(page)+Number(1);
						var newsAmount = data.newsAmount;
						var totalPage=Math.ceil(newsAmount/12);
						if(prepage<1)prepage=1;
						if(propage>Math.ceil(newsAmount/12))propage=Math.ceil(newsAmount/12);
					//	$("#englist-Page").append(hhhh);
						
						$("#englist-Page").append("&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>&nbsp;&nbsp;" +
								"<span>"+page +"/" + totalPage+"</span>"+
								"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/12)+"'><img src='../icons/last.png' /></a> </p>");	
						//$("#englist-Page").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newsAmount+" item&nbsp;&nbsp; "+page+"/"+totalPage+" page" +
							//	"&nbsp;&nbsp;<a href='engNewsList.jsp?id="+id+"&page=1'><img src='../icons/first.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+prepage+"'><img src='../icons/pre.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+propage+"'><img src='../icons/pro.png' /></a>  <a href='engNewsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/8)+"'><img src='../icons/last.png' /></a> </p>");
					});	
				});	
			
	
		

		
	}
function displayNoticeListDetail(i){

		
		var title = newsTitle[i];
		if(newsTitle[i].gblen()>45)
			title=newsTitle[i].gbtrim(45, '…');
        var tbl = document.getElementById('englist-table');   
        var row = tbl.insertRow(i);  
        
        var cell = row.insertCell(0);   
        cell.innerHTML=""+
		"<img src='../icons/point.jpg' width='5' height='5' /><span class='index2-right-title'>["+newsSectionName[i]+"]"+
		"<span class='index2-right-title'><a title="+newsTitle[i]+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
        var cell1 = row.insertCell(1);   
       // cell1.innerHTML="<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;&nbsp;</font>"; 
        var cell2 = row.insertCell(2);   
        cell2.innerHTML="<font color='#585858'>["+newsDate[i].substring(0,10)+"]</font>"; 
	}

	
	
	
	
	String.prototype.gblen = function() {   
	    var len = 0;   
	    for (var i=0; i<this.length; i++) {   
	        if (this.charCodeAt(i)>127 || this.charCodeAt(i)==94) {   
	            len += 2;   
	        } else {   
	            len ++;   
	        }   
	    }   
	    return len;   
	}   
	String.prototype.gbtrim = function(len, s) {   
	    var str = '';   
	    var sp  = s || '';   
	    var len2 = 0;   
	    for (var i=0; i<this.length; i++) {   
	        if (this.charCodeAt(i)>127 || this.charCodeAt(i)==94) {   
	            len2 += 2;   
	        } else {   
	            len2 ++;   
	        }   
	    }   
	    if (len2 <= len) {   
	        return this;   
	    }   
	    len2 = 0;   
	    len  = (len > sp.length) ? len-sp.length: len;   
	    for (var i=0; i<this.length; i++) {   
	        if (this.charCodeAt(i)>127 || this.charCodeAt(i)==94) {   
	            len2 += 2;   
	        } else {   
	            len2 ++;   
	        }   
	        if (len2 > len) {   
	            str += sp;   
	            break;   
	        }   
	        str += this.charAt(i);   
	    }   
	    return str;   
	}   

	
});