<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院—学院风采</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basepath%>/css/index.css" rel="stylesheet"  type="text/css" />
<link href="<%=basepath%>/css/newsList.css" rel="stylesheet"  type="text/css" />
<link href="<%=basepath%>/css/newsContent.css" rel="stylesheet"   type="text/css"/>

<link href="<%=basepath%>/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=basepath%>/css/jquery.ad-gallery.css"  rel="stylesheet" type="text/css">
<link href="<%=basepath%>/css/banner.css" rel="stylesheet" type="text/css">

<script src="<%=basepath%>/js/jquery.js" type="text/javascript"></script>
	
	<style>
	p.frendLink{
	
    	font-family:"楷体";
    	font-size:15px;
    	font-weight:bold;
 
	}
	#linkPic-table tr{
		height:70px;
	}
	img.pic{
		clear:both;
		text-align:center;
		margin-top:20px;
		margin-left:200px;
	}
	p.picTitle{
	    font-family:"楷体";
    	font-size:15px;
    	text-align:center;
    	font-weight:bold;
	}
	
	</style>
	
</head>


<body>

<div id="index3-container" style="text-align:left">
	<jsp:include page="header2.jsp" />

	<div id="index3-news">
		<div id="index3-news-header"><span class="part-name">学院风采</span></div>
		<div id="index3-news-content">
				
		   <div id="gallery" class="ad-gallery" >
		      <div class="ad-image-wrapper">
		      </div>
		      <div class="ad-controls">

		      </div>
		      <div class="ad-nav">
		        <div class="ad-thumbs">
		          <ul class="ad-thumb-list">
		           
		            <li>
		              <a href="../roundPic/20111021.jpg">
		                <img src="../roundPic/20111021.jpg" width="50px" height="28px" title="学院风采" alt="2011年10月21日我院参加国家示范性软件学院十周年庆典并获多项殊荣" class="image1">
		              </a>
		            </li>

		            <li>
		              <a href="../roundPic/20111027.jpg">
		                <img src="../roundPic/20111027.jpg" width="50px" height="28px" title="学院风采" alt="2011年10月27日数字媒体技术专业召开虚拟现实技术专题讲座" class="image2">
		              </a>
		            </li>
		            <li>
		              <a href="../roundPic/2011109.jpg">
		                <img src="../roundPic/2011109.jpg" width="50px" height="28px" title="学院风采" alt="2011年10月9日台湾成功大学黄崇明教授来院访问并做学术报告" class="image3">
		              </a>

		            </li>
		            <li>
		              <a href="../roundPic/2011111.jpg">
		                <img src="../roundPic/2011111.jpg" width="50px" height="28px" title="学院风采" alt="2011年11月1日软件学院与中锐教育集团签订合作协议" class="image4">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/2011113.jpg">
		                <img src="../roundPic/2011113.jpg" width="50px" height="28px" title="学院风采" alt="2011年11月3日日本岐阜大学藤田教授来院访问并做报告" class="image5">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/2011228.jpg">
		                <img src="../roundPic/2011228.jpg" width="50px" height="28px" title="学院风采" alt="2011年2月28日丁烈云校长莅临软件学院调研" class="image6">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/2011322.jpg">
		                <img src="../roundPic/2011322.jpg" width="50px" height="28px" title="学院风采" alt="2011年3月22日我院开展消防安全知识培训" class="image7">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/20115.jpg">
		                <img src="../roundPic/20115.jpg" width="50px" height="28px" title="学院风采" alt="2011年5月日本立命馆大学情报理工学院陈延伟教授来院访问并作学术报告" class="image8">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/2011614.jpg">
		                <img src="../roundPic/2011614.jpg" width="50px" height="28px" title="学院风采" alt="2011年6月14日我院开展青年管理人员培训" class="image9">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/2011616.jpg">
		                <img src="../roundPic/2011616.jpg" width="50px" height="28px" title="学院风采" alt="2011年6月16日我院举行庆祝建党90周年暨党建工作总结表彰大会" class="image10">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/201161.jpg">
		                <img src="../roundPic/201161.jpg" width="50px" height="28px" title="学院风采" alt="2011年6月1日我院承办国家信标委SOA标准工作组云计算标准研讨会" class="image11">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/201167.jpg">
		                <img src="../roundPic/201167.jpg" width="50px" height="28px" title="学院风采" alt="2011年6月7日我院举行2009-2010学年学生奖励基金颁奖典礼" class="image12">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/2011927.jpg">
		                <img src="../roundPic/2011927.jpg" width="50px" height="28px" title="学院风采" alt="2011年9月27日我院举行新网站开通暨学院成立九周年大会" class="image13">
		              </a>
		            </li>
		             <li>
		              <a href="../roundPic/20119271.jpg">
		                <img src="../roundPic/20119271.jpg" width="50px" height="28px" title="学院风采" alt="2011年9月27日学院聘请杨本强为兼职教授" class="image14">
		              </a>
		            </li>
		           </ul>
		        </div>
		      </div>

    </div>

 
		
		</div>
		
					

	</div>
			
			
	<jsp:include page="banner.jsp" />
</div>


<script src="<%=basepath%>/js/jquery.ad-gallery.js" type="text/javascript"></script>


   <script type="text/javascript">
   
  $(function() {
  
    var galleries = $('.ad-gallery').adGallery();
    $('#switch-effect').change(
      function() {
        galleries[0].settings.effect = $(this).val();
	
        return false;
      }
    );
    $('#toggle-slideshow').click(
      function() {
        galleries[0].slideshow.toggle();
        return false;
      }
    );
    $('#toggle-description').click(
      function() {
        if(!galleries[0].settings.description_wrapper) {
          galleries[0].settings.description_wrapper = $('#descriptions');
        } else {
          galleries[0].settings.description_wrapper = false;
        }
        return false;
      }
    );
  });
  </script>	
</body>


</html>