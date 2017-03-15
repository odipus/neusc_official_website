<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--信息安全</title>
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
		<div id="index3-news-header"><span class="part-name">专业介绍--信息安全</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
			<table>
				<tr height="260px">
				<td width="250px">
					<img src="../upload/teachers/zzl.jpg" height="240px" width="180px">
				</td>
				<td>
					<p class="leader">朱志良</p>
					<p class="leader">东北大学软件学院院长</p>
				</td>
				</tr>
				<tr height="260px">
				<td width="250px">
					<img src="../upload/teachers/chenh.jpg" height="240px" width="180px">
				</td>
				<td>
					<p class="leader">陈欢</p>
					<p class="leader">东北大学软件学院党委书记</p>
				</td>
				</tr>
				<tr  height="260px">
				<td width="250px">
					<img src="../upload/teachers/lvxj.jpg" height="240px" width="180px">
				</td>
				<td>
					<p class="leader">吕兴君</p>
					<p class="leader">东北大学软件学院副院长、党委副书记</p>
				</td>
				</tr>
				
				<tr  height="260px">
				<td width="250px">
					<img src="../upload/teachers/panghj.jpg" height="240px" width="180px">
				</td>
				<td>
					<p class="leader">庞洪江</p>
					<p class="leader">东北大学软件学院副院长</p>
				</td>
				
				</tr>
				
				<tr  height="260px">
				<td width="250px">
					<img src="../upload/teachers/chendm.jpg" height="240px" width="180px">
				</td>
				<td>
					<p class="leader">陈东明</p>
					<p class="leader">东北大学软件学院副院长</p>
				</td>
				</tr>	
				<tr  height="260px">
				<td width="250px">
					<img src="../upload/teachers/yury.jpg" height="240px" width="180px">
				</td>
				<td>
					<p class="leader">于瑞云</p>
					<p class="leader">东北大学软件学院院长助理</p>
				</td>
				</tr>
			</table>
			
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>