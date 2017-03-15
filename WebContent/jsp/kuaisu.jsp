<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--快速通道</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

	<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">
	
	<style>
	p.frendLink{
	
    	font-family:"楷体";
    	font-size:15px;
    	font-weight:bold;
 
	}
	#linkPic-table tr{
		height:70px;
	}
	p.ksLink{
	margin-left:80px;
	font-family:"黑体";
    font-size:15px;
    color:#5c6979;
    font-weight:600;
    line-height:30px;
	}
		#pageList td{
		BORDER-BOTTOM: #CCC 1px dashed;
	}
	
	div#index3-news {
    background-color: white;
    border: 1px solid #A8A8A8;
    clear: both;
    height:400px;
    margin-left: 40px;
    position: relative;
    width: 942px;
}
	</style>
	
</head>


<body>

<div id="index3-container" style="text-align:left">
	<jsp:include page="header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">快速通道</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			
			 			
			 			
			 		
			 			
			 			
		
			<table style="float: left; margin-left: 80px; width: 600px;" id="pageList">
			
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://219.216.101.168/" target="_blank">学院成立十周年专题网站<img id="GridViewTZ_ctl02_ImgNew1" src="../icons/new.gif" style="border-width:0px;"></a>	
				</span></td>
			</tr>
			

			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
						<a class="ksLink" href="http://sc.neu.edu.cn/jsp/newsContent.jsp?sectionId=10012&newsId=470" target="_blank">软件工程硕士自主招生(秋季)</a>	
				</span></td>
			</tr>

<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
						<a class="ksLink" href="http://sc.neu.edu.cn/SWC_01/user/login_link" target="_blank">软件工程硕士网上报名系统</a>	
				</span></td>
			</tr>

			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://bb.neu.edu.cn/" target="_blank">Blackboard平台</a>
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://kjc.neu.edu.cn/business/login.jsp" target="_blank">科研管理平台</a>
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://202.118.31.197/ACTIONQUERYTEACHERSCHEDULEBYPUBLIC.APPPROCESS" target="_blank">教师课表查询</a>
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href='http://202.118.31.197/ACTIONQUERYSTUDENTSCORE.APPPROCESS' target=_blank>学生成绩查询</a>
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://202.118.31.197/ACTIONQUERYSTUDENTSCHEDULEBYSELF.APPPROCESS" target="_blank">学生课表查询</a>
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://202.118.31.197/ACTIONLOGON.APPPROCESS?mode=1&applicant=ACTIONEDITSCOREBYTEACHER" target="_blank">本科成绩录入</a>
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://202.118.31.197/ACTIONLOGON.APPPROCESS?mode=1&applicant=ACTIONQUERYTASKBYTEACHERNO" target="_blank">学生点名册打印</a>	
				</span></td>
			</tr>
			<tr>
				<td><img width="8" height="8" src="../icons/point.jpg"></td>
				<td><span class="index2-right-title">
					<a href="http://202.118.27.233/home/home.asp" target="_blank">教师业绩管理系统</a>	
				</span></td>
			</tr>
		</table>	
		
				
			
	
			
		</div>
									
								
			<br/>		
	</div>

	<jsp:include page="banner.jsp" />
</div>
	
</body>


</html>