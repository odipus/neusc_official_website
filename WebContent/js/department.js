$(document).ready(function(){
	var orgName;
	var orgDuty;
	var teacher;
	var subNews;
	var str   =   window.location.href;
	var orgId = str.substring(str.length,str.lastIndexOf ('orgId=')+6);
	var subNewsTitle = new Array();
	var subNewsHtmlPath = new Array();
	var subNewsDate = new Array();
	var picNewsTitle = new Array();
	var picPath = new Array();
	var picNewsId = new Array();
	var picNewsSectionId = new Array();
	var picNewsPath = new Array();

	var subNewsId = new Array();

	$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
		var org = data.org;
		$("#department-title").append("<span>"+org.orgName+"</span>")
		$("#department-right-content-area").append("<span class='department-title-1'>"+org.orgName+"</span><hr><br/>");
		$("#department-right-content-area").append("<span>"+org.orgDuty+"</span>");
	});


	//为机构首页的导航条赋上链接
	$("#menuIndex").attr({ href: "department.jsp?orgId="+orgId });
	$("#menuNews").attr({ href: "departmentSubpage.jsp?fc=list&orgId="+orgId+"&page=1"});
	$("#menuDuty").attr({ href: "departmentSubpage.jsp?fc=duty&orgId="+orgId+"&page=1"});
	$("#menuTeach").attr({ href: "departmentSubpage.jsp?fc=teach&orgId="+orgId+"&page=1"});


	display();

	function display(){
		$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
			org = data.org;
			$.getJSON("subSiteAction!querySubSiteByCode?subSiteCode="+org.orgCode,function(data){
				subSite = data.subSite;
				$.getJSON("subNewsAction!queryNotice?subSiteId="+subSite.subSiteId+"&page=1&size=5",function(data){
					var newslist = data.subNewsList;
					$("#department-side1").append("<marquee id='announcement' onmouseover='announcement.stop()' onmouseout='announcement.start()' scrollAmount=1 scrollDelay=1 direction=up width=180px height=170px></marquee>");
					if(newslist.length==0){
						$("#announcement").append("<p style='margin-left:20px;'>暂无最新公告</p>");
					}
					$.each(newslist,function(i){
						subNewsTitle[i] = newslist[i].subNewsTitle;
						subNewsHtmlPath[i] ="departmentSubpage.jsp?fc=news&orgId="+orgId+"&newsId="+newslist[i].subNewsId;
						subNewsDate[i] = newslist[i].newsDate;
						displayNoticeDetail(i);

					});
					$("#department-side1").append("<div class='department-side-bottom'>"+
						"<img src='../images/index-arrow.png'>"+
						"<span class='news-more'><a href='departmentSubpage.jsp?fc=list&orgId="+orgId+"&page=1'>更多</a></span>"+
						"</div>");
				});

				$.getJSON("subNewsAction!queryPicturenews?subSiteId="+subSite.subSiteId+"&page=1&size=5",function(data){
					var list = data.subNewsList;
					if(list.length==0){
						$("#picRonud").append("<p style='margin-left:20px;margin-top:20px;'>暂无图片新闻……</p>");
					}
					$.each(list,function(i){
						picNewsTitle[i] = list[i].subNewsTitle.substring(0,10)+"……";
						picPath[i] = list[i].picPath;
						picNewsId[i] = list[i].subNewsId;
						subNewsHtmlPath[i] ="departmentSubpage.jsp?fc=news&orgId="+orgId+"&newsId="+list[i].subNewsId;

						//picNewsSectionId[i] = list[i].section.sectionId;
						//picNewsPath[i] = "newsContent.jsp?sectionId="+picNewsSectionId[i]+"&newsId="+picNewsId[i];
						displayPicturenews(i);
					});

			      
				});
			});
		});
	}
	function displayNoticeDetail(i){
		var newsDisplay = document.createElement('span');
		newsDisplay.className = "announcement-title";
		newsDisplay.innerHTML="<a href="+subNewsHtmlPath[i]+" target=_blank>"+subNewsTitle[i]+"("+subNewsDate[i].substring(5,10)+")</a>"
		$("#announcement").append(newsDisplay);

	}

	function displayPicturenews(i){
		$("#picRound_ul").append("<li>"+(Number(i)+Number(1))+"</li>");
		$("#picRonud_list").append("<a href="+subNewsHtmlPath[i]+" target='_blank'><img src=../"+picPath[i]+" height='150px' width='206px' title="+picNewsTitle[i]+" alt=''  /></a>"); 		

	}

});