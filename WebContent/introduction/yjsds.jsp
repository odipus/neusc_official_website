<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<title>东北大学国家示范性软件学院--研究生导师</title>
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
		<div id="index3-news-header"><span class="part-name">研究生导师</span></div>
		<div id="index3-news-content">
			<div id="newsContent-Guide">
			</div>
			<div id="index3-newsContent">
				<br/><p class='department2-orgTitle'><b>东北大学软件学院</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>副教授</b></p><p id='t2' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t3' class='department2-teacher'></p><br/><hr class='tchHr'/> 
				<br/>
				<br/><p class='department2-orgTitle'><b>东北大学计算中心</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>副教授</b></p><p id='t2' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t3' class='department2-teacher'></p><br/><hr class='tchHr'/> 
				<br/>
				<br/><p class='department2-orgTitle'><b>东北大学信息学院</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>副教授</b></p><p id='t2' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t3' class='department2-teacher'></p><br/><hr class='tchHr'/> 
				<br/>
				<br/><p class='department2-orgTitle'><b>东软集团</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>副教授</b></p><p id='t2' class='department2-teacher'></p><hr class='tchHr'/> 
				<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t3' class='department2-teacher'></p><br/><hr class='tchHr'/> 
 
	
				<a class='tchLink' href='tchInfo.jsp?tchId="+teacherList[i].teacherId+"'></a>&nbsp;&nbsp;
    	
<!-- <pre>
校内  朱志良	男	教授	软件学院	信息整合与中间件技术、多媒体信息处理、虚拟现实及地理信息系统、混沌分形与（数据压缩）
			83680520	zzl@mail.neu.edu.cn
校内	 杨广明	男	教授	软件学院	信息安全技术、嵌入式系统	83680512	ygm5@hotmail.com	
校内	 徐怀宇	男	教授	软件学院	电子商务、高速铁路、物联网	13555788577	xuhuaiyu@hotmail.com	
校内	姜慧研	女	教授	软件学院	图像处理，模式识别，计算机辅助诊断	13998163069	hyjiang@mail.neu.edu.cn	
校内	周福才	男	教授	软件学院	网络与信息安全、可信计算、电子商务安全的关键技术	13940413064	zhoufucai@ise.neu.edu.cn	
校内	陈东明	男	副教授	软件学院	信息处理与安全、复杂网络、企业信息化	83680511，
			13998834820	chendm@mail.neu.edu.cn	
校内	董傲霜	女	副教授	软件学院	虚拟现实技术	83681822	dongaoshuang@mail.neu.edu.cn	
校内	韩春燕	女	副教授	软件学院	信息系统工程、分布式系统、嵌入式系统、网络通信	13940575805	hancy0223@126.com	
校内	姜琳颖	女	副教授	软件学院	嵌入式系统、计算机网络	13940055982	lyjiang_neu@126.com	
校内	李丹程	女	副教授	软件学院	信息系统工程、软件架构	83684726	ldc@mail.neu.edu.cn	
校内	宋杰	男	副教授	软件学院	信息整合，数据仓库	13940346797	songjie@mail.neu.edu.cn	
校内	严丽	女	副教授	软件学院	数据库建模与智能信息处理	83688873	yanlilyjiaji@163.com	
校内	程维	男	副教授	软件学院	复杂网络	13386889763	cheng_weiqq@163.com
校内	代钰	女	副教授	软件学院	服务组合；服务QoS管理	13080703469	neu_daiyu@126.com
校内	高天寒	男	副教授	软件学院	下一代互联网及网络安全 	13700038569	gaoth@mail.neu.edu.cn	
校内	李昕	女	讲师	软件学院	计算机网络、保密通信、网络编码	13514206875	neulixin@139.com	
校内	刘国奇	男	讲师	软件学院	信息整合、服务计算	13591402086	guoqiliu@126.com	
校内	毛克明	男	讲师	软件学院	模式识别、图像处理	13066751017	rockmao@live.cn	
校内	任涛	男	讲师	软件学院	计算机网络通信及加密算法	13840366956	chinarentao@163.com	
校内	谭振华	男	讲师	软件学院	分布式网络安全	13478212785	tanzh@mail.neu.edu.cn	
校内	于海	男	副教授	软件学院	复杂网络，混沌，非线性动力系统	13804059171	yuhai@mail.com	
校内	于瑞云	男	讲师	软件学院	无线传感器网络、参与式感知、多传感器数据融合	13940259948	yury@mail.neu.edu.cn	
校内	张明卫	男	讲师	软件学院	云计算、知识工程	13898101130	zhangmw@mail.neu.edu.cn	
校内	张爽	女	副教授	软件学院	电子商务/政务、虚拟现实、软件架构平台技术及应用开发	13940069218	zhangs914@163.com

校内	周传生	男	教授	沈师软件学院	软件工程与分布式组件技术	13700037802	jasoncs@126.com	

校内	常桂然	男	教授	计算中心	计算机网络技术，网络与协同计算，网络与信息安全	024-83672602	chang@neu.edu.cn	
校内	高克宁	女	教授	计算中心	web信息处理	13940432022	gkn@cc.neu.edu.cn	
校内	黄卫祖	男	教授	计算中心	多媒体与网络教育、信息集成、知识处理	83682313	hwz@mail.neu.edu.cn	
校内	吕振辽	男	副教授	计算中心	企业信息化	23994399	lzl@cc.neu.edu.cn	
校内	易秀双	男	副教授	计算中心	新一代网络技术及应用、网络信息安全	13304041232	xsyi@mail.neu.edu.cn	

校内	郭楠	女	副教授	信息学院	服务计算	13604076781	guonan@ise.neu.edu.cn	仅单证学生可选
校内	胡清河	男	副教授	信息学院	SOA技术与应用、电子商务与供应链、电子政务	13998889871	huqinghe@ise.neu.edu.cn	
校内	马宗民	男	教授	信息学院	智能数据与知识工程	13840472162	mazongmin@ise.neu.edu.cn	
校内	乔建忠	男	教授	信息学院	软件体系结构、分布式并行计算和操作系统技术	13709823906	qiaojianzhong@ise.neu.edu.cn	
校内	王兴伟	男	教授	信息学院	下一代互联网、自组织网络、IP/DWDM光Internet、移动无线Internet、网络信息安全和网格计算	
				13940055404	wangxingwei@ise.neu.edu.cn	
校内	姚羽	男	副教授	信息学院	网络安全	83686617	yaoyu@mail.neu.edu.cn	
校内	张斌	男	教授	信息学院	Web工程、数据库及数据挖掘技术、信息集成、组件技术、信息网格	13604022102
					zhangbin@ise.neu.edu.cn	

东软	胡景德	男	教授	东软集团	嵌入式系统应用、ERP应用、网络及多媒体应用	13348875533	hujd@neusoft.com	
东软	江根苗	男	研究员	东软集团	医学成像技术、图像处理与人工智能	13804037506	jianggm@neusoft.com	
东软	江早	男	副教授	东软集团	图像处理、数字放送	13602543130	jiangz@neusoft.com	
东软	康雁	男	教授	东软集团	生物医学工程	13940472926	kangy@neusoft.com	
东软	李品彦	男	副教授	东软集团	电子商务、软件方法学	13602543130	lipinyan@neusoft.com	
东软	李永旭	男	副教授	东软集团	生物医学工程	13840421166	liyongxu@neusoft.com	
东软	刘积仁	男	教授	东软集团	分布式多媒体、计算机网络、嵌入式软件	13904016718	liujr@neusoft.com	
东软	柳玉辉	男	副教授	东软集团	图像处理、网络安全技术	13904007760	liuyh@neusoft.com	
东软	卢朝霞	女	教授	东软集团	计算机网络安全、数据库理论与计算机集成管理	13904006617	luzx@neusoft.com	
东软	杨利	男	教授	东软集团	数据库与多媒体技术、分布式处理技术	13302813206	yangli@neusoft.com	
东软	余克清	男	副教授	东软集团	嵌入式计算机软件开发、计算机工作流系统研究	13704116102	yukq@neusoft.com	
东软	袁淮	男	副研究员	东软集团	工作流系统设计与实现、计算机网络安全	13909816519	yuanh@neusoft.com	
东软	张立东	男	副教授	东软集团	商业智能	13604032526	zhangld@neusoft.com	
东软	张霞	女	教授	东软集团	数据管理系统	13604021349	zhangx@neusoft.com	
东软	张应辉	男	副教授	东软集团	计算机网络、计算机软件技术、嵌入式软件技术	13980806060	zhangyh@neusoft.com	
东软	赵大哲	女	教授	东软集团	医学影像、软件工程学	13804016931	zhaodz@neusoft.com	
东软	赵宏	男	教授	东软集团	图像处理、分布式多媒体信息系统及多媒体网络技术	13904002826	zhaoh@neusoft.com	
东软	郑全录	男	研究员	东软集团	生物医学工程	13804024751	zhengql@neusoft.com	
东软	邹豪	男	副教授	东软集团	图象处理与模式识别、医学图象处理与三维医学图象重建	13940069671	zouh@neusoft.com	
            
        </pre> -->
			
			</div>
		</div>
	</div>
			
	<jsp:include page="../jsp/banner.jsp" />
</div>
	
</body>


</html>