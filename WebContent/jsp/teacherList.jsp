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
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

<script src="<%=basepath%>/js/teacherList.js" type="text/javascript"></script> 

	
	<style>
	p.department2-teacher{
		width:750px;
	}
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
    font-family: "楷体";
    font-size: 18px;
    line-height: 30px;
  
	}
	div#index3-news-content-area{
		margin-left:40px;
		width:650px;
	}
	a.tchLink{
	margin-right:10px;
	margin-left:10px;
	margin-bottom:10px;
	float:left; 
	color:black;
	}
	.tchLink a:active{
	margin-right:10px;
	margin-left:10px;
	margin-bottom:10px;
	float:left; 
	color:black;
	}
		}
	.tchLink a:link{
	margin-right:10px;
	margin-left:10px;
	margin-bottom:10px;
	float:left; 
	color:black;
	}
		}
	.tchLink a:visited{
	margin-right:10px;
	margin-left:10px;
	margin-bottom:10px;
	float:left; 
	color:black;
	}
	hr.tchHr{
		width: 820px;
		size:2;
		display:block;
		clear:left;
	}
	
	
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">师资队伍</span></div>
		<div id="index3-news-content">
			<div id="index3-news-content-area">
			
			<div id="newsContent-Guide">
				<p class="commonLink">当前位置：首页&nbsp;&gt;&nbsp;师资队伍</p>
			</div>
			<p><strong>(按姓氏笔画排序)</strong></p>
	
<!-- 			<br>
			<p class="department2-orgTitle"><b>教授</b></p><br>
			<p id="t1" class="department2-teacher">
				<a class="tchLink" href="tchInfo.jsp?tchId=7">朱志良</a>
				<a class="tchLink" href="tchInfo.jsp?tchId=21">杨广明</a>
				<a class="tchLink" href="tchInfo.jsp?tchId=98">周福才</a>
				<a class="tchLink" href="tchInfo.jsp?tchId=75">姜慧研</a>
				<a class="tchLink" href="tchInfo.jsp?tchId=57">徐怀宇</a>
				
			</p><hr class="tchHr"><br><p class="department2-orgTitle"><b>副教授</b></p><br>
			<p id="t2" class="department2-teacher">
			<a class="tchLink" href="tchInfo.jsp?tchId=80">于&nbsp;&nbsp;海</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=4">于瑞云</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=63">代&nbsp;&nbsp;钰</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=77">任&nbsp;&nbsp;涛</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=76">严&nbsp;&nbsp;丽</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=15">张&nbsp;&nbsp;爽</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=17">李丹程</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=11">陈东明</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=41">姜琳颖</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=47">高天寒</a>			
			<a class="tchLink" href="tchInfo.jsp?tchId=20">程&nbsp;&nbsp;维</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=32">韩春燕</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=31">董傲霜</a>


			
			</p><hr class="tchHr"> <br><p class="department2-orgTitle"><b>讲师</b></p><br>
			<p id="t3" class="department2-teacher">
			<a class="tchLink" href="tchInfo.jsp?tchId=34">赵晓丹</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=30">张艳升</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=33">张明卫</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=25">张&nbsp;&nbsp;莉</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=24">杨&nbsp;&nbsp;巍</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=43">徐&nbsp;&nbsp;捷</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=29">吴辰铌</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=35">王&nbsp;&nbsp;爽</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=28">王书睿</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=94">王冬琦</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=23">王蓓蕾</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=19">佟&nbsp;&nbsp;强</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=44">谭振华</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=22">宋&nbsp;&nbsp;航</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=48">那&nbsp;&nbsp;俊</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=65">毛克明</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=42">马&nbsp;&nbsp;毅</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=45">刘&nbsp;&nbsp;莹</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=52">刘洪娟</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=46">刘国奇</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=66">李&nbsp;&nbsp;昕</a>
			<a class="tchLink" href="tchInfo.jsp?tchId=49">李&nbsp;&nbsp;妲</a><a class="tchLink" href="tchInfo.jsp?tchId=16">黄利萍</a><a class="tchLink" href="tchInfo.jsp?tchId=37">宫晓莉</a><a class="tchLink" href="tchInfo.jsp?tchId=39">崔晓莉</a><a class="tchLink" href="tchInfo.jsp?tchId=40">毕&nbsp;&nbsp;佳</a></p><hr class="tchHr"> <br><p class="department2-orgTitle"><b>助教</b></p><br><p id="t4" class="department2-teacher"><a class="tchLink" href="teacherInfo.jsp?tchId=59">朱&nbsp;&nbsp;潜</a><a class="tchLink" href="teacherInfo.jsp?tchId=64">赵建喆</a><a class="tchLink" href="teacherInfo.jsp?tchId=55">徐&nbsp;&nbsp;剑</a><a class="tchLink" href="teacherInfo.jsp?tchId=93">谢&nbsp;&nbsp;青</a><a class="tchLink" href="teacherInfo.jsp?tchId=56">王学毅</a><a class="tchLink" href="teacherInfo.jsp?tchId=53">宋经平</a><a class="tchLink" href="teacherInfo.jsp?tchId=54">石&nbsp;&nbsp;凯</a><a class="tchLink" href="teacherInfo.jsp?tchId=73">孟婷婷</a><a class="tchLink" href="teacherInfo.jsp?tchId=62">刘益先</a><a class="tchLink" href="teacherInfo.jsp?tchId=60">高&nbsp;&nbsp;健</a><a class="tchLink" href="teacherInfo.jsp?tchId=67">邓卓夫</a><a class="tchLink" href="teacherInfo.jsp?tchId=58">陈&nbsp;&nbsp;默</a></p><hr class="tchHr"> 
	 -->
			</div>
		</div>
	</div>
			
	<jsp:include page="banner.jsp" />
</div>

</body>


</html>