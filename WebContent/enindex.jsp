<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/jquery.js" type="text/javascript"></script>
<link href="<%=basepath%>/icons/favicon.ico"  rel="shortcut icon" />
<title>Software College of Northeastern University</title>

<link rel="stylesheet" type="text/css" href="css/engNews.css" /> 
<link rel="stylesheet" type="text/css" href="css/engHeader.css" /> 
<link rel="stylesheet" type="text/css" href="css/engMenu.css" /> 
<link rel="stylesheet" type="text/css" href="css/enindex.css" /> 

</head>

<body>

<div id="eng-container">
	<div id="divup">
	<div id="eng-top">
			<div id="eng-rightLink">
			<a class="eng-rightLink"   href="index.jsp">Chinese</a>
			<a class="eng-rightLink"   href="jsp/engPage?pageId=1003">Contact Us</a>
			</div>
			<div style="width:200px;display:inline;float:right;padding-top:10px;padding-right:280px;"><span style="color:#ffffff;font-family:Times New Roman;font-weight: bold;font-size:15px;">
			<script language="javascript"> 
				function PageDate(){   
					currentDate = new Date();  
					with(currentDate){   
						var day=getDay();
						var month=getMonth()+1;
						var engMonth = '';
						
						if(month==1){engMonth="January";}
						if(month==2){engMonth="February";}
						if(month==3){engMonth="March";}
						if(month==4){engMonth="April";}
						if(month==5){engMonth="May";}
						if(month==6){engMonth="June";}
						if(month==7){engMonth="July";}
						if(month==8){engMonth="August";}
						if(month==9){engMonth="September";}
						if(month==10){engMonth="October";}
						if(month==11){engMonth="November";}
						if(month==12){engMonth="December";}
						
						
						this.document.write(engMonth+' '+getDate()+','+getFullYear()+'   ') ;  
					}  
					
					if(day==1){document.write(' Monday');}
					if(day==2){document.write(' Tuesday');}
					if(day==3){document.write(' Wednesday');}
					if(day==4){document.write(' Thursday');}
					if(day==5){document.write(' Friday');}
					if(day==6){document.write(' Saturday');}
					if(day==0){document.write(' Sunday');} 
				}
				PageDate();
			</script>
			</span></div>
	</div>
		</div>
		
  <div id="menu">
      <ul class="menu">
        <li><a href="enindex.jsp"><span style="font-size:17px;">Home</span></a></li>
          <li><a href="jsp/engPage.jsp?pageId=1001" ><span style="font-size:17px;">About</span></a></li>
          <li><a href="jsp/engFaculties.jsp"><span style="font-size:17px;">Faculty</span></a></li>
          <li><a href="jsp/engMajor.jsp"><span style="font-size:17px;">Major&Courses </span></a></li>
          <li><a href="jsp/engNewsList.jsp?id=1001&page=1"><span style="font-size:17px;">News&Events</span></a></li>
          <li><a href="jsp/engNewsList.jsp?id=1002&page=1"><span style="font-size:17px;">International Cooperation</span></a></li>
          <!--<li><a href="jsp/engAdmissions.jsp"><span style="font-size:17px;">Admission</span></a></li>-->
		  <li><a href="jsp/engPage?pageId=1015"><span style="font-size:17px;">Admission</span></a></li>
		  
      </ul>
  </div>

	<div id="eng-body">
		<div id="picturenews-content" style=" width: 480px; height:350px; z-index:3; float:left; margin-left:25px; margin-top:30px;">							
							<jsp:include page="html/engpicNews.jsp"></jsp:include>
		</div>
		<div id="eng-news">
			<span style="display:block;float:left;margin-left:20px;color:#3892c2;font-weight:bold;font-family:Microsoft Sans Serif;font-size:22px" title="TOP NEWS">TOP NEWS</span>
			<!--<a id="pointMore" style="float:right;color:#84abda;font-family:微软雅黑;font-size:13px;padding-top:8px;" title="More">More</a>-->
			<div id="eng-more" style="float:right">
			
			<a href="jsp/engTopNewsList.jsp?id=1003&page=1" >
						<img border="0" src="images/eng-more1.png">
					</a>
			</div>
			
			<div id="line"></div>
			<div id="eng-news-content">
		
			</div>
			
			
			<div id="detail" style="float:right">
			   <a id="pointMore">
					<p color="blue"> detail</p>
				</a>
			</div>
		</div>

		<div id="eng-red">
			
			<div id="eng-red-right">
				<div id="eng-red-more">
					<a href="jsp/engNewsList.jsp?id=1002&page=1" >
						<img border="0" src="images/eng-more.png">
					</a>
				</div>
				<p style="color:#3892C2;font-size:18px;font-family:Microsoft Sans serif;">INTERNATIONAL COOPERATION</p>
				
				<hr style="float:left;width:99%;color:#136581"/><br/>
				
				<ul id="international" style="margin-left:15px;">
						<table width="450px"  id="engtableInter">			
							<tbody>
							</tbody>
						</table>
				 </ul>
				<!--<div id="engPage-news">
					<p id="engPage-newsTitle"></p>
					<p id="engPage-newsInfo"></p>
					<div id="engPage-newsContent">	
					
						<table width="650px" bgcolor="#F5F6F8" id="engtableInter">			
							<tbody>
							</tbody>
						</table>
						<div id="englist-Page">
						
						</div>
				</div> -->
				
				
 			</div>
			<div id="eng-red-left">
				<div id="eng-red-more">
					<a href="jsp/engNewsList.jsp?id=1001&page=1" >
						<img border="0" src="images/eng-more.png">
					</a>
				</div>
				<div id="eng-red-left-line "></div>
				<p style="color:#3892C2;font-size:18px;font-family:Microsoft Sans serif;">NEWS&amp;EVENTS</p>
				<hr style="float:left;width:95%;color:#136581"/><br/>
				
				
				<ul id="events" style="margin-left:15px;">
				<table width="450px"  id="engtable">			
							<tbody>
							</tbody>
						</table>
				</ul>
			</div>
			<!--<div id="eng-search">
				<input name="" type="text" style="width:240px; height:20px; float:left;" />
				<img style="float:right;margin-right:55px"border="0" src="images/eng-search.jpg"/>
			
	    	</div>-->
		</div>
		
	</div>

	<div id="eng-banner">
		
		<div id="eng-banner-text">
			<p style="font-family:华文细黑;color:white;font-size:100%;">
				© Copyright 2013-2014 Software College of Northeastern University.&nbsp; All rights reserved.
			</p>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>		   
<script type="text/javascript" src="js/english.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/engpicnews.js"></script>
</body>
</html>
