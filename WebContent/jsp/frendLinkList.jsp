<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>友情链接</title>
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
		height:50px;
	}
	#linkPic-table td{
		BORDER-BOTTOM: #CCC 1px dashed;
	}
	
	</style>
	
</head>


<body>

<div id="index3-container" style="text-align:left">
	<jsp:include page="header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">友情链接</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<table id="linkPic-table" style="float:left; margin-left:80px;">
				
				<tr><td><img width="8" height="8" src="../icons/point.jpg"></td>
					<td width="150">
					<a class="black_bold" target="_blank" href="http://www.neu.edu.cn">
							<img height="40" border="0" width="120" src="../linkPic/neulogo.jpg">
					</a>
					</td>
					<td width="400">
						<a class="black_bold" target="_blank" href="http://www.neu.edu.cn">
						<p class="frendLink">东北大学网站首页</p>
						</a>
					</td>
				</tr>
				
				<tr><td><img width="8" height="8" src="../icons/point.jpg"></td>
					<td>
							<a class="black_bold" target="_blank" href="http://www.neu-pioneer.cn">
							<img height="40" border="0" width="120" src="../linkPic/plogo.gif">
							</a>
					
					</td>
					<td>
							<a class="black_bold" target="_blank" href="http://www.neu-pioneer.cn">
							<p class="frendLink">东北大学先锋网</p>
							</a>
					
					</td>
				</tr>
				
				<tr><td><img width="8" height="8" src="../icons/point.jpg"></td>
					<td>
			  			<a class="black_bold" target="_blank" href="http://202.118.31.220/default.aspx">
						<img height="40" border="0" width="120" src="../linkPic/chuangxin.jpg"></a>
					</td>
					<td>
							<a class="black_bold" target="_blank" href="http://202.118.31.220/default.aspx">
							<p class="frendLink">东大创新网</p>
							</a>
					
					</td>
				</tr>
				<tr><td><img width="8" height="8" src="../icons/point.jpg"></td>
					 <td>
				  		<a class="black_bold" target="_blank" href="http://neunews.neu.edu.cn:8080/campus/index.html">
						<img height="40" border="0" width="120" src="../linkPic/xinwen.jpg"></a>
					</td>
					<td>
							<a class="black_bold" target="_blank" href="http://neunews.neu.edu.cn:8080/campus/index.html">
							<p class="frendLink">东大新闻网</p>
							</a>
					
					</td>
				</tr>
				<tr><td><img width="8" height="8" src="../icons/point.jpg"></td>
					
					<td>
			  			<a class="black_bold" target="_blank" href="http://www.neusoft.com/cn/">
						<img height="40" border="0" width="120" src="../linkPic/neusoft.jpg"></a>
					</td>
					<td>
							<a class="black_bold" target="_blank" href="http://www.neusoft.com/cn/">
							<p class="frendLink">东软集团官方网站</p>
							</a>
					
					</td>
				</tr>
				<tr><td><img width="8" height="8" src="../icons/point.jpg"></td>
					<td>
				  		<a class="black_bold" target="_blank" href="http://www.ibm.com/cn/zh/">
						<img height="40" border="0" width="120" src="../linkPic/ibm.jpg"></a>
					</td>
					<td>
							<a class="black_bold" target="_blank" href="http://www.ibm.com/cn/zh/">
							<p class="frendLink">IMB中国官方网站</p>
							</a>
					
					</td>
				</tr>
			</table>	
									
								
								
									
									
								
								
								
									
			<br/>		
		</div>
	</div>
			
	<jsp:include page="banner.jsp" />
</div>
	

</body>


</html>