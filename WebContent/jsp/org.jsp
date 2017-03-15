<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>学院概况</title>
<link rel="shortcut icon" href="<%=basepath%>/icons/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

<script src="<%=basepath%>/js/org.js" type="text/javascript"></script>

	
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
	
	p.title2{
	color: #1B2C7A;
    display: block;
    font-family: "黑体";
    font-size: 20px;
    font-weight: bold;
    line-height: 70px;
   
	}

	span.index3-newsContent-Title{
		color:black;
	    font-family:"黑体";
	    font-size:23px;
	    font-weight:400;
	    display:block;
	    text-align:center;
	    line-height:40px;
	}
	span.index3-newsContent-Content{
		font-family:"宋体";
	    font-size:14px;
	    line-height:20px;
	}
	span.index3-newsContent-Info{
		color:#686868;
	    font-family:"黑体";
	    font-size:14px;
	    font-weight:400;
	    display:block;
	    text-align:center;
	    line-height:25px;
	}
	span.index-newsContent-Editor{
		color:#00008B;
	}
span.department-title-1 {
    color: #1B2C7A;
    display: block;
    font-family: "黑体";
    font-size: 25px;
    font-weight: bold;
    line-height: 70px;
    text-align: center;
}
	div#index3-newsContent{
	width:700px;;
	min-height:400px;
	display:inline-block;
	text-align: left;

}	
	#orgTable tr{
		height:20px;
		font-family: Arial,Helvetica,sans-serif;
    font-size: 13px;
	}
		p.text{
		text-indent:2em;
		font-family: Arial,Helvetica,sans-serif;
		font-size: 13px;
		line-height: 20px;
		text-align: left;
	}

	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"></div>
		<div id="index3-news-content">
			
			<div id="index3-newsContent">
			
    
            
        
			</div>
		</div>
	</div>
			
	<jsp:include page="banner.jsp" />
</div>
	
</body>


</html>