<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>俱乐部</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet" />
<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>




		
<%-- 	
<script type="text/javascript" src="<%=basepath%>/js/swfobject.js"></script>
	<script type="text/javascript">
		var flashvars = {};   
		var params = {};   
		params.quality = "high";   
		params.bgcolor = "#473686";   
		params.play = "true";   
		params.loop = "false";   
		params.scale = "showall";   
		params.menu = "false";   
		params.devicefont = "false";   
		params.salign = "";   
		params.allowscriptaccess = "sameDomain";   	  
		params.wmode = "Opaque";
		swfobject.embedSWF("flash/header-flash.swf", "header-flash", "1024px", "137px", "9.0.0", "expressInstall.swf",flashvars,params);
		</script> --%>
		
<style>
div.department-index-container{
	text-align:left;
	width:1024px;
	margin:0 auto;
	background-image:url('../images/index-bg.png');
	background-repeat: repeat;

	}
div#department-title{
	padding-left:10px;
	float:left;
	width:190px;
	height:36px;
}
div.department-menu-line{
	float:left;
	width:4px;
	height:36px;
}


div#department-left{
	text-align:left;
	clear:both;
	width:208px;
	height:auto;
	overflow: hidden;

    }
div#department-right{
	border:1px solid #A8A8A8;
	height:100%;
	border-right:0px;
	border-bottom:0px;
	}
div#department-right-header{
	width:776px;
	height:28px;
	background-image:url('../images/department-right-header.png');
	}
div#department-right-content{
	width:740px;;
	height:503px;
	border:1px solid #A8A8A8;
	border-top:0px;
	border-left:0px;
	float:left;
	background-color:white;
	}
div#department-right-content-area{
	width:680;
	height:100%;
	margin-left:30px;
	overflow:hidden;
}
div.department-side{
	
	width:206px;
	height:320px;
	border:1px solid #A8A8A8;
	background-color:white;
	
}
div.department-side-pic{
	
	width:206px;
	height:210px;
	border:1px solid #A8A8A8;
	background-color:white;
	
}
div.department-side-header{
	text-align:left;
	width:206px;
	height:28px;
	background-image:url('../images/department-side-header.png');
	}
div.department-side-content{

	text-align:left;
	width:206px;
	height:100%;
	line-height:20px;
	overflow:hidden;

	}

div.department-side-line{
	width:206px;
	height:5px;
	background-image:url('../images/index-side-line.png');
	background-repeat: repeat-x;
	}
div.department-side-bottom{
	vertical-align:middle;
	height:25px;
	margin-left:130px;
	margin-top:20px;
	line-height:25px;
	position:relative;
	}
	
/*重写部分menu的css*/
	div#menu {
    background: url('../images/department-menu-bg.png');
	background-repeat: repeat-x; 
    width:1024px;
    height:36px;
    border:0px;
    padding:0px;
    margin:0px;
    z-index:1;
    }
    div#menu-blank{
	width:40px;
	float:left;
	background-repeat: repeat-x; 
	background: url('../images/department-menu-bg.png');
    height:36px;
	}
	div#menu ul.menu {
    padding-right: 3px;  
	background: url('../images/department-menu-bg.png') right 0;
	background-repeat: repeat-x; 
    }
    div#menu a {
    padding: 0 10px 0 0;
    line-height: 34px;
    height: 36px;
    margin-right: 5px;
    _margin-right: 1px;
    background: none;
    text-transform: uppercase;
    position: relative;
    z-index: 10;
    display: block;
    float: left;
    line-height: 36px;
    text-decoration: none;
    margin-top: 1px;
    white-space: nowrap;
    width: auto;
    padding-right:2px;
    text-align:center;
   }
    div#menu span {
    margin-top: 2px;
    padding-left: 5px;
    color: #fff;
    font: normal 13px;
    background: none;
    line-height: 36px;	
    display: block;
    cursor: pointer;
    text-align: center;
}
	div#menu ul.menu>li:hover>a span {
	 color:#3f127b;
}
 /*   重写部分header的css */
    div#header-line{
	width:1024px;
	height:8px;
	float:left;
	background-image:url('../images/department-header-line.png');
	background-repeat: no-repeat;
	display:inline; 
}
div#header-login{
	height:28px;
	width:983px;
	float:right;
	border: 1px solid #A8A8A8;
	border-right:0px;
	border-top:0px;
	border-bottom:0px;
	vertical-align:middle; 
	line-height:24px;
	border-bottom:1px;
	background-image:url('../images/department-login-bg.jpg');
	background-repeat: repeat-x; 
	display:inline; 
	}
	/*重写banner的css*/
	p.banner2 a:link{
	color:#554590;
	font-family:黑体;
	font-weight: bold; 
	}
	p.banner2 a:visited{
	color:#554590;
	font-family:黑体;
	font-weight: bold; 
	}
	p.banner2 a:active{
	color:#554590;
	font-family:黑体;
	font-weight: bold; 
	}
	div#banner-line {
    background-image: url("../images/department-banner-line.png");
    background-repeat: repeat-x;
    float: left;
    height: 5px;
    left: 40px;
    position: relative;
    width: 952px;
}



div#department-title span{
    display:inline;
    font-family:"黑体";
    font-size:18px;
    font-weight:600;
    letter-spacing: -0.3mm;
}

/*部门业常用文字样式*/
span.department-title-1{
    display:block;
    font-family:"黑体";
    font-size:25px;
    font-weight:bold;
    line-height:70px;
    text-align: center;
    color:#1b2c7a;
}

	div#galScroll{
		width:200px;
		height:100%;
	}
	div#galScroll img{
		width:200px;
		height:140px;
	}


</style>
</head>

<body>

	

    <div class="department-index-container">
	<div id="header-container">
	<!-- container begin -->
		<div id="header">
		<!-- header begin -->
			<div id="logo">
			<!-- logo begin -->
				<img src="<%=basepath%>/images/department-header-logo.png">
			</div>
			<!-- logo end -->
			<div id="swc">
			<!-- swc begin -->
				&nbsp;&nbsp;<img src="<%=basepath%>/images/department-header-title.png">
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
			<div id="department-title"><span>IBM技术俱乐部</span></div>
			<div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		    <ul class="menu">
		       <li><a id="menuIndex" class="parent"><span>首页</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a id="menuDuty" class="parent"><span>俱乐部简介</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a id="menuTeach" class="parent"><span>人员组成</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a id="menuNews" class="parent"><span>新闻动态</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a href="<%=basepath%>/index.jsp" class="parent"><span>返回学院网站</span></a></li>  
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>        
		    </ul>
		</div>
		<!-- menu end -->
		<div id="header-flash">
			<img src="<%=basepath%>/images/department-flash.png">
		</div>
		<div id="header-line"></div>
		
		<div id="header-login">
			<table width="980px">
				<tr>
					<td width="40px"></td>
					<td><span class="header-login">用户名：</span>
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
					</td>
					<td width="150px"></td>
					<td><span class="header-login-info">总访问量为：12345</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><span class="header-login-info"> <%@include file="date.jsp"%></span>&nbsp;&nbsp;</td>
				</tr>
			</table>				
		</div>
		<div id="header-line2"></div>	
	</div>
	<!-- container end -->



	
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="40px"></td>
			<td>
				<div id="department-left">
				<div class="department-side">
		  			<div class="department-side-header"><span class='part-name'>最新动态</span></div>
		  			<div class="department-side-line"></div>
		  			<div id="department-side1" class="department-side-content"></div>
		  		</div>
		  		<div class="department-side-pic">
		  			<div class="department-side-header"><span class='part-name'>图片新闻</span></div>
		  			<div class="department-side-line"></div>
		  			<div id="department-side2" class="department-side-content">
		  					
		  			</div>
		  		</div>	
				</div>
			</td>
			<td>
				<div id="department-right">
				<div id="department-right-header"><span class='part-name'>俱乐部简介</span></div>
				<div id="department-right-content">
					<div id="department-right-content-area">
								<span class="department-title-1">IBM技术俱乐部</span>
								
					
					
					</div>
				
					
				</div>
				</div>
			</td>
	
		</tr>
	</table>
	<jsp:include page="banner.jsp" />
	</div>
	
</body>


</html>

