<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basepath%>/css/index.css" rel="stylesheet"  type="text/css"/>
<link href="<%=basepath%>/css/newsContent.css" rel="stylesheet"  type="text/css"/>
<link href="<%=basepath%>/css/header.css" rel="stylesheet"  type="text/css"/>
<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">
<link href="<%=basepath%>/css/style.css" rel="stylesheet" type="text/css" >

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/department.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/jquery.easing-1.3.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/jquery.slide-0.4.3.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/swfobject.js"  type="text/javascript"></script>
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
swfobject.embedSWF("../flash/header-flash3.swf", "header-flash-place", "1024px", "137px", "6.0.0", "expressInstall.swf",flashvars,params);
</script>	
		
<style>
div.department-index-container{
	text-align:left;
	width:1024px;
	margin:0 auto;
	background-image:url('../images/department-index-bg.png');
	background-repeat: repeat;

	}
div#department-title{
	padding-left:10px;
	float:left;
	display:inline;
	width:190px;
	height:36px;
}
div.department-menu-line{
	float:left;
	width:4px;
	height:36px;
	display:inline;
}


div#department-left{
	text-align:left;
	clear:both;
	width:208px;
	height:504px;
	overflow: hidden;

    }
div#department-right{
	border:1px solid #A8A8A8;
	height:501px;
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
	height:473px;
	border:1px solid #A8A8A8;
	border-top:0px;
	border-left:0px;
	float:left;
	background-color:white;
	}
div#department-right-content-area{
	width:640px;
	height:100%;
	clear:left;
	margin-left:50px;
	overflow:hidden;
}
div.department-side{
	
	width:206px;
	height:250px;
	border:1px solid #A8A8A8;
	background-color:white;
	over-flow:hidden;
	
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
	height:217px;
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
	float:left;
	display:inline;
	
	}
marquee#announcement{
	float:left;
	margin-top:10px;
	position:relative;
	
	_margin-top:10px;
	 height:140px;
	 width:180px;
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
    line-height:0px;
    z-index:1;
    }
    div#menu-blank{
	width:40px;
	float:left;
	background-repeat: repeat-x; 
	background: url('../images/department-menu-bg.png');
    height:36px;
    display:inline;
	}
	div#menu ul.menu {
    padding-right: 3px;  
	background: url('../images/department-menu-bg.png') right 0;
	background-repeat: repeat-x; 
    }
    div#menu a {
    line-height: 34px;
    height: 36px;
    margin-right:5px;
    text-transform: uppercase;
    position: relative;
    z-index: 10;
    display: inline-block;
    float: left;
    line-height: 36px;
    text-decoration: none;
    white-space: nowrap;
    width: auto;
    text-align:center;
   }
    div#menu span {
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
	 color:#B15BFF;
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
  
    position: relative;
    width: 1024px;
}



div#department-title span{
    display:inline;
    font-family:"黑体";
    font-size:18px;
    font-weight:600;
    letter-spacing: -0.3mm;
}
div#header {
    background-image: url("../images/department-header-bg.png");
    background-repeat: repeat-x;
    height: 69px;
    width: 100%;
    z-index: -1;
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

p.text{
	text-indent:2em;
	font-family: Arial,Helvetica,sans-serif;
	font-size: 13px;
	line-height: 20px;
	text-align: left;
}

#picRonud {position:relative; width:207px; height:180px; overflow:hidden; font-size:13px} 
#picRonud_list img {border:0px;} 
#picRonud_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=20);opacity:0.1;z-index:1000;cursor:pointer; width:205px; } 
#picRonud_info{display:block;
position:absolute; bottom:2px; left:5px;height:25px;color:black;z-index:1001;cursor:pointer} 
#picRonud_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;} 
#picRonud ul { position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; z-index:1002; 
margin:0; padding:0; bottom:3px; right:5px; height:25px} 
#picRonud ul li { padding:0 8px; line-height:20px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background-color:#6f4f67;cursor:pointer; margin:0; font-size:13px;} 
#picRonud_list a{position:absolute;} </style> 
</head>

<body>

	

    <div class="department-index-container">
	<div id="header-container">
	<!-- container begin -->
		<div id="header">
		<!-- header begin -->
			
			<div id="swc">
			<!-- swc begin -->
				&nbsp;&nbsp;<img src="<%=basepath%>/images/header-title2.png">
			</div>
			<!-- swc end -->
			<div id="search">
			<!-- search begin -->
<%-- 				<img src="<%=basepath%>/images/department-header-arrow.png">&nbsp;
				<input type="text" name="search" />&nbsp;&nbsp;
				<img src="<%=basepath%>/images/department-header-search.png"> --%>
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
		        <li><a id="menuDuty" class="parent"><span>机构简介</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a id="menuTeach" class="parent"><span>师资队伍</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a id="menuNews" class="parent"><span>新闻动态</span></a></li>
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>
		        <li><a href="<%=basepath%>/index.jsp" class="parent"><span>返回学院网站</span></a></li>  
		        <div class="department-menu-line"><img src="<%=basepath%>/images/department-menu-line.png"></div>        
		    </ul>
		</div>
		<!-- menu end -->
		<div id="header-flash"><div id="header-flash-place"></div>
			
		</div>
		<div id="header-line"></div>
		
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
		  		<div class="department-side">
		  			<div class="department-side-header"><span class='part-name'>图片新闻</span></div>
		  			<div class="department-side-line"></div>
		  			<div id="department-side2" class="department-side-content">
		  				<div id="picRonud"> 
						<div id="picRonud_bg"></div> 
						<!--标题背景--> 
						<div id="picRonud_info"></div> 
						<!--标题--> 
						<ul id="picRound_ul"> 
					
						
						</ul> 
						<div id="picRonud_list"> 
						
						</div> 
						</div> 
						<script type="text/javascript">// <![CDATA[ 
						var t = n = 0, count; 
						setTimeout(ss,1000);
						function ss(){ 
							count=$("#picRonud_list a").length; 
							$("#picRonud_list a:not(:first-child)").hide(); 
							$("#picRonud_info").html($("#picRonud_list a:first-child").find("img").attr('alt')); 
							$("#picRonud_info").click(function(){window.open($("#picRonud_list a:first-child").attr('href'), "_blank")}); 
							$("#picRonud li").click(function() { 
								var i = $(this).text() - 1;//获取Li元素内的值，即1，2，3，4 
								n = i; 
								if (i >= count) return; 
								$("#picRonud_info").html($("#picRonud_list a").eq(i).find("img").attr('alt')); 
								$("#picRonud_info").unbind().click(function(){window.open($("#picRonud_list a").eq(i).attr('href'), "_blank")}) 
								$("#picRonud_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000); 
								$(this).css({"background":"#be2424",'color':'#000'}).siblings().css({"background":"#6f4f67",'color':'#fff'}); 
							}); 
							t = setInterval("showAuto()", 4000); 
							$("#picRonud").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()", 4000);}); 
						}
						function showAuto() 
						{ 
						n = n >=(count - 1) ? 0 : ++n; 
						$("#picRonud li").eq(n).trigger('click'); 
						} 
						// ]]></script> 
		  			
		  			</div>
		  			</div>
		  		</div>	
			</td>
			<td>
				<div id="department-right">
				<div id="department-right-header"><span class='part-name'>部门简介</span></div>
				<div id="department-right-content">
					<div id="department-right-content-area">
				
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

