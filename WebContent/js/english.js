$(document).ready(function(){
	$.ajaxSetup ({cache: false});
	
	var now= new Date();
	var year=now.getFullYear();
	var month=now.getMonth()+1;
	var date=now.getDate();
	var day = now.getDay();
	


	$.getJSON("engNewsAction!queryPoint",function(data){		
		var engNews = data.engNews;
		$("#pointMore").attr("href","jsp/engNews.jsp?newsId="+engNews.newsId);
		$("#eng-news-content").append("<p style='font-size:21px;font-family:Times New Roman;font-weight:bold;'>"+engNews.newsTitle+"</p>");		
		if(engNews.newsContent.gblen()>800)
			var newsContent=engNews.newsContent.gbtrim(800, '…');
			
		else
			var newsContent = engNews.newsContent;

		$("#eng-news-content").append("<br/>"+newsContent);
		
		

	});
	
	
	
	
	$.getJSON("engNewsAction!queryNewsBySectionId?sectionId=1001&page=1&size=5",function(data){
		var newslist = data.engNewsList;
		$.each(newslist,function(i){
		
		
		
		   var title = newslist[i].newsTitle;
			if(title.gblen()>40)
				title=title.gbtrim(40, '…');
			var tbl = document.getElementById('engtable'); 
	        var row = tbl.insertRow(i);   
	        var cell = row.insertCell(0);   
	        cell.innerHTML="<p style='line-height:25px'>"+
			"<img src='../icons/point.jpg' width='5' height='5' />"+
			"<span class='eng-list-title'><a font color='#585858' style='font-size:14px' title="+newslist[i].newsTitle+" href='jsp/engNews.jsp?newsId="+newslist[i].newsId+"' target=_blank>&nbsp;&nbsp;"+title+"</a></span></p>";  
	        var cell1 = row.insertCell(1);   
	        cell1.innerHTML="<font color='#585858' style='font-size:14px'>["+newslist[i].newsDate.substring(0,10)+"]</font>"; 
		});
	});	
	
	
	
	
	$.getJSON("engNewsAction!queryNewsBySectionId?sectionId=1002&page=1&size=5",function(data){
		var newslist = data.engNewsList;
		
		$.each(newslist,function(i){
		
		
		var title = newslist[i].newsTitle;
			if(title.gblen()>42)
				title=title.gbtrim(42, '…');
			var tbl = document.getElementById('engtableInter'); 
	        var row = tbl.insertRow(i);   
	        var cell = row.insertCell(0);   
	        cell.innerHTML="<p style='line-height:25px'>"+
			"<img src='../icons/point.jpg' width='5' height='5' />"+
			"<span class='eng-list-title'><a font color='#5C6979' style='font-size:14px' title="+newslist[i].newsTitle+" href='jsp/engNews.jsp?newsId="+newslist[i].newsId+"' target=_blank>&nbsp;&nbsp;"+title+"</a></span></p>";  
	        var cell1 = row.insertCell(1);   
	        cell1.innerHTML="<font color='#585858' style='font-size:13px'>["+newslist[i].newsDate.substring(0,10)+"]</font>"; 
		//$("#international").append("<br/><li><a style='color:#32304c;font-size:13px;' href='jsp/engNews.jsp?newsId="+newslist[i].newsId+"' title='"+title+"'>"+title+"&nbsp;&nbsp;&nbsp;["+newslist[i].newsDate.substring(0,10)+"]</a> ")
			//$("#international").append("<li><a style='color:#32304c;font-size:13px;' href='jsp/engNews.jsp?newsId="+newslist[i].newsId+"' title='"+newslist[i].newsTitle+"'>"+newslist[i].newsTitle+"</a>");
		});
	});	
	
	
	
	
	
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