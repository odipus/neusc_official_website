<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院</title>
<link rel="shortcut icon" href="<%=basepath%>/icons/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=basepath%>/css/index.css" rel="stylesheet" />
<link type="text/css" href="<%=basepath%>/css/newsList.css" rel="stylesheet" />

<link type="text/css" href="<%=basepath%>/css/header.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/banner.css" rel="stylesheet">
<link type="text/css" href="<%=basepath%>/css/style.css" rel="stylesheet">

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/superfish.css" media="screen">
<script type="text/javascript" src="../js/hoverIntent.js"></script>
<script type="text/javascript" src="../js/superfish.js"></script>
<script src="<%=basepath%>/js/jquery.easing-1.3.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/newsList.js" type="text/javascript"></script>
<script src="<%=basepath%>/js/jquery.slide-0.4.3.js" type="text/javascript"></script>

<script src="<%=basepath%>/js/jquery-1.7.2.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=basepath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basepath%>/css/style.css" />


<script type="text/javascript" src="<%=basepath%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/bootstrap.min.js"></script> 
	
<style>
	
div.index-side{
	width:206px;
	height:220px;
	border:1px solid #A8A8A8;
	background-color:white;	
}
div.index-side-header{
	text-align:left;
	width:206px;
	height:28px;
	background-image:url('../images/index-side-header.png');
	}
div.index-side-content{
	text-align:left;
	width:206px;
	height:169px;
	line-height:20px;
	overflow:hidden;
}
div.index-side-line{
	width:206px;
	height:5px;
	background-image:url('../images/index-side-line.png');
	background-repeat: repeat-x;
}
div.index-side-bottom{
	vertical-align:middle;
	height:35px;
	margin-left:130px;
	line-height:35px;
	position:relative;
}
marquee#announcement{
	float:left;
	margin-top:10px;
	position:relative;
	
	_margin-top:10px;
	 height:140px;
	 width:180px;
}
	
</style>
<style type="text/css"> 
#picRonud {position:relative; width:207px; height:180px; overflow:hidden; font-size:13px} 
#picRonud_list img {border:0px;} 
#picRonud_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=10);opacity:0.1;z-index:1000;cursor:pointer; width:205px; } 
#picRonud_info{display:block;
position:absolute; bottom:2px; left:5px;height:25px;color:#fff;z-index:1001;cursor:pointer} 
#picRonud_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;} 
#picRonud ul { position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; z-index:1002; 
margin:0; padding:0; bottom:3px; right:5px; height:25px} 
#picRonud ul li { padding:0 8px; line-height:20px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background-color:#6f4f67;cursor:pointer; margin:0; font-size:13px;} 
#picRonud_list a{position:absolute;} 

.aNode {line-height: 25px}
</style> 
</head>

<body>

	<div class="index-container">
	<jsp:include page="header2.jsp" />
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="40px"></td>
			<td>
				<div id="index2-left" style="height: 445px">
					<div class="index-side" style="height: 443px">
			  			<div class="index-side-header"><span class='part-name'>工作流程图导航</span></div>
			  			<div class="index-side-line"></div>
			  			<div class="index-side-content" id="index2-announcement"></div>
			  		</div>
				</div>
				
			</td>
			<td>
				<div id="index2-right">
				<div id="index2-right-header">
					<span class="part-name">文件列表</span>
				</div>
				<div id="index2-right-content">
					<div id="newsContent-Guide">
						<p class="commonLink">
          				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前位置：
						<a class="commonLink" href="../index.jsp">首页</a>
						 > 
						<a href="#">工作流程图</a>
						 > 文件列表
						</p>
					</div>
					
					<div class="row-fluid" style="margin-left:25px">
    					<div class="span7" style="width: 683px">
							
				            <!-- Accardion -->
							<div class="accordion acc-home" id="accordion2">
				                <div class="accordion-group">
				                  <div class="accordion-heading">
				                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne" style="font-size:13px">
				                  	<img width="5" height="5" src="../icons/point.jpg">
				                      	&nbsp;&nbsp;财务资产流程图
				                    </a>
				                  </div>
				                  <div id="collapseOne" class="accordion-body in collapse" style="height: auto">
				                    <div class="accordion-inner">
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=1-1.pdf" title="软件学院办公用品申领采购流程.pdf">&nbsp;&nbsp;软件学院办公用品申领采购流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=1-2.pdf" title="软件学院财务报账审批流程.pdf">&nbsp;&nbsp;软件学院财务报账审批流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=1-3.pdf" title="软件学院资产采购审批流程.pdf">&nbsp;&nbsp;软件学院资产采购审批流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=1-4.pdf" title="软件学院资产使用管理流程.pdf">&nbsp;&nbsp;软件学院资产使用管理流程.pdf</a>
											</span>
										</div>
				                    </div>
				                  </div>
				                </div><!--/accordion-group-->
				
				                <div class="accordion-group">
				                  <div class="accordion-heading">
				                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo" style="font-size:13px">
				                        <img width="5" height="5" src="../icons/point.jpg">
				                        &nbsp;&nbsp;人事工作流程图
				                    </a>
				                  </div>
				                  <div id="collapseTwo" class="accordion-body collapse" style="height: 0px;">
				                    <div class="accordion-inner">
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=2-1.pdf" title="软件学院非领导职务人员考核操作流程.pdf">&nbsp;&nbsp;软件学院非领导职务人员考核操作流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=2-2.pdf" title="软件学院绩效津贴分配工作流程.pdf">&nbsp;&nbsp;软件学院绩效津贴分配工作流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=2-3.pdf" title="软件学院聘期考核工作流程.pdf">&nbsp;&nbsp;软件学院聘期考核工作流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=2-4.pdf" title="软件学院请销假流程.pdf">&nbsp;&nbsp;软件学院请销假流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=2-5.pdf" title="软件学院职员晋级工作流程.pdf">&nbsp;&nbsp;软件学院职员晋级工作流程.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=2-6.pdf" title="软件学院专业技术岗位聘任工作流程.pdf">&nbsp;&nbsp;软件学院专业技术岗位聘任工作流程.pdf</a>
											</span>
										</div>
				                    </div>
				                  </div>
				                </div><!--/accordion-group-->
				
				                <div class="accordion-group">
				                  <div class="accordion-heading">
				                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree" style="font-size:13px">
				                       <img width="5" height="5" src="../icons/point.jpg">                                                        
				                       &nbsp;&nbsp;外事工作流程图
				                    </a>
				                  </div>
				                  <div id="collapseThree" class="accordion-body collapse" style="height: 0px;">
				                    <div class="accordion-inner">
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=3-1.pdf" title="教职工出国流程图.pdf">&nbsp;&nbsp;教职工出国流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=3-2.pdf" title="教职工赴港澳流程图.pdf">&nbsp;&nbsp;教职工赴港澳流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=3-3.pdf" title="教职工赴台流程图.pdf">&nbsp;&nbsp;教职工赴台流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=3-4.pdf" title="外事接待流程图.pdf">&nbsp;&nbsp;外事接待流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=3-5.pdf" title="学生出国（赴港澳）流程图.pdf">&nbsp;&nbsp;学生出国（赴港澳）流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=3-6.pdf" title="学生赴台流程图.pdf">&nbsp;&nbsp;学生赴台流程图.pdf</a>
											</span>
										</div>				
				                    </div>
				                  </div>
				                </div><!--/accordion-group-->
				
				                <div class="accordion-group">
				                  <div class="accordion-heading">
				                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour" style="font-size:13px">
				                       <img width="5" height="5" src="../icons/point.jpg">
				                       &nbsp;&nbsp;学生工作流程图
				                    </a>
				                  </div>
				                  <div id="collapseFour" class="accordion-body collapse" style="height: 0px;">
				                    <div class="accordion-inner">
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-1.pdf" title="软件学院发展学生党员流程图.pdf">&nbsp;&nbsp;软件学院发展学生党员流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-2.pdf" title="软件学院接收预备党员流程图.pdf">&nbsp;&nbsp;软件学院接收预备党员流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-3.pdf" title="软件学院学生党员评优工作流程图.pdf">&nbsp;&nbsp;软件学院学生党员评优工作流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-4.pdf" title="软件学院学生评奖.pdf">&nbsp;&nbsp;软件学院学生评奖.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-5.pdf" title="软件学院预备党员转正流程图.pdf">&nbsp;&nbsp;软件学院预备党员转正流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-6.pdf" title="学办毕业生工作流程图.pdf">&nbsp;&nbsp;学办毕业生工作流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-7.pdf" title="学办贫困生工作流程图.pdf">&nbsp;&nbsp;学办贫困生工作流程图.pdf</a>
											</span>
										</div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;<img width="5" height="5" src="../icons/point.jpg">
											<span class="index2-right-title">
												<a class="aNode" href="<%=basepath%>/jsp/down.jsp?fname=4-8.pdf" title="学办请假流程图.pdf">&nbsp;&nbsp;学办请假流程图.pdf</a>
											</span>
										</div>
				                    </div>
				                  </div>
				                </div><!--/accordion-group-->
				
				            </div><!--/accardion-->
        				</div><!--/span7-->
    				</div> 

					
					<div id="newsContent-Page">
					</div>		
				</div>
				
			</td>
	
		</tr>
	</table>
	<jsp:include page="banner.jsp" />
	</div>

	
</body>


</html>