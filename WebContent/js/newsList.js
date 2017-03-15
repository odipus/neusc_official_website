
$(document).ready(function(){
	
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
	$.ajaxSetup ({cache: false});
	//进入二级页面的链接形式为newsList.jsp?id=10002&page=1
	var page = str.substring(str.length,str.lastIndexOf ('page=')+5);
	var id = str.substring(str.indexOf('id=')+3,str.indexOf('&'));

	
			displayNotice();
			displayPic();	
			//公告和普通section的二级页面略有不同
			if(id==10001){
				displayNoticeList(page);
			}
			else{
				displayNewsList(id);
			}
			
		

/*显示二级页面左边第一个div的内容（现固定为动态新闻）*/		
		function displayNotice(){
		$.getJSON("newsAction!queryNoticeBySectionId?sectionId="+id+"&page=1&size=5",function(data){
			var newslist = data.newsList;
			$("#index2-announcement").append("<marquee id='announcement' onmouseover='announcement.stop()' onmouseout='announcement.start()' scrollAmount=1 scrollDelay=1 direction=up width=180px height=140px></marquee>");
			if(newslist.length==0){
				var newsDisplay = document.createElement('span');
				newsDisplay.className = "announcement-title";
				newsDisplay.innerHTML="<a>暂无最新公告……</a>"
				$("#announcement").append(newsDisplay);
			}
			$.each(newslist,function(i){
				newsTitle[i] = newslist[i].newsTitle;
				newsDate[i] = newslist[i].newsDate;
				newsHtmlPath[i] = "newsContent.jsp?newsId="+newslist[i].newsId;
				displaySideNotice(i);			
			});					
		});	
		}
		function displaySideNotice(i){
			var newsDisplay = document.createElement('span');
			newsDisplay.className = "announcement-title";
			newsDisplay.innerHTML="<a href="+newsHtmlPath[i]+">"+newsTitle[i]+"("+newsDate[i].substring(5,10)+")</a>"
			$("#announcement").append(newsDisplay);
		}
		
		
/*显示二级页面左边第二个div的内容（该栏目的图片新闻）*/	
		function displayPic(){

			$.getJSON("newsAction!queryPicturenewsBySectionId?sectionId="+id+"&page=1&size=5",function(data){
				var list = data.newsList;
				if(data.newsList.length==0){
					$("#picRonud_list").append("<p style='margin-top:20px; text-align:center;'>暂无图片新闻……</p>"); 
				}
				$.each(list,function(i){
					picNewsTitle[i] = list[i].newsTitle;
					picPath[i] = list[i].picPath;
					picNewsId[i] = list[i].newsId; 
					picNewsSectionId[i] = list[i].section.sectionId;
					picNewsPath[i] = "newsContent.jsp?newsId="+picNewsId[i];
					newsHtmlPath[i] = list[i].newsHtmlPath;
					displayPicturenews(i);
				});	

			});
		}
		function displayPicturenews(i){	
				$("#picRound_ul").append("<li>"+(Number(i)+Number(1))+"</li>");
				$("#picRonud_list").append("<a href="+picNewsPath[i]+" target='_blank'><img  src ='data:image/png;base64,"+newsHtmlPath[i]+"' height='150px' width='206px' title="+picNewsTitle[i]+" alt=' '/></a>"); 		
		}
          
			
		
		
	
		
/*显示二级页面右面主要部分的所有新闻列表*/
		function displayNewsList(id){
			var section;
	
			$.getJSON("sectionAction!querySectionById?sectionId="+id,function(data){
				section = data.section;
				$("#index2-right-header").append("<span class='part-name'>"+section.sectionName+"--新闻列表</span>");
				$("#newsContent-Guide").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前位置：<a href='../index.jsp' class='commonLink'>首页</a>&nbsp;&gt;&nbsp;<a href='#'>"+section.sectionName+"</a>&nbsp;&gt;&nbsp;新闻列表</p>");	
				
					$.getJSON("newsAction!queryNewsBySectionId?sectionId="+id+"&page="+page+"&size=12",function(data){
						var newslist = data.newsList;
						$.each(newslist,function(i){
							newsTitle[i] = newslist[i].newsTitle;
							newsDate[i] = newslist[i].newsDate;
							newsClick[i] = newslist[i].newsClick;
							newsHtmlPath[i] = "newsContent.jsp?newsId="+newslist[i].newsId;
							
							displayNewsListDetail(i);
							
							
						});
						$.getJSON("newsAction!queryNewsAmountBySectionId?sectionId="+id,function(data){
							var prepage = Number(page)-Number(1);
							var propage = Number(page)+Number(1);
							var newsAmount = data.newsAmount;
							if(prepage<1)prepage=1;
							if(propage>Math.ceil(newsAmount/11))propage=Math.ceil(newsAmount/11);
							
							$("#newsContent-Page").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共"+newsAmount+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newsAmount/12)+" 页" +
									"&nbsp;&nbsp;<a href='newsList.jsp?id="+id+"&page=1'>首页</a>  <a href='newsList.jsp?id="+id+"&page="+prepage+"'>上一页</a>  <a href='newsList.jsp?id="+id+"&page="+propage+"'>下一页</a>  <a href='newsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/12)+"'>尾页</a> </p>");	
						});
					});
				
				
			});
			
			function displayNewsListDetail(i){
				var title = newsTitle[i];
				if(newsTitle[i].gblen()>55)
					title=newsTitle[i].gbtrim(55, '…');
	            var tbl = document.getElementById('index2-right-table');   
	            var row = tbl.insertRow(i);   
	            var cell = row.insertCell(0);   
	            cell.innerHTML=""+
				"<img src='../icons/point.jpg' width='5' height='5' />"+
				"<span class='index2-right-title'><a title="+newsTitle[i]+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+title+"</a></span>";  
	            var cell1 = row.insertCell(1);   
	            cell1.innerHTML="<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;&nbsp;</font>"; 
	            var cell2 = row.insertCell(2);   
	            cell2.innerHTML="<font color='#585858'>["+newsDate[i].substring(0,10)+"]</font>"; 
		    							
			}	

		}
		
		
		
		function displayNoticeList(page){
		
			$("#index2-right-header").append("<span class='part-name'>最新公告--新闻列表</span>");
			$("#newsContent-Guide").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前位置：<a href='../index.jsp'>首页</a>&nbsp;&gt;&nbsp;<a href=''>最新公告</a>&nbsp;&gt;&nbsp;新闻列表</p>");			
		
			$.getJSON("newsAction!queryNotice?page="+page+"&size=12",function(data)
			{
				var newslist = data.newsList;
				$.each(newslist,function(i){
					newsTitle[i] = newslist[i].newsTitle;
					newsDate[i] = newslist[i].newsDate;
					newsSectionName[i] = newslist[i].section.sectionName;
					newsClick[i] = newslist[i].newsClick;
					newsHtmlPath[i] = "newsContent.jsp?newsId="+newslist[i].newsId;
					
					displayNoticeListDetail(i);		
				});
				$.getJSON("newsAction!queryNoticeAmount",function(data){
					var prepage = Number(page)-Number(1);
					var propage = Number(page)+Number(1);
					var newsAmount = data.newsAmount;
					if(prepage<1)prepage=1;
					if(propage>Math.ceil(newsAmount/12))propage=Math.ceil(newsAmount/12);
					
					$("#newsContent-Page").append("<p class='commonLink'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共"+newsAmount+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newsAmount/12)+" 页" +
							"&nbsp;&nbsp;<a href='newsList.jsp?id="+id+"&page=1'>首页</a>  <a href='newsList.jsp?id="+id+"&page="+prepage+"'>上一页</a>  <a href='newsList.jsp?id="+id+"&page="+propage+"'>下一页</a>  <a href='newsList.jsp?id="+id+"&page="+Math.ceil(newsAmount/12)+"'>尾页</a> </p>");
				});
			});	
			

			
		}
		function displayNoticeListDetail(i){

			
			var title = newsTitle[i];
			if(newsTitle[i].gblen()>45)
				title=newsTitle[i].gbtrim(45, '…');
            var tbl = document.getElementById('index2-right-table');   
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