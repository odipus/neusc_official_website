<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--软件工程</title>
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
	
	
	</style>
	
</head>


<body>

<div id="index3-container">
	<jsp:include page="../jsp/header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">专业介绍--软件工程</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
			<span class="title1">软件工程（学术型）</span>
	
<p><strong>培养目标：</strong></p>
<p class="text">培养掌握计算机科学与软件开发的基础理论、专业知识和基本技能，掌握数字媒体核心技术与设计标准，具有较强的实践能力和基本的视听艺术素养，具有艺术创意能力，具有虚拟现实和动漫、游戏支撑软件的研发能力，具有交互式媒体和数字娱乐等数字文化作品的设计、制作、技术支持、管理、研发和团队协作能力的高级复合型应用人才。
</p><p><strong>主要课程：</strong></p><p class="text">高等数学、离散数学、概率论与数理统计、数字媒体技术概论、高级语言程序设计、面向对象程序设计、大学英语、体育、思想道德修养与法律基础、形式与政策、中国近代史概要、马克思主义基本原理、军事理论、日语、韩语、毛泽东思想和中国特色社会主义理论体系概论、IT 职业英语、数字艺术设计概论、数据结构与算法设计、计算机系统、软件工程、计算机图形学、人机交互技术、网页制作与脚本编程、动画设计基础、游戏设计基础、计算机三维建模、虚拟现实技术，动画插件编程等。
</p><p><strong>毕业生适用范围：</strong></p><p class="text">毕业生将主要服务于国内外大中型与数字媒体及数字娱乐相关的企业、事业、学校等单位，从事交互式媒体和数字娱乐等数字文化作品的设计、制作、技术支持、生产管理、教学和技术研发创新等工作。
</p><br/>
	
			
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>