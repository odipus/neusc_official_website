<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--大事记</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsContent.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>

<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />
	
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
	p.events{
	     color:#5c6979;
    	display: block;
   	 	font-family: "黑体";
    	font-size: 18px;
   	 	font-weight: 600;
    	line-height: 40px;
    	text-align: center;
	}
	.index2-right-title a{
		color:#5c6979;
    	display: block;
   	 	font-family: "黑体";
    	font-size: 15px;
   	 	font-weight: 400;
    
    
	}
	
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="../jsp/header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">大事记</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
		
			<hr/>
		
			<table style="float:left;margin-left:20px;width:600px">
				<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2010年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2009年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2008年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2007年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2006年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2005年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2004年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2003年大事记</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;东北大学软件学院2002年大事记</a></span></td>
    			</tr>
    			<tr height="20px"></tr>
            </table>
            
    
			<p class='commonLink' style="display:block;clear:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共9条&nbsp;&nbsp;当前第1/1 页 &nbsp;&nbsp;<a href=''>首页</a>  <a href=''>上一页</a>  <a href=''>下一页</a>  <a href=''>尾页</a> </p>
			<br/>	
				
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>