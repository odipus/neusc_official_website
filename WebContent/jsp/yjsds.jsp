<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--研究生导师</title>
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
	a.tchLink {
    float: left;
    margin-bottom: 10px;
    margin-left: 20px;
   
        color: black;
    font-family: "黑体";
    font-size: 13px;
    letter-spacing: -0.3mm;
white-space:nowrap;
    text-decoration: none;
	display:inline;
word-break:keep-all;
}

hr.tchHr {
    clear: left;
    display: block;
    size: 2px;
    width: 820px;
}
	
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="../jsp/header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">研究生导师</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
			<br><p class='department2-orgTitle'><b>(按姓氏笔画排序)</b></p>
							<br/><p class='department2-orgTitle'><b>博士生导师</b></p><p id='t1' class='department2-teacher'><br/>
										
					<a class='tchLink' href="tchInfo.jsp?tchId=4">于瑞云</a>	
					<a class='tchLink' href="tchInfo.jsp?tchId=10">王兴伟</a>	
					<a class='tchLink' href="tchInfo.jsp?tchId=7">朱志良</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=77">任&nbsp;&nbsp;涛</a> 
					<a class='tchLink' href="tchInfo.jsp?tchId=98">周福才</a>	
					<a class='tchLink' >张&nbsp;&nbsp;斌</a>	
					<a class='tchLink' >温&nbsp;&nbsp;涛</a>	
					<a href="tchInfo.jsp?tchId=75" class="tchLink">姜慧研</a> 
				</p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t2' class='department2-teacher'><br/>
					<a class='tchLink' href="tchInfo.jsp?tchId=10">王兴伟</a>				
					<a href="tchInfo.jsp?tchId=7" class="tchLink">朱志良</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=100">陈东明</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=17">李丹程</a> 
					<a href="tchInfo.jsp?tchId=21" class="tchLink">杨广明</a>
					<a href="tchInfo.jsp?tchId=98" class="tchLink">周福才</a> 
					<a href="tchInfo.jsp?tchId=107" class="tchLink">郝培锋</a> 
					<a href="tchInfo.jsp?tchId=75" class="tchLink">姜慧研</a> 
				</p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>副教授</b></p><br/>
					<a class="tchLink" >马连博</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=4">于瑞云</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=80">于&nbsp;&nbsp;海</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=63">代&nbsp;&nbsp;钰</a> 
					<a class="tchLink" >刘&nbsp;&nbsp;圆</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=46">刘国奇</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=77">任&nbsp;&nbsp;涛</a> 
					<a class="tchLink" >张&nbsp;&nbsp;伟</a> 
					<a class="tchLink" >张吉良</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=15">张&nbsp;&nbsp;爽</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=68">宋&nbsp;&nbsp;杰</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=41">姜琳颖</a> 
					<a class='tchLink' >郭贵冰</a>		
					<a class="tchLink" href="tchInfo.jsp?tchId=47">高天寒</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=20">程&nbsp;&nbsp;维</a>
					<a class="tchLink" href="tchInfo.jsp?tchId=31">董傲霜</a> 
					<a class="tchLink" href="tchInfo.jsp?tchId=32">韩春燕</a> 	
					<a class="tchLink" href="tchInfo.jsp?tchId=44">谭振华</a> 	
				<hr class='tchHr'/> 
	
				<br/><p class='department2-orgTitle'><b>硕士导师：</b></p>
				<br/><a style="color:black;" href='down.jsp?fname=daoshi.doc'>硕士导师名单.doc</a>
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>