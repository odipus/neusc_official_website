<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<link rel="stylesheet" type="text/css" href="../css/superfish.css" media="screen">
<script type="text/javascript" src="../js/hoverIntent.js"></script>
<script type="text/javascript" src="../js/superfish.js"></script>
			<script type="text/javascript">

		// initialise plugins
		jQuery(function(){
			jQuery('ul.sf-menu').superfish();
		});

		</script>
		<script type="text/javascript" src="../js/swfobject.js"></script>
		<script type="text/javascript">
		var flashvars = {};   
		var params = {};   
		params.quality = "high";   
		params.bgcolor = "#117390";   
		params.play = "true";   
		params.loop = "false";   
		params.scale = "showall";   
		params.menu = "false";   
		params.devicefont = "false";   
		params.salign = "";   
		params.allowscriptaccess = "sameDomain";   	  
		params.wmode = "Opaque";
		swfobject.embedSWF("../flash/header-flash2.swf", "header-flash-place", "1024px", "137px", "6.0.0", "expressInstall.swf",flashvars,params);
		</script>



<div id="header-container">
<!-- container begin -->
	<div id="header">
	<!-- header begin -->
	
	
		<div id="swc">
		<!-- swc begin -->
			<img src="<%=basepath%>/images/header-title.jpg">
		</div>
		<!-- swc end -->
		<div id="search">
		<!-- search begin -->
			<SPAN style="COLOR: #000000">
				<div id="searchbox">
<!--
					<form action="http://www.google.com/search" method="get" target="_blank">
						<div class="content">
							<input type="text" class="textfield" style="color:#888;" name="as_q" size="24" value='输入关键字搜索本站' onblur="if(this.value == '')this.value='输入关键字搜索本站'" onfocus="if(this.value == '输入关键字搜索本站')this.value = ''" />
							<input name="as_sitesearch" value="sc.neu.edu.cn" type="hidden">
							<input type="submit" class="button" value="搜索"/>
						</div>
					</form>
-->

				</div>
			</SPAN>
			<!--  
			<img src="<%=basepath%>/images/header-arrow.png">&nbsp;
			<input type="text" name="search" size="13" style="height:18px;"/>&nbsp;&nbsp;
			<img src="<%=basepath%>/images/header-search.png">
			-->
		</div>
		<!-- search end -->
	</div>
	<!-- header end -->
	
	<div id="menu">
	<!-- menu beign -->
			<ul class="sf-menu">
			<li class="current"><a href="../index.jsp" class="parent"><span>学院首页</span></a></li>
			
			<li><a class="parent"><span>学院概况</span></a>
			<ul id="guideLi2">
				<li><a href="../jsp/page.jsp?pageId=1008"><span>学院简介</span></a></li>
				<li><a href="../jsp/org.jsp?orgId=1" target="_blank"><span>理事会</span></a></li>
				<li><a href="../jsp/org.jsp?orgId=2" target="_blank"><span>学院领导</span></a></li>
				<li><a href="../jsp/page.jsp?pageId=1002"><span>大事记</span></a></li>
			</ul></li>
			<li><a class="parent"><span>机构设置</span></a>
			<ul id="guideLi3">
				<li><a href="../jsp/org.jsp?orgId=3"><span>学院办公室</span></a></li>
				<li><a href="../jsp/org.jsp?orgId=4"><span>教学科研办公室</span></a></li>
				<li><a href="../jsp/org.jsp?orgId=5"><span>学生工作办公室</span></a></li>
				<li><a href="../jsp/department.jsp?orgId=6"><span>软件工程研究所</span></a></li>
				<li><a href="../jsp/department.jsp?orgId=7"><span>信息安全研究所</span></a></li>
				<li><a href="../jsp/department.jsp?orgId=8"><span>数字媒体技术研究所</span></a></li>
				<li><a href="../jsp/department.jsp?orgId=9"><span>外语教学部</span></a></li>
				<li><a href="../jsp/department.jsp?orgId=10"><span>实验中心</span></a></li>
			</ul>
			</li><li><a class="parent"><span>师资队伍</span></a>
			<ul id="guideLi4">
				<li><a href="../jsp/page.jsp?pageId=1009"><span>队伍概况</span></a></li>
				<li><a href="../jsp/teacherList.jsp"><span>教师队伍</span></a></li>
			</ul></li>
			<li><a class="parent"><span>党政工作</span></a>
			<ul id="guideLi5">
				<li><a href="../jsp/newsList.jsp?id=10002&amp;page=1"><span>党建工作</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10003&amp;page=1"><span>人事行政</span></a></li>
			</ul></li>
			<li><a class="parent"><span>人才培养</span></a>
			<ul id="guideLi6">
				<li><a class="parent"><span>本科生教学</span></a>
					<ul id="guideLi28">
					<li><a href="../jsp/newsList.jsp?id=10016&amp;page=1"><span>教学管理</span></a></li>
					<li><a href="../jsp/newsList.jsp?id=10017&amp;page=1"><span>教学改革</span></a></li>
					</ul></li>
			<li><a class="parent"><span>研究生教学</span></a>
				<ul id="guideLi29">
				<li><a href="../jsp/newsList.jsp?id=10020&amp;page=1"><span>教学管理</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10022&amp;page=1"><span>教学点管理</span></a></li>
				</ul></li>
			</ul></li>
			<li><a class="parent"><span>招生工作</span></a>
			<ul id="guideLi7">
				<li><a href="../jsp/newsList.jsp?id=10012&amp;page=1"><span>招生信息</span></a></li>
				<li><a class="parent"><span>本科生专业</span></a>
					<ul id="guideLi42">
					<li><a href="../jsp/page.jsp?pageId=1022"><span>软件工程</span></a></li>
					<li><a href="../jsp/page.jsp?pageId=1023"><span>信息安全</span></a></li>
					<li><a href="../jsp/page.jsp?pageId=1024"><span>数字媒体技术</span></a></li>
					</ul></li>
				<li><a class="parent"><span>研究生专业</span></a>
					<ul id="guideLi43">
					<li><a href="../jsp/page.jsp?pageId=1025"><span>软件工程（学术型）</span></a></li>
					<li><a href="../jsp/page.jsp?pageId=1026"><span>软件工程（应用型）</span></a></li>
					<li><a href="../jsp/page.jsp?pageId=1027"><span>软件工程（单证）</span></a></li>
				</ul></li>
				<li><a href="../jsp/yjsds.jsp"><span>研究生导师</span></a></li>
			</ul></li>
			<li><a class="parent"><span>学生工作</span></a>
			<ul id="guideLi8">
				<li><a href="../jsp/newsList.jsp?id=10007&amp;page=1"><span>日常管理</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10008&amp;page=1"><span>学生活动</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10009&amp;page=1"><span>就业信息</span></a></li>
				<li><a class="parent"><span>学生科创</span></a>
					<ul id="guideLi41">
					<li><a href="../jsp/newsList.jsp?id=10010&amp;page=1"><span>科技竞赛</span></a></li>
					<li><a href="../jsp/newsList.jsp?id=10011&amp;page=1"><span>创新项目</span></a></li>
					<li><a href="../jsp/newsList.jsp?id=10029&amp;page=1"><span>学生社团</span></a></li>
					</ul></li>
			</ul></li>
			<li><a class="parent"><span>学科科研</span></a>
			<ul id="guideLi9">
				<li><a href="../jsp/newsList.jsp?id=10004&amp;page=1"><span>学科建设</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10005&amp;page=1"><span>科学研究</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10006&amp;page=1"><span>学术活动</span></a></li>
				<li><a href="../jsp/page.jsp?pageId=1005"><span>研究室</span></a></li><li>
				<a href="../jsp/page.jsp?pageId=1006"><span>联合实验室</span></a></li><li>
				<a href="../jsp/page.jsp?pageId=1007"><span>工程中心</span></a></li>
			</ul></li>
			<li><a class="parent"><span>合作交流</span></a>
			<ul id="guideLi10">
				<li><a href="../jsp/newsList.jsp?id=10013&amp;page=1"><span>校企合作</span></a></li>
				<li><a href="../jsp/newsList.jsp?id=10014&amp;page=1"><span>国际交流</span></a></li>
			</ul></li>
		</ul>
	
	  
	</div>
	<!-- menu end -->
	<div id="header-flash"><div id="header-flash-place"></div>
	</div>
	<div id="header-line"></div>
	
	<div id="header-login">
		<table width="980px">
			<tr>
			<td width="463px"></td>

				<td width="150px"></td>
				<td><span class="header-login-info">总访问量：<%@include file="countNo.jsp"%></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><span class="header-login-info"> <%@include file="date.jsp"%></span>&nbsp;&nbsp;</td>
			</tr>
		</table>				
	</div>
	<div id="header-line2"></div>	
</div>
<!-- container end -->