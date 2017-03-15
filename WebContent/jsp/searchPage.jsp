<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>东北大学国家示范性软件学院</title>
<link rel="shortcut icon" href="<%=basepath%>/icons/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/header.css"
	rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css"
	rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/newsList.css"
	rel="stylesheet" />
	
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

strong {
	font-family: Arial, Helvetica, sans-serif;
}

p.text {
	text-indent: 2em;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	line-height: 20px;
	text-align: left;
}

p.events {
	color: #5c6979;
	display: block;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	font-weight: 600;
	line-height: 40px;
	text-align: center;
}

.index2-right-title a {
	color: #5c6979;
	display: block;
	font-family: "黑体";
	font-size: 15px;
	font-weight: 400;
}

.index2-right-title a:visited {
	color: #5c6979;
	display: block;
	font-family: "黑体";
	font-size: 15px;
	font-weight: 400;
}

.index2-right-title a:hover {
	color: #5c6979;
	display: block;
	font-family: "黑体";
	font-size: 15px;
	font-weight: 400;
}

.index2-right-title a:active {
	color: #5c6979;
	display: block;
	font-family: "黑体";
	font-size: 15px;
	font-weight: 400;
}

#pageList td {
	BORDER-BOTTOM: #CCC 1px dashed;
}

#pageList tr {
	height: 35px;
}

.pageTable {
	margin-top: 20px;
	float: left;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
}

p.frendLink {
	font-family: "楷体";
	font-size: 15px;
	font-weight: bold;
}

#linkPic-table tr {
	height: 70px;
}

p.ksLink {
	margin-left: 80px;
	font-family: "黑体";
	font-size: 15px;
	color: #5c6979;
	font-weight: 600;
	line-height: 30px;
}

#pageList td {
	BORDER-BOTTOM: #CCC 1px dashed;
}

span.index2-news-title a:link {
	font-weight: lighter;
}

span.index2-right-title {
	padding: 0px;
	margin: 0px;
	line-height: 25px;
	width: 680px;
	overflow: hidden;
}

#index3-newsContent p {
	text-indent: 2em;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	line-height: 20px;
	text-align: left;
}

p.frendLink {
	font-family: "楷体";
	font-size: 15px;
	font-weight: bold;
}

#linkPic-table tr {
	height: 50px;
}

#linkPic-table td {
	BORDER-BOTTOM: #CCC 1px dashed;
}
</style>

</head>


<body>

	<div id="index3-container">
		<jsp:include page="../jsp/header2.jsp" />

		<div id="index3-news">
			<div id="index3-news-header"></div>
			<div id="index3-news-content">

				<div id="index3-newsContent"></div>

			</div>
		</div>

		<jsp:include page="../jsp/banner.jsp" />
	</div>


	<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=basepath%>/js/page.js" type="text/javascript"></script>
</body>


</html>