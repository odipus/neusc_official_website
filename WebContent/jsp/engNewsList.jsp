<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<html>
	<head>
	 <link href="<%=basepath%>/css/engPage.css" rel="stylesheet" type="text/css">  
	<style>
		.eng-list-title a {
	    color: #5C6979;
	    font-family: Arial,Helvetica,sans-serif;
	    font-size: 14px;
	    line-height:22px;
	    font-weight: 600;
	    letter-spacing: -0.1mm;
	    margin: 0;
	    padding: 0;
		}
		.commonLink {
	    color: black;
	    font-family: Arial,Helvetica,sans-serif;
	    font-size: 13px;
	    line-height:20px;
	    margin: 0;
	    padding: 0;
		}
		.commonLink a{
	    color: black;
	    font-family: Arial,Helvetica,sans-serif;
	    font-size: 13px;
	    line-height:20px;
	    margin-left:10px;
	    padding: 0;
		}
		div#engList-page {
		margin-top:30px;
		width:100%;
		height:20px;
		line-height:20px;
		vertical-align: middle;
		}
	    
	     
	    #engList-page img {
		margin-bottom:-3px;
		margin-left:10px;
		margin-right:10px;
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
					<span id="engPage-guide1">News List&gt;</span>
					<span id="engPage-guide2"></span>
					<br/>
					<hr/>
				</div>
				
				
				
				
				<div id="engPage-news">
					<p id="engPage-newsTitle"></p>
					<p id="engPage-newsInfo"></p>
					<div id="engPage-newsContent">	
					
						<table id="englist-table"width="650px" bgcolor="#F5F6F8" >			
							<tbody>
							</tbody>
						</table>
						<div id="englist-Page">
						
						</div>
				</div>
					<hr style="width:800px;"/>
					<br/>
				</div>
			</div>
			
			
			<!-- <div id="index2-right">
				<div id="index2-right-header"></div>
				<div id="index2-right-content">
					<div id="newsContent-Guide">
					</div>
					<table id="index2-right-table" width="650px" bgcolor='#F5F6F8'>			
						
					</table>
					<div id="newsContent-Page">
					</div>		
				</div>    -->
			
			
			
		
			<jsp:include page="engBanner.jsp" />
		
		</div>
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/engNewsList.js" type="text/javascript"></script>

	</body>
</html>