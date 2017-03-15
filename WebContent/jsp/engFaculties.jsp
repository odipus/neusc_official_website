<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<html>
	<head>
	<link href="<%=basepath%>/css/engPage.css" rel="stylesheet" type="text/css">
	<style>
		p.teacherTitle{
			color:black;
			font-size:14px;	
			display:block;
			font-weight:900;
			font-family:Microsoft Sans serif;" 
		}
		a.teacherName{
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
					<span id="engPage-guide1"> Faculties &gt;</span>
					<span id="engPage-guide2"></span>
					<br/>
					<hr/>
				</div>
				<div id="engPage-news">
					<p id="engPage-newsTitle">Faculties of Software College</p>
					<div id="engPage-newsContent">	
						<p class="teacherTitle">Professor</p>
						<br/>
							<p id="t1">
											
							</p>	
						<hr/>
						<p class="teacherTitle">Associate Professors</p>
							<p id="t2"></p>
						<hr/>
						<p class="teacherTitle">Lecturers</p>
							<p id="t3"></p>
						<hr/>
						<p class="teacherTitle">Assistants </p>
							<p id="t4"></p>
						<hr/>
					</div>
					<hr style="width:800px;"/>
					<br/>
				</div>
			</div>
		
			<jsp:include page="engBanner.jsp" />
		
		</div>
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/engFaculties.js" type="text/javascript"></script>
	</body>
</html>