<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院</title>
<link rel="shortcut icon" href="<%=basepath%>/icons/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/style.css" rel="stylesheet">

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/superfish.css" media="screen">
<script type="text/javascript" src="../js/hoverIntent.js"></script>
<script type="text/javascript" src="../js/superfish.js"></script>
<script src="<%=basepath%>/js/jquery.easing-1.3.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/newsList.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/jquery.slide-0.4.3.js" type="text/javascript"></script>

	
<style>
	
div.index-side{
	width:206px;
	height:220px;
	border:1px solid #A8A8A8;
	background-color:white;	
}
div.index-side-header{
	text-align:left;
	width:206px;
	height:28px;
	background-image:url('../images/index-side-header.png');
	}
div.index-side-content{
	text-align:left;
	width:206px;
	height:169px;
	line-height:20px;
	overflow:hidden;
}
div.index-side-line{
	width:206px;
	height:5px;
	background-image:url('../images/index-side-line.png');
	background-repeat: repeat-x;
}
div.index-side-bottom{
	vertical-align:middle;
	height:35px;
	margin-left:130px;
	line-height:35px;
	position:relative;
}
marquee#announcement{
	float:left;
	margin-top:10px;
	position:relative;
	
	_margin-top:10px;
	 height:140px;
	 width:180px;
}
	
</style>
<style type="text/css"> 
#picRonud {position:relative; width:207px; height:180px; overflow:hidden; font-size:13px} 
#picRonud_list img {border:0px;} 
#picRonud_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=10);opacity:0.1;z-index:1000;cursor:pointer; width:205px; } 
#picRonud_info{display:block;
position:absolute; bottom:2px; left:5px;height:25px;color:#fff;z-index:1001;cursor:pointer} 
#picRonud_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;} 
#picRonud ul { position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; z-index:1002; 
margin:0; padding:0; bottom:3px; right:5px; height:25px} 
#picRonud ul li { padding:0 8px; line-height:20px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background-color:#6f4f67;cursor:pointer; margin:0; font-size:13px;} 
#picRonud_list a{position:absolute;} </style> 
</head>


<body>

	<div class="index-container">
	<jsp:include page="header2.jsp" />
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="40px"></td>
			<td>
				<div id="index2-left">
				<div class="index-side">
		  			<div class="index-side-header"><span class='part-name'>最新公告</span></div>
		  			<div class="index-side-line"></div>
		  			<div class="index-side-content" id="index2-announcement"></div>
		  		</div>
		  		<div class="index-side">
		  			<div class="index-side-header"><span class='part-name'>图片新闻</span></div>
		  			<div class="index-side-line"></div>
		  			<div class="index-side-content" id="index2-news">
		  			     
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
						setTimeout(ss,500);
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
				<div id="index2-right">
				<div id="index2-right-header"></div>
				<div id="index2-right-content">
					<div id="newsContent-Guide">
					</div>
					<table id="index2-right-table" width="650px" bgcolor='#F5F6F8'>			
						
					</table>
					<div id="newsContent-Page">
					</div>		
				</div>
				
			</td>
	
		</tr>
	</table>
	<jsp:include page="banner.jsp" />
	</div>

	
</body>


</html>
