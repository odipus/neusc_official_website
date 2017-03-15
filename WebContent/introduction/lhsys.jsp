<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--联合实验室</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>


	
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
	
	
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="../jsp/header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">联合实验室</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
		
    
            
        
			
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>