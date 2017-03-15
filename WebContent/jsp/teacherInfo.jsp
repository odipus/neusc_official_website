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
<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet" />
<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/teacherInfo.js" type="text/javascript"></script>


		

		
<style>
div.department-index-container{
	text-align:left;
	width:1024px;
	height:auto;
	margin:0 auto;
	background-image:url('../images/index-bg.png');
	background-repeat: repeat;

	}
div#department-title{
	padding-left:10px;
	float:left;
	width:190px;
	height:36px;
}




div#department2-main{
	border:1px solid #A8A8A8;
	margin-left:40px;
	display:inline-block;
	width:944px;
	border-right:0px;
	border-bottom:0px;
	}
div#department2-main-header{
	width:100%;
	height:28px;
	background-image:url('../images/department2-main-header.png');
	}
div#department2-main-content{
	width:100%;
	height:auto !important;
	height:813px; 
	min-height:813px;
	border:1px solid #A8A8A8;
	border-top:0px;
	border-left:0px;
	background-color:white;
	}
div#department2-main-content-area{
	width:820px;
	margin-left:50px;
	overflow:hidden;
}

	


div#department-title span{
    display:inline;
    font-family:"黑体";
    font-size:16px;
    font-weight:600;
    letter-spacing: -0.3mm;
}

/*部门业常用文字样式*/
span.department-title-1{
    display:block;
    font-family:"黑体";
    font-size:25px;
    font-weight:bold;
    line-height:70px;
    text-align: center;
    color:#1b2c7a;
}
p.department2-teacher{
	front-family:"黑体";
	line-height:20px;
}
img.teacherPic{

	padding:10px;

}
div#teacherInfo-left{
	margin-top:40px;
	width:200px;
	height:100%;
	background-image:url('../images/teacherInfo-bg.jpg');
	background-repeat: no-repeat;
	float: left;	
}
div#teacherInfo-right{
	margin-top:40px;
	margin-left:20px;
	width:550px;
	height:100%;
	float: left;	
}
p.teacherInfo-style1{
 	display:block;
    font-family:"楷体";
    font-size:16px;
    font-weight:bold;
    line-height:30px;
    text-align: left;
    color:#1b2c7a;
    margin-left:20px;
}
</style>
</head>

<body>

	

    <div class="department-index-container">
		<jsp:include page="header2.jsp" />
		
		<div id="department2-main">
		<div id="department2-main-header"></div>
		<div id="department2-main-content">
			<div id="department2-main-content-area">
		
				<!-- <p class='commonLink'>当前位置：学院首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;软件工程研究所&nbsp;&gt;&nbsp;教师个人信息</p> -->
				<div id="teacherInfo-left">
					<img id="teacherPic" height="140px" width="200px">
					<br/><br/>
					
				</div>
				<div id="teacherInfo-right">
			
				</div>
			
			
		
			</div>

			
		</div>
		</div>
		
	<jsp:include page="banner.jsp" />
	</div>


	
</body>


</html>

