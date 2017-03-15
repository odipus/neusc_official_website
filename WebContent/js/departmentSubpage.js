$(document).ready(function(){
	var fc;
	//fc=duty部门简介
	//fc=teach师资队伍
	//fc=list新闻列表页面
	//fc=notice公告列表
	//fc=news新闻内容页面

	var orgId;
	var page;
	var org;
	var subSite;
	var newsId;
	var newsTitle = new Array();
	var newsHtmlPath = new Array();
	var newsDate = new Array();
	var newsSectionName = new Array();
	var newsClick = new Array();
	var newsContent = new Array();
	var newsAuthor = new Array();

	//fc=list&orgId=11&page=1

	var str   =   window.location.href;

	fc = str.substring(str.indexOf('fc=')+3,str.lastIndexOf ('orgId=')-1);
	$.ajaxSetup ({cache: false});

	if(fc=="news"){
		//fc=news&orgId=11&newsId=1111
		newsId = str.substring(str.length,str.lastIndexOf('newsId=')+7);
		orgId = str.substring(str.indexOf('orgId=')+6,str.lastIndexOf ('newsId=')-1);
	}else{
		page = str.substring(str.length,str.lastIndexOf('page=')+5);
		orgId = str.substring(str.indexOf('orgId=')+6,str.lastIndexOf ('page=')-1);
	}

	if(fc=="list"){
		$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
			org = data.org;
			displayHeader(org);
			$("#department2-main-header").append("<span class='part-name'>&nbsp;新闻列表</span>");
			/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;新闻列表</p>");
			*/
			$("#department2-main-content-area").append("<br/><table id='index2-right-table' width='820px' bgcolor='#F5F6F8'></table>");
			$.getJSON("subSiteAction!querySubSiteByCode?subSiteCode="+org.orgCode,function(data){
				subSite = data.subSite;

				$.getJSON("subNewsAction!querySubNewsBySubSiteId?subSiteId="+subSite.subSiteId+"&page="+page+"&size=16",function(data){
					var newslist = data.subNewsList;
					$.each(newslist,function(i){
						newsTitle[i] = newslist[i].subNewsTitle;
						newsDate[i] = newslist[i].newsDate;
						newsClick[i] = newslist[i].newsClick;

						order = i;
						newsHtmlPath[i] = "departmentSubpage.jsp?fc=news&orgId="+orgId+"&newsId="+newslist[i].subNewsId;	
						
						i
			            var tbl = document.getElementById('index2-right-table');   
			            var row = tbl.insertRow(0);   
			            var cell = row.insertCell(0);   
			            cell.innerHTML=""+
						"<td style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='5' height='5' /></td>"+
						"<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a title="+newsTitle[i]+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+newsTitle[i]+"</a></span>"+
						"&nbsp;&nbsp;&nbsp;<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;"+
						"["+newsDate[i].substring(0,10)+"]</font>"+ 				
						"</td>";  
					});

					$.getJSON("subNewsAction!querySubNewsAmountBySubSiteId?subSiteId="+subSite.subSiteId,function(data){
						var prepage = Number(page)-Number(1);
						var propage = Number(page)+Number(1);
						var newsAmount = data.newsAmount;
						if(prepage<1)prepage=1;
						if(propage>Math.ceil(newsAmount/11))propage=Math.ceil(newsAmount/11);

						$("#department2-main-content-area").append("<p class='commonlink'>共"+newsAmount+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newsAmount/11)+" 页" +
								"&nbsp;&nbsp;<a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page=1'>首页</a>  <a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page="+prepage+"'>上一页</a>  <a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page="+propage+"'>下一页</a>  <a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page="+Math.ceil(newsAmount/11)+"'>尾页</a> </p>");
					});
					
					
				});

			});


		});

	}

	if(fc=="notice"){


		$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
			org = data.org;
			displayHeader(org);
			$("#department2-main-header").append("<span class='part-name'>&nbsp;公告列表</span>");
			/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;最新公告</p>");
			*/
			$("#department2-main-content-area").append("<br/><table id='index2-right-table' width='820px' bgcolor='#F5F6F8'></table>");
			$.getJSON("subSiteAction!querySubSiteByCode?subSiteCode="+org.orgCode,function(data){
				subSite = data.subSite;

				$.getJSON("subNewsAction!queryNotice?subSiteId="+subSite.subSiteId+"&page="+page+"&size=11",function(data){
					var newslist = data.newsList;
					$.each(newslist,function(i){
						newsTitle[i] = newslist[i].subNewsTitle;
						newsDate[i] = newslist[i].newsDate;
						newsClick[i] = newslist[i].newsClick;

						order = i;
						newsHtmlPath[i] = "departmentSubpage.jsp?fc=news&orgId="+orgId+"&newsId="+newslist[i].subNewsId;

			    		var newsDisplay = document.createElement('tr');
						newsDisplay.className = "index2-news-title";
						newsDisplay.innerHTML=""+
							"<td height='30' align='center' style='BORDER-BOTTOM: #CCC 1px dashed;'><img src='../icons/point.jpg' width='5' height='5' /></td>"+
							"<td style='BORDER-BOTTOM: #CCC 1px dashed;'><span class='index2-right-title'><a title="+newsTitle[i]+" href="+newsHtmlPath[i]+" target=_blank>&nbsp;&nbsp;"+newsTitle[i]+"</a></span>"+
							"&nbsp;&nbsp;&nbsp;<font color='#585858'>(浏览:&nbsp;"+newsClick[i]+")&nbsp;&nbsp;"+
							"["+newsDate[i].substring(0,10)+"]</font>"+
							"</td>";
						$("#index2-right-table").append(newsDisplay);
					});

					$.getJSON("subNewsAction!queryNoticeAmount?subSiteId="+subSite.subSiteId,function(data){
						var prepage = Number(page)-Number(1);
						var propage = Number(page)+Number(1);
						var newsAmount = data.newsAmount;
						if(prepage<1)prepage=1;
						if(propage>Math.ceil(newsAmount/11))propage=Math.ceil(newsAmount/11);

						$("#department2-main-content-area").append("<p>共"+newsAmount+" 条&nbsp;&nbsp;当前第 "+page+"/"+Math.ceil(newsAmount/11)+" 页" +
								"&nbsp;&nbsp;<a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page=1'>首页</a>  <a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page="+prepage+"'>上一页</a>  <a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page="+propage+"'>下一页</a>  <a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page="+Math.ceil(newsAmount/11)+"'>尾页</a> </p>");
					});
				});
			});


		});

	}

	if(fc=="duty"){
		$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
			org = data.org;
			displayHeader(org);
			$("#department2-main-header").append("<span class='part-name'>&nbsp;机构简介</span>");
			/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;机构简介</p>");
			*/
	/*		$("#department2-main-content-area").css("margin-left","100px");
			$("#department2-main-content-area").css("width","720px");*/

			$("#department2-main-content-area").append("<span class='department-title-1'>"+org.orgName+"</span><hr><br/>");
			$("#department2-main-content-area").append(org.orgDuty);
		});
	}

		if(fc=="teach"){

		$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
			org = data.org;
			displayHeader(org);
			if(org.orgName=="实验中心"){
				syzx();
			}else if(org.orgName=="外语教学部"){
				wyjxb();
			}
			else{
				$("#department2-main-header").append("<span class='part-name'>&nbsp;师资队伍</span>");
				/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;师资队伍</p>");
				*/
				$("#department2-main-content-area").append("<br/><strong>(按姓氏笔画排序)</strong><br/>");
				$("#department2-main-content-area").append("<br/><p class='department2-orgTitle'><b>所长</b></p><p id='t1' class='department2-teacher'></p><hr style='width: 820px' size='2'/> " +
						"<br/><p class='department2-orgTitle'><b>副所长</b></p><p id='t2' class='department2-teacher'></p><hr style='width: 820px' size='2'/><br/>"+
						"<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t3' class='department2-teacher'></p><hr style='width: 820px' size='2'/> "+
						"<br/><p class='department2-orgTitle'><b>副教授</b></p><p id='t4' class='department2-teacher'></p><hr style='width: 820px' size='2'/> "+
						"<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t5' class='department2-teacher'></p><hr style='width: 820px' size='2'/> "+
						"<br/><p class='department2-orgTitle'><b>助教</b></p><p id='t6' class='department2-teacher'></p><hr style='width: 820px' size='2'/> <br/><br/>");
				$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
					var teacherList = data.tchesList;
					var jiaoshou ="";
					var fujiaoshou="";
					var jiangshi="";
					var zhujiao="";
					$.each(teacherList,function(i){
						
						var tName = teacherList[i].tchName; 
					
						
						if(tName.length==2){
							tName = tName.substring(0,1)+"&nbsp;&nbsp;"+tName.substring(1);
						}
						
						if(teacherList[i].tchOrgDuty!=null){
							var duty = teacherList[i].tchOrgDuty;
							if(duty.substring(duty.length,duty.length-3)=="所所长")
								$("#t1").append("<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;");
							else if(duty.substring(duty.length,duty.length-3)=="副所长")
								$("#t2").append("<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;");
						}
						if(teacherList[i].tchTitle=="教授")
							jiaoshou = jiaoshou + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						else if(teacherList[i].tchTitle=="副教授")
							fujiaoshou = fujiaoshou + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						else if(teacherList[i].tchTitle=="讲师")
							jiangshi = jiangshi + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						else if(teacherList[i].tchTitle=="助教")
							zhujiao = zhujiao + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
					});
					
					var test = process(jiaoshou, _surname);
					$("#t3").append(test);
					var test = process(fujiaoshou, _surname);
					$("#t4").append(test);
					var test = process(jiangshi, _surname);
					$("#t5").append(test);
					var test = process(zhujiao, _surname);
					$("#t6").append(test);
				});

			}
			function syzx(){
				$("#department2-main-header").append("<span class='part-name'>&nbsp;师资队伍</span>");
				/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;师资队伍</p>");
				*/
				$("#department2-main-content-area").append("<br/><strong>(按姓氏笔画排序)</strong><br/>");
				$("#department2-main-content-area").append("<br/><p class='department2-orgTitle'><b>主任</b></p><p id='t1' class='department2-teacher'></p><hr style='width: 820px' size='2'/> " +
						"<br/><p class='department2-orgTitle'><b>副主任</b></p><p id='t2' class='department2-teacher'></p><hr style='width: 820px' size='2'/>"+
						"<br/><p class='department2-orgTitle'><b>高级实验师</b></p><p id='t3' class='department2-teacher'></p><hr style='width: 820px' size='2'/>"+
						"<br/><p class='department2-orgTitle'><b>实验师</b></p><p id='t4' class='department2-teacher'></p><hr style='width: 820px' size='2'/> "+
						"<br/><p class='department2-orgTitle'><b>助理实验师</b></p><p id='t5' class='department2-teacher'></p><hr style='width: 820px' size='2'/> <br/><br/>");
				$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
					var teacherList = data.tchesList;
					var zr="";
					var fzr="";
					var gjsys="";
					var sys="";
					var zlsys="";
					$.each(teacherList,function(i){
						
						var tName = teacherList[i].tchName;
						
						if(tName.length==2){
							tName = tName.substring(0,1)+"&nbsp;&nbsp;"+tName.substring(1);
						}
						
						if(teacherList[i].tchOrgDuty=="实验中心主任")
							zr = zr + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						else if(teacherList[i].tchOrgDuty=="实验中心副主任")
							fzr = fzr + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						if(teacherList[i].tchTitle=="高级实验师")
							gjsys = gjsys+ "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						else if(teacherList[i].tchTitle=="实验师")
							sys = sys +"<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";
						else if(teacherList[i].tchTitle=="助理实验师"||teacherList[i].tchTitle=="暂聘助理实验师")
							zlsys = zlsys +"<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;*";


					});
					var test = process(zr, _surname);
					$("#t1").append(test);
					var test = process(fzr, _surname);
					$("#t2").append(test);
					var test = process(gjsys, _surname);
					$("#t3").append(test);
					var test = process(sys, _surname);
					$("#t4").append(test);
					var test = process(zlsys, _surname);
					$("#t5").append(test);
				});

			}
			function wyjxb(){
				$("#department2-main-header").append("<span class='part-name'>&nbsp;师资队伍</span>");
				/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;师资队伍</p>");
				*/
				$("#department2-main-content-area").append("<br/><strong>(按姓氏笔画排序)</strong><br/>");
				$("#department2-main-content-area").append("" +
						"<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t1' class='department2-teacher'></p><hr style='width: 820px' size='2'/><br/>"+
				"<br/><p class='department2-orgTitle'><b>助教</b></p><p id='t2' class='department2-teacher'></p><hr style='width: 820px' size='2'/><br/>");

				$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
					var teacherList = data.tchesList;
					var jiangshi="";
					var zhujiao="";
					$.each(teacherList,function(i){
						var tName = teacherList[i].tchName;
						
						if(tName.length==2){
							tName = tName.substring(0,1)+"&nbsp;&nbsp;"+tName.substring(1);
						}
						if(teacherList[i].tchTitle=="讲师")
						jiangshi = jiangshi + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;";
						else if(teacherList[i].tchTitle=="助教")
						zhujiao = zhujiao + "<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+tName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;";

					});
					var test = process(jiangshi, _surname);
					$("#t1").append(test);
					var test = process(zhujiao, _surname);
					$("#t2").append(test);
				});

			}
			
			// 姓氏列表（复姓仅取首字）    
			var _surname = [];
			_surname[1] = '乙';
			_surname[2] = '丁七卜刁刀乜';
			_surname[3] = '干于寸万弋上山广门弓卫也习马子幺';
			_surname[4] = '支云亓元木王车丰韦尤戈区仇从公毛午牛长风凤计卞文方亢斗邓孔尹巴水';
			_surname[5] = '艾玉古东布石左龙归帅叶卢田申史冉付印仝丛丘白句包乐冯邝召台皮司边代';
			_surname[6] = '邢戎巩权吉西成毕过匡师吕曲乔年朱伍伏仲任伊伉华向后全邬危刘齐庄江池汤宇安关羊米许祁农那阮阳阴孙纪';
			_surname[7] = '麦杜杨邴芮花芦苏劳李吾严巫酉甫励邳抗轩连芈邺肖岐时旷吴岑何但佟邱佘余谷犹狄邹言辛库闵冷汪沐沙沃沈宋张陆阿陈妫姒邵邰孟';
			_surname[8] = '青武林杭苗英苟范昔郁欧卓尚呼明易罗国和邾季竺佴郈侬岳兒郄郐念金鱼周於庞冼郎房屈练';
			_surname[9] = '贰项柯相柏柳胡荆郝郦南荀荣革查赵哈思香钟钮郜侯段皇禹郗俞独昝逄施闻洪宦宫姜娄祖祝费胥姚贺绕骆';
			_surname[10] = '班敖秦桂耿索袁莫聂晋栗贾顾夏原柴党晁晏钱铁俸倪徐殷翁奚卿馀郭高栾席唐凌浦海涂容诸谈展陶姬桑';
			_surname[11] = '梅梓菅萧萨黄曹奢龚盛戚常崔符瘐康麻阎渔盖寇梁扈尉屠隗隆巢';
			_surname[12] = '琮韩彭葛董蒋壹覃粟惠辜斐喻嵇程税智傅储焦舒鲁童温滑游曾谢禄缗';
			_surname[13] = '槐楼赖靳甄蒯鄢蓝蓟蓬蒲蒙楚雷零裘肆訾虞睢路锡简解鲍詹雍满窦谬褚';
			_surname[14] = '慕蔡蔺蔚臧管鲜端韶廖阚赛谭熊翟缪';
			_surname[15] = '耦横撒墨稷黎樊滕颜潘豫';
			_surname[16] = '融薛薄燕霍冀黔穆衡嬴澹';
			_surname[17] = '璩檀懋鞠戴赡镡魏繇襄糜麋濮蹇';
			_surname[18] = '瞿';
			_surname[19] = '酆矍籍灌';
			_surname[20] = '露夔';
			_surname[21] = '囊鬻';

			function findit(zi, dict)
			{
			for (var i=1; i<dict.length; ++i) {
			var _str = dict[i];
			for (var j=0; j<_str.length; ++j) {
			if (zi == _str.charAt(j)) return i;
			}
			}
			return 0;
			}

			// txt 待处理的姓名数据行（一行一条信息）
			function process(txt, dict)
			{
			var _out = [];
			var _list = txt.split("*");
			_list.sort();
			// 姓名数据行循环
			for (var i=0; i<_list.length; ++i) {
			var _line = _list[i].replace(/^\s+/, '');
			if (_line == '')
			continue;
			// 取第一字

			var _chr =_line.charAt(_line.indexOf(">")+1);
			// 笔画数查询
			var _num = findit(_chr, dict);
			if (_out[_num] !== undefined) {
			_out[_num] += _line + " ";
			} else {
			_out[_num] = _line + " ";
			}
			}
			var _ret = '';
			for (var i=0; i<_out.length; ++i) {
			if (_out[i] !== undefined) {
			_ret += _out[i];
			}
			}
			return _ret;
			}


		});
	}
	if(fc=="news"){

		$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
			org = data.org;
			displayHeader(org);
			$("#department2-main-header").append("<span class='part-name'>&nbsp;新闻内容</span>");
			/*$("#department2-main-content-area").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;新闻列表&nbsp;&gt;&nbsp;新闻内容</p>");
*/
				$.getJSON("subNewsAction!querySubNewsById?subNewsId="+newsId,function(data){
					var subNews = data.subNews;
					if(subNews.isPicNews==1){
						$("#department2-main-content-area").append("<span class='index3-newsContent-Title'>"+subNews.subNewsTitle+"</span>"+
								"<span class='index3-newsContent-Info'>发布者：<span class='newsContent-Editor'>"+subNews.subNewsAuthor+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"+subNews.newsDate.substring(0,10)+"&nbsp;"+subNews.newsDate.substring(11,16)+"&nbsp;&nbsp;&nbsp;<span class='print' style='text-decoration: none; cursor: hand;'  onmousedown='javascript:print()'><img src='../icons/print.png'>打印</span></span>"+
								"<br/><br/><img style='margin-left:100px' height='300px' width='500px' src =../"+subNews.picPath+"><br/>"+
								"<span class='index3-newsContent-Content'>&nbsp;&nbsp;&nbsp;&nbsp;"+subNews.newsContent+"</span><br/><br/>");
						
					}else{
						$("#department2-main-content-area").append("<span class='index3-newsContent-Title'>"+subNews.subNewsTitle+"</span>"+
								"<span class='index3-newsContent-Info'>发布者：<span class='newsContent-Editor'>"+subNews.subNewsAuthor+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"+subNews.newsDate.substring(0,10)+"&nbsp;"+subNews.newsDate.substring(11,16)+"&nbsp;&nbsp;&nbsp;<span class='print' style='text-decoration: none; cursor: hand;'  onmousedown='javascript:print()'><img src='../icons/print.png'>打印</span></span>"+
								"<br/><br/>"+
								"<span class='index3-newsContent-Content'>&nbsp;&nbsp;&nbsp;&nbsp;"+subNews.newsContent+"</span><br/><br/>");
					
					}
if(subNews.isAttach==1){
					$("#index3-download").append("<span>相关文件下载</span>");
					
					var link=subNews.attachPath;
					//var name = news.attachName;
					var d = ',';  //用于分隔多个附件
					var n =0;  //用于记录附件字段中有多少哥逗号
					var filelink = link.substring(link.length,link.lastIndexOf ('/')+1);
					//var filename = name.substring(link.length,link.lastIndexOf ('/'));
					
					if(link.indexOf(',')==-1){
						$("#index3-download").append("<br/><a href='down.jsp?fname="+filelink+"'>"+filelink+"</a>");
						
					}
					
					else{
						for(i=0;i<link.length;i++){
							  index=d.indexOf(link.charAt(i));
							  if(index==-1){
							    
							  }else{n++;}
							}
						for(i=0;i<=n;i++){
							if(i==n){
								var flink = filelink.substring(0,filelink.length);
								//var fname = filename.substring(0,filename.length);
							}else{
								var flink = filelink.substring(0,filelink.indexOf (','));
								//var fname = filename.substring(0,filename.indexOf (','));
							}
							
							filelink = filelink.substring(filelink.indexOf (',')+1,filelink.length);
							//filename = filename.substring(filename.indexOf (',')+1,filename.length);
						
							$("#index3-download").append("<br/><a href='down.jsp?fname="+flink+"'>"+flink+"</a>");
						}
						

					}
					
				}
					});

		});


	}
	function displayHeader(org){
		$("#department-title").append("<span>"+org.orgName+"</span>");
		$("#menuIndex").attr({ href: "department.jsp?orgId="+orgId });
		$("#menuNews").attr({ href: "departmentSubpage.jsp?fc=list&orgId="+orgId+"&page=1"});
		$("#menuDuty").attr({ href: "departmentSubpage.jsp?fc=duty&orgId="+orgId+"&page=1"});
		$("#menuTeach").attr({ href: "departmentSubpage.jsp?fc=teach&orgId="+orgId+"&page=1"});
	}



});