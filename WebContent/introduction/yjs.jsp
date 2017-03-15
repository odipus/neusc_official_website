<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--研究室</title>
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
	p.yjslink{
	
    display: block;
    font-family: "黑体";
    font-size: 20px;
    font-weight: 400;
    line-height: 40px;
    text-align: left;
    margin-left:120px;
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
		<div id="index3-news-header"><span class="part-name">研究室</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
	
			<hr/>
    		<table style="float:left;margin-left:20px;width:600px">
				<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;信息整合技术研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;多媒体医疗信息处理技术研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;虚拟现实与动漫技术研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;信息系统工程联合研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;服务科学研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;混沌分形研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;集成电路应用软件研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;网络安全研究室</a></span></td>
    			</tr>
    			<tr>
					<td height='35' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='8' height='8' /></td>
					<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a href="#" target=_blank>&nbsp;内容安全技术研究室</a></span></td>
    			</tr>
    			<tr height="30px"></tr>
            </table>
        
			
			<br/>				
            
			
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>