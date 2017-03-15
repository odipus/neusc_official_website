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

<script src="<%=basepath%>/js/newsContent.js" type="text/javascript"></script>

	<style>
		span{
			font-family: Arial,Helvetica,sans-serif;
    		font-size: 13px;
		}
		p{
			font-family: Arial,Helvetica,sans-serif;
    		font-size: 13px;
		}
p.commonLink a{
	color:black;
}
p.commonLink a:link{
	color:black;
}
p.commonLink a:active{
	color:black;
}
p.commonLink a:visited{
	color:black;
}
		
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>		
			<br/>		
		</div>
		<div id="index3-download">
			
			
			
			
		
			
		</div>
		
	</div>
			
	<jsp:include page="banner.jsp" />
	
</div>

	
</body>


</html>