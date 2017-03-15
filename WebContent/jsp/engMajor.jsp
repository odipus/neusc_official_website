<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<html>
	<head>
	<link href="<%=basepath%>/css/engPage.css" rel="stylesheet" type="text/css">
	<script src="js/jquery.js" type="text/javascript"></script>
	<style>
		p.degree-class{
			color:black;
			font-size:14px;	
			display:block;
			margin-top:10px;
			margin-bottom:10px;
			font-weight:900;
			font-family:Microsoft Sans serif;" 
		}
		a.degree{
			color:black;
			font-size:13px;	
			margin-left:25px;
			margin-bottom:5px;
			display:inline-block;
			font-family:Microsoft Sans serif;" 
		}
	</style>
		<title>
		Software College of Northeastern University
		</title>
	</head>
	<body>
		<div id="engPage-container">
			<jsp:include page="engHeader.jsp" />
			<div id="engPage-body">
				<div id="engPage-guide">
					<span id="engPage-guide1"> Major and Course &gt;</span>
					<span id="engPage-guide2"></span>
					<br/>
					<hr/>
				</div>
				<div id="engPage-news">
					<p id="engPage-newsTitle"></p>
					<div id="engPage-newsContent">			
					<p class="degree-class">Undergraduate Degree</p>
					<div id="undergraduate">
				
					</div>
					<p class="degree-class">Postgraduate Degree</p>
					<div id="postgraduate">
						
					</div>
					<p class="degree-class">Ph.d.</p>
					<div id="phd">
					
					</div>
					</div>
					<hr style="width:800px;"/>
					<br/>
				</div>
			</div>
		
			<jsp:include page="engBanner.jsp" />
		
		</div>
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/engMajor.js" type="text/javascript"></script>
	</body>
</html>