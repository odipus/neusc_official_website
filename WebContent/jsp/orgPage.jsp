<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet" />
<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">
<link href="<%=basepath%>/css/departmentSubpage.css" rel="stylesheet" type="text/css">

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/orgPage.js" type="text/javascript"></script>


<script type="text/javascript" src="<%=basepath%>/js/swfobject.js"></script>
<script type="text/javascript">
var flashvars = {};   
var params = {};   
params.quality = "high";   
params.bgcolor = "#117390";   
params.play = "true";   
params.loop = "ture";   
params.scale = "showall";   
params.menu = "false";   
params.devicefont = "false";   
params.salign = "";   
params.allowscriptaccess = "sameDomain";   	  
params.wmode = "Opaque";
swfobject.embedSWF("../flash/header-flash3.swf", "header-flash", "1024px", "137px", "9.0.0", "expressInstall.swf",flashvars,params);
</script>
		

</head>
<style>
span.index3-newsContent-Title{
	color:black;
    font-family:"黑体";
    font-size:23px;
    font-weight:400;
    display:block;
    text-align:center;
    line-height:40px;
}
span.index3-newsContent-Content{
	font-family:"宋体";
    font-size:14px;
    line-height:20px;
}
span.index3-newsContent-Info{
	color:#686868;
    font-family:"黑体";
    font-size:14px;
    font-weight:400;
    display:block;
    text-align:center;
    line-height:25px;
}
span.index-newsContent-Editor{
	color:#00008B;
}
div#header{
	width:100%;
	height:69px;
	background-image:url('../images/department-header-bg.png');
	background-repeat: repeat-x; 
	z-index:-1;
	}

</style>

<body>

	

    <div class="department-index-container">
	<div id="header-container">
	<!-- container begin -->
		<div id="header">
		<!-- header begin -->

			<div id="swc">
			<!-- swc begin -->
				&nbsp;&nbsp;<img src="<%=basepath%>/images/header-title2.jpg">
			</div>
			<!-- swc end -->
			<div id="search">
			<!-- search begin -->
				<img src="<%=basepath%>/images/department-header-arrow.png">&nbsp;
				<input type="text" name="search" />&nbsp;&nbsp;
				<img src="<%=basepath%>/images/department-header-search.png">
			</div>
			<!-- search end -->
		</div>
		<!-- header end -->
		
		<div id="menu">
		<!-- menu beign -->
			<div id="menu-blank"></div>
			<div id="department-title"></div>
			<div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		   <ul class="menu">
		       <li><a id="menuIndex" class="parent"><span>首页</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a href="<%=basepath%>/index.jsp" class="parent"><span>返回学院网站</span></a></li>  
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>        
		    </ul>
		</div>
		<!-- menu end -->
		<div id="header-flash">
			
		</div>
		<div id="header-line"></div>
		
		<div id="header-login">
			<table width="980px">
				<tr>
					<td width="463px"></td>
					<%-- <td><span class="header-login">用户名：</span>
					</td>
					<td><input type="text" name="username" size="15"/>&nbsp;&nbsp;
					</td>
					<td><span class="header-login">密码：</span>
					</td>
					<td><input type="text" name="password" size="15" height="50"/>&nbsp;&nbsp;
					</td>
					<td><input type="image" border="0" name="submit" src="<%=basepath%>/images/department-login-button-submit.png" width="40" height="20" >&nbsp;&nbsp;
					</td>
					<td><input type="image" border="0" name="reset" src="<%=basepath%>/images/department-login-button-cancle.png" width="40" height="20">
					</td> --%>
					<td width="320px"></td>
					<%-- <td><span class="header-login-info">总访问量为：12345</span>&nbsp;&nbsp;&nbsp;&nbsp;</td> --%>
					<td><span class="header-login-info"> <%@include file="date.jsp"%></span>&nbsp;&nbsp;</td>
				</tr>
			</table>				
		</div>
		<div id="header-line2"></div>	
	</div>
	<!-- container end -->
		<div id="department2-main">
		<div id="department2-main-header"></div>
		<div id="department2-main-content">
			<div id="department2-main-content-area">
			       
			
			</div>		
		</div>
		</div>
		
	<jsp:include page="banner.jsp" />
	</div>


	
</body>


</html>

