<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--学生社团</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

	<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">
	
	<style>
	p.frendLink{
	
    	font-family:"楷体";
    	font-size:15px;
    	font-weight:bold;
 
	}
	#linkPic-table tr{
		height:70px;
	}
	
	</style>
	
</head>


<body>

<div id="index3-container" style="text-align:left">
	<jsp:include page="../jsp/header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">学生社团</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<table id="linkPic-table">
				
				<tr>
					<td width="150">
					<a class="black_bold" target="_blank" href="club.jsp">
							<img height="40" border="0" width="120" src="../linkPic/oracleclub.jpg">
					</a>
					</td>
					<td width="400">
						<a class="black_bold" target="_blank" href="club.jsp">
						<p class="frendLink">甲骨文俱乐部</p>
						</a>
					</td>
				</tr>
				
				<tr>
					<td>
							<a class="black_bold" target="_blank" href="http://www.neu-pioneer.cn">
							<img height="40" border="0" width="120" src="../linkPic/ibmclub.jpg">
							</a>
					
					</td>
					<td>
							<a class="black_bold" target="_blank" href="http://www.neu-pioneer.cn">
							<p class="frendLink">IMB技术俱乐部</p>
							</a>
					
					</td>
				</tr>
				
			</table>	
									
								
								
									
									
								
								
								
									
			<br/>		
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>