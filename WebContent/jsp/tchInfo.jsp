<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院---教师个人信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

<script src="<%=basepath%>/js/teacherInfo.js" type="text/javascript"></script>

<style>
span.department-title-1{
    display:block;
    font-family:"黑体";
    font-size:25px;
    font-weight:bold;
    line-height:70px;
    text-align: center;
    color:#1b2c7a;
}
p.department2-teacher{
	front-family:"黑体";
	line-height:20px;
}
img.teacherPic{

	padding:10px;

}
div#teacherInfo-left{
	margin-top:40px;
	margin-left:25px;
	width:200px;
	min-height:400px;

	background-image:url('../images/teacherInfo-bg.jpg');
	background-repeat: no-repeat;
	float: left;	
}
div#teacherInfo-right{
	margin-top:40px;
	margin-left:20px;
	width:520px;
	height:100%;
	float: left;	
}
p.teacherInfo-style1{
 	display:block;
    font-family:"楷体";
    font-size:16px;
    font-weight:bold;
    line-height:30px;
    text-align: left;
    color:#1b2c7a;
    margin-left:20px;
}
div#teacher-area{
	width:820px;
	margin-left:50px;
	overflow:hidden;
	min-height:400px;
	height:auto !important;
	height:100%;
	margin-bottom:20px;
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
		<div id="index3-news-header"><span class="part-name">教师简介</span></div>
		<div id="index3-news-content">	
			<div id="teacher-area">
			<div id="teacherInfo-left">
					<img id="teacherPic" height="240px" width="175px">
					<br/>
					
				</div>
			<div id="teacherInfo-right">
			
			</div>	
			</div>	
		</div>
	
		
	</div>
			
	<jsp:include page="banner.jsp" />
	
</div>

</body>


</html>