<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>软件学院</title>
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
	p.info{
	
       display: block;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 15px;
    line-height: 30px;
  
	}
	
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="../jsp/header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">技术支持</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
			<table style="float:left">
				<tr height="40px">
					<td width="100px"><p class="info">总体设计:</p></td><td width="100px"><p class="info">于瑞云</p></td><td><p class="info">yury@mail.neu.edu.cn</p></td>
				</tr>
				<tr height="40px">
					<td><p class="info">界面设计：</p></td><td><p class="info">谢青</p></td><td><p class="info">xieq@swc.neu.edu.cn</p></td>  
				</tr>
				<tr height="40px">
					<td><p class="info">开发人员：</p></td><td><p class="info">刘睿</p></td><td><p class="info">liurui.transcendent@gmail.com</p></td>
				</tr>
				<tr height="40px">   
				    <td>  </td><td><p class="info">王亚</p></td><td><p class="info">wangyapersonal@gmail.com</p></td>
				</tr>
				<tr height="40px">   
				    <td>  </td><td><p class="info">吕云松</p></td><td><p class="info">1130470023@qq.com</p></td>
				</tr>
				<tr height="40px">   
				    <td>  </td><td><p class="info">姜美薇</p></td><td><p class="info">592807764@qq.com</p></td>
				</tr>
				<tr height="40px">
					<td><p class="info">维护人员：</p></td><td><p class="info">梁臣</p></td><td><p class="info">1589395477@qq.com</p></td>
				</tr>
				
		
			</table>
			<p style="clear:both" class="info">本网站版权归东北大学软件学院所有</p>
	
			
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>