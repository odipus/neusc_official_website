$(document).ready(function(){	
		var sectionsList  = new Array();

	
	
	var newsTitle = new Array();
	var newsSectionName = new Array();
	var newsDate = new Array();
	var newsClick = new Array();
	var newsHtmlPath = new Array();
	var str   =   window.location.href;
	var sectionId = str.substring(str.length,str.lastIndexOf ('sec=')+4);
	var page =  str.substring(str.indexOf('page=')+5,str.indexOf('&'));
	var newslist = new Array();
	var docList = new Array();
	
	$.getJSON("sectionAction!querySectionsNotUpper",function(data){
		sectionsList = data.sectionsList;
			$.each(sectionsList,function(i){
				if(sectionsList[i].sectionId == sectionId)		 
				$("#downSelect").append("<option selected='selected' value='downloadList.jsp?page=1&sec="+sectionsList[i].sectionId+"'>"+sectionsList[i].sectionName+"</option>");	
					else
				$("#downSelect").append("<option value='downloadList.jsp?page=1&sec="+sectionsList[i].sectionId+"'>"+sectionsList[i].sectionName+"</option>");	
			});
	});
	
	$.getJSON("docAction!queryAllDocs",function(data){
		docList = data.docList;
			$.each(docList,function(i){
		
				var title = newsTitle[i];
	
	            var tbl = document.getElementById('docList-table');   
	            var row = tbl.insertRow(i);   
	            var cell = row.insertCell(0);   
		        cell.innerHTML=""+
		           "<span class='index2-right-title'><a title="+docList[i].docName+" href=docDown.jsp?fname="+docList[i].docPath.substring(docList[i].docPath.length,docList[i].docPath.lastIndexOf ('/')+1)+" target=_blank>&nbsp;&nbsp;"+docList[i].docName+"</a></span>";
		        var cell1 = row.insertCell(1);   
		        cell1.innerHTML=""+
		           "&nbsp;&nbsp;&nbsp;<font color='#585858'>(上传时间:&nbsp;"+docList[i].docDate.substring(0,10)+")</font>";
		        var cell2 = row.insertCell(2); 
			});

	});
	$.getJSON("docAction!queryDocsAmount",function(data){
		var Length = data.docsAmount;
		var prepage = Number(page)-Number(1);
		var propage = Number(page)+Number(1);
		if(prepage<1)prepage=1;
		if(propage>Math.ceil(Length/16))propage=Math.ceil(Length/16);
	
		
		$("#docPage").append("<p class='commonLink' style='margin-left:40px'>共"+Length+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(Length/16)+" 页" +
				"&nbsp;&nbsp;<a href='downloadList.jsp?page=1&sec="+sectionId+"'>首页</a>  <a href='downloadList.jsp?page="+prepage+"&sec="+sectionId+"'>上一页</a>  <a href='downloadList.jsp?page="+propage+"&sec="+sectionId+"'>下一页</a>  <a href='downloadList.jsp?page="+Math.ceil(Length/16)+"&sec="+sectionId+"'>尾页</a> </p>");	
		});
	
	if(sectionId=="all"){
		$.getJSON("newsAction!queryAttachedNews?page="+page+"&size=13",function(data){
			newslist = data.newsList;
			$.each(newslist,function(i){
				newsTitle[i] = newslist[i].newsTitle;
				newsSectionName[i] = newslist[i].section.sectionName;
				newsDate[i] = newslist[i].newsDate;
				newsClick[i] = newslist[i].newsClick;

				newsHtmlPath[i] = "newsContent.jsp?sectionId="+newslist[i].section.sectionId+"&newsId="+newslist[i].newsId+"";
				
				var title = newsTitle[i];
			/*	if(newsTitle[i].gblen()>50)
					title=newsTitle[i].gbtrim(50, '…');*/
	            var tbl = document.getElementById('download-table');   
	            var row = tbl.insertRow(i);   
	            var cell = row.insertCell(0);   
		        cell.innerHTML=""+
		           "<span class='index2-right-title'>["+newsSectionName[i]+"]<a title="+title+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+newsTitle[i]+"</a></span>";
		        var cell1 = row.insertCell(1);   
		        cell1.innerHTML=""+
		           "&nbsp;&nbsp;&nbsp;<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")</font>";
		        var cell2 = row.insertCell(2);   
		        cell2.innerHTML=""+
		           "&nbsp;&nbsp;&nbsp;<font color='#585858'>["+newsDate[i].substring(0,10)+"]</font>";
	    	
	    	
				});
			$.getJSON("newsAction!queryAttachedNewsAmount",function(data){
				var newsLength = data.newsAmount;
				var prepage = Number(page)-Number(1);
				var propage = Number(page)+Number(1);
				if(prepage<1)prepage=1;
				if(propage>Math.ceil(newsLength/16))propage=Math.ceil(newsLength/16);
			
				
				$("#index3-news-content").append("<br/><br/><p class='commonLink' style='margin-left:40px'>共"+newsLength+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newsLength/16)+" 页" +
						"&nbsp;&nbsp;<a href='downloadList.jsp?page=1&sec="+sectionId+"'>首页</a>  <a href='downloadList.jsp?page="+prepage+"&sec="+sectionId+"'>上一页</a>  <a href='downloadList.jsp?page="+propage+"&sec="+sectionId+"'>下一页</a>  <a href='downloadList.jsp?page="+Math.ceil(newsLength/16)+"&sec="+sectionId+"'>尾页</a> </p>");	
				});
			
			});
			
	
	}else{
		
		$.getJSON("newsAction!queryAttachedNewsBySectionId?page="+page+"&size=13&sectionId="+sectionId,function(data){
			newslist = data.newsList;
			$.each(newslist,function(i){
				newsTitle[i] = newslist[i].newsTitle;
				newsSectionName[i] = newslist[i].section.sectionName;
				newsDate[i] = newslist[i].newsDate;
				newsClick[i] = newslist[i].newsClick;

				newsHtmlPath[i] = "newsContent.jsp?sectionId="+newslist[i].section.sectionId+"&newsId="+newslist[i].newsId+"";
				
				var title = newsTitle[i];
			/*	if(newsTitle[i].gblen()>50)
					title=newsTitle[i].gbtrim(50, '…');*/
	            var tbl = document.getElementById('download-table');   
	            var row = tbl.insertRow(0);   
	            var cell = row.insertCell(0);   
		        cell.innerHTML=""+
		            "<td height='30' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'></td>"+
					"<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'>["+newsSectionName[i]+"]<a title="+title+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+newsTitle[i]+"</a></span>"+
					"&nbsp;&nbsp;&nbsp;<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;"+
					"["+newsDate[i].substring(0,10)+"]</font>"+ 				
					"</td>";
				
	    	
				});
			
			var prepage = Number(page)-Number(1);
			var propage = Number(page)+Number(1);
			if(prepage<1)prepage=1;
			if(propage>Math.ceil(newslist.length/16))propage=Math.ceil(newslist.length/16);
			
			$("#index3-news-content").append("<br/><br/><p class='commonLink' style='margin-left:40px'>共"+newslist.length+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newslist.length/16)+" 页" +
					"&nbsp;&nbsp;<a href='downloadList.jsp?page=1&sec="+sectionId+"'>首页</a>  <a href='downloadList.jsp?page="+prepage+"&sec="+sectionId+"'>上一页</a>  <a href=''downloadList.jsp?page="+propage+"&sec="+sectionId+"'>下一页</a>  <a href=''downloadList.jsp?page="+Math.ceil(newslist.length/16)+"&sec="+sectionId+"'>尾页</a> </p>");	
			});

		

	}

});
