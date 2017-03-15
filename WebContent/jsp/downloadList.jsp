<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

<script src="<%=basepath%>/js/download.js" type="text/javascript"></script>

	
	<style>
	span.title1 {
    color: #1B2C7A;
    display: block;
    font-family: "黑体";
    font-size: 25px;
    font-weight: bold;
    line-height: 70px;
    text-align: center;
}
	p.info{
	
    display: block;
    font-family: "楷体";
    font-size: 18px;
    line-height: 30px;
  
	}
	
	a.downLink{
	color: #1B2C7A;
	 display: block;
     font-family: "楷体";
     font-size: 18px;
	 margin-right:10px;
	 margin-left:10px;
	 margin-top:10px;
	 display:block;
	 float:left;

	}
	#downSelect{
		display:inline;
	}
	div#docList{
	    margin-left:40px;
		width:100%;
		height:270px;
	}
	div#docPage{
		height:20px;
		
		
	}
	div#index3-newsContent{
		margin-left:40px;
	}
	span.index2-right-title{
		margin-left:10px;
	}
	  
	#download-table td{
		BORDER-BOTTOM: #CCC 1px dashed;
	}
	#docList-table td{
		BORDER-BOTTOM: #CCC 1px dashed;
	}
	#docList-table{
		margin:0px;
		padding:0px;
	
	}
	
	</style>
	  
		<SCRIPT TYPE="text/javascript">
		 $(function() {
			  
			   
			    $('#downSelect').change(
			      function() {
			      
			    	top.location = $(this).val();
			        return false;
			      });
		 });
		
		/* 	function dropdown(mySel)
			{
			var myWin, myVal;
			myVal = mySel.options[mySel.selectedIndex].value;
			if(myVal)
			   {
			 
			   top.location = myVal;
			   }
			return false;
			} */
			
		</SCRIPT>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="header2.jsp" />


	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">资源下载</span></div>
		<div id="index3-news-content">
 	
			<div id="docList" style="margin-top:20px;">
				<span class="downSelect"  >常用资料下载：</apan>	
				<table id='docList-table' width='820px' top="250px" bgcolor='#F5F6F8'></table>
					
			</div>
			<div id="docPage"></div>	
				
				<div id="index3-newsContent">
				<br/>
				<span class="downSelect"  >按类别查看新闻附件：</apan>			
				<select id="downSelect" name="downList">	
				<option value="downloadList.jsp?page=1&sec=all">全部</opstion>				
				</select>	
				<br/>	
				<table id='download-table' width='820px' bgcolor='#F5F6F8'></table>
				</div>
			</div>
		</div>

			
	<jsp:include page="banner.jsp" />
</div>
	
</body>


</html>