<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<html>
	<head>
	<link href="<%=basepath%>/css/engPage.css" rel="stylesheet" type="text/css">
	<style>
		div#tchPic{
				width:175px;
				height:240px;
			}
			div#tchLeft{
				width:175px;
				height:280px;
				float:left;
				display:block;
			}
			p#tchTitle{
			color:black;
			font-size:14px;	
			display:block;
			font-weight:900;
			font-family:Microsoft Sans serif;" 
			}
			p#tchName{
			color:black;
			font-size:14px;	
			display:block;
			font-weight:400;
			font-family:Microsoft Sans serif;" 
			}
			div#tchInfo{
				width:400px;
				float:left;
				margin-left:20px;
				display:block;

				
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
					<span id="engPage-guide1"> Introduction of teacher &gt;</span>
					<span id="engPage-guide2">&gt;&gt; Print</span>
					<br/>
					<hr/>
				</div>
			
					<p id="engPage-newsTitle"></p>
					<div id="engPage-newsContent">
						<div id="tchLeft">
							<div id="tchPic"></div>
							<p id="tchTitle"></p>
							<p id="tchName"></p>
						</div>
						<div id="tchInfo">

						</div>			
					</div>
					<hr style="display:block;width:800px;"/>
					<br/>
			
			</div>
		
			<jsp:include page="engBanner.jsp" />
		
		</div>
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/engTeacherInfo.js" type="text/javascript"></script>
	</body>
</html>