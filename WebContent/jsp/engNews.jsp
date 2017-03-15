<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<html>
	<head>
	<link href="<%=basepath%>/css/engPage.css" rel="stylesheet" type="text/css">
	<link href="<%=basepath%>/css/engNews.css" rel="stylesheet" type="text/css">


		<title>
		Software College of Northeastern University
		</title>
	</head>
	<body>
		<div id="engPage-container">
			<jsp:include page="engHeader.jsp" />
			<div id="engPage-body">
				<div id="engPage-guide">
					<span id="engPage-guide1">News&gt;</span>
					
					<span id="engPage-guide2" style='text-decoration: none; cursor: hand;'  onmousedown='javascript:print()'>
					<img style="float:right" src="../icons/print.png"></span>
					<br/>
					<hr/>
				</div>
				
				<div id="engPage-news">
					<p id="engPage-newsTitle"></p>
					<p id="engPage-newsInfo"></p>
					<br/>
					<div id="engPage-newsContent">			
					</div>
				
					<div id="index3-download"></div>
					<hr style="width:800px;"/>
					<br/>
					
					
				</div>
			</div>
			
			
		
			<jsp:include page="engBanner.jsp" />
		
		</div>
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/engNews.js" type="text/javascript"></script>
	</body>
</html>