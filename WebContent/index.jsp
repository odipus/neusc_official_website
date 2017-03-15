<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta name="Keywords" content="东北大学软件学院,东北大学国家示范性软件学,东北大学软件工程,东北大学信息安全,东北大学数字媒体技术">
	<meta name="description" content="东北大学国家示范性软件学院官方网站，软件学院概况、师资队伍、教学情况、日常管理等信息">
	<link href="<%=basepath%>/icons/favicon.ico"  rel="shortcut icon" />
	<link href="<%=basepath%>/css/header.css" rel="stylesheet" type="text/css">
	<link href="<%=basepath%>/css/picturenews.css" rel="stylesheet" type="text/css">
	<link href="<%=basepath%>/css/jquery-ui-1.8.14.custom.css" rel="stylesheet" type="text/css">
	<link href="<%=basepath%>/css/index.css" rel="stylesheet"  type="text/css" />
	<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">
	<link href="<%=basepath%>/css/superfish.css" rel="stylesheet" type="text/css" media="screen">
	
	<title>东北大学国家示范性软件学院</title>
	<script type="text/javascript">
function blinklink1()
{

if (!document.getElementById('blink1').style.color)
{
	document.getElementById('blink1').style.color="blue"
}
else if (document.getElementById('blink1').style.color=="blue")
{
	document.getElementById('blink1').style.color="red"
}
else
{
	document.getElementById('blink1').style.color="blue"
}
	timer1=setTimeout("blinklink1()",1000)
}
function blinklink2()
{
if (!document.getElementById('blink2').style.color)
{
	document.getElementById('blink2').style.color="red"
}
else if (document.getElementById('blink2').style.color=="red")
{
	document.getElementById('blink2').style.color="blue"
}
else
{
	document.getElementById('blink2').style.color="red"
}

	timer2=setTimeout("blinklink2()",1000)
}
function blinklink3()
{
if (!document.getElementById('blink3').style.color)
{
	document.getElementById('blink3').style.color="red"
}
else if (document.getElementById('blink3').style.color=="red")
{
	document.getElementById('blink3').style.color="blue"
}
else
{
	document.getElementById('blink3').style.color="red"
}

	timer3=setTimeout("blinklink3()",1000)
}

function blinklink(){
	blinklink1();
	blinklink2();
	blinklink3();
}

function stoptimer()
{
clearTimeout(timer1)
clearTimeout(timer2)
clearTimeout(timer3)
}
</script>

</head>
<body onload="blinklink()" onunload="stoptimer()">
	<div class="index-container">	 
		<div id="header-ad"></div>	
		<div id="header-container">
			<div id="header">
				<div id="swc">
					<img src="<%=basepath%>/images/header-title.jpg"> 
				</div>
				<div id="search">	
					<a href="enindex.html">English Version</a>	
				</div>
			</div>
			<div id="menu">   		   				   		   		
				<ul class="sf-menu">
					<li class="current"><a href="index.jsp" class="parent"><span>学院首页</span></a></li>	
					<li><a class="parent"><span>学院概况</span></a>
					<ul id="guideLi2">
						<li><a href="jsp/page.jsp?pageId=1008"><span>学院简介</span></a></li>
						<li><a href="jsp/org.jsp?orgId=1" target="_blank"><span>理事会</span></a></li>
						<li><a href="jsp/org.jsp?orgId=2" target="_blank"><span>学院领导</span></a></li>
						<li><a href="jsp/page.jsp?pageId=1002"><span>大事记</span></a></li>
					</ul></li>
					<li><a class="parent"><span>机构设置</span></a>
					<ul id="guideLi3">
						<li><a href="jsp/org.jsp?orgId=3"><span>学院办公室</span></a></li>
						<li><a href="jsp/org.jsp?orgId=4"><span>教学科研办公室</span></a></li>
						<li><a href="jsp/org.jsp?orgId=5"><span>学生工作办公室</span></a></li>
						<li><a href="jsp/department.jsp?orgId=6"><span>软件工程研究所</span></a></li>
						<li><a href="jsp/department.jsp?orgId=7"><span>信息安全研究所</span></a></li>
						<li><a href="jsp/department.jsp?orgId=8"><span>数字媒体技术研究所</span></a></li>
						<li><a href="jsp/department.jsp?orgId=9"><span>外语教学部</span></a></li>
						<li><a href="jsp/department.jsp?orgId=10"><span>实验中心</span></a></li>
					</ul>
					</li><li><a class="parent"><span>师资队伍</span></a>
					<ul id="guideLi4">
						<li><a href="jsp/page.jsp?pageId=1009"><span>队伍概况</span></a></li>
						<li><a href="jsp/teacherList.jsp"><span>教师队伍</span></a></li>
					</ul></li>
					<li><a class="parent"><span>党政工作</span></a>
					<ul id="guideLi5">
						<li><a href="jsp/newsList.jsp?id=10002&amp;page=1"><span>党建工作</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10003&amp;page=1"><span>人事行政</span></a></li>
						
						<li><a class="parent"><span>职工之家</span></a>
							<ul id="guideLi55">
							<li><a href="jsp/newsList.jsp?id=10035&amp;page=1"><span>工会纪要</span></a></li>
							<li><a href="jsp/newsList.jsp?id=10036&amp;page=1"><span>活动通知</span></a></li>	
							<li><a href="jsp/newsList.jsp?id=10037&amp;page=1"><span>工会文件</span></a></li>
							<li><a href="jsp/newsList.jsp?id=10038&amp;page=1"><span>大事记</span></a></li>							
							</ul>
						</li>
						
						<li><a href="jsp/pictureList.jsp"><span>工作流程图</span></a></li>
					</ul></li>
					<li><a class="parent"><span>人才培养</span></a>
					<ul id="guideLi6">
						<li><a class="parent"><span>本科生教学</span></a>
							<ul id="guideLi28">
							<li><a href="jsp/newsList.jsp?id=10016&amp;page=1"><span>教学管理</span></a></li>
							<li><a href="jsp/newsList.jsp?id=10017&amp;page=1"><span>教学改革</span></a></li>			
							</ul></li>
					<li><a class="parent"><span>研究生教学</span></a>
						<ul id="guideLi29">
						<li><a href="jsp/newsList.jsp?id=10020&amp;page=1"><span>教学管理</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10022&amp;page=1"><span>教学点管理</span></a></li>
						</ul></li>
					</ul></li>
					<li><a class="parent"><span>招生工作</span></a>
					<ul id="guideLi7">
						<li><a href="jsp/newsList.jsp?id=10012&amp;page=1"><span>招生信息</span></a></li>
						<li><a class="parent"><span>本科生专业</span></a>
							<ul id="guideLi42">
							<li><a href="jsp/page.jsp?pageId=1022"><span>软件工程</span></a></li>
							<li><a href="jsp/page.jsp?pageId=1023"><span>信息安全</span></a></li>
							<li><a href="jsp/page.jsp?pageId=1024"><span>数字媒体技术</span></a></li>
							</ul></li>
						<li><a class="parent"><span>研究生专业</span></a>
							<ul id="guideLi43">
							<li><a href="jsp/page.jsp?pageId=1025"><span>软件工程（学术型）</span></a></li>
							<li><a href="jsp/page.jsp?pageId=1026"><span>软件工程（应用型）</span></a></li>
							<li><a href="jsp/page.jsp?pageId=1027"><span>软件工程（单证）</span></a></li>
						</ul></li>
						<li><a href="jsp/yjsds.jsp"><span>研究生导师</span></a></li>
					</ul></li>
					<li><a class="parent"><span>学生工作</span></a>
					<ul id="guideLi8">
						<li><a href="jsp/newsList.jsp?id=10007&amp;page=1"><span>日常管理</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10008&amp;page=1"><span>学生活动</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10009&amp;page=1"><span>就业信息</span></a></li>
						<li><a class="parent"><span>学生科创</span></a>
							<ul id="guideLi41">
							<li><a href="jsp/newsList.jsp?id=10010&amp;page=1"><span>科技竞赛</span></a></li>
							<li><a href="jsp/newsList.jsp?id=10011&amp;page=1"><span>创新项目</span></a></li>
							<li><a href="jsp/newsList.jsp?id=10029&amp;page=1"><span>学生社团</span></a></li>
							</ul></li>
					</ul></li>
					<li><a class="parent"><span>学科科研</span></a>
					<ul id="guideLi9">
						<li><a href="jsp/newsList.jsp?id=10004&amp;page=1"><span>学科建设</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10005&amp;page=1"><span>科学研究</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10006&amp;page=1"><span>学术活动</span></a></li>
						<li><a href="jsp/page.jsp?pageId=1005"><span>研究室</span></a></li><li>
						<a href="jsp/page.jsp?pageId=1006"><span>联合实验室</span></a></li><li>
						<a href="jsp/page.jsp?pageId=1007"><span>工程中心</span></a></li>
					</ul></li>
					<li><a class="parent"><span>合作交流</span></a>
					<ul id="guideLi10">
						<li><a href="jsp/newsList.jsp?id=10013&amp;page=1"><span>校企合作</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10014&amp;page=1"><span>国际交流</span></a></li>
						<li><a href="jsp/newsList.jsp?id=10033&amp;page=1"><span>国际项目</span></a></li>
					</ul></li>
				</ul>
			</div>
			<div id="header-flash">
				<div id="header-flash-place"></div>
			</div>

			<div id="header-line"></div> 
			<div id="header-login">
			<form name="loginform" action="userAction!login"  method="POST" >
				<table width="980px">
					<tr>		
						<td width="35px"></td>
						<td width="60px"><span class="header-login" >用户名：</span>
						</td>
						<td width="110px"><input type="text" id="user_z" name="userName" style="width:90px;height:20px;"/>
						</td>
						<td width="45px"><span class="header-login">密码：</span>
						</td>
						<td width="100px"><input type="password" id="userPsw" name="userPsw" style="width:90px;height:20px;" onchange="checkPwd(this)"/>
						</td>
						<td style="display:none" ><input type="text" id="kcode" name="textcode" />
						</td>
						<td style="display:none" ><input type="text" id="new_username" name="new_username" />
						</td>
						<td style="display:none" ><input type="text" id="new_password" name="new_password" />
						</td>
						<td width="55px"><input type="image" id="submitbutton" border="0" name="submit"  src="<%=basepath%>/images/header-login-button-submit.png" />
						</td>
						<td width="55px">	
						</td>					
						<td width="150px"></td>
						<td><span class="header-login-info"> <%@include file="jsp/date.jsp"%></span>&nbsp;&nbsp;</td>
					</tr>
				</table>
				</form>
			</div>
			<div id="header-line2"></div>
		</div>
		<table border="0" cellpadding="0" cellspacing="0">
			<tbody><tr>
				<th rowspan="2" width="40px"></th>
				<th rowspan="2" valign="top">
				  	<div id="index-left" class="connectedSortable">
					  	<div class="index-side-top">
						  	<div class="index-side-header"><span class="part-name">最新公告</span></div>
						  	<div class="index-side-line"></div>
						  	<div class="index-side-content-top">
							  	<div class="index-news-blank"></div>
							  		<div id="slideNews" style="overflow:hidden;height:126px;width:170px;float:left;">
										<div id="slideNews1">	
											<br/>										
											<jsp:include page="html/slideNews.jsp"></jsp:include>
										</div>
											 
										<div id="slideNews2">
										</div>
										
									</div>
									<script>
										  var speed=70//速度数值越大速度越慢
										  document.getElementById("slideNews2").innerHTML=document.getElementById("slideNews1").innerHTML
										  function Marquee(){
										  if(document.getElementById("slideNews2").offsetHeight-document.getElementById("slideNews").scrollTop<=0)
											document.getElementById("slideNews").scrollTop-=document.getElementById("slideNews1").offsetHeight
										  else{
											document.getElementById("slideNews").scrollTop++
										  }
										  }
										  var MyMar=setInterval(Marquee,speed)
										  document.getElementById("slideNews").onmouseover=function() {clearInterval(MyMar)}
										  document.getElementById("slideNews").onmouseout=function() {MyMar=setInterval(Marquee,speed)}
									</script>
							  	
						  	</div>
						  	<div class="index-side-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10001&amp;page=1">更多</a></span></div>
					  	</div>
					  	<div class="index-side">
							<div class="index-side-header"><span class="part-name">学院动态</span></div>
							<div class="index-side-line"></div>
							<div class="index-side-content">
								<div class="index-news-blank"></div>
								<jsp:include page="html/10031.jsp"></jsp:include>
							</div>
							<div class="index-side-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10031&amp;page=1">更多</a></span></div>
						</div>				
				  		<div class="index-side">
						  	<div class="index-side-header"><span class="part-name">学科科研</span></div>
						  	<div class="index-side-line"></div>
						  	<div class="index-side-content">
						  		<div class="index-news-blank"></div>	
						  		<jsp:include page="html/10034.jsp"></jsp:include>						
							</div>
							<div class="index-side-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10034&amp;page=1">更多</a></span></div>
						</div>
						<div class="index-side">
						  	<div class="index-side-header"><span class="part-name">学生科创</span></div>
						  	<div class="index-side-line"></div>
						  	<div class="index-side-content">
						  		<div class="index-news-blank"></div>	
						  		<jsp:include page="html/10028.jsp"></jsp:include>						
							</div>
							<div class="index-side-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10028&amp;page=1">更多</a></span></div>
						</div>
					</div>
			 	</th>
			 	<td height="216px" valign="top">
			 		<div id="picturenews">
			 			<div id="picturenews-header"><span class="part-name"><strong>图片新闻</strong></span></div>
			 			<div id="picturenews-content">							
							<jsp:include page="html/picNews.jsp"></jsp:include>
						</div>
			 		</div>
				</td>
			 	<th rowspan="2" valign="top">
		 			<div id="index-right" class="connectedSortable">
			 			<div class="index-right-side-top">
				 			<div class="index-right-header"><span class="part-name">快速通道</span></div>
				 			<div class="index-right-line"></div>
				 			<div class="index-right-body-top">
				 				<div class="index-news-blank"></div>
				 				
								
								<a class="ksLink"  id="blink2"  style="color:blue;font-size:13px"  href="http://sc.neu.edu.cn/jsp/newsContent.jsp?newsId=907" target="_blank">诚聘英才</a>
								<!-- <a class="ksLink"  id="blink3"  style="color:red;font-size:13px" href="http://sc.neu.edu.cn/jsp/newsContent.jsp?sectionId=10012&newsId=1274" target="_blank">2013年软件工程硕士入学须知</a>-->
								<a class="ksLink"  id="blink1"  style="color:red;font-size:13px" href="http://www.chinadegrees.cn/zzlk/login.shtml?action=forwardIndex" target="_blank">软件工程硕士网上报名系统</a>
					 			<a class="ksLink"  href="http://bb.neu.edu.cn/" target="_blank">Blackboard平台</a>
					 			<a class="ksLink"  href="http://kjc.neu.edu.cn/business/login.jsp" target="_blank">科研管理平台</a>
					 			<a class="ksLink"  href="http://202.118.31.197/ACTIONQUERYTEACHERSCHEDULEBYPUBLIC.APPPROCESS" target="_blank">教师课表查询</a>
					 			<a class="ksLink"  href="http://202.118.31.197:8000/xk_login.jsp" target="_blank">学生选课系统</a>
					 			
				 			</div>
				 			<div class="index-right-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/kuaisu.jsp">更多</a></span></div>
			 			</div>
			 			<div class="index-right-side">
				 			<div class="index-right-header"><span class="part-name">国际项目</span></div>
				 			<div class="index-right-line"></div>
				 			<div class="index-right-body">
				 				<div class="index-news-blank"></div>
				 				<jsp:include page="html/10033.jsp"></jsp:include>
				 			</div>
				 			<div class="index-right-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10033&amp;page=1">更多</a></span></div>
			 			</div>
			 			<div class="index-right-side">
				 			<div class="index-right-header"><span class="part-name">学生工作</span></div>
				 			<div class="index-right-line"></div>
				 			<div class="index-right-body">
				 				<div class="index-news-blank"></div>
				 				<jsp:include page="html/10025.jsp"></jsp:include>
				 			</div>
				 			<div class="index-right-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10025&amp;page=1">更多</a></span></div>
			 			</div>
			 			<div class="index-right-side">
							<div class="index-right-header"><span class="part-name">招生就业</span></div>
							<div class="index-right-line"></div>
							<div class="index-right-body">
								<div class="index-news-blank"></div>
								<jsp:include page="html/10030.jsp"></jsp:include>						
							</div>
							<div class="index-right-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10030&amp;page=1">更多</a></span></div>
							</div>
					</div>
			 	</th>
			</tr>
			<tr>
			  <td valign="top">
				<div id="index-center">
					<div id="index-center-left" class="connectedSortable">
						<div class="index-center-news">
							<div class="index-center-header"><span class="part-name2"><strong>本科生教学</strong></span></div>
							<div class="index-center-line"></div>
							<div class="index-center-content">
								<div class="index-news-blank-center"></div>
								
								<!--[if IE 6]> <br/><![endif]-->
								<jsp:include page="html/10026.jsp"></jsp:include>
							</div>
							<div class="index-center-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10026&amp;page=1">更多</a></span></div>
						</div>
						<div class="index-center-news">
							<div class="index-center-header"><span class="part-name2"><strong>国际交流</strong></span></div>
							<div class="index-center-line"></div>
							<div class="index-center-content">
								<div class="index-news-blank-center"></div>
								<!--[if IE 6]> <br/><![endif]-->
								<jsp:include page="html/10014.jsp"></jsp:include>
								</div>
							<div class="index-center-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10014&amp;page=1">更多</a></span></div>
						</div>
					</div>
					<div id="index-center-right" class="connectedSortable">
						<div class="index-center-news">
							<div class="index-center-header"><span class="part-name2"><strong>研究生教学</strong></span></div>
							<div class="index-center-line"></div>
							<div class="index-center-content">
								<div class="index-news-blank-center"></div>
								<!--[if IE 6]> <br/><![endif]-->
								<jsp:include page="html/10027.jsp"></jsp:include>
							</div>
							<div class="index-center-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10027&amp;page=1">更多</a></span></div>
						 </div>
						<div class="index-center-news">
							<div class="index-center-header"><span class="part-name2"><strong>校企合作</strong></span></div>
							<div class="index-center-line"></div>
							<div class="index-center-content">
								<div class="index-news-blank-center"></div>
								<!--[if IE 6]> <br/><![endif]-->
								<jsp:include page="html/10013.jsp"></jsp:include>
							</div>							
							<div class="index-center-bottom"><img src="images/index-arrow.png"><span class="news-more"><a href="jsp/newsList.jsp?id=10013&amp;page=1">更多</a></span></div>
						</div>
					</div>
					<div id="slidePic" style="padding-top:20px;padding-bottom:26px;overflow:hidden;height:109px;width:520px;color:#ff0000;margin-left:10px;">
						<table align="left" border="0" cellpadding="0">
						<tbody>
							<tr>
								<td id="slideRound1" valign="top">
								  <table border="0" cellpadding="0" cellspacing="0" width="100%">
								  <tbody>
								  	<tr>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10000.jpg" height="103px" width="186px"></a></div></td>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10001.jpg" height="103px" width="186px"></a></div></td>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10002.jpg" height="103px" width="186px"></a></div></td>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10003.jpg" height="103px" width="186px"></a></div></td>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10004.jpg" height="103px" width="186px"></a></div></td>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10005.jpg" height="103px" width="186px"></a></div></td>
								    <td><div class="roundPic"><a href="jsp/pictures.jsp"><img src="roundPic/10006.jpg" height="103px" width="186px"></a></div></td>
								    </tr>
								  </tbody>
								  </table>
								 </td>
							 <td id="slideRound2" valign="top">						
							 </td>
							 </tr>
						 </tbody>
						 </table>
					</div>
						  <script>
						  var speed2=50//速度数值越大速度越慢

						  document.getElementById("slideRound2").innerHTML=document.getElementById("slideRound1").innerHTML
						  function Marquee2(){
						  if(document.getElementById("slideRound2").offsetWidth-document.getElementById("slidePic").scrollLeft<=0)
						  document.getElementById("slidePic").scrollLeft-=document.getElementById("slideRound1").offsetWidth
						  else{
						  document.getElementById("slidePic").scrollLeft++
						  }
						  }
						  var MyMar2=setInterval(Marquee2,speed2)
						  document.getElementById("slidePic").onmouseover=function() {clearInterval(MyMar2)}
						  document.getElementById("slidePic").onmouseout=function() {MyMar2=setInterval(Marquee2,speed2)}
						  </script>
				</div>
			  </td>
			</tr>
		</tbody></table>
		<div id="banner">
			<div id="banner-line"></div>		
			<div id="banner-text">
				<table height="25px" width="500px">
					<tbody><tr>
						<td style="border-right:1px solid #a0a0a0" align="center"><p class="banner2"><a target="_blank" href="introduction/contactus.jsp">联系我们</a></p></td>
						<td style="border-right:1px solid #a0a0a0" align="center"><p class="banner2"><a target="_blank" href="introduction/codeInfo.jsp">技术支持</a></p></td>
						<td style="border-right:1px solid #a0a0a0" align="center"><p class="banner2"><a target="_blank" href="jsp/page.jsp?pageId=1010">友情链接</a></p></td>
						<td style="border-right:1px solid #a0a0a0" align="center"><p class="banner2"><a target="_blank" href="jsp/newsList.jsp?id=10015&amp;page=1">诚聘英才</a></p></td>
						<td align="center"><p class="banner2"><a target="_blank" href="jsp/downloadList.jsp?page=1&amp;sec=all">资源下载</a></p></td>
					</tr>
				</tbody></table>
				<div style="width:100%;" align="center">
					<p id="banner1">© Copyright 2011-2014 Software College Northeastern University. 东北大学软件学院. All rights reserved.</p>
					<p id="banner1">地址：辽宁省沈阳市和平区文化路3号巷11号      邮编：110819 </p>
				</div>
			</div>
		</div>
		<br>
		<br>
	</div>


	<script type="text/javascript" src="<%=basepath%>/js/jquery.js" ></script>
	<script type="text/javascript" src="<%=basepath%>/aes/aes.js" ></script>
	
	<script type="text/javascript" src="<%=basepath%>/js/jquery.easing-1.3.js" ></script>
	<script type="text/javascript" src="<%=basepath%>/js/picnews.js"></script>
	<script type="text/javascript" src="<%=basepath%>/js/hoverIntent.js"></script>
	<script type="text/javascript" src="<%=basepath%>/js/superfish.js"></script>
	<script type="text/javascript" src="<%=basepath%>/js/swfobject.js"></script>
	<script type="text/javascript" src="<%=basepath%>/js/index.js"></script>
	


	


	</body>
</html>